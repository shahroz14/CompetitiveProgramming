package hackerrank;

import java.util.Scanner;

public class AbsolutePermutation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int  t = in.nextInt();
	l1:	for(int i=1; i<=t; i++){
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n+1];
			boolean[] flag = new boolean[n+1];
			int j;
			for(j=1; j<=n; j++){
				if(j+k<=n&&!flag[j+k]&&!flag[j]){
					flag[j+k] = true;
					flag[j] = true;
					arr[j] = j+k;
					arr[j+k] = j;
				}
				
			}
			//System.out.println(Arrays.toString(arr));
			
				StringBuilder sb = new StringBuilder("");
				for(int l=1; l<=n; l++){
					if(arr[l]<=n && arr[l]>0)
						sb.append(arr[l]+" ");
					else{
						System.out.println(-1);
						continue l1;
					}	
				}
				System.out.println(sb);
		}
	}
}
