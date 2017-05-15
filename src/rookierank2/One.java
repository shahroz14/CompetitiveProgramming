package rookierank2;

import java.util.Scanner;

public class One {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] type = new int[6];
		for(int i=0; i<n ; i++)
			type[in.nextInt()]++;
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for(int i=5; i>0; i--){
			if(type[i]>max){
				max = type[i];
				maxIndex = i;
			}
		}
		for(int i=1; i<=5; i++)
			if(type[i]==max){
				System.out.println(i);
				break;
			}
	}
}
