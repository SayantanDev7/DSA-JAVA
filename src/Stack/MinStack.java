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
        System.out.println("Enter the size of the Stack: ");
        int n = sc.nextInt();



        sc.close();
    }
}
