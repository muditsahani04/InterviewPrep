
public class QuickSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[] {40,20,10,7,60,90,30};
		System.out.print(quickSelect(a, 0, a.length-1,3));
	
	}
	
	private static int quickSelect(int[] arr, int start, int end,int k)
	{
		if (start == end)
			return arr[start];
		
		int pivot = partition(arr, start, end);
		
		if (pivot == k-1)
			return arr[pivot];
		else if (pivot > k-1)
			return quickSelect(arr, start, pivot-1, k);
		else
			return quickSelect(arr, pivot+1, end, k);
	}
	private static int partition(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		
		if (start == end )
			return start;
		
		
		int pivot = start;
		int l = pivot+1;
		int r = end;
		while (l<r)
		{
			while (l<r && arr[l]< arr[pivot]) l++;
			while (r>l && arr[r] > arr[pivot]) r--;
			if (l<r)
			{
				swap(arr,l,r);
			}
		}
		
		if (arr[r] < arr[pivot])
		{
			swap(arr, r,pivot);
			return r;
		}
		else
		{
			swap(arr, r-1,pivot);
			return r-1;
		}
		
	}


	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
