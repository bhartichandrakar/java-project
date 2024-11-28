package PDF;

import java.util.Arrays;

public class L215KthLargestElementArray {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("The " + k + "-th largest element is: " + findKthLargest(nums, nums.length - k + 1));        
    }

    public static int findKthLargest(int[] nums, int k) {
        if(k > nums.length){
            return 0;
        }
        /* Arrays.sort(nums);
        int result = nums[nums.length - k]; */

        int result = quickSelect(nums,k);
        return result;
    }
        
    public static int quickSelect(int[] nums, int k) {
        return quickSelectHelper(nums, 0 , nums.length - 1, k - 1);
    }
        
    private static int quickSelectHelper(int[] nums, int low, int high, int k) {
        if (low == high) {
            return nums[low];
        }
        int pivotIndex =  partition(nums, low, high);
        if (pivotIndex == k) { // Found the k-th smallest element
            return nums[pivotIndex];
        } else if (k < pivotIndex) { // Search in the left part
            return quickSelectHelper(nums, low, pivotIndex - 1, k);
        } else { // Search in the right part
            return quickSelectHelper(nums, pivotIndex + 1, high, k);
        }

    }
        
    private static int partition(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int pivot = nums[high];
        int i = low;

        for(int j = low; j < high; j++){
            if(nums[j] < pivot){
                swap(nums, i , j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }
    private static void swap(int[] nums, int i, int j) {
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
    }
}
