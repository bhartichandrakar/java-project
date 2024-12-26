package Striver.recursion;

public class PrintFibonacciSeries {

    public static void main(String[] args) {
        int N = 7;
        System.out.println(fibonacci(N));
    }

    private static int fibonacci(int n) {
       if (n <= 1) {
            return n;
       }
       int last = fibonacci(n-1);
       int slast = fibonacci(n-2);
       return last + slast;
    }

}
