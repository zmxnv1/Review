# ArrayList源码
### 序
Java中的泛型实际上是一种伪泛型，针对于编译器而言的，只在编译器这个层面有泛型的概念。由于Java中所有的类都继承于Object, 所以容器类内部就是简单的Object[]。ArrayList内部的核心就是Object类型的数组。
据我所了解，ArrayList是没有顺序的，但是在ArrayList<Integer>中发现ArrayList是有顺序的，最终决定从源码入手。

### 属性
```
private static final long serialVersionUID = 8683452581122892189L; // 序列化相关
private transient Object[] elementData; //核心，用transient关键词修饰
private int size; //大小
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8; //最大容量

```

### 初始化
```
public class ArrayList<E> entends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{

public ArrayList(int initialCapacity) {
    super(10);
    if(initialCapacity < 0) 
        throw new IllegalArgumentException("Illegal Capacity: " + initalCapcaity);
        this.elementData = new Object[initialCapacity]; 
}

public ArrayList(){
    this(10) ;  //默认容量为10
}

public ArrayList<Collection<? extends E> c) {
    elementData = c.toArray();
    size = elementData.length;
    if(elementData.getClass() != Object[].class) 
        elementData = Arrays.copyOf(elementData, size, Object[].class);
}
```
### 容量相关
```
public void ensureCapacity(int minCapacity) {
    if(minCapacity > 0) ensureCapacityInternal(minCapacity);
}
public void ensureCapacityInternal(int minCapacity) {
    modCount++;
    if(minCapacity - elementData.length > 0) 
        grow(minCapacity);
}
private void grow(int minCapacity){
    int oldCapacity = elementData.length;
    int newCapacity = odlCapacity + (oldCapacity >> 1);
    if(newCapacity - minCapacity < 0) newCapacity = minCapacity;
    if(newCapacity - MAX_ARRAY_SIZE > 0) 
        newCapacity = hugeCapacity(minCapacity);
    elementData = Arrays.copfof(elementData, newCapacity); //elementData已经是新的了，旧的被GC
}
private static int hugeCapacity(int minCapacity) {
    if(minCapacity < 0) 
        throw new OutOfMemoryError(); //内存错误
    return (min > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
}

private void rangeCheck(int index) {
    if(index >= size)
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}
private void rangeCheckForAdd(int index) { //判断索引是否合理，用于精确添加或者删除某个时
    if(index > size || index < 0) 
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

}
```

### 核心
```
public boolean add(E e) {
    ensureCapacityInternal(size + 1); //确保容量正常
    elementData[size++] = e; //ArrayList存放的是索引，
    return true; 
}

/*
 *没有觉得有什么精妙之处
 */
public void add(int index, E element) {
    rangeCheckForAdd(index);
    ensureCapacityInternal(size + 1);
    System.arraycopy(elementData, index, elementData, index + 1, size - index); //复制，将原elementData的index索引开始(size - index)数量的元素复制到elementData数组,开始索引为index+1
    elementDat[index] = element;
    size++;
}

public E remove(int index) {
    rangeCheck(index);
    modeCount++;
    E oldValue = elementDat(index);
    int numValue = size - index - 1;
    if(numMoved > 0) 
        System.arraycopy(elementData, index + 1, elementDat, index, numMoved);
    elementData[--size] = null;
    return oldValue;

}

public boolean remove(Object o){
    if(o == null) {
        for(int index = 0; index < size; index++) {
            if(elementData[index] == null) {
                fastRemove(index);
                return true;
            }
        }
    }else {
        for (int index = 0; index < size; index++) {
            if(o.equals(elementData[index])) { //同HashMap判断方法不同，而且移除的是第一个
                fastRemove(index);
                return true;
            }
        }
    }
    return false;
}

```

### 总结
由于时间关系，先总结这些常用的。由二八定律可知，这些源码中20%的部分在80%的时间被使用，先分析这些吧。