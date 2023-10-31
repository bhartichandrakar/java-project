package Leet;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s ="IV";
        int result = romanToInt(s);
        System.out.println(result);
        
    }
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int number = 0;
        int currentVal = 0;
        for(int i = s.length() -1; i >= 0 ; i-- ){
            int val = map.get(s.charAt(i));
            if(currentVal == 0){
                currentVal = val;
            }else if (currentVal > val){
                
            }
        }

        return number;
    }
}
