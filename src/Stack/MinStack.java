package Stack;

import java.util.Scanner;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);

        if(minStack.isEmpty())
            minStack.push(value);
        else{
            int currentmin = Math.min(value,minStack.peek());
            minStack.push(currentmin);
        }
        // minStack.push(value)
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        //we need to solve this in O(1) TC
        //if we traverse the stack and use Math.min then in WC its O(n)
        return minStack.peek();
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MinStack st = new MinStack();


        System.out.println("Enter the size of the Stack: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the stack: ");
        for(int i=0;i<n;i++){
            int value = sc.nextInt();
            st.push(value);
        }

        System.out.println("\nStack: " + st.stack);
        System.out.println("Min Stack: " + st.minStack);

        System.out.println("Top element: " + st.top());
        System.out.println("Minimum element: " + st.getMin());

        // Pop one element
        System.out.println("\nAfter popping:");
        st.pop();

        System.out.println("Stack: " + st.stack);
        System.out.println("Minimum element: " + st.getMin());



        sc.close();
    }
}
