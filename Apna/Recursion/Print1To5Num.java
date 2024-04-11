package Apna.Recursion;

public class Print1To5Num {
    public static void main(String[] args) {
        printNum(1);
    }

    private static void printNum(int i) {
        if (i == 6) {
            return;
        }
        System.out.println(i);
        printNum(i+1);
    }
}
