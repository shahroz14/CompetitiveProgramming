package universityCodesprint;

import java.util.Scanner;

public class BreakingRecords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] sc = new int[n];
		for(int i=0; i<n; i++)
			sc[i] = in.nextInt();
		int min = sc[0];
		int max = sc[0];
		int timesUp = 0;
		int timesDown = 0;
		for(int i=1; i<n; i++){
			if(sc[i]>max)
				timesUp++;
			if(sc[i]<min)
				timesDown++;
			min = Math.min(min, sc[i]);
			max = Math.max(max, sc[i]);
		}
		System.out.println(timesUp+" "+timesDown);
	}
}
