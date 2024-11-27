package PDF;

import java.util.HashMap;
import java.util.Map;

public class L205IsomorphicStrings {

    public static void main(String[] args) {

        boolean isomorphic = isIsomorphic("foo", "bar");
        System.out.println(isomorphic);
        
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character,Character> map = new HashMap<Character,Character>();

        for(int i = 0; i < s.length(); i++){
            Character cS = s.charAt(i);
            Character tS = t.charAt(i);
            if (map.get(cS) != null) {
                if(map.get(cS) != tS){
                    return false;
                }
            }else{
                if(map.containsValue(tS)){
                    return false;
                }
            }
            map.put(cS, tS);  
        }
        return true;
    }

}
