package Apna.Recursion;

public class SumOfNNum {
    public static void main(String[] args) {
        int i = 1;
        int n = 5;
        int sum = 0;
        printSum(i, n, sum);
    }

    private static void printSum(int i, int n, int sum) {
        if (i == n) {
            sum += i;
            System.out.println(sum);
            return; 
        }
        sum += i;
        printSum(i+1, n, sum);
        System.out.println(sum);
    }
}
