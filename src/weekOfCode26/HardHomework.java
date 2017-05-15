package weekOfCode26;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HardHomework {
	public static void main(String[] args) {
		
		
		//System.out.println(df.format(Math.sin(1)));
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double start = System.nanoTime();
		DecimalFormat df = new DecimalFormat("##.#########");
		double max = -4;
		for(int x=0; x<=n; x++){
			for(int y=0; y<=(n-x); y++){
				for(int z=0; z<=n-x-y; z++){
					if(x+y+z==n){
						double sineSum = Math.sin(x)+Math.sin(y)+Math.sin(z);
						if(sineSum>max){
							max = sineSum;
							System.out.println(x+", "+y+", "+z);
						}
					}
				}
			}
		}
		System.out.println(df.format(max));
		System.out.println("Time Taken : "+(System.nanoTime()-start)/1000000+" ms");
	}
}
