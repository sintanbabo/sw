package datastruct;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		
		test.push(1);
		test.push(2);
		test.push(3);
		
		while(!test.isEmpty()) {
			System.out.println(test.pop());
		}
	}
}
