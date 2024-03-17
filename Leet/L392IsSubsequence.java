package Leet;

public class L392IsSubsequence {
    public static void main(String[] args) {
       String s = "acb", t = "ahbgdc";
       boolean result = isSubsequence(s, t);
       System.out.println(result); 
    }

    public static boolean isSubsequence(String s, String t) {
        // Handle Empty String s:

        // The code checks if the input string s is null or empty. If so, it returns true because an empty string is considered a subsequence of any other string.
        if (s == null || s.length() == 0) {
            return true; // Empty s is a subsequence of any t
        }
        // Pointers and Loop:

        // It initializes two integer variables:
        // i: pointer for iterating through the string s.
        // j: pointer for iterating through the string t.
        
        int sIndex = 0;
        int tIndex = 0;
        //A while loop continues as long as both pointers haven't reached the end of their respective strings (i < s.length() and j < t.length()).
        while (sIndex < s.length() && tIndex < t.length()) {
            //Inside the loop, it compares the characters at the current positions of both pointers (s.charAt(i) and t.charAt(j))
            //If the characters match, it means the current character in s is found in t. The i pointer (for s) is incremented to move on to the next character in s.
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            //Always Move t Pointer:

            //Regardless of whether the characters match or not, the j pointer (for t) is always incremented. This ensures we iterate through the entire string t.
                tIndex++;
        }
        //Return Condition:

        // After the loop finishes, the function checks if the i pointer (for s) has reached the end of the string s (i == s.length()). This indicates that all characters in s have been found in their correct order within t.
        // If all characters are found, it returns true, indicating s is a subsequence of t. Otherwise, it returns false.
        return sIndex == s.length();
    }

    //Time Complexity:

    // O(min(m, n)): The solution uses two pointers and iterates through the shorter of the two strings (s or t) in the worst case, resulting in linear time complexity proportional to the minimum length between s and t.
    // Space Complexity:

    // O(1): The solution uses constant extra space for the two pointers and loop variables, regardless of the string lengths.
}

// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false
 

// Constraints:

// 0 <= s.length <= 100
// 0 <= t.length <= 104
// s and t consist only of lowercase English letters.
 

// Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?