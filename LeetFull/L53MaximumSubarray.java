package LeetFull;

public class L53MaximumSubarray {

    public static void main(String[] args) {

        int[] nums = {5,4,-1,7,8};
        int result = maxSubArray(nums);
        System.out.println(result);
        
    }

    //This code implements the Kadane's algorithm to find the maximum subarray sum in a given array.
    public static int maxSubArray(int[] nums) {
        //Initialization:
        //sum is initialized to 0 to store the current subarray sum.
        int sum = 0;
        //maxSum is initialized to the first element of the array nums[0] as this could potentially be the maximum subarray itself.
        int maxSum = nums[0];
        // Iterate through the array:
        // The code iterates through the array using a for loop.
        for(int i=0; i < nums.length; i++){
            //Update current subarray sum:
            //sum is updated by adding the current element nums[i] to it.
            sum = sum + nums[i];
            //Update maximum subarray sum:
            //The code checks if the current subarray sum (sum) is greater than the current maximum subarray sum (maxSum).
            if (sum > maxSum) {
                //If it is, maxSum is updated to sum.
                maxSum = sum;
            }
            //Reset sum if negative:
            //If the current subarray sum (sum) becomes negative, it's reset to 0. 
            //This is because any negative subarray sum cannot contribute to a larger positive subarray sum.
            if(sum < 0){
                sum = 0;
            }
        }
        //Return the maximum subarray sum:

        //After iterating through the entire array, the final value of maxSum is returned, which represents the maximum subarray sum found.
        return maxSum;
    }

    // Time Complexity:
    // The code iterates through the entire array once using a for loop, resulting in a time complexity of O(n), where n is the length of the input array.

    // Space Complexity:
    // The code only uses a constant amount of extra space for variables like sum and maxSum. Therefore, the space complexity is O(1).
}


// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
 

// Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.