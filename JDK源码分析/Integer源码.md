# Integer源码

### 属性
```
public final class Integer extends Number implements Compareable<Integer>  //final 不可继承
public static final int MIN_VALUE = 0x8000000; //最大值
public static final int MAX_VALUE = 0x7ffffff; //最小值
private final int val;  // final 值不可变
public static final int SIZE = 32;
final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
};
```

### 构造
```
public Integer(int value) {
	this.value = value;
}
public Integer(String s) throws NumberFormatException {
	this.value = paresInt(s, 10);
}
```

### 强转
```
public byte byteValue() {
	return (byte)value;
}
public shortValue() {
	return (short)value;
}
public int intValue() {
	return value;
}
public long longValue() {
	return (long)value;
}
public 	float floatValue() {
	return (float)value;
}
public double doubleValue() {
	return (double)vlaue;
}

```


### 位操作
```
/*
如果i == 0， 返回0
如果i < 0, 返回 0x80000000
如果i > 0, 返回 和它最靠近的且比他小的2的N次方
*/
public static int highestOneBit(int i){
	// 这一连串的异或应该是将最高位1后面的所有位直1, 精妙
	i |= (i >> 1);
    i |= (i >> 2);
    i |= (i >> 4);
    i |= (i >> 8);
    i |= (i >> 16);
    return i - (i >>> 1);
}
public static int lowestOneBit(int i) {
        return i & -i;
}
//反转
public static int reverse(int i) {
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) |
            ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
}
public static int reverseBytes(int i) {
        return ((i >>> 24)           ) |
               ((i >>   8) &   0xFF00) |
               ((i <<   8) & 0xFF0000) |
               ((i << 24));
}

```
### int和String转换
```
// 经典的atoi
public static int parseInt(String s, int radix)
                throws NumberFormatException
    {
        /*
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         */

        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                                            " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                                            " greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    throw NumberFormatException.forInputString(s);

                if (len == 1) // Cannot have lone "+" or "-"
                    throw NumberFormatException.forInputString(s);
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    throw NumberFormatException.forInputString(s);
                }
                if (result < multmin) {
                    throw NumberFormatException.forInputString(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw NumberFormatException.forInputString(s);
                }
                result -= digit;
            }
        } else {
            throw NumberFormatException.forInputString(s);
        }
        return negative ? result : -result;
}
Integer getInteger(String nm)
Integer getInteger(String nm, int val)
Integer getInteger(String nm, Integer val)
Integer decode(String nm)
Integer valueOf(String s)
Integer valueOf(String s, int radix)
int parseUnsignedInt(String s)
int parseUnsignedInt(String s, int radix)
int parseInt(String s)
int parseInt(String s, int radix)
```
所有将String转换成Integer的方法都是基于parseInt方法实现的
```
getInteger(String nm) ---> getInteger(nm, null);--->Integer.decode()--->Integer.valueOf()--->parseInt()
```


### 其他方法
```
/*
将String转换为不同进制的数字
public static Integer decode(String nm) throws NumberFormatException {
        int radix = 10;
        int index = 0;
        boolean negative = false;
        Integer result;

        if (nm.length() == 0)
            throw new NumberFormatException("Zero length string");
        char firstChar = nm.charAt(0);
        // Handle sign, if present
        if (firstChar == '-') {
            negative = true;
            index++;
        } else if (firstChar == '+')
            index++;

        // Handle radix specifier, if present
        if (nm.startsWith("0x", index) || nm.startsWith("0X", index)) {
            index += 2;
            radix = 16;
        }
        else if (nm.startsWith("#", index)) {
            index ++;
            radix = 16;
        }
        else if (nm.startsWith("0", index) && nm.length() > 1 + index) {
            index ++;
            radix = 8;
        }

        if (nm.startsWith("-", index) || nm.startsWith("+", index))
            throw new NumberFormatException("Sign character in wrong position");

        try {
            result = Integer.valueOf(nm.substring(index), radix);
            result = negative ? Integer.valueOf(-result.intValue()) : result;
        } catch (NumberFormatException e) {
            // If number is Integer.MIN_VALUE, we'll end up here. The next line
            // handles this case, and causes any genuine format error to be
            // rethrown.
            String constant = negative ? ("-" + nm.substring(index))
                                       : nm.substring(index);
            result = Integer.valueOf(constant, radix);
        }
        return result;
}



public int hashCode() {
	return value;   //hashCode 就是 value
}


public static String toString(int i, int radix) {

        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
            radix = 10;

        /* Use the faster version */
        if (radix == 10) {
            return toString(i);
        }

        char buf[] = new char[33];
        boolean negative = (i < 0);
        int charPos = 32;

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[-(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[-i];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
}

public boolean equals(Object obj) {
	if(obj instanceOf Integer) {  //判断类是否相同
    	return value == ((Integer)obj).intValue();
    }
    return false;
}
```