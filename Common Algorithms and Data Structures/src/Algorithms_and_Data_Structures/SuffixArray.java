package Algorithms_and_Data_Structures;

import java.util.Arrays;

/*
 *  A Suffix Array is a sorted array of suffixes of a string.
 *  Only the indices of suffixes are stored in the string instead of whole strings.
 *  For example: Suffix Array of "banana" would look like this:
 *  
 *  5 -> a
 *  3 -> ana
 *  1 -> anana
 *  0 -> banana
 *  4 -> na
 *  2 -> nana
 * 
 * 	for a good explanation see: https://www.geeksforgeeks.org/suffix-array-set-2-a-nlognlogn-algorithm/
 * 								https://web.stanford.edu/class/cs97si/suffix-array.pdf
 */

//an O(n*log(n)^2) implementation of a suffix array
public class SuffixArray {
	
	private static class suffix implements Comparable<suffix>{
		public int index;
		public int[] rank = new int[2];
		
		
		@Override
		public int compareTo(suffix other) {
			if(this.rank[0] > other.rank[0] || this.rank[0] == other.rank[0] && this.rank[1] > other.rank[1])
				return 1;
			if(this.rank[0] == other.rank[0] && this.rank[1] == other.rank[1])
				return 0;
			return -1;
		}
	}
	
	public static int[] generateSuffixArray(String txt) {
		
		int n = txt.length();
		suffix[] sufs = new suffix[n];
		
		for(int i = 0; i < n; i++) {
			sufs[i] = new suffix();
			sufs[i].index = i;
			sufs[i].rank[0] = (int)(txt.charAt(i) - 'a');
			sufs[i].rank[1] = (i + 1 < n)? (int)(txt.charAt(i + 1) - 'a') :  -1;
		}
		
		Arrays.sort(sufs);
		
		for(int k = 2; k < 2 * n; k *= 2) {
			
			int curRank = 0;
			int[] rank0 = new int[n];
			int[] ind = new int[n];
			rank0[0] = 0;
			
			for(int i = 1; i < n; i++) {
				if(sufs[i].compareTo(sufs[i-1]) == 0) {
					rank0[i] = curRank;
				}
				else {
					curRank++;
					rank0[i] = curRank;
				}
			}
			
			for(int i = 0; i < n; i++) {
				ind[sufs[i].index] = i;
				sufs[i].rank[0] = rank0[i];
			}
			
			for(int i = 0; i < n; i++) {
				sufs[i].rank[1] = (sufs[i].index + k < n)? sufs[ind[sufs[i].index + k]].rank[0] : -1;
			}
			
			Arrays.sort(sufs);
		}
		
		int[] suffixArray = new int[n];
		
		for(int i = 0; i < n; i++) {
			suffixArray[i] = sufs[i].index;
		}
		
		return suffixArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "aabbcc";
		
		int[] sufArr = generateSuffixArray(str);
		
		for(int i = 0; i < sufArr.length; i++) {
			System.out.print(sufArr[i]);
		}

	}

}
