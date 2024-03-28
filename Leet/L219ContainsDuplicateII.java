package Leet;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class L219ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        /* HashMap for Last Seen Indices: A HashMap named lastSeen is used to store the last seen index of each number encountered in the nums array. */
        Map<Integer,Integer> map = new HashMap<>();
        /* Looping and Checking: The code iterates through each element (num) in the nums array using a for loop with an index i.

        Duplicate Found: If lastSeen already contains the current number (num), it checks if the difference between the current index (i) and the last seen index (lastSeen.get(num)) is less than or equal to k.
        If the difference is less than or equal to k, it means a duplicate was found within the allowed distance k, and the function returns true.
        Update Last Seen Index: If the number is not seen before (or the previous occurrence was beyond the k distance), the current index (i) is stored as the last seen index for num in the lastSeen HashMap. */
        for(int i = 0; i <nums.length; i++){
            if (map.containsKey(nums[i])) {
                if(Math.abs(i - map.get(nums[i])) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        /* No Duplicates Found: If the loop completes without finding any duplicates within the allowed k distance, the function returns false. */
        return false;
    }
    /* Time Complexity:

    The time complexity is O(N), where N is the length of the nums array.
    This is because the loop iterates through each element in the array once, and HashMap operations (get, put, containsKey) generally have constant average time complexity.
    Space Complexity:

    The space complexity is O(min(N, k)) in the worst case.
    The lastSeen HashMap will store at most min(N, k) unique numbers and their corresponding last seen indices.
    In the best case (no duplicates), lastSeen might only store a few entries (less than k).
    In the worst case (all elements are duplicates within k distance), lastSeen might store up to N entries. */
}


/* Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false */
