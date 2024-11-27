package PDF;

import java.util.Arrays;

public class L215KthLargestElementArray {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};

        int result = findKthLargest(nums, 4);
        System.out.println(result);
        
    }

    public static int findKthLargest(int[] nums, int k) {
        if(k > nums.length){
            return 0;
        }
        /* Arrays.sort(nums);
        int result = nums[nums.length - k]; */

        int largest = nums[0];
        int secondLargest = 0;

        for(int i = 1; i < nums.length - 1; i++ ){
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            }else{
                if (secondLargest < nums[i]) {
                    secondLargest = nums[i];
                }
            }

        }
        return secondLargest;
    }
}
