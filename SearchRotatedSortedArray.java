
public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {17,18,19,20,2,3,4,5,6,7,8,9,10};
		//int[] array = {6,5,4,3,2,1,0};
		System.out.println("Found At : "+ searchRotatedSortedArray(array,5, 0, array.length-1));
	}
	public static int searchRotatedSortedArray(int[] a,int target, int start, int end)
    {
    
    
	if (start == end && a[start] != target)
		return -1;
    if (end < start)
        return -1;
        
    int mid = (start + end)/2;
	if (a[mid] ==  target)
		return mid;
    if (a[end] == target)
        return end;
    if (a[start] ==  target)
        return start;
        
	if (a[end] > a[start])
    {
        if (target < a[mid])
            return searchRotatedSortedArray(a, target, start, mid-1);
        else
           return searchRotatedSortedArray(a, target, mid+1, end);
    }
    else
    {
        if (target > a[mid])
          {
            if (target > a[start] && a[mid] < a[start])
                return searchRotatedSortedArray(a, target, start, mid-1);
            return searchRotatedSortedArray(a, target, mid+1, end);
          }
	else
      {
        if (target < a[end] && a[mid] > a[end] )
            return searchRotatedSortedArray(a, target, mid+1, end);
	    return searchRotatedSortedArray(a, target, start, mid-1);	
      }
    }
	
    }
}
