package baejoon;

import java.util.*;

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

 */
public class P2042_SegmentTree {
	
	public static void init(long tree[], long input[], int node, int start, int end)
	{
		if (start == end){
			tree[node] = input[start];
		}
		else {
			int middle = (start + end) / 2;
			init(tree,input,node*2,start, middle);
			init(tree,input,node*2+1,middle+1, end);
			tree[node] = tree[node*2] + tree[node*2+1];			
		}
	}
	
	public static void update(long tree[],int node, int start, int end, int index, long value)
	{
		
	}
	
	public static void find(long tree[], int node, int start, int end, int s, int e)
	{
		
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		// segment tree 생성
		long tree[] = new long[N*4];
		
		// 입력값 저장
		long input[] = new long[N+1];
		
		// 입력값 받기
		for(int i=1; i<=N; i++) {
			input[i] = sc.nextLong();
		}
		
		// 값변경 및 검색 조건 저장
		long index,v;
		int s,e;
		
		for(int i=0; i<K+M; i++) {
			int temp = sc.nextInt();
			if (temp == 1) {
				index = sc.nextLong();
				v = sc.nextLong();
				update(tree,1,1,N,i,v-input[i]);
				input[i] = v;
			}
			else if (temp == 2) {
				s = sc.nextInt();
				e = sc.nextInt();
				find(tree,1,1,N,s,e);
			}
		}
		
		// segment tree 초기화
		init(tree, input, 1, 1, N);
		
		
		
		for(int i=0; i<4*N; i++) {
			System.out.print(tree[i] + ", ");
		}
		System.out.println();
		
		long end = System.currentTimeMillis();
		
		System.out.println((end-start)/1000 + "초 걸림");
	}
}
