package Stack;

import java.util.Stack;

public class Evaluate_ReversePolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String ele: tokens){
            if(ele.equals("+") || ele.equals("/") || ele.equals("*") || ele.equals("-")){
                int opnd2 = st.pop();
                int opnd1 = st.pop();
                int res = 0;
                switch(ele){
                    case "+" :
                        res = opnd1 + opnd2;
                        break;
                    case "*" :
                        res = opnd1 * opnd2;
                        break;
                    case "-" :
                        res = opnd1 - opnd2;
                        break;
                    case "/" :
                        res = opnd1 / opnd2;
                        break;

                }
                st.push(res);
            }
            else{
                int num = Integer.parseInt(ele);
                st.push(num);

            }
        }

        return st.peek();
    }
}

//TC -> O(n) traversing the string in worst case size n
//    SC -> O(n) using auxillary space which is another stack
