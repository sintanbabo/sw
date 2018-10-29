package sw;

import java.util.*;

public class p5531 {
	
	// 정렬 함수
	public static long sort(int[] a, int[] d, int start, int end)
	{
		if (start >= end) 
			return 0;
		
		// 중간 찾기
		int mid = (start + end) / 2;
		
		// 중간 이전을 정렬 (1그룹)
		long cnt1 = sort(a,d,start,mid);
		
		// 중간 이후를 정렬 (2그룹)
		long cnt2 = sort(a,d,mid+1,end);
		
		// 1그룹과 2그룹을 merge
		return cnt1 + cnt2 + merge(a,d,start,mid,end);
	}
	
	// 통합 함수
	public static long merge(int[] a, int[] d, int start, int mid, int end)
	{
		int index,index1, index2;
		long cnt=0;
		
		index1 = start;
		index2 = mid+1;
		index = start;
		
		// 1그룹과 2그룹 값을 비교해서 하나의 배열에 저장한다.
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
		
		// 1그룹에서 처리되지 않은 데이터가 있다면 처리한다.
		if (index1 <= mid) {
			for(int i=index1; i<=mid; i++) {
				d[index] = a[i];
				index++;
			}
		}
		// 2그룹에서 처리되지 않은 데이터가 있다면 처리한다.
		else {
			for(int i=index2; i<=end; i++) {
				d[index] = a[i];
				index++;
			}
		}
		
		// d의 값을 a로 복사
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
		
		// a 배열의 중앙을 기준으로 좌측에서 가장 큰 값를 찾는다.
		int i;
		
		int mid = (0 + (n-1)) / 2;
		int min=mid+1, max=0;
		
		for(i=0; i<=mid; i++) {
			if (a[i] > a[max]) {
				max = i;
			}
		}
		
		// 좌측에서 가장 큰 값보다 작고 가장 오른쪽에 있는 a 값을 찾는다.
		for(; i<n; i++)
		{
			if (a[i] < a[max]) {
				min = i;
			}
		}
		
		// 왼쪽에서 가장 큰 값과 오른쪽에서 가장 작은 값을 바꾼다.
		int temp3 = a[max];
		a[max] = a[min];
		a[min] = temp3;
		
		long cnt = sort(a,d,0,n-1);
		
		System.out.println(cnt);
	}
}
