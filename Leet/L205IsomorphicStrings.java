package Leet;

import java.util.HashMap;
import java.util.Map;

public class L205IsomorphicStrings {
    public static void main(String[] args) {
        String s = "badc", t = "baba";
        boolean result = isIsomorphic(s, t);
        System.out.println(result);
        
    }

    public static boolean isIsomorphic(String s, String t) {
        /* Base Case Check: It checks if s and t have different lengths. If so, they cannot be isomorphic and return false. */
        if(s.length() != t.length()){
            return false;
        }
        /* HashMap: A HashMap named map is used to store mappings between characters in s and their corresponding characters in t. */
    Map<Character, Character> map = new HashMap<Character, Character>();
    /* Looping and Mapping: The code iterates through each character (index count) of s and t using a while loop.
    Existing Mapping: If cS (character from s) already exists in map, it checks if the corresponding value (map.get(cS)) matches tS. If not, the strings are not isomorphic due to inconsistent mapping.
    New Mapping: If cS is not yet mapped, it checks if map.containsValue(tS). This checks if tS is already a value (mapped character) in the map. 
    If tS has already been used to map a different character in s, the strings are not isomorphic. Otherwise, charS is mapped to tS in map. */
        for (int i = 0; i < s.length(); i++) {
            Character cS = s.charAt(i);
            Character tS = t.charAt(i);
            if(map.get(cS) != null){
                if(map.get(cS) != tS){
                    return false;
                }
            }else{
                if(map.containsValue(tS)){
                    return false;
                }
                map.put(cS, tS);
            }
        }
        return true;
    }

    /* Time Complexity:

        The time complexity is O(N), where N is the length of the strings s and t.
        This is because the loop iterates through each character in the strings once. The operations within the loop (HashMap and HashSet lookups/insertions) generally have constant average time complexity. 
        Space Complexity:

        The space complexity is O(N) in the worst case.
        */
}




/* Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character. */
