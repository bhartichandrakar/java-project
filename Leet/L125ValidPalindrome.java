package Leet;

public class L125ValidPalindrome {
    public static void main(String[] args) {
        boolean result = isPalindrome(" ");
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        //Handle edge cases: Check for an empty or null string, which are considered palindromes.
        if (s == null || s.isEmpty()) {
            return true; // Empty string is a palindrome
        }
        //Initialize pointers:

        // left pointer starts at the beginning of the string.
        // right pointer starts at the end of the string.
        int left = 0;
        int right = s.length() - 1;
        //Two-pointer comparison loop:
        //Use a while loop to iterate as long as left is less than right (meaning there are characters to compare in the middle).
        while (left < right) {
            //Convert characters at both left and right indices to lowercase using Character.toLowerCase().
            char charLeft = Character.toLowerCase(s.charAt(left)); // Convert to lowercase
            //Check if the character at left is not alphanumeric using Character.isAlphanumeric():
            char charRight = Character.toLowerCase(s.charAt(right)); // Convert to lowercase
            //If not, increment left to skip non-alphanumeric characters.
            if (!Character.isLetterOrDigit(charLeft)) {
                left++; // Skip non-alphanumeric characters from left
            } 
            //Similarly, check the character at right for non-alphanumeric characters and increment right if needed.
            else if (!Character.isLetterOrDigit(charRight)) {
                right--; // Skip non-alphanumeric characters from right
            }
            //If both characters are alphanumeric but don't match (charLeft != charRight), it's not a palindrome, so return false.
            else if (charLeft == charRight) {
                left++;
                right--;
            }
            //If characters match, move both pointers inwards (left++ and right--) for the next comparison.
            else{
                return false;
            }
        }
        //If the loop completes without finding any mismatches, all characters have been compared successfully, and the string is a palindrome, so return true.
        return true;

        // Time Complexity:

        // O(n): The time complexity is linear in the length of the input string s. 
        //In the worst case, the loop iterates through the entire string once, comparing characters and performing constant-time operations.

        // Space Complexity:

        // O(1): The solution uses a constant amount of extra space for loop counters, variables, and temporary character storage. 
        //It modifies the input string characters in-place using Character.toLowerCase() but doesn't create new strings, 
        //so the space complexity remains constant.
    }
}

// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
//it reads the same forward and backward. Alphanumeric characters include letters and numbers.

// Given a string s, return true if it is a palindrome, or false otherwise.

 

// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
// Example 3:

// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.
 

// Constraints:

// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.