package Striver.recursion;

public class CheckStringPalindromeNot {
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(palindrome(0, s));
    }

    private static boolean palindrome(int i, String s) {
        if (i>=s.length()/2) {
            return true;
        }

        if (s.charAt(i)!=s.charAt(s.length()-i-1)) {
            return false;
        }

        return palindrome(i+1, s);
        
    }

}
