### HashMap
#####概述
HashMap采用了数组+链表的形式。大致情形就是将一个key通过hash放入数组对应位置，当两个key的hash一样时，采用链地址法解决冲突。当链表长度大于8时，在JDK1.8中，将链表转化为红黑树。

#####初始化
```
/*
initialCapacity 代表初始容量，即数组的长度
loadFactor 代表负载因子，当数组已经使用的数量>(总数 * loadFactor) 时， 扩容
*/
public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);

        // Find a power of 2 >= initialCapacity
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;

        this.loadFactor = loadFactor;
        threshold = (int)Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
        table = new Entry[capacity];
        useAltHashing = sun.misc.VM.isBooted() &&
                (capacity >= Holder.ALTERNATIVE_HASHING_THRESHOLD);
        init();
}

public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
}

public HashMap() {
     this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
}
```
##### 计算hash
```
/*
首先根据hash计算出数组的位置主要有两种方法
1). hash % length
2). hash & (length - 1)
HashMap使用第二种, 见indexFor函数
HashTable使用第一种
*/
final int hash(Object k) {
        int h = 0;
        if (useAltHashing) {
            if (k instanceof String) {   //直接计算String的hash
                return sun.misc.Hashing.stringHash32((String) k);
            }
            h = hashSeed;
        }
		/*下面这一部分作用是扰动计算
        由于HashMap采用 hash & (length - 1)的方法
        初始length为16
        所以计算是直用到了hash二进制数的后4位，对于后4位相同的hash值，会发生地址冲突。
        这里将hash的前几位通过扰动，减少hash冲突
		*/
        h ^= k.hashCode();
       	h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
}
static int indexFor(int h, int length) {
        return h & (length-1);
}

```

##### put
```   
public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);  //见下函数，可以看到HashMap的key可以为空
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            /*
            这里判断key相同两种方法
            1) e.hash == hash && e.key == key
            2) e.hash == hash && key.equals(k)
            所以对于自定义的key类，定义两个key相同时，一定要重写hashcode，否则即时equal返回true，仍然不同
            */
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;   //覆盖value
                e.recordAccess(this);
                return oldValue;
            }
        }

        modCount++;
        addEntry(hash, key, value, i); //放入新的key-value，见下函数
        return null;
}
private V putForNullKey(V value) {
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        addEntry(0, null, value, 0);
        return null;
}
void addEntry(int hash, K key, V value, int bucketIndex) {
		/* 扩容 */
        if ((size >= threshold) && (null != table[bucketIndex])) {
        /*
        容量直接翻倍
        */
            resize(2 * table.length);    
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        
		//深拷贝，放入key-value
        createEntry(hash, key, value, bucketIndex);
}
void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;
}
```

##### resize
```
/*
当capacity * 0.75 < size时， 进行扩容
扩容不是简单的容量*2, 还要重新计算hash
*/
void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;  //设置容量
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        boolean oldAltHashing = useAltHashing;
        useAltHashing |= sun.misc.VM.isBooted() &&
                (newCapacity >= Holder.ALTERNATIVE_HASHING_THRESHOLD);
        boolean rehash = oldAltHashing ^ useAltHashing;
        transfer(newTable, rehash);  //重新计数hash
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
}
void transfer(Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        for (Entry<K,V> e : table) {
            while(null != e) {
                Entry<K,V> next = e.next;
                if (rehash) {
                    e.hash = null == e.key ? 0 : hash(e.key);
                }
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
}
```

##### get
```
public V get(Object key) {
        if (key == null)
            return getForNullKey();  //如下函数
        Entry<K,V> entry = getEntry(key);

        return null == entry ? null : entry.getValue();
}
private V getForNullKey() {
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }
        return null;
}
final Entry<K,V> getEntry(Object key) {
        int hash = (key == null) ? 0 : hash(key);   //首先计算hash
        for (Entry<K,V> e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            /*计算key是否相同同put*/
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
}
```

