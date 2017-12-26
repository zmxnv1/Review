import java.util.Arrays;

public class Solution57{
    public boolean isContinuous(int[] numbers) {
        int count = 0;
        for(int i : numbers) {
            if(i == 0) count++;
        }
        Arrays.sort(numbers);
        for(int i = count; i < numbers.length - 1; i++) {
            if(numbers[i] == numbers[i + 1]) return false;
            count -= (numbers[i + 1] - numbers[i]); 
            if(count < 0) return false;
        }
        return true;
        
    }
}