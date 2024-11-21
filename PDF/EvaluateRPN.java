package PDF;

import java.util.Stack;

public class EvaluateRPN {

    public static void main(String[] args) {
        String[] arr = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(arr));
    }

    public static int evalRPN(String[] tokens) {

        int result = 0;
        String operators = "+-/*";

        Stack<String> stack = new Stack<String>();

        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a+b));
                        break;
                
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;

                    case "*":
                        stack.push(String.valueOf(a*b));
                        break;

                    case "/":
                        stack.push(String.valueOf(a/b));  
                }
            }
        }

        result = Integer.valueOf(stack.pop());
        return result;
    }
}