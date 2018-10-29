import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {
	public static int Answer, N;
	public static int[][] arrCard, arrAnswer;


	public static void main(String args[]) throws Exception {
		long start = System.currentTimeMillis();
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이
		 * 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에
		 * 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래
		 * 주석을 지우고 이 메소드를 사용하셔도 좋습니다. 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석
		 * 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("c:\\sample_input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
//		int T = 4;

		for (int test_case = 1; test_case <= T; test_case++) {
			/*
			 * 각 테스트 케이스를 표준 입력에서 읽어옵니다.
			 */
			N = sc.nextInt();
						
			arrCard = new int[N][2];
			arrAnswer = new int[N][N];

			for(int i=0;i<N;i++){
				arrCard[i][0] = sc.nextInt();
			}
			for(int i=0;i<N;i++){
				arrCard[i][1] = sc.nextInt();
			}
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * 이 부분에 여러분의 알고리즘 구현이 들어갑니다. 여러분의 정답은 AnswerN에 저장되는 것을 가정하였습니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			Answer=compareCard(0,0);
			
			//System.out.print(" "+arrUsed[1][6]);
			// 표준출력(화면)으로 답안을 출력합니다.			
			System.out.println("#"+ test_case + " " + Answer);
			
		}
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
		
		/* 답
		#1 7
		#2 6
		*/
		
		sc.close();
	}
	
	public static int compareCard(int lCard, int rCard){
		//System.out.println("누적값 : "+Answer);
		if(lCard>N-1||rCard>N-1){
			//System.out.println(N);
			//System.out.println("return");
			return 0;
		}
		//System.out.println("idx : "+lCard+" / "+rCard);
		//System.out.println("value : "+arrCard[lCard][0]+" / "+arrCard[rCard][1]);
		//System.out.println("---------------------------------");
		if(arrCard[lCard][0]>arrCard[rCard][1]){			
			if(arrAnswer[lCard][rCard] > 0){
				return arrAnswer[lCard][rCard];
			}else{				
				arrAnswer[lCard][rCard] = arrCard[rCard][1]+compareCard(lCard, rCard+1);
				return arrAnswer[lCard][rCard];
			}
		}else {	
			if(arrAnswer[lCard][rCard] > 0){
				return arrAnswer[lCard][rCard];
			}else{				
				arrAnswer[lCard][rCard] = Math.max(compareCard(lCard+1,rCard),compareCard(lCard+1,rCard+1));
				return arrAnswer[lCard][rCard];
			}
		}
	}
}
