package LeetFull;

public class FirstOccurrenceString {
    public static void main(String[] args) {
        int result = strStr("aleetcode", "leet");
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        // If needle is empty, it is considered found at index 0, so return 0.
        if (needle.isEmpty()) {
            return 0; // Empty needle is found at index 0
        }
        //Iterate through haystack using an outer loop (i) from 0 to haystack.length() - needle.length() + 1. 
        //This ensures the window of characters in haystack being compared to needle is at least as long as needle.
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            //If the first character of haystack at index i matches the first character of needle:
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                //Initialize a second loop variable j to 1.
                //Compare subsequent characters in haystack (starting from i + 1) with the remaining characters in needle (starting from index j).
                while(j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
                    j++;
                }
                //If all characters match (j reaches the end of needle), return i as the starting index of the match.
                if(j == needle.length()){
                    return i;
                }
                //If the inner loop (j) completes without a full match, 
                //continue iterating the outer loop (i) to check the next potential starting point in haystack.
            }
        }
        //If the outer loop finishes without finding a match, return -1, indicating the needle is not present in the haystack.
        return -1;

        // Time Complexity:

        // Best case: O(1) if the first character of haystack doesn't match the first character of needle.
        // Average case: O(m * n), where m is the length of haystack and n is the length of needle. In the worst case, the outer loop iterates through all potential starting positions (m - n + 1) and the inner loop iterates through all characters of needle (n) for each potential match.
        // Space Complexity: O(1), as the algorithm uses constant extra space for variables regardless of the input size.
    }

    //Using indexOf function
    // public static int strStr(String haystack, String needle) {
    //     return haystack.indexOf(needle);
    // }
}


// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
// Example 2:

// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

// Constraints:

// 1 <= haystack.length, needle.length <= 104
// haystack and needle consist of only lowercase English characters.
