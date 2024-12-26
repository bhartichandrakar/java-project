package Striver.recursion;

public class FactorialOfANumber {
    public static void main(String[] args) {
        int fact = fact(4);
        System.out.println(fact);
    }

    private static int fact(int i) {
        if (i == 1) {
            return 1;
        }

        return i * fact(i-1);
    }

}
