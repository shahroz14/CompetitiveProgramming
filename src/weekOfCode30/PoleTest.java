package weekOfCode30;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PoleTest {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:\\PoleTest.txt")));
		bw.write(n+" "+k+"\r\n");
		for(int i=0; i<n; i++){
			bw.write( 3*i +" "+ getRandom(2, 50)+"\r\n");
		}
		bw.flush();
		bw.close();
		System.out.println("Done");
	}
	
	static int getRandom(int low, int high){
		Random r = new Random();
		return low + r.nextInt(high-low);
	}
}
