package WorldCodeSprint;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class PrimeDigitSum {
	
	static int MOD = 100000007;
	static boolean[] primes;
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		primes = sieveOfEratosthenes(45);
		
		for(int i=0; i<t; i++){
			int n = in.nextInt();
			List<Integer> list = bruteForce(4);
			System.out.println(list);
			//System.out.println(list.size());
			dp(n);
		}
		
	}
	
	static int dp(int n){
		
		List<Integer> primesList;
		
		if(n<=4)
			return bruteForce(n).size();
		
		else if(n>4){
			
			primesList = bruteForce(4);
			HashMap<Integer, String> primeMap = new HashMap<Integer, String>();
			int[][] dp = new int[280][n-4];
			
			for (int i=0; i<primesList.size(); i++) 
				primeMap.put((i+1), String.valueOf(primesList.get(i)));
			
			for(int i=0; i<280; i++){
				String st = primeMap.get(i+1);
				int k = Integer.parseInt(st);
				int count= 0;
				for(int j=0; j<10; j++){
					if(primes[sumOfDigits((k*10+j)%1000)]&&primes[sumOfDigits((k*10+j)%10000)]&&primes[sumOfDigits((k*10+j)%100000)])
						count++;
				}
				dp[i][0] = count;
			}
			int sum=0;
			for(int i=0; i<280; i++){
				sum+=dp[i][0];
				System.out.print(dp[i][0]+", ");
				if(i%20==0)
					System.out.println("\n");
			}
			
			
			System.out.println("5 digit sum = " + sum);
		}
		return n;
	}
	
	
	static  int sumOfDigits(int n){
		int digitSum = 0;
		while(n>0){
			digitSum += n%10;
			n = n/10;
		}
		return digitSum;
	}
	
	static List<Integer> bruteForce(int n){
		
		List<Integer> list = new ArrayList<Integer>();
		if(n==3){
			for(int i=100; i<1000; i++){
				if(primes[sumOfDigits(i)])
					list.add(i);
			}
		}
		if(n==4){
			for(int i=1000; i<10000; i++){
				if(primes[sumOfDigits(i)]&&primes[sumOfDigits(i/10)]&&primes[sumOfDigits(i%1000)])
					list.add(i);
			}
		}
		
		return list;
	}
	
	static boolean[] sieveOfEratosthenes(int n)
    {
        
        boolean prime[] = new boolean[n+1];
        
        for(int i=0;i<n;i++)
            prime[i] = true;
        
        prime[0] = false;
        prime[1] = false;
         
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        
        return prime;
    }
	
}
