package algorithm.algorithm;

public class Permutation {
	
	public static int data[] = {1,2,3,4};
	
	public static int swap(int i, int j)
	{
		int temp;
		if (i == j) return 0;
		temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		return 0;
	}
	
	public static int permutation(int TotalN, int N)
	{		
		if(N == 1) {
			for(int temp : data) {
				System.out.print(temp + " ");
			}
			System.out.println("");
			return 0;
		}
		
		for(int i=0; i<N; i++) {
			swap(i,N-1);
			permutation(TotalN,N-1);
			swap(i,N-1);
		}
		
		return 0;
	}

	public static void main(String[] args)
	{
		permutation(4,4);
	}

}
