package sw;

import java.util.*;

public class p5531 {
	
	// ���� �Լ�
	public static long sort(int[] a, int[] d, int start, int end)
	{
		if (start >= end) 
			return 0;
		
		// �߰� ã��
		int mid = (start + end) / 2;
		
		// �߰� ������ ���� (1�׷�)
		long cnt1 = sort(a,d,start,mid);
		
		// �߰� ���ĸ� ���� (2�׷�)
		long cnt2 = sort(a,d,mid+1,end);
		
		// 1�׷�� 2�׷��� merge
		return cnt1 + cnt2 + merge(a,d,start,mid,end);
	}
	
	// ���� �Լ�
	public static long merge(int[] a, int[] d, int start, int mid, int end)
	{
		int index,index1, index2;
		long cnt=0;
		
		index1 = start;
		index2 = mid+1;
		index = start;
		
		// 1�׷�� 2�׷� ���� ���ؼ� �ϳ��� �迭�� �����Ѵ�.
		while(index1 <= mid && index2 <= end) {
			if (a[index1] <= a[index2]) {
				d[index] = a[index1];
				index1++;
			}
			else {
				d[index] = a[index2];
				index2++;
				cnt += (mid-index1+1);
			}
			index++;
		}
		
		// 1�׷쿡�� ó������ ���� �����Ͱ� �ִٸ� ó���Ѵ�.
		if (index1 <= mid) {
			for(int i=index1; i<=mid; i++) {
				d[index] = a[i];
				index++;
			}
		}
		// 2�׷쿡�� ó������ ���� �����Ͱ� �ִٸ� ó���Ѵ�.
		else {
			for(int i=index2; i<=end; i++) {
				d[index] = a[i];
				index++;
			}
		}
		
		// d�� ���� a�� ����
		for(int i=start; i<= end; i++)
		{
			a[i] = d[i];
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int d[] = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		// a �迭�� �߾��� �������� �������� ���� ū ���� ã�´�.
		int i;
		
		int mid = (0 + (n-1)) / 2;
		int min=mid+1, max=0;
		
		for(i=0; i<=mid; i++) {
			if (a[i] > a[max]) {
				max = i;
			}
		}
		
		// �������� ���� ū ������ �۰� ���� �����ʿ� �ִ� a ���� ã�´�.
		for(; i<n; i++)
		{
			if (a[i] < a[max]) {
				min = i;
			}
		}
		
		// ���ʿ��� ���� ū ���� �����ʿ��� ���� ���� ���� �ٲ۴�.
		int temp3 = a[max];
		a[max] = a[min];
		a[min] = temp3;
		
		long cnt = sort(a,d,0,n-1);
		
		System.out.println(cnt);
	}
}
