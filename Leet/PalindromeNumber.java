package Leet;

public class PalindromeNumber {
    public static void main(String[] args) {
        boolean palindromeNumber = palindromeNumber(10);
        System.out.println(palindromeNumber);

    }

    private static boolean palindromeNumber(int n) {
        int r , sum =0, temp;
        temp = n;
        while(n >0){
            r = n % 10;
            sum = (sum*10) + r;
            n = n/10;
        }
        if (temp == sum) {
            return true;
        }else{
            return false;
        }
    }
}
