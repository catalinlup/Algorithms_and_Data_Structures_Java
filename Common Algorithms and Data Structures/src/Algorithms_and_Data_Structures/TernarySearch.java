package Algorithms_and_Data_Structures;

/*
 * Ternary Search works in a similar way with binary search, but it involves
 * dividing the array into 3 parts
 * 
 * It is used in unimodal functions, in order to determine the maximum/minimum value 
 * of that function
 * 
 * Unimodal Function = function with a single peak (local maximum/minimum)
 * 
 * Complexity: O(log3 N)
 * 
 *For more info: https://www.hackerearth.com/practice/algorithms/searching/ternary-search/tutorial/
 * 
 */

public class TernarySearch {
	
	public static int TernarySearch(int[] A, int low, int high, int key) {
		if(low <= high) {
			
			int mid1 = low + (high - low) / 3;
			int mid2 = high - (high - low) / 3;
			
			if(A[mid1] == key) 
				return mid1;
			
			if(A[mid2] == key)
				return mid2;
			
			if(key < A[mid1]) {
				return TernarySearch(A, low, mid1 - 1, key);
			}
			
			if(key < A[mid2]) {
				return TernarySearch(A, mid1 + 1, mid2 -1, key);
			}
			
			return TernarySearch(A, mid2 + 1, high, key);
			
		}
		
		return -1;
	}
	
	public static double func(double x) {
		return -2*x*x + 2*x + 3;
	}
	
	static double approximateMaximum(double low, double high, int iterations) {
		
		for(int i = 1; i <= iterations; i++) {
			
			double mid1 = low + (high - low) / 3;
			double mid2 = high - (high - low) / 3;
			
			if(func(mid1) > func(mid2))
				high = mid2;
			else
				low = mid1;
			
		}
		
		return func(low);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {2, 3, 5, 6, 8, 9, 12, 13, 14};
		
		System.out.println(TernarySearch(A, 0, A.length -1, 9));
		
		System.out.println(approximateMaximum(-3,3,2000));

	}

}
