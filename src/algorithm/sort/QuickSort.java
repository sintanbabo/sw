package algorithm.sort;

public class QuickSort {
	static int i = 0;
	
	public static void quickSort(int[] arr, int begin, int end) {
		if(begin < end) {
			int p = partition(arr,begin,end);
			quickSort(arr,begin,p-1);
			quickSort(arr,p+1,end);
		}
	}
	
	public static int partition(int[] arr, int begin, int end)
	{
		int left = begin;
		int right = end;
		
		int pivot = (left+right)/2;
		
		System.out.println("Quick Sort " + ++i + " ´Ü°è : pivot - " + arr[pivot]);
		
		while(left < right)
		{
			while((arr[left] < arr[pivot]) && (left < right)) left++;
			while((arr[right] >= arr[pivot]) && (left < right)) right--;
			
			if (left < right) {
				swap(arr,left,right);
			}
		}
		
		swap(arr,pivot,right);
		print(arr);
		return left;
	}
	
	public static void swap(int arr[], int left, int right)
	{
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void print(int arr[])
	{
		for(int k=0; k<arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {69,10,30,2,16,8,31,22};
		QuickSort.quickSort(arr, 0, arr.length-1);		
	}
}
