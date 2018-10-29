import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class A11 {
	int a,b;
}

public class melong implements Comparable<melong>{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		float d = 30000000;
		
		int temp = 0;
		
		for(int i=0; i<3000000; i++) {
			for (int j=0; j<1000000; j++) {
				 temp = temp + 1;
			}
		}
		
		List<Integer> l1[] = new ArrayList[10];
		l1[0] = new ArrayList<Integer>();
		
		PriorityQueue pq = new PriorityQueue<melong>();
		
		List l = new ArrayList();

		bw.write("" + a + " " + b + " " + c);
		bw.newLine();
		bw.flush();
		
		br.close();
		bw.close();
	}

	@Override
	public int compareTo(melong arg0) {
		return 0;
	}
}
