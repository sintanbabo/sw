import java.util.Scanner;

/*
6 8 1 2 1 4 2 3 3 4 2 5 6 5 4 5 6 2
7 8  1 2 1 4 2 3 3 4 2 5 2 6 6 7 7 5
 */
public class two_color {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int x,y,color,nResult=-1;
		
		int[][] graph = new int[V][V];
		int[] result = new int[V];
		
		// 각각의 연결 경로값 입력
		for(int i=0; i<E; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			graph[x-1][y-1] = 1;
			graph[y-1][x-1] = 1;
		}
		
		for(int i=0; i<V; i++) result[i] = -1;
		
		result[0] = 0;
		for(int i=0; i<V; i++){
			if(result[i] == 0) color = 1; else color = 0;
			for (int j=0; j<V; j++) {
				if (graph[i][j] == 1) {
					if (result[j] == -1) {
						result[j] = color;
						nResult = 0;
					}
					else if (result[j] == color) {
						result[j] = color;
						nResult = 0;
					}
					else if (result[j] != color) {
						nResult = -1;
						break;
					}
						
				}
			}
			if (nResult == -1)
				break;
		}
		String sResult = "";
		if (nResult != -1)
			for(int i=0; i<V; i++)
				if (result[i] == 1){
					sResult += (i+1) + " ";
					nResult += 1;
				}
		
		System.out.println("count : " + nResult);
		System.out.println(sResult);
		
	}

}
