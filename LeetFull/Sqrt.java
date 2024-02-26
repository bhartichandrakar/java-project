package LeetFull;

public class Sqrt {

    public static void main(String[] args) {
        int result = mySqrt(26);
        System.out.println(result);
    }
    public static int mySqrt(int x) {
        //left: Starts at 1 (potential square root value).
        long left = 1;
        //right: Starts at x (upper bound of possible square roots).
        long right = x;
        //mid: calculated in each iteration to split the search space.
        long mid = 0;
        //If x is 0, its square root is 0, so return 0.
        if(x == 0) return 0;
        //If x is less than 3 (1 or 2), its square root is 1, so return 1.
        if (x < 3) {
            return 1;
        }
        //Binary search loop:
        //Run a loop as long as left is less than or equal to right and the difference between right and left is greater than 1 (to avoid infinite loops with single-element search space).
        while (left <= right && right - left > 1) {
            //Calculate mid: the middle point of the current search space
            mid = left + (right - left)/2;
            //If (mid * mid) == x, then mid is the square root, so return it (cast to int for integer part).
            if((mid * mid) == x){
                return (int)mid;
            }
            //Check for square root exceeding x:
            //If (mid * mid) < x, we need to search in the right half of the search space, 
            //so update left to mid (excluding mid itself as it's already checked).
            else if((mid * mid) < x){
                left = mid;
            }
            //Check for square root falling short of x:
            //If (mid * mid) > x, we need to search in the left half of the search space, so update right to mid (excluding mid itself as it's already checked).
            else if((mid * mid) > x){
                right = mid;
            }
        }
        //If the loop completes without finding an exact match, it means the square root is between left and right. Since (left * left) <= x and (right * right) > x, left represents the closest integer square root, so return it (cast to int).
        return (int)left;
    }
    //The time complexity of the provided code snippet is O(log n), where n is the initial value of x
}


// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

// Example 1:

// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.
// Example 2:

// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

// Constraints:

// 0 <= x <= 231 - 1
