package sort;

public class SelectionSort {
	public static void main(String[] args) {
		int a[] = {41,32,10,6,22,50,51,100};
		
		selectionSort(a);
		
		for(int b:a) {
			System.out.print("" + b + " ");
		}
	}
	
	public static void selectionSort(int a[])
	{
		for(int i=0; i<a.length-1; i++)
		{
			for(int j=i+1; j<a.length-1; j++)
			{
				if (a[i] > a[j]) 
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}
