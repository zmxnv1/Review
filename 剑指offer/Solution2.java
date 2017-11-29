import java.util.*;
public class Solution2{
	public static String replaceSpace(StringBuffer str) {
		int size = str.toString().length();
		for(int i = 0, tempSize = size; i < tempSize; i++) {
			if(str.charAt(i) == ' ') size += 2;
		}
		char[] result = new char[size];
		int index = result.length - 1;
		for(int i = str.toString().length() - 1; i >= 0; i--) {
			if(str.charAt(i) == ' ') {
				result[index--] = '0';
				result[index--] = '2';
				result[index--] = '%';
			}
			else {
				result[index--] = str.charAt(i);
			}
		}
		return new String(result);
	}
	public static void main(String[] args){
		System.out.println(replaceSpace(new StringBuffer(args[0])));
	}

}