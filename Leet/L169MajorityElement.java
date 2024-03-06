package Leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L169MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    //Boyer-Moore Voting Algorithm Solution:
    //Explanation:

    // Initialization:

    // Two variables are initialized:
    // count: keeps track of the number of times the current candidate element has been seen minus the number of times other elements have been seen.
    // candidate: stores the current potential majority element.
    // Iterate and Update Count:

    // A for-each loop iterates through each element (num) in the array nums.
    // Inside the loop:
    // If count is 0, it means no majority element has been identified yet. In this case, the current element (num) becomes the candidate (candidate = num).
    // The count is updated based on the current element and the candidate:
    // If the current element (num) is the same as the candidate (num == candidate), the count is incremented by 1, indicating another occurrence of the potential majority element.
    // If the current element is different from the candidate, the count is decremented by 1. 
    //This essentially cancels out the previous occurrences of non-candidate elements as long as the candidate keeps appearing.
    // Majority Element:

    // After iterating through the entire array, the candidate variable will hold the element that appeared more than half the times in the array (if a majority element exists). 
    //This is because any non-majority element's occurrences will be canceled out by the opposing decrements in the count.
    // Time Complexity:

    // O(n): The solution iterates through the array only once using a for-each loop. This results in a linear time complexity.
    // Space Complexity:

    // O(1): The solution uses constant extra space for the count and candidate variables, regardless of the array size.
    // Advantages:

    // This approach is significantly more efficient than the brute force method for larger datasets due to its linear time complexity.
    // It avoids the need for additional data structures like a hash table.
    // This solution effectively utilizes the Boyer-Moore Voting Algorithm to find the majority element in an array with a time complexity of O(n) and space complexity of O(1), 
    //making it a preferred approach for this problem.
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0; // Stores the potential majority element

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // The code begins by sorting the array nums in non-decreasing order using the sort function from the C++ Standard Library. 
    //This rearranges the elements such that identical elements are grouped together.
    // Once the array is sorted, the majority element will always be present at index n/2, where n is the size of the array.
    // This is because the majority element occurs more than n/2 times, and when the array is sorted, it will occupy the middle position.
    // The code returns the element at index n/2 as the majority element.
    // The time complexity of this approach is O(n log n) since sorting an array of size n takes O(n log n) time.
    // public static int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     int n = nums.length;
    //     return nums[n/2];
    // }



    //brute force
    //HashMap for Element Counts:

    // It creates a HashMap named map to store the count of each element encountered in the array.
    // Iterate and Count Elements:

    // A for loop iterates through each element (nums[i]) in the array nums.
    // Inside the loop:
    // It checks if the element (nums[i]) already exists as a key in the map.
    // If it exists (map.get(nums[i]) != null), the code retrieves the current count for that element (count = map.get(nums[i])).
    // If it doesn't exist, the count is initialized to 0 (count = 0).
    // The count for the current element is incremented using ++count.
    // The updated count is then stored back in the map with the element as the key (map.put(nums[i], count)).
    // Find Majority Element:

    // After iterating through the entire array, the code searches for the element with the highest count in the map.
    // It initializes two variables: max to store the maximum count encountered so far and result to store the element with the maximum count.
    // It iterates through all the key-value pairs in the map using a loop over the entrySet of the map.
    // Inside the loop:
    // It compares the current element's count (entry.getValue()) with the max value.
    // If the current element's count is greater than max, it updates max and result with the current element and its count, respectively.
    // Return Majority Element:

    // After iterating through all elements in the map, the result variable will hold the element that appeared the most times in the array (majority element). The function returns this value.
    // Time Complexity:

    // O(n): The solution iterates through the array once using a for loop and iterates through the map entries once using a loop over the entrySet. This results in a linear time complexity of O(n).
    // Space Complexity:

    // O(n): In the worst case, the HashMap can store up to n unique elements from the array, each with their corresponding count. Therefore, the space complexity is considered O(n).
    // Drawbacks:

    // This approach might not be optimal for very large arrays due to the space required for the HashMap.
    // public static int majorityElement(int[] nums) {
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int i = 0; i < nums.length; i++){
    //         int count = 0;
    //         if (map != null && map.get(nums[i]) != null) {
    //             count = map.get(nums[i]);
    //             map.put(nums[i], ++count);
    //         }else{
    //             map.put(nums[i], ++count);
    //         }
    //     }
    //     int max = 0;
    //     int result = 0;
    //     for(Map.Entry<Integer,Integer> entry : map.entrySet()){
    //         if(entry.getValue() > max){
    //             result = entry.getKey();
    //             max = entry.getValue();
    //         }
    //     }
    //     return result;
    // }
}


// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
 

// Constraints:

// n == nums.length
// 1 <= n <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow-up: Could you solve the problem in linear time and in O(1) space?
