package LeetFull;

public class PalindromeNumber {

    public static void main(String[] args) {
        boolean result = isPalindrome(121);
        System.out.println(result);
    }


public static boolean isPalindrome(int x) {
        //Initialize two variables: original to store the original number and reversed to store the reversed number.
        int original = x;
        int reversed = 0;
        while (original > 0) {
            //In the loop, extract the last digit (unit) of original using modulo (%) and add it to reversed.
            int unit = original % 10;
            reversed = 10 * reversed + unit;
            //Update original by dividing it by 10 (to remove the last digit).
            original /= 10;
            //Repeat the process until original becomes 0.
        }
        //Finally, compare reversed with the original number. If they are equal, it’s a palindrome.
        return reversed == x;
}

// public boolean isPalindrome(int x) {
//     Convert the integer x to a string (strX).
//     Use StringBuilder to reverse strX    
//     String strX = Integer.toString(x);
//     Compare the reversed string with the original string. If they are equal, it’s a palindrome.
//     return strX.equals(new StringBuilder(strX).reverse().toString());
// }
    
}


// public boolean isPalindrome(int x) {
//     if (x < 0) return false;
//     //Convert x to a string (strX).
//     String strX = Integer.toString(x);
//     //Initialize two pointers (left and right) at the beginning and end of the string.
//     int left = 0;
//     int right = strX.length() - 1;
//     //Compare characters at these pointers while moving them towards each other.
//     while (left < right) {
//         //If any pair of characters doesn’t match, it’s not a palindrome.
//         if (strX.charAt(left) != strX.charAt(right)) return false;
//         left++;
//         right--;
//     }
//     return true;
// }


// Time Complexity:

// All three approaches have a time complexity of O(log N), where N is the input number.
// The space complexity is O(1) for the first two approaches and O(log N) for the third approach (due to string conversion).







// Given an integer x, return true if x is a 
// palindrome
// , and false otherwise.

 

// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

// Constraints:

// -231 <= x <= 231 - 1