package Leet;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9,9};
        int[] result = plusOne(digits);
        Arrays.stream(result).forEach(System.out::println);
        
    }

    public static int[] plusOne(int[] digits) {

        //iterates through the digits array in reverse order using a loop
        for(int i = digits.length - 1; i >= 0;i--){
            //If the digit is not 9, it simply needs to be incremented by 1 
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
            //If the digit is 9, it needs to be reset to 0 (digits[i] = 0), 
            //and a carry of 1 needs to be propagated to the next position (handled later).
            else{
                digits[i]=0;
            }
        }

        // Handle overflow:

        // If the loop completes without a return statement (meaning all digits were 9), it signifies an overflow scenario where the incremented value requires an extra digit.
        // In this case, a new array result with one extra element (digits.length + 1) is created.
        // The first element of result is set to 1 (result[0] = 1), representing the new most significant digit due to the overflow carry.
        // The original digits are copied from their second element (1) to the new array (result).
        // Finally, the result array is returned, representing the incremented number with the extra digit.

        int[] result = new int[digits.length+1];
        result[0]=1;
        return result;
    }

    // Time Complexity:

    // Best case (no overflow): O(1), as the loop iterates through the array only once and the in-place modification avoids creating a new array.
    // Worst case (overflow): O(n), where n is the length of the array, due to creating a new array and copying elements. However, this occurs only when all digits are 9, which is a less frequent scenario.
    // Space Complexity:

    // Best case (no overflow): O(1), as the algorithm modifies the original array in-place.
    // Worst case (overflow): O(n + 1), due to creating a new array with one extra element.
    
}


// You are given a large integer represented as an integer array digits, 
//where each digits[i] is the ith digit of the integer. 
//The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

// Increment the large integer by one and return the resulting array of digits.

 

// Example 1:

// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].
// Example 2:

// Input: digits = [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
// Incrementing by one gives 4321 + 1 = 4322.
// Thus, the result should be [4,3,2,2].
// Example 3:

// Input: digits = [9]
// Output: [1,0]
// Explanation: The array represents the integer 9.
// Incrementing by one gives 9 + 1 = 10.
// Thus, the result should be [1,0].
 

// Constraints:

// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
// digits does not contain any leading 0's.
