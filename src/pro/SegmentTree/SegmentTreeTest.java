package pro.SegmentTree;

import java.io.File;
import java.io.FileNotFoundException;
 import java.util.Scanner;
 
  
 public class SegmentTreeTest 
  {
	static int[] arr;
	static double[] node;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		long start = System.currentTimeMillis();
		//File file =new File("D:\\dev\\worksspace\\Solution\\src\\Baekjoon2042");
		//Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			arr = new int[N+1];
			node = new double[20000000];
			
			for (int i = 1; i <= N; i++) {
				arr[i] = sc.nextInt();
			}
			
			initNode(1, 1, N);
			
			for (int i = 0; i < M+K; i++) {
				int gubun = Integer.parseInt(sc.next());
				int x = Integer.parseInt(sc.next());
				int y = Integer.parseInt(sc.next());
				
				if(gubun == 1) { // 변경
					updateNode(1, 1, N, x, y-arr[x]);
					arr[x] = y;
				}
				else if(gubun == 2){ // 합
					double tempAnswer = sumNode(1, 1, N, x, y);
					System.out.println((int)tempAnswer);
				}
				// for (int j = 0; j < N; j++) {
				// System.out.print(arr[j+1]+" ");
				// }
				// System.out.println();
			}
		}
	
		sc.close();
		// long end = System.currentTimeMillis();
		// System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
	}
	
	private static double sumNode(int nodeNum, int start, int end, int x, int y) {
		double result = 0;
		if(y<start || x>end) return result;
		if(start>=x && end<=y) return node[nodeNum];
		
		result += sumNode(nodeNum*2, start, (start+end)/2, x, y);
		result += sumNode(nodeNum*2+1, (start+end)/2 +1, end, x, y);
		return result;
	}
	
	private static void updateNode(int nodeNum, int start, int end, int x, int diff) {
		if(x < start || x > end) return;
		if(x>=start && x<=end){
			node[nodeNum] += diff;
			if(start == end) return;
		}
		
		updateNode(nodeNum*2, start, (start+end)/2, x, diff);
		updateNode(nodeNum*2+1, (start+end)/2 +1, end, x, diff);
	}
	
	private static double initNode(int nodeNum, int start, int end) {
		double result = 0;
		if(start == end){
			node[nodeNum] = arr[start];
			return node[nodeNum];
		}
		
		node[nodeNum] = initNode(nodeNum*2, start, (start+end)/2) + initNode(nodeNum*2+1, (start+end)/2 +1, end);
		return result;
	}
}
/*
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

17
12
*/


