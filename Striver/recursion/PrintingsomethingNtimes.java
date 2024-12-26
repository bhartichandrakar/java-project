package Striver.recursion;

public class PrintingsomethingNtimes {
    static int count = 1;

    public static void main(String[] args) {
        printNtime(6);
    }

    private static void printNtime(int n) {

        if (n == 0) {
            return;
        }
        
        
        //count = count + 1;
        printNtime(n - 1);
        System.out.println(n);
        

    }

}
