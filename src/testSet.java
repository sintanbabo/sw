import java.util.HashSet;


public class testSet {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i=0; i<10; i++)
			hs.add(i);
		
		System.out.println();
		
		for (int a : hs)
			System.out.println(a + " ");
	}

}
