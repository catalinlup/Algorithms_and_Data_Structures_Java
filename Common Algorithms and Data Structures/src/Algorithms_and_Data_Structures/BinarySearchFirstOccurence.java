package Algorithms_and_Data_Structures;

public class BinarySearchFirstOccurence {
	
	
	public static int BinarySearch(int[] A, int low, int high, int target) {
		
		while(low < high) {
			
			int mid = (low + high) / 2;
			
			if(target > A[mid]) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
			
		}
		
		System.out.println(low);
		return (A[low] == target)? low : -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//         0 1 2 3 4 5 6 7
		int[] A = {0,0,0,0,0,0,0,0};
		
		System.out.println(BinarySearch(A, 0, A.length - 1, 1));
		

	}

}
