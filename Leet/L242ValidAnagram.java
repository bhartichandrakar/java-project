package Leet;

import java.sql.Time;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L242ValidAnagram {
    public static void main(String[] args) {
        String s = "ab", t = "a";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
       /*  Length Check: It first checks if the lengths of s and t are equal. If not, they cannot be anagrams (same characters with different frequencies). */
       if(s.length() != t.length()) return false;
      /*  HashMap for Character Counts: A HashMap named charCount is used to store the frequency of each character encountered. */
       Map<Character, Integer> charCount = new HashMap<>();

        // Count character occurrences in s
       /*  Counting Characters in s: The code iterates through each character in s using a character array (s.toCharArray()) and updates the count in charCount. 
        If a character is encountered for the first time, its count is initialized to 1. Otherwise, the existing count is incremented. */
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if same characters and frequencies exist in t
        /* Checking Characters and Frequencies in t: The code iterates through each character in t.
        Character Not Found or Frequency Exhausted: If the character (c) from t is not present in charCount (meaning it doesn't exist in s) or 
        its count has already reached 0 in charCount (meaning all occurrences in s have been used), then t cannot be an anagram of s.
        Frequency Decrement: If the character is found in charCount with a positive count, the count is decremented (since we've encountered that character in t). */
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1); // Decrement count for t
        }

        return true;

        /* Time Complexity:

        The time complexity is O(N), where N is the length of the longer string (s or t).
        This is because both loops iterate through each character in the strings, and HashMap operations (get, put) generally have constant average time complexity.
        Space Complexity:

        The space complexity is O(1) or constant in this specific case.
        The charCount HashMap will hold at most 26 entries (for lowercase English letters), regardless of the input string lengths. */

       //Brute-Force
       /* char[] as = s.toCharArray();
       Arrays.sort(as);
       s = new String(as);

       char[] at = t.toCharArray();
       Arrays.sort(at);
       t = new String(at);

       if (!t.equals(s)) {
        return false;
       }
        return true; */
    }
}


/* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case? */
