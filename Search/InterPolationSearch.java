public class InterPolationSearch {
	 static int arr[] = new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
             24, 33, 35, 42, 47};


	public static void main(String[] args) {

		 int x = 47; // Element to be searched
         int index = interpolationSearch(x);
          
         // If element was found
         if (index != -1)
               System.out.println("Element found at index " + index);
            else
               System.out.println("Element not found.");
	}
	static int interpolationSearch(int x)
	    {
	        // Find indexes of two corners
	        int lo = 0, hi = (arr.length - 1);
	      
	        // Since array is sorted, an element present
	        // in array must be in range defined by corner
	        while (lo <= hi && x >= arr[lo] && x <= arr[hi])
	        {
	            int pos =(int)( lo + (((double)(hi-lo) /
	                  (arr[hi]-arr[lo]))*(x - arr[lo])));
	      
	            // Condition of target found
	            if (arr[pos] == x)
	                return pos;
	      
	            // If x is larger, x is in upper part
	            if (arr[pos] < x)
	                lo = pos + 1;
	      
	            // If x is smaller, x is in the lower part
	            else
	                hi = pos - 1;
	        }
	        return -1;
	    }

}
