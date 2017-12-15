import java.util.ArrayList;
public class Solution42 {
    public int[] multiply(int[] A) {
        int[] C = new int[A.length];
        int[] D = new int[A.length];
        int[] B = new int[A.length];
        if(A.length == 0) return B;
        C[0] = A[0];
        D[A.length - 1] = A[A.length - 1];
        for(int i = 1; i < A.length; i++) {
            C[i] = A[i] * C[i - 1];
            D[A.length - i - 1] = A[A.length - i - 1] * D[A.length - i];
        }
        for(int i = 1; i < A.length - 1; i++) {
            B[i] = C[i - 1] * D[i + 1];
        }
        B[0] = D[1];
        B[A.length - 1] = C[A.length - 2];
        return B;
    }

}