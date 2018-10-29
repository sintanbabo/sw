package algorithm.sort;

public class InsertionSort {
	public static void main(String[] args) {
		int a[] = {41,32,10,6,22,50,51,100};
		
		insertionSort(a);
		
		for(int b:a) {
			System.out.print("" + b + " ");
		}
	}
	
	public static void insertionSort(int a[])
	{
		for(int i=1; i<a.length; i++)
		{
			int currentValue = a[i];
			int position = i;
			
			while (position>0 && a[position-1]>currentValue) 
			{
				a[position] = a[position-1];
				position--;
			}
			
			a[position] = currentValue;
		}
	}
}
