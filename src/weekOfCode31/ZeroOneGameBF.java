package weekOfCode31;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ZeroOneGameBF {
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		File f = new File("D:\\sample.txt");
		BufferedWriter br = new BufferedWriter(new FileWriter(f));
		br.write(1+"\r\n");
		br.write(q+"\r\n");
		Random r = new Random();
		for( int i=0; i<q; i++){
			br.write(r.nextInt(2)+" ");
		
		}
		br.flush();
		br.close();
		System.out.println("Done");
		
	}
	
	
	
}
