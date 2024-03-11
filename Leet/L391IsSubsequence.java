package Leet;

public class L391IsSubsequence {
    public static void main(String[] args) {
       String s = "abc", t = "";
       boolean result = isSubsequence(s, t);
       System.out.println(result); 
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if ((s.length() < 1 && t.length() > 0) || (s.length() < 1 && t.length() < 1)) {
            return true;
        }
        boolean result = false;
        if (s.charAt(0) != t.charAt(0)) {
            return result;
        }
        int sLength = s.length();
        int tLength = t.length();
        for(int i = 1; i < sLength; i++){
            boolean found = false;
            for(int j = 1; j < tLength; j++){
                if (s.charAt(i) == t.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }

        return true;
    }
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
