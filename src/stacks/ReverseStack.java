package stacks;

import java.util.Stack;

public class ReverseStack {
	
	public static Stack<Integer> reverseStack(Stack<Integer> stack) {
		
		if (!stack.isEmpty()) {
			int top = stack.pop();
			reverseStack(stack);
			reverseOrder(stack, top);	
		}
		return stack;
	}
	
	public static void reverseOrder(Stack<Integer> stack, int elem) {
		
		if (stack.isEmpty()) {
			stack.push(elem);
		}
		else {
			int x = stack.pop();
			reverseOrder(stack, elem);
			stack.push(x);
		}
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		
		System.out.println("Before Reversing : " + stack.toString() + " " + stack.peek());
		
		reverseStack(stack);
		
		System.out.println("\nAfter Reversing : " + stack.toString()  + " " + stack.peek());
	}

}
