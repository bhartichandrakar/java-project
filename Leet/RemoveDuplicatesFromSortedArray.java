package Leet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int result = removeDuplicates(new int[]{1,2,2});
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums) {
        //If the array is empty, return 0.
        if (nums.length == 0) {
            return 0;
        }
        //Set i to 0 (slow pointer) and j to 1 (fast pointer).
        int i = 0;
        //Loop through the array starting from j = 1.
        for(int j = 1; j < nums.length;j++){
            //If nums[j] is different from nums[i], it's a unique element:
            if(nums[i] != nums[j]){
                //Increment i to move the slow pointer to the next available position.
                i++;
                //Copy the value of nums[j] to nums[i] to overwrite the duplicate.
                nums[i] = nums[j];
            }
        }
        //Arrays.stream(nums).forEach(System.out::println);
        //After the loop, i + 1 represents the number of unique elements kept in the array.
        return i + 1;
    }

    //Time Complexity: O(n), where n is the length of the array. Each element is visited and compared at most twice.
    //Space Complexity: O(1), as the algorithm uses constant extra space for pointers regardless of the input size.
}




// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
// Return k.
// Custom Judge:

// The judge will test your solution with the following code:

// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length

// int k = removeDuplicates(nums); // Calls your implementation

// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//     assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

 

// Example 1:

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
// Example 2:

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
 

// Constraints:

// 1 <= nums.length <= 3 * 104
// -100 <= nums[i] <= 100
// nums is sorted in non-decreasing order.
