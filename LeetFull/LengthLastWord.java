package LeetFull;

public class LengthLastWord {
    public static void main(String[] args) {
        String s = "luffy is still joyboy   ";
        int result = lengthOfLastWord(s);
        System.out.println(result);       
    }

    //1. Single Pass Approach:
    public static int lengthOfLastWord(String s) {
        //Initialize length to 0
        int length = 0;
        //Iterate through the string in reverse order (i = s.length() - 1).
        for(int i = s.length() -1; i >= 0 ; i--){
            //For each character:
            //If it's not a space (' '), increment length.
            if(s.charAt(i) != ' '){
                length++;
            }
            //If it's a space, and length is greater than 0 (meaning a word preceded it), return length as the last word's length.
            else if(length > 0){
                return length;
            }
        }
        //If the loop finishes without encountering a space after a word, return the final length
        return length;

        //Time Complexity: O(n), where n is the length of the input string. Each character is visited at most once.
        //Space Complexity: O(1), as the algorithm uses constant extra space for variables regardless of the input size.
    }

    //2. String Split Approach:

    // public static int lengthOfLastWord(String s) {
        //Trim the string: Remove leading and trailing whitespace using s.trim().
        //Split on space: Split the string into separate words using split(" ").
    //     String[] words = s.trim().split(" ");
        //If there are words (array length > 0), return the length of the last word (words[words.length - 1]).
        //If there are no words (length == 0), return 0 as the last word's length.
    //     return words.length > 0 ? words[words.length - 1].length() : 0;

        //Time Complexity: O(n), where n is the length of the input string in the worst case due to the split operation.
        //Space Complexity: O(n), as the split operation might create a new string array in the worst case.
    // }
}

//Choosing the Approach:

//Single pass: Generally preferred due to its lower space complexity (O(1)) and efficient handling of edge cases (trailing whitespaces).
//String split: Can be slightly slower due to string manipulation overhead, but it's simpler to read and understand for beginners.

// Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal 
// substring
//  consisting of non-space characters only.

 

// Example 1:

// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.
// Example 2:

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.
// Example 3:

// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.
 

// Constraints:

// 1 <= s.length <= 104
// s consists of only English letters and spaces ' '.
// There will be at least one word in s.
