package Striver.recursion;

public class Print1ToNUsingRecursion {
    public static void main(String[] args) {
        int n = 5;
        func(n, n);
    }
    //using recursive approach
    // private static void func(int i, int n) {
    //     if (i > n) {
    //         return;
    //     }

    //     System.out.println(i);
    //     func(i+1, n);
    // }

    //using backtracking approach
    private static void func(int i, int n) {
        if (i < 1) {
            return;
        }

        
        func(i-1, n);
        System.out.println(i);
    }

}
