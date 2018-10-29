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
		 * �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ��������
		 * �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп�
		 * �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�. ���� �׽�Ʈ�� ������ ������ �Ʒ�
		 * �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�. ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�
		 * ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("c:\\sample_input.txt"));

		/*
		 * ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
//		int T = 4;

		for (int test_case = 1; test_case <= T; test_case++) {
			/*
			 * �� �׽�Ʈ ���̽��� ǥ�� �Է¿��� �о�ɴϴ�.
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
			 * �� �κп� �������� �˰��� ������ ���ϴ�. �������� ������ AnswerN�� ����Ǵ� ���� �����Ͽ����ϴ�.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			Answer=compareCard(0,0);
			
			//System.out.print(" "+arrUsed[1][6]);
			// ǥ�����(ȭ��)���� ����� ����մϴ�.			
			System.out.println("#"+ test_case + " " + Answer);
			
		}
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("���� �ð� : " + (end - start) / 1000.0);
		
		/* ��
		#1 7
		#2 6
		*/
		
		sc.close();
	}
	
	public static int compareCard(int lCard, int rCard){
		//System.out.println("������ : "+Answer);
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
