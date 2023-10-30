package Leet;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "babad";
        String s = longestPalindrome(input);
        System.out.println(s);
    }
    public static String longestPalindrome(String s) {
        return null;
    }

    
    //Brute-Force
    // public static String longestPalindrome(String s) {
    //     int n = s.length(), start = 0, end = 0;
    //     boolean[][] dp = new boolean[n][n];
    //     for (int len = 0; len < n; len++) {
    //         for (int i = 0; i + len < n; i++) {
    //             int j = i + len;
    //             if (len == 0) {
    //                 dp[i][j] = true;
    //             } else if (len == 1) {
    //                 dp[i][j] = s.charAt(i) == s.charAt(j);
    //             } else {
    //                 dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
    //             }
    //             if (dp[i][j] && len > end - start) {
    //                 start = i;
    //                 end = j;
    //             }
    //         }
    //     }
    //     return s.substring(start, end + 1);
    // }
    
}
