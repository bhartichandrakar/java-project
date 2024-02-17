package LeetFull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] a = {3,2,4};
        int[] result = twoSum1(a , 6);
        Arrays.stream(result).forEach(System.out::println);
    }
    
    public static int[] twoSum1(int[] nums, int target) {
        // create a hash map to store the numbers and their indices
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // loop through the array
        for(int i=0; i<= nums.length; i++){
            // calculate the complement of the current number
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                 // return the indices of the two numbers
                return new int[]{i,map.get(complement)};
            }
            // otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        // if no solution is found, throw an error.
        return new int[] {};
    }
}

//This solution has a time complexity of O(n), where n is the length of the array, 
//and a space complexity of O(n), as we need to store n numbers in the map.








// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109



