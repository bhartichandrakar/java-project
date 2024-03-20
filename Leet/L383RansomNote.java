package Leet;

import java.sql.Time;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L383RansomNote {
    public static void main(String[] args) {

       String ransomNote = "aa", magazine = "baa";
       boolean result = canConstruct(ransomNote, magazine);
       System.out.println(result);
        
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.isBlank()){
            return true;
        }
        if (magazine == null || magazine.length() == 0) {
            return false; // Empty magazine can't construct anything
        }
        // Character Count Array:

        // It creates an integer array charCounts of size 26. This array will store the frequency of each lowercase letter (a-z) in the magazine string.
        int[] charCounts = new int[26];
        //Counting Characters in Magazine:

        // It iterates through each character (c) in the magazine string.
        // It uses the ASCII value of the character (c) minus 'a' (offset for lowercase letters) as the index in the charCounts array. 
        //This efficiently maps characters to their corresponding count positions in the array.
        // It increments the count at the calculated index in charCounts to represent the frequency of that character in the magazine.
        for(Character c : magazine.toCharArray()){
            charCounts[c - 'a']++;
        }

        //Arrays.stream(point).forEach(System.out::println);
        //Checking Ransom Note Characters:

        // It iterates through each character (c) in the ransomNote string.
        // Verify Character Availability:

        // Similar to the brute force solution, it checks if the count for the current character (c) in the charCounts array is 0. 
        // This indicates that the required character is missing from the magazine, and the function returns false.
        // Decrement Character Count:

        // If the character is found with a sufficient count, the count at the corresponding index in charCounts is decremented by 1 to reflect its usage in the ransom note.
        // Return Result:

        // After iterating through the entire ransomNote, if no missing characters were encountered, 
        // it means all characters and their required frequencies are available in the magazine. The function returns true.
        for(Character c : ransomNote.toCharArray()){
            if (charCounts[c - 'a'] > 0) {
                charCounts[c - 'a']--;
            }else{
                return false;
            }
        }
        return true;

        // Time Complexity:

        // O(m + n): Similar to the brute force solution, it iterates through the characters in both strings (once for magazine and once for ransom note) in the worst case. This results in a linear time complexity of O(m + n), where m and n are the lengths of magazine and ransomNote, respectively.
        // Space Complexity:

        // O(1): The charCounts array has a fixed size of 26, regardless of the input string lengths. This makes the space complexity constant (O(1)).
        // Advantages:

        // This solution avoids building a hash map and utilizes a fixed-size array for character counts, leading to potentially better performance for larger datasets.
        // It leverages the fact that we only care about lowercase letters (a-z) and efficiently maps them to their corresponding count positions in the array.
    }

    // public static boolean canConstruct(String ransomNote, String magazine) {
    //     if(ransomNote.isBlank()){
    //         return true;
    //     }
    //     //Brute Force

    //     //Handle Empty Strings:

    //     // The code checks for empty strings:
    //     // If ransomNote is empty, it returns true because an empty note can be constructed from any magazine.
    //     // If magazine is empty, it returns false because no characters can be constructed from an empty magazine.
    //     // Character Frequency Map for Magazine:

    //     // It creates a HashMap named magazineMap to store the frequency of each character in the magazine string.
    //     // It iterates through the characters in magazine and updates the corresponding character count in the magazineMap.
    //     // Iterate Through Ransom Note:

    //     // It iterates through each character (c) in the ransomNote string.
    //     // Check Character Availability:

    //     // Inside the loop, it checks if the current character (c) exists in the magazineMap.
    //     // If the character is not found in the map, or its count in the map is 0 (no occurrences left), 
    //     //it means the required character is missing from the magazine, and the function returns false.
    //     // Decrement Character Count:

    //     // If the character is found in the magazineMap with a sufficient count, the count for that character is decremented by 1 in the map to indicate its usage in the ransom note.
    //     // Return Result:

    //     // After iterating through all characters in the ransomNote, 
    //     //if no missing characters or insufficient counts were encountered, it means the ransom note can be constructed from the characters (and their frequencies) available in the magazine. The function returns true.
    //     // Time Complexity:

    //     // O(m + n): In the worst case, it iterates through all characters in magazine (to build the map) and all characters in ransomNote (to check availability). This results in a linear time complexity of O(m + n), where m and n are the lengths of magazine and ransomNote, respectively.
    //     // Space Complexity:

    //     // O(min(m, n)): The magazineMap stores the character frequencies, and its size scales with the number of distinct characters and their frequencies in the smaller of magazine and ransomNote (whichever has fewer unique characters). This can be considered O(min(m, n)) in space complexity.
    //     Map<Character,Integer> map = new HashMap<>();
    //     for(Character c : magazine.toCharArray()){
    //         if (map.get(c) != null) {
    //             map.put(c, map.get(c)+1);
    //         }else{
    //             map.put(c, 1);
    //         }
    //     }

    //     for(Character c : ransomNote.toCharArray()){
    //         if (map.get(c) != null && map.get(c) > 0) {
    //             map.put(c, map.get(c)-1);
    //         }else{
    //             return false;
    //         }
    //     }
    //    return true;
    // }
}

// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

 

// Example 1:

// Input: ransomNote = "a", magazine = "b"
// Output: false
// Example 2:

// Input: ransomNote = "aa", magazine = "ab"
// Output: false
// Example 3:

// Input: ransomNote = "aa", magazine = "aab"
// Output: true
 

// Constraints:

// 1 <= ransomNote.length, magazine.length <= 105
// ransomNote and magazine consist of lowercase English letters.
