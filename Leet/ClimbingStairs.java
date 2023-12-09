package Leet;
//This solution is also for Fibonacci Series
public class ClimbingStairs {
    public static void main(String[] args) {
       int result = climbStairs(9);
       System.out.println(result);
    }

    public static int climbStairs(int n) {
        if(n <= 3) return n;
        int a = 2, b = 3; 
        for(int i = 0; i < n - 3; i++){
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
