package test;

import myStack.Mystack;

public class MyStackTest {

	public static void main(String[] args) {
		Mystack mystack = new Mystack();
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);		
		System.out.println("Max in stack: " + mystack.getMax());
		System.out.println("Min in stack: " + mystack.getMin());
		System.out.println("Peek in stack: " + mystack.peek());
		System.out.println("Pop in stack: " + mystack.pop());
		System.out.println("Pop in stack: " + mystack.pop());
		System.out.println(mystack.isEmpty());
		System.out.println("Pop in stack: " + mystack.pop());
		System.out.println(mystack.isEmpty());
	}

}
