package weekOfCode30;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RMQTest {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:\\RMQTest.txt")));
		bw.write(n+" "+q+"\r\n");
		for(int i=0; i<n; i++){
			bw.write(getRandom(1, 40000)+" ");
		}
		bw.write("\r\n");
		for(int i=0; i<q; i++){
			int left = getRandom(0, n-2);
			int right = getRandom(left, n-1);
			int x = getRandom(1, 40000);
			int y = getRandom(0, x);
			bw.write(left+" "+right+" "+x+" "+y+"\r\n");
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
