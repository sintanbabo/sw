
import java.util.Scanner;
import java.util.Stack;

/*
2
3 ()(())(())()
5 (()()()))()()())

 */
public class matching_bracket {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int testcount = sc.nextInt();
		int N;
		char[] value;
		int nResult = 0;
		
		for (int tc = 1; tc<=testcount; tc++) {
			Stack<Character> s = new Stack<Character>();
			N = sc.nextInt();
			value = sc.next().toCharArray();
			int match_cnt = 0;
			int i = 0;
			try {
				for (i=0; i<value.length; i++) {
					if (value[i] == '(') {
						s.push(value[i]);
					}
					else {
						s.pop();
						match_cnt++;
						if (match_cnt == N) {
							nResult = i+1;
							break;
						}
					}
				}
			}
			catch(Exception e)
			{
				nResult = 0;
			}
			
			System.out.println("#" + tc + " " + nResult);
			
		}
	}
}
