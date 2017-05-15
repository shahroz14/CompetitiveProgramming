package spoj;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PRIME1 {
	
	
	public static void main(String[] args) {
		
		/*PrintWriter pw = new PrintWriter(new File("D:\\primes.txt"));*/
		
		List<Integer> primesList = new ArrayList<Integer>();
		primesList = sieve((int) Math.sqrt(1000000000l)+1);
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int q=0; q<t; q++) {
			
			int m = in.nextInt();
			int n = in.nextInt();
			
			boolean[] primes = new boolean[n-m+1];
			Arrays.fill(primes, true);
			
			StringBuilder ans = new StringBuilder();
			
			Iterator<Integer> itr = primesList.iterator();
			
			while(itr.hasNext()){
				
				int f = itr.next();
				
				if(f > n)
					break;
				
				int st = getClosestDivisor(f, m);
				
				for(int i=st; i<=n; i+=f)
					if(i!=f)
						primes[i-m] = false;
					
			}
			
			
			for(int i=0; i<n-m+1; i++)
				if(primes[i]&i+m>=2)
					ans.append((i+m)+" \n");
			
			System.out.println(ans);
		}
	}
	
	private static int getClosestDivisor(int f, int m) {
		
		while(m%f!=0)
			m++;
		
		return m;
		
	}

	static List<Integer> sieve(int n){
		
		List<Integer> primeList = new ArrayList<Integer>();
		
		boolean prime[] = new boolean[n+1];
        
        for(int i=0;i<n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
            if(prime[p] == true)
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
		
        
        for(int i=2; i<n; i++)
        	if(prime[i])
        		primeList.add(i);
        
        
        return primeList;
	}
}
