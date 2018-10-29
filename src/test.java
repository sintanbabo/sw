
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {
	
	static int AnswerN;
	static int N;
	static int[] left, right;
	static int[][] dp;

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("D:\\workspaceJuno\\SwAuth\\src\\smart\\AD12_카드게임.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			AnswerN = 0;
			N = sc.nextInt();
			left = new int[N];
			right = new int[N];
			dp = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				left[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				right[i] = sc.nextInt();
			}
			
			AnswerN = dpMethod(0, 0);
			System.out.println("#"+test_case+" "+ AnswerN);
		}
	}

	static int dpMethod(int le, int re){

		if( le == N || re == N ){
			return 0;
		}
		
		if( dp[le][re] > 0 ){
			return dp[le][re];
		}

		if( left[le] > right[re] ){
			dp[le][re] = Math.max( dp[le][re], dpMethod(le, re+1) + right[re] );
		}else{
			dp[le][re] = Math.max( dp[le][re], dpMethod( le+1, re) ); 
			dp[le][re] = Math.max( dp[le][re], dpMethod( le+1, re+1) );
		}
		
		return dp[le][re];
	}
	
}
