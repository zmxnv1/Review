# Object源码
Object是所有类的父类，在Object中有11个方法。下面记录一下Object的源码

### public final native class<?> getClass()
此方法是一个native, final方法，即不允许子类重写。
**此方法返回当前运行时对象的Class对象，这里是运行时。**如下
```
"str".getClass() // java.lang.String
"str".getClass() == String.class // true
Number n = 0;
class<? extends Number> c = n.getClass() //class java.lang.Integer
```

### public native int hashCode()
**如果两个对象通过equals方法判断相同，则hashcode一定要相同，换言之，如果重写equals方法，一定要重写hashCode()方法。**

生成对象的hashcode，主要用在hash表中。
String的hash码生成方式如下, n为String的长度。
$$\sum_{i=0}^{n-1}{31^{i}s[n-1-i]} $$


### public boolean equals(Object obj)

默认方法 return(this == obj)，基本类型值相等，其他引用相同。

重写的equals方法需满足下面条件。
1. 自反性 x.equals(x) == true
2. 对称性 a.equals(b) == b.equals(a)
3. 传递性 (a.equals(b) && b.equals(c)) == a.eqals(c)
4. 一致性 如果(x.equals(y) == true)，而且x, y没有被修改，则x.eqauls(y)恒为true。
5. (x != null && x.equals(null)) == false;

### protected native Object clone() throws CloneNotSupportedException
创建并返回当前对象的一份拷贝，一般情况下，对于任何对象x, 表达式(x.clone() != x) == true，(x.clone().getClass() == x.getClass()) == true。

Object类的Clone方法是一个protected方法，如果不重写Clone方法调用会发生CloneNotSupportedException()方法。

### public String toString()
在输出时会默认调用此方法。
```
return getClass().getName() + "@" + Integer.toHexString(hashCode());
```


### public final native void notify()
唤醒在此对象监视器上等待的单个线程。
此方法只应由作为此对象监视器的所有者的线程来调用。通过以下三种方法，线程可以成为此对象监视器的拥有者。
* 通过执行此对象的同步实例方法
* 通过执行此对象上进行同步的synchronized语句
* 对于Class类型的对象，可以通过执行该类同步静态方法。


### public final native void notifyAll()
唤醒在此对象监视器上等待的全部线程。

### public final native void wait(long timeout) throws InterruptedException
在其他线程调用此对象的notify()或notifyAll()方法，或者超过指定的时间量之前，导致当前线程等待。

### public final void wait(long timeout, int nanos) throws InterruptedException
### public final void wait() throws InterruptedException



### protected void finalize() throws Throwable()

Object类的默认实现不进行任何操作，该方法的作用是实例被垃圾回收时用于自救的函数。

*如果通过标记法发现类没有被root引用，这些类会被第一次标记并进行筛选。在这些类中如果该类的finalize()方法没有被重写或者finalize()方法已经被调用，则此类直接被回收，无需执行finalize()方法。否则将这些类放入一个F-Queue队列中，稍后一个低优先级的线程会对这个队列中的类进行第二次标记，如果这个对象在finalize()方法中将自己重新与引用链建立关联，则这个类完成自救。但是finalize()方法只会被系统执行一次。**

**finalize()的运行代价高昂，不确定性大，不建议使用。**