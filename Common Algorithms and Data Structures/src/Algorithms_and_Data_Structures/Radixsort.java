package Algorithms_and_Data_Structures;


import java.util.Scanner;

public class Radixsort {
	
public static void countsort(int[] A, int place) {
		
		int[] freqv = new int[10];
		int[] output = new int[A.length];
		
		for(int i = 0; i < A.length; i++) {
			int cif = (A[i] / place) % 10;
			freqv[cif]++;
		}
		
		for(int i = 1; i < 10; i++) {
			freqv[i] += freqv[i - 1];
		}
		
		for(int i = A.length - 1; i >= 0; i--) {
			int cif = (A[i] / place) % 10;
			output[freqv[cif] - 1] = A[i];
			freqv[cif]--;
		}
		
		for(int i = 0; i < A.length; i++) {
			A[i] = output[i];
		}
		
	}
	
	public static void radixSort(int[] A) {
		
		int mx = A[0];
		
		for(int i = 1; i < A.length; i++) {
			mx = Math.max(mx, Math.abs(A[i]));
		}
		
		int place = 1;
		
		while(mx > 0) {
			countsort(A, place);
			printArray(A);
			place *= 10;
			mx /= 10;
		}
		
		
	}
	
	public static void printArray(int[] A) {
		
		for(int i = 0; i < A.length; i++) {
			System.out.print(String.format("%d ", A[i]));
		}
		System.out.println("");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = scn.nextInt();
		}
		
		radixSort(A);
		

	}
	
}
