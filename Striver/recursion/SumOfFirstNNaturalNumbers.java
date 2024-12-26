package Striver.recursion;

public class SumOfFirstNNaturalNumbers {
    public static void main(String[] args) {

        sum(6, 0);

    }

    private static void sum(int i, int j) {
        
        if (i == 0) {
            System.out.println(j);
            return;
        }

        sum(i-1, j+i);
    }

}
