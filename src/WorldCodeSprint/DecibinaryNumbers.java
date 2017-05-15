package WorldCodeSprint;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DecibinaryNumbers {
	
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		long[][] dp = new long[300001][55];
		
		for(int i=0; i<55; i++){
			dp[0][i] = 1;
		}
		
		for(int i=1; i<300001; i++){
			dp[i][0] = 0;
		}
		
		File f = new File("D:\\SampleProg.txt");
		FileWriter fw = new FileWriter(f);
		long count=0;
		for(int i=1; i<300001; i++){
			for(int j=1; j<55; j++){
				for(int k=0; k<10; k++){
					int s = (int) (i-(k*Math.pow(2, k)));
					if(s>=0)
						dp[i][j] += dp[s][j-1];
					else
						break;
				}
				System.out.print(dp[i][j]+" ");
				fw.write(dp[i][j]+ " ");
				count++;
			}
			System.out.println("\ncount = "+count+"\n");
			
			fw.write("\n");
			fw.flush();
		}
		
		
		
		
		
		
		for(int i=0; i<q; i++){
			int x = in.nextInt();
			
		}
	}
	
	
}
