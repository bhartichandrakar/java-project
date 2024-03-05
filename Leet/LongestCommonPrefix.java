package Leet;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String result = longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        //Checks if the input array strs is null or empty. If so, returns an empty string as there's no common prefix.
        if(strs == null || strs.length == 0){
            return "";
        }
        //Sorts the array of strings using Arrays.sort(strs). This ensures that strings with a common prefix will be placed consecutively.
        Arrays.sort(strs);
        //Initializes index to 0 to track character positions.
        int index = 0;
        //Gets the first and last strings from the sorted array (first = strs[0]
        String first = strs[0];
        //last = strs[strs.length - 1])
        String last = strs[strs.length - 1];
        //Enters a while loop that continues as long as index is within the bounds of the first string's length.
        while(index < first.length()){
            //Compares the characters at the current index of both first and last strings.
            if(first.charAt(index)==last.charAt(index)){
                //If the characters match, increments index to move to the next character.
                index++;
            }else{
                //If the characters don't match, breaks out of the loop as a mismatch indicates the end of the common prefix.
                break;
            }
        }
        //If index is still 0 after the loop, it means no common prefix was found, so returns an empty string.
        //Otherwise, returns a substring of first from the beginning up to (but not including) index, representing the longest common prefix.
        return index==0?"":first.substring(0, index);
    }
    
}

//Time Complexity: O(S log S), where S is the sum of the lengths of all strings. Sorting takes O(S log S) time, and the remaining comparisons take O(S) time.
//Space Complexity: O(1), as the algorithm uses constant extra space for variables regardless of the input size.
//Sorting Trade-off: Sorting the strings adds a log S factor to the time complexity, but it simplifies the comparison process.




// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
 

// Constraints:

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters.
