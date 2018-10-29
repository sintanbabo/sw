package pro.datastruct;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String[]> al = new ArrayList<String[]>();
		
		String a[] = {"1","2","3"};
		String b[] = {"4","5","6"};
		String c[] = {"7","8","9"};
		
		al.add(a);
		al.add(b);
		al.add(c);
		
		for(String[] temp : al)
		{
			for(String temp1 : temp)
			{
				System.out.print(temp1 + " ");
			}
			System.out.println("");
		}
		System.out.println("---------------------------------");
		
		ArrayList<ArrayList<Integer>> al1 = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		ArrayList<Integer> al3 = new ArrayList<Integer>();
		ArrayList<Integer> al4 = new ArrayList<Integer>();
		
		al2.add(1);
		al2.add(2);
		al2.add(3);
		
		al3.add(4);
		al3.add(5);
		al3.add(6);
		
		al4.add(7);
		al4.add(8);
		al4.add(9);
		
		al1.add(al2);
		al1.add(al3);
		al1.add(al4);
		
		for(ArrayList<Integer> t1 : al1)
		{
			for(Integer i : t1)
			{
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}
