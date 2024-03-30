package Leet;

import java.util.ArrayList;
import java.util.List;

public class L228SummaryRanges {
    public static void main(String[] args) {

        int[] nums = { 0, 2, 3, 4, 6, 8, 9 };
        List<String> result = summaryRanges(nums);
        result.stream().forEach(System.out::println);

    }

    public static List<String> summaryRanges(int[] nums) {
        /*
         * Initialization:
         * 
         * An empty ArrayList named result is created to store the summary ranges.
         * If the input nums array is empty (length == 0), an empty list is returned.
         */
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result; // Empty array, no ranges
        }

        /*
         * Iterating and Building Ranges:
         * 
         * start and end variables are initialized with the first element of nums. These
         * represent the current range being built.
         */
        int start = nums[0];
        int end = start;
        /*
         * The code iterates through nums using a for loop starting from the second
         * element (index 1).
         */
        for (int i = 1; i < nums.length; i++) {
            /*
             * Consecutive Elements: If the current element (nums[i]) is one more than the
             * previous end (end + 1), it means the sequence continues.
             * The end variable is incremented to extend the range.
             */
            if (nums[i] == end + 1) {
                end++; // Extend the range if consecutive
            }
            /*
             * n-Consecutive Elements: If the current element is not consecutive (nums[i] !=
             * end + 1), it signifies the end of the current range.
             * The previous range is formatted using the formatRange function and added to
             * the result list.
             * start and end are reset to the current element to begin building a new range.
             */
            else {
                result.add(formatRange(start, end)); // Add previous range and update values
                start = nums[i];
                end = start;
            }
        }
        /*
         * Adding the Last Range:
         * 
         * After processing all elements, the final range is formatted and added to the
         * result list.
         */
        result.add(formatRange(start, end)); // Add the last range
        return result;

        /*
         * Time Complexity:
         * 
         * The time complexity is O(N), where N is the length of the nums array.
         * The loop iterates through the array once, and the formatRange function has
         * constant time complexity.
         * Space Complexity:
         * 
         * The space complexity is O(N) in the worst case.
         * The result list can potentially store N strings if there are no consecutive
         * elements in the input array. However, in cases with many consecutive
         * elements, the list might store fewer strings.
         */

    }

    /*
     * Formatting Ranges:
     * 
     * The formatRange function takes start and end values and returns a String
     * representation of the range.
     * If start and end are equal (single element range), it returns the value as a
     * String.
     * Otherwise, it returns a String in the format "start->end" to indicate a
     * range.
     */
    private static String formatRange(int start, int end) {
        if (start == end) {
            return String.valueOf(start); // Single number range
        } else {
            return start + "->" + end; // Range format
        }
    }


     /* public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result; // Empty array, no ranges
        }
        int left = 0;
        int right = 0;
        int count = 1;
        while (count < nums.length) {
            if (nums[count] - nums[right] != 1) {
                if (right  == left) {
                    result.add(String.valueOf(nums[left]));
                }else{
                    result.add(nums[left] +"->"+nums[right]);
                }
                left = count;
                right = count;
            }else{
               right++;
            }
            count++;
        }
        if (right == left ) {
            result.add(String.valueOf(nums[left]));
        }else{
            result.add(nums[left] +"->"+nums[right]);
        }
        
        return result;
    } */

}

/*
 * You are given a sorted unique integer array nums.
 * 
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of the
 * ranges, and there is no integer x such that x is in one of the ranges but not
 * in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * "a->b" if a != b
 * "a" if a == b
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 * 
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order
 */