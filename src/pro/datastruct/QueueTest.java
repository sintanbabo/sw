package pro.datastruct;

import java.util.LinkedList;

public class QueueTest {
	public static void main(String[] args) {
		LinkedList<Integer> test = new LinkedList<Integer>();
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		while(!test.isEmpty()) {
			System.out.println(test.pop());
		}
	}
}
