package Leet;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String first = strs[0];
        int index = 0;
        String last = strs[strs.length - 1];
        while (index < first.length()) {
            if(first.charAt(index)==last.charAt(index)){
                index++;
            }else{
                break;
            }
         
        }
        return index==0?"":first.substring(0, index);
    }
    
}
