package Leet;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    public static void main(String[] args) {
        int size = lengthOfLongestSubstring("abcabcb");
        System.out.println(size);
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int startIndex = 0;
        int endIndex = 0;
        int maxCount = 0;
        List<Character> countList = new ArrayList<Character>();
        while(endIndex < s.length()){
           
            if(!countList.contains(s.charAt(endIndex))){
                countList.add(s.charAt(endIndex));
                maxCount= Math.max(maxCount, countList.size());
                endIndex++;
            }else{
                countList.remove(Character.valueOf(s.charAt(startIndex)));
                startIndex++;
            }
        }
        countList.stream().forEach(System.out::println);
     return maxCount;
    }
}
