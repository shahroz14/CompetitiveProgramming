package weekOfCode30;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class MelodiousPassword {
	
	static StringBuilder sb;
	static char[] v = {'a','e','i','o','u'};
	static char[] c = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		File f = new File("D:\\Sample.txt");
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(java.io.FileDescriptor.out));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
		  //       FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 1);
		sb = new StringBuilder();
		int n = in.nextInt();
		double start = System.nanoTime();
		melPass("", n, true);
		melPass("", n, false);
		//System.out.println(sb);
		bw.write(sb.toString());
		//bw.write(((System.nanoTime()-start)/1000000+" ms"));
		bw.flush();
		bw.close();
		System.out.println(((System.nanoTime()-start)/1000000+" ms"));
		//bw.println((System.nanoTime()-start)/1000000+" ms");
	}
	
	static void melPass(String prefix, int n, boolean flag){
		if(n==0){
			sb.append(prefix+"\r\n");
		}
		else{
			if(flag){
				for(int i=0; i<v.length; i++){
					melPass(prefix+v[i], n-1, !flag);
				}
			}
			else{
				for(int i=0; i<c.length; i++){
					melPass(prefix+c[i], n-1, !flag);
				}
			}
			
		}	
	}
	
	
}
