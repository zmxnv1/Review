public class Solution53{
    public int GetNumberOfK(int [] array , int k) {
        int index = searchIndex(array, k);
        if(index == -1) return 0;
        int left = index, right = index;
        while(right < array.length &&  array[right] == k) right++;
        while(left >= 0 && array[left] == k) left--;
        return (right - left - 1);
    }
    public int searchIndex(int[] array, int k) {
        int left = 0, right = array.length - 1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(array[mid] > k) {
                right = (mid - 1);
            }
            else if(array[mid] < k) {
                left = (mid + 1);
            }
            else if(array[mid] == k) {
                return mid;
            }
        }
        return -1;
    }
}