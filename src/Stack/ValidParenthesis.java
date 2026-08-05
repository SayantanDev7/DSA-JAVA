//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//        Example 1:
//
//        Input: s = "()"
//
//        Output: true
//
//        Example 2:
//
//        Input: s = "()[]{}"
//
//        Output: true
//
//        Constraints:
//
//        1 <= s.length <= 104
//        s consists of parentheses only '()[]{}'.


package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // char firstchar = s.charAt(0);
        // stack.push(firstchar);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int flag = 0;
            if(c == '(' || c == '[' || c == '{' )
                stack.push(c);

            else{
                if(stack.isEmpty())
                    return false;
                switch(stack.peek()){
                    case '(':
                        if(c == ')')
                            stack.pop();
                        else
                            return false;
                        break;


                    case '{':
                        if(c == '}')
                            stack.pop();
                        else
                            return false;
                        break;


                    case '[':
                        if(c == ']')
                            stack.pop();
                        else
                            return false;
                        break;

                }
            }


        }
        if(stack.size() == 0)
            return true;
        return false;
    }
}
