package Leet;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        boolean result = isValid("[{(){}()}]");
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        //Initialize an empty stack to store opening parentheses temporarily.
        Stack<Character> stack = new Stack<Character>();
        //Loop through each character in the input string.
        for(Character c : s.toCharArray()){
            //If the current character is an opening parenthesis ((, {, [), push it onto the stack.
            if (c=='(' || c=='{' || c=='[') {
                stack.push(c);
            }
            //If the current character is a closing parenthesis :
            //Check if the stack is empty (mismatched pair if true).
            //Pop the top element from the stack.
            //If the popped element doesn't match the expected opening pair for the current closing parenthesis, return false (invalid sequence).
            else if (c==')' && (stack.isEmpty() || stack.pop() != '(')) {
                    return false;
            }else if (c=='}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }else if (c==']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
        }
        //After iterating through all characters, if the stack is empty, all parentheses are paired correctly, return true; otherwise, unpaired parentheses exist, return false.
        return stack.isEmpty();


    //Time Complexity: O(n), where n is the length of the input string. Each character is processed only once (push or pop on stack).
    //Space Complexity: O(n) in the worst case. The stack might store all opening parentheses if they're at the beginning of the string and closing ones are later.

    //Alternative Approach:
    //Another common approach is using a HashMap to map opening parentheses to their closing counterparts. Time complexity remains O(n), but space complexity might be reduced to O(1) if only limited types of parentheses are considered.
    }


    // public static boolean isValid(String s) {
    //     Map<Character, Character> mappings = new HashMap<>();
    //     mappings.put(')', '(');
    //     mappings.put('}', '{');
    //     mappings.put(']', '[');

    //     Stack<Character> stack = new Stack<>();
    //     for (char c : s.toCharArray()) {
    //         if (mappings.containsKey(c)) {
    //             char topElement = stack.isEmpty() ? '#' : stack.pop();
    //             if (topElement != mappings.get(c)) {
    //                 return false;
    //             }
    //         } else {
    //             stack.push(c);
    //         }
    //     }
    //     return stack.isEmpty();
    // }


    // public static boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<>();
    //     for (char c : s.toCharArray()) {
    //         if (c == '(' || c == '{' || c == '[') {
    //             stack.push(c);
    //         } else {
    //             if (stack.isEmpty()) return false;
    //             char open = stack.pop();
    //             if (c == ')' && open != '(') return false;
    //             if (c == '}' && open != '{') return false;
    //             if (c == ']' && open != '[') return false;
    //         }
    //     }
    //     return stack.isEmpty();
    // }
}


// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
