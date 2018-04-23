
public class MinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {17,18,19,20,2,3,4,5,6,7,8,9,10};
		//int[] array = {6,5,4,3,2,1,0};
		System.out.println("Minimum : "+ findMinRecurs(array, 0, array.length-1));
	}
	
	public static int findMinRecurs(int[] a, int start, int end)
	{
		if (start == end)
			return a[start];
		
		if (a[start] < a[end])
			return a[start];
			
		if (end - start == 1)
			return Math.min(a[start], a[end]);
		
		int mid = (start + end)/2;
		if (a[mid] < a[start])
		{
			if (a[mid] > a[end])
				return a[end];
			return (findMinRecurs(a, start, mid));
		}
			
		else
			return (findMinRecurs(a, mid, end));
	}
}
