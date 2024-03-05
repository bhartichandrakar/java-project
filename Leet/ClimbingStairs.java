package Leet;


public class ClimbingStairs {

    public static void main(String[] args) {
        int result = climbStairs(5);
        System.out.println(result);
     }

   //   The Fibonacci series is a sequence of numbers where each number is the sum of the two preceding ones, 
   //   usually starting with 0 and 1. The sequence begins: 0, 1, 1, 2, 3, 5, 8, 13, 21, and so on.
     public static int climbStairs(int n) {
      //If n is less than or equal to 3, the Fibonacci number is simply n itself (0, 1, 2, and 3 are the first four Fibonacci numbers).
      if(n <= 3) return n;
      //Two integer variables, a and b, are initialized with the values 2 and 3, respectively.
      //These represent the second and third Fibonacci numbers, which are needed to calculate subsequent numbers in the sequence.
      int a = 2, b = 3; 
      for(int i = 0; i < n - 3; i++){
         //The value of b is updated to the sum of the current a and b (representing the next Fibonacci number).
          b = a + b;
          //The value of a is updated to the previous value of b (shifting values for the next iteration).
          a = b - a;
      }
      //After the loop completes, the final value of b holds the nth Fibonacci number, and it is returned.
      return b;
     }
    
    // Time Complexity:

// Best case: O(1), if n is less than or equal to 3, as the base case calculation dominates.
// Average/Worst case: O(n), as the loop iterates n - 3 times in the worst case, but the constant number of operations within the loop makes it linear in n.
// Space Complexity:

// O(1), as the code uses only constant extra space for variables a, b, and loop counters, regardless of the input value n. 
// This is significantly better than using recursion for this calculation, which can lead to space complexity proportional to the recursion depth (in this case, n).
}

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
