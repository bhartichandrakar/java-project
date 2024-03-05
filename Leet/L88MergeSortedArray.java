package Leet;

import java.util.Arrays;

public class L88MergeSortedArray {
    public static void main(String[] args) {

        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
        Arrays.stream(nums1).forEach(e -> System.out.println(e));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //Initialization:

        // i: Points to the last element of the filled part of nums1.
        // j: Points to the last element of nums2.
        // k: Points to the last element of the merged array in nums1 (initially at the end where elements will be placed).
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        //Merge loop:

        // Use a while loop to iterate as long as both i and j are not negative (meaning there are elements in both arrays).
        // In each iteration, compare the elements at indices i and j:
        // This effectively places the larger element from either array at the end of the merged portion (nums1[k]).
        while(i >= 0 && j >= 0){
            // If nums1[i] is greater, place it at nums1[k] and decrement both i and k.
            if (nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            }
            // If nums2[j] is greater, place it at nums1[k] and decrement both j and k.
            else {
                nums1[index--] = nums1[i--];
            }
        }
        // Copy remaining elements from nums2 (if any)
        //Copy remaining elements:

        //After the loop, if elements remain in nums2 (because j might not have reached -1), 
        //iterate through them using another while loop and copy them to the remaining positions of nums1 using k.
        while (j >= 0){
            nums1[index--] = nums2[j--];
        }
        // Time Complexity:

        // O(m + n): This represents the linear time complexity of iterating through both arrays (nums1 and nums2) at most once and performing constant-time comparisons and assignments in each iteration.
        // Space Complexity:

        // O(1): The solution modifies the original array nums1 in-place and uses a constant amount of extra space for loop counters and temporary variables.


        // int index = 0;
        // for(int i = m; i < nums1.length;i++){
        //     nums1[i] = nums2[index++];
        // }
        //Arrays.sort(nums1);
                
        // Bubble Sort: A simple but less efficient sorting algorithm. It iterates through the array repeatedly, 
        //swapping adjacent elements if they are in the wrong order. 
        //This is more for educational purposes and should not be used for 
        //large datasets due to its O(n^2) time complexity.
        //int k = nums1.length;
        // for(int i = 0;i < k - 1; i++){
        //     for(int j = 0; j < k - i - 1;j++){
        //         if(nums1[j] > nums1[j+1]){
        //             swap(nums1 , j , j+1);
        //         }
        //     }
        // }
        
    }

    // private static void swap(int[] nums1, int left, int right) {
    //     int temp=nums1[left];
    //     if(nums1[left] > nums1[right]){
    //         nums1[left] = nums1[right];
    //         nums1[right] = temp;
    //     }
    // }
}



// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
//and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
//To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
//and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

// Example 1:

// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
// Example 2:

// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].
// Example 3:

// Input: nums1 = [0], m = 0, nums2 = [1], n = 1
// Output: [1]
// Explanation: The arrays we are merging are [] and [1].
// The result of the merge is [1].
// Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

// Constraints:

// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[j] <= 109
 

// Follow up: Can you come up with an algorithm that runs in O(m + n) time?