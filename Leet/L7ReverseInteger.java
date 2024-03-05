package Leet;

public class L7ReverseInteger {
    public static void main(String[] args) {
        int result = reverse(1534236469);
        System.out.println(result);
    }

    public static int reverse(int x) {
        //Get the Absolute Value:

        // int num = Math.abs(x);: This line takes the absolute value of the input integer x and stores it in a new variable num. 
        // This is necessary because the reversal logic works the same for positive and negative numbers, but the overflow checks need to consider the sign.
        int num = Math.abs(x);
        // Initialize Variables:

        // int rev = 0;: This initializes a variable rev to 0, which will be used to store the reversed integer digit by digit.
        int rev = 0;
        //while (num != 0): This while loop continues as long as num (the absolute value) is not zero. 
        //In each iteration, the loop extracts a digit and adds it to the rev (reversed number).
        while (num != 0) {
            //This line extracts the last digit of num using the modulo operator (%). 
            //The remainder after dividing num by 10 is the last digit, which is stored in ld (last digit).
            int ld = num % 10;
            
            // Overflow check
            //Overflow check:
            // This line checks for potential overflow. It compares the current rev with the maximum possible value an integer can hold divided by 10, minus the extracted digit (ld). 
            // If this condition is true, it means adding ld to rev would cause an overflow
            if (rev > (Integer.MAX_VALUE - ld) / 10) {
                //return 0;: If overflow is detected, the function returns 0 to indicate an invalid input.
                return 0;
            }
            //This line builds the reversed number. 
            //It multiplies the current rev by 10 (shifting existing digits left) and then adds the extracted last digit (ld) to the rightmost position.
            rev = rev * 10 + ld;
            //This line removes the last digit from the original number num by performing integer division (/)
            num = num / 10;
        }
        //This line handles the sign of the original input x.
        // If x is negative (x < 0), it negates the reversed number (-rev) to maintain the original sign.
        // Otherwise, it returns the rev (positive reversed number).
        return (x < 0) ? (-rev) : rev;
        // The time complexity of this solution is O(log10(x)), which represents the number of digits in the input integer.
        // The space complexity is O(1) as it uses a constant amount of extra space for variables.


        //brute-force
        // String str  = Integer.toString(x);
        // StringBuilder sb = new StringBuilder();
        // if (str.charAt(0) == '-') {
        //     sb.append("-");
        // }
        // for(int i = str.length() - 1; i >= 0 ; i--){
        //     if (str.charAt(i) != '-') {
        //         sb.append(str.charAt(i));
        //     }
        // }
        // int res = 0;
        // try{
        //     res = Integer.valueOf(sb.toString());
        // }catch (NumberFormatException e) {
        //     System.err.println("Error: Invalid number format");
        // }
        
        // return res;
    }
}

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21
 

// Constraints:

// -231 <= x <= 231 - 1