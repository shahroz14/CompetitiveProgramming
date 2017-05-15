package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class CuttingBoards {
	
	static final int MOD = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int i=0; i<q; i++){
			int m = in.nextInt();
			int n = in.nextInt();
			
			int[][] costs = new int[m+n-1][2];
			
			for(int j=1; j<m; j++){
				costs[j][0] = in.nextInt();
				costs[j][1] = 0; //horizontal
			}
		
			for(int j=1; j<n; j++){
				costs[j][0] = in.nextInt();
				costs[j][1] = 1; //vertical
			}
			
			mergeSort(costs, 1, costs.length);
			
			int hseg = 1;
			int vseg = 1;
			
			long cost = 0;
			
			for(int j=m+n-2; j>0; j--){
				if(costs[j][1]==0){
					cost += costs[j][0]*vseg%MOD;
					hseg++;
				}
				else{
					cost += costs[j][0]*hseg%MOD;
					vseg++;
				}
			}
			
			System.out.println(cost%MOD);
			
			
		}
	}
	
	public static void mergeSort(int[][] array, int p, int r){
		int q;
		if(p<r){
			q = (p+r)/2;
			mergeSort(array, p, q);
			mergeSort(array, q+1, r);
			merge(array, p, q, r);
		}
	}
	
	public static void merge(int[][] array, int low, int mid, int high){
		int[][] left = new int[mid-low+2][2];
		int[][] right = new int[high-mid+1][2];
		int a=0, b=0;
		
		
		for(int i=0; i<left.length-1; i++){
			left[i][0] = array[low+i][0];
			left[i][1] = array[low+i][1];
		}
		left[left.length-1][0] = 999999999;

		
		for(int i=0; i<right.length-1; i++){
			right[i][0] = array[mid+1+i][0];
			right[i][1] = array[mid+1+i][1];
		}
		right[right.length-1][0] = 999999999;
		
		
		for(int i=low; i<=high; i++){
			if(left[a][0]<=right[b][0]){
				array[i][0] = left[a][0];
				array[i][1] = left[a++][1];
			}
			else{
				array[i][0] = left[b][0];
				array[i][1] = left[b++][1];
			}
		}
	}
}
