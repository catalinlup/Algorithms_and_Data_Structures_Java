package Algorithms_and_Data_Structures;


import java.util.Random;
import java.util.Scanner;

public class Quicksort {
	
	public static Random rnd = new Random();
	
	public static int partition(int[] A, int start, int end) {
		
		int i = start + 1;
		int pivot = start;
		
		for(int j = start + 1; j <= end; j++) {
			if(A[j] < A[pivot]) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i += 1;
			}
		}
		
		int temp = A[i - 1];
		A[i - 1] = A[start];
		A[start] = temp;
		
		return i - 1;
	}
	
	public static int randPartition(int[] A, int start, int end) {
		
		int toSwap = start + rnd.nextInt(end - start + 1);
		
		int temp = A[start];
		A[start] = A[toSwap];
		A[toSwap] = temp;
		
		return partition(A, start, end);
		
	}
	
	public static void quicksort(int[] A, int start, int end) {
		
		if(start < end) {
			int piv = randPartition(A, start, end);
			quicksort(A, start, piv - 1);
			quicksort(A, piv + 1, end);
		}
	}
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int[] A = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			A[i] = scn.nextInt();
		}
		
		quicksort(A,1,n);
		
		for(int i = 1; i <= n; i++) {
			
			System.out.print(String.format("%d ", A[i]));
		}

	}

}
