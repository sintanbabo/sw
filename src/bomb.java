import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
10 1 13 134142233241325332343428436442 
9 2 1123 112133141222235244323337442
9 1 23 232241133334343431442227111
8 1 22 225233331432244421413314
10 2 2134 214111348225441233139246337143

#1 22
#2 15
#3 10
#4 19
#5 17
*/
public class bomb {

	static int M, S, start_bomb[][] = new int[16][2], input_bomb[][] = new int[16][4];
	static int used[][] = new int[4][4], bomb[][] = new int[4][4], result;
	static ArrayList<Integer> point = new ArrayList<Integer>(); 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // ��ź ����
		S = sc.nextInt(); // ���� ��ź
		result = 0;
		
		for (int i=0; i<S; i++) {
			start_bomb[i][0] = sc.nextInt();
			start_bomb[i][1] = sc.nextInt();
		}
		
		// ��ź ��ġ �Է�, 3��° ���� ��� ���� ǥ��
		for(int i=0; i<M; i++) {
			input_bomb[i][0] = sc.nextInt();
			input_bomb[i][1] = sc.nextInt();
			input_bomb[i][2] = sc.nextInt();
		}
		
		// 4*4 �迭�� ��ȯ
		for (int z=0; z<M; z++) {
			for(int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					if ((input_bomb[z][0]-1) == i && (input_bomb[z][1]-1) == j) {
						bomb[i][j] = input_bomb[z][2];
					}
				}
			}
		}
		
		for (int i=0; i<S; i++) {
						
			// �������� arraylist�� �Է� 
			{
				
			}
		}
		
		System.out.println(result);
	}
}