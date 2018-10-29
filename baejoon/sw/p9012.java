package sw;

import java.util.*;

public class p9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		Stack<Character> s = new Stack<Character>();
		
		for(int t=1; t<=T; t++) {
			s.clear();
			char[] a = new String(sc.next()).toCharArray();
			try {
				for(int i=0; i<a.length; i++) {
					if (a[i] == '(') s.push(a[i]);
					else if (a[i] == ')')  s.pop();
				}
				if (s.isEmpty()) System.out.println("YES");
				else System.out.println("NO");
			}
			catch(Exception e) {
				System.out.println("NO");
			}
		}
	}
}
