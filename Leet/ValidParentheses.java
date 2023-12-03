package Leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        boolean result = isValid("[{()}]()");
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for(Character c : s.toCharArray()){
            if(c == '['){
                stack.push(']');
            }else if (c == '{') {
                stack.push('}');
            }else if (c == '(') {
                stack.push(')');
            }else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
     return stack.isEmpty(); 
    }
}
