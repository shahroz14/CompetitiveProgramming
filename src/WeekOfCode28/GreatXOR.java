package WeekOfCode28;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class GreatXOR {
	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println(pow(2, 10));
		//System.out.println(7^10);
		//System.out.println((int)Math.ceil(Math.log(5)/Math.log(2)));
		//double start = System.nanoTime();
		Scanner in = new Scanner(System.in);
		String ans = "";
		int q = in.nextInt();
		for(int k=0; k<q; k++){
			long n = in.nextLong();
			long upBound = pow((long)2, (long)Math.ceil(Math.log(n)/Math.log(2)));
			if(n==upBound)
				ans += n-1+"\n";
			else{
				ans += upBound-n-1+"\n";
			}
		}
		System.out.println(ans);
		//System.out.println("Time Taken : "+(System.nanoTime()-start)/1000000+" ms");
	}
	
	public static long pow(long a, long b){
		long ans = 1;
		while(b>0){
			if(b%2!=0)
				ans = ans*a;
	
			a = a*a;
			b = b/2;
			
		}
		return ans;
	}
}
