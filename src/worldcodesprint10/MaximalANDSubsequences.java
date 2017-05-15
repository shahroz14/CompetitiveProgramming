package worldcodesprint10;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximalANDSubsequences {
	
	static int MOD = 1000000007;
	
	public static void main(String[] args) {
		//System.out.println(Math.log(1000000000000000000l)/Math.log(2));
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int pow = (int) ( Math.log(1000000000000000000l)/Math.log(2));
		long[] arr = new long[n];
		
		List[] cnt = new ArrayList[(int) ( Math.log(1000000000000000000l)/Math.log(2))+1];
		
		for(int i=0; i<n; i++){
			arr[i] = in.nextLong();
			int index = (int) (Math.log(arr[i])/Math.log(2));
			if(cnt[index]==null)
				cnt[index] = new ArrayList<Long>();
			cnt[index].add(arr[i]);
		}
		System.out.println(cnt[4]);
		int c = pow;
		int N = 0;
		long largest = 0;
		
		while(c > 1){
			
			for(int i=c; i>=0; i--){
				if(cnt[i]!=null && cnt[i].size() >= k){
					
					N = cnt[i].size();
					c = i;
					largest += Math.pow(2, i);
					List[] temp = new ArrayList[c+1];
					for (Object num : cnt[i]) {
						long no = (Long) num;
						System.out.println(no+", "+c);
						no = (long) (no-Math.pow(2, c));
						//System.out.println(no+", "+c);
						int ind = 0;
						if(no!=0)
						 ind = (int) ((Math.log(no)/Math.log(2)));
						if(temp[ind]==null)
							temp[ind] = new ArrayList<Long>();
						temp[(int) (ind)].add(no);
					}
					System.out.println(Arrays.toString(temp));
					cnt = temp;
					
					break;
				}
			}
			
			c--;
		}
		
		System.out.println((int)largest);
		//System.out.println("NCR"+N+","+k);
		System.out.println(nCr(N, k));
		
	}
	

	
	
	static String nCr(int n, int r){
		int d = r;
		long num = 1;
		while(r>0){
			num = (num*n) % MOD;
			n--;
			r--; 
		}
		
		long den = fact(d);
		//System.out.println("indss"+den);
		BigInteger b1 = new BigInteger(String.valueOf(num));
		BigInteger b2 = new BigInteger(String.valueOf(den));
		BigInteger b3 = b1.multiply(b2.modInverse(new BigInteger(String.valueOf(MOD))));
		
		return b3.remainder(new BigInteger(String.valueOf(MOD))).toString();
		
	}
	
	static long fact(int r){
		long fac = 1;
		while(r>0){
			fac = (fac*r)%MOD;
			r--;
		}
		return fac;
	}
}
