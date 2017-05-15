package deolite;

import java.util.Scanner;

public class JailBreak {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int n = in.nextInt();
		int[] wall = new int[n];
		for(int i=0; i<n; i++)
			wall[i] = in.nextInt();
		int jumps = 0;
		for(int i=0; i<n; i++){
			int h = x;
			jumps++;
			while(h<wall[i]){
				h = h-y;
				jumps++;
				h = h+x;
			}
		}
		System.out.println(jumps);
	}
	

}
