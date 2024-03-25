package Leet;

import java.util.HashMap;
import java.util.Map;

public class L290WordPattern {
    public static void main(String[] args) {

        String pattern = "abba", s = "dog dog dog dog";
        boolean result = wordPattern(pattern, s);
        System.out.println(result);
        
    }

    public static boolean wordPattern(String pattern, String s) {
        /* HashMaps for Mapping: Two HashMaps are used:
        charMap: Maps characters from the pattern (charP) to the corresponding words (word).
        wordMap: Maps words (word) to the corresponding characters from the pattern (charP). */
        Map<Character, String> map = new HashMap<>();
        /* Split String into Words: The code splits the str string into an array of words (words) using the split(" ") method. */
        String[] ss = s.split(" ");
        /* Length Check: It checks if the number of words (words.length) matches the length of the pattern (pattern.length). 
        If not, the strings cannot follow the same pattern. */
        if(pattern.length() != ss.length) return false;
        /* Looping and Mapping: The code iterates through each character (charP) in pattern and its corresponding word (word) at the same index (i).
        Existing Mapping: If charP already exists in charMap, it checks if the corresponding word (charMap.get(charP)) matches the current word. If not, the pattern is not followed consistently.
        New Mapping: If charP is not yet mapped, and word is not present in wordMap, it creates new mappings for both HashMaps, associating charP with word and vice versa.
        Word Used for Different Character: If word already exists in wordMap but is mapped to a different character than charP, the pattern is not followed (same word used for different characters). */
        for(Character i = 0; i < pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
               if(!map.get(pattern.charAt(i)).equals(ss[i])){
                return false; // Inconsistent mapping in pattern
               }
            }else{
                if(map.containsValue(ss[i])){
                    return false; // Word used for different character
                }
                map.put(pattern.charAt(i), ss[i]);
            }
        }
        return true;
    }

    /* Time Complexity:

    The time complexity is O(N), where N is the minimum of the length of the pattern and the number of words (words.length).
    The loop iterates through each character-word pair, and the HashMap operations (get, put, containsKey) generally have constant average time complexity.
    Space Complexity:

    The space complexity is O(N) in the worst case.
    The HashMaps charMap and wordMap can potentially store up to N unique characters/words depending on the input strings. */
}


/* Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space. */