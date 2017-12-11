public class Solution36 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int sumOr = 0, firstOr = 0, secondeOr = 0;
        for(int i = 0; i < array.length; i++) {
            sumOr ^= array[i];
        }
        sumOr &= (-sumOr);
        for(int i : array) {
            if((i & sumOr) == 0) {
                firstOr ^= i;
            }
            else secondeOr ^= i;
        }
        num1[0] = firstOr;
        num2[0] = secondeOr;

    }
}
