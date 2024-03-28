package Leet;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class L202HappyNumber {

    public static void main(String[] args) {
        boolean result = isHappy(2);
        System.out.println(result);
    }

    public static boolean isHappy(int n) {
        /* HashSet for Seen Numbers: A HashSet named seenNumbers is used to track numbers encountered during the calculation. This helps detect cycles that prevent reaching 1. */
        Set<Integer> set = new HashSet<>();
        /* Loop and Calculate Sum of Squares: The code uses a while loop until n becomes 1.

        Inside the loop, it repeatedly calculates the sum of squares of digits in n.
        To extract each digit, it uses the modulo operator (%) to get the remainder and multiplies it by itself (digit * digit) to square it.
        Integer division (/) is used to remove the last digit from n for further processing in the next iteration. */
        while(n != 1){
            int sumOfSquare = 0;
            while (n > 0) {
                int lastDigit = n % 10;
                sumOfSquare += lastDigit * lastDigit;
                n = n /10;
            }
            /* Cycle Detection and Handling:

            After calculating the sum of squares (sumOfSquares), it checks if it exists in seenNumbers.
            If sumOfSquares is already seen, it means a cycle has been detected (repeating calculations without reaching 1). In this case, the function returns false.
            If sumOfSquares is not seen before, it's added to seenNumbers.
            The loop continues with n being assigned the newly calculated sumOfSquares for the next iteration. */
            if (set.contains(sumOfSquare)) {
                return false;
            }
            set.add(sumOfSquare);

            n = sumOfSquare;
        }
        /* Reaching 1:

        If the loop completes without encountering a cycle and n reaches 1, it means the calculation successfully reached 1, and the function returns true (happy number). */
        return true;
    }
    /* Time Complexity:

    The worst-case time complexity is O(n), where n is the initial value.
    This is because in the worst case, the calculation might enter an infinite loop if n never reaches 1. However, in practice, most numbers eventually reach 1 through the squaring process.
    Space Complexity:

    The space complexity is O(n) in the worst case.
    The seenNumbers HashSet can potentially store up to n unique numbers if the calculation enters a long cycle before reaching 1. */
}


/* Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

Example 1:

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
Example 2:

Input: n = 2
Output: false
 

Constraints:

1 <= n <= 231 - 1 */
