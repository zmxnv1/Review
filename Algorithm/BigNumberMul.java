public class BigNumberMul{

    public static String mul(String A, String B){
        int flag = 0;
        if(A.charAt(0) == '-') flag++;
        if(B.charAt(0) == '-') flag++;
        if(A.charAt(0) == '-' || A.charAt(0) == '+') A = A.substring(1);
        if(B.charAt(0) == '-' || B.charAt(0) == '-') B = B.substring(1);

        char[] result = new char[A.length() + B.length() + 1];
        int indexA, indexB, bit = 0, index;
        for(int i = A.length() - 1; i >= 0; i--) {
            for(int j = B.length() - 1; j >= 0; j--) {
                indexA = A.length() - i - 1;
                indexB = B.length() - j - 1;

                index = indexA + indexB;
                bit += (A.charAt(i) - '0') * (B.charAt(j) - '0');

                if(result[indexA + indexB] != '\0') {
                    bit += result[indexA + indexB] - '0';
                }

                while(bit >= 10) {
                    result[index] = (char)(bit % 10 + '0');
                    index++;
                    bit = bit / 10;
                    if(result[index] != '\0') {
                        bit += result[index] - '0';
                    }
                }
                result[index] = (char)(bit + '0');
                bit = 0;
           }
       }
       return (flag % 2 == 1 ? "-" : "") +  new StringBuffer(new String(result)).reverse().toString();
    }

    public static String mul(int A, int B){
        return mul(String.valueOf(A), String.valueOf(B));
    }

    public static void main(String[] args){
        System.out.println(mul(args[0], args[1]));
    }

}