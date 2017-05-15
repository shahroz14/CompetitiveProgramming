package weekOfCode26;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Twins {
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n==1)
			n=2;
		int m = in.nextInt();
		int count = 0;
		List<Integer> list = sieveInRange(n, m);
		//System.out.println(list+"\nsize = "+list.size());
		for(int i=1; i<list.size(); i++){
			if(list.get(i)-list.get(i-1)==2)
				count++;
		}
		System.out.println(count);
		
	}
	static List<Integer> sieveOfEratosthenes(int n)
    {
        List<Integer> list = new ArrayList<Integer>();
		// Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
         
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
         
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                list.add(i);
        }
        
        return list;
    }
	
	static List<Integer> sieveInRange(int n, int m)
    {
        List<Integer> list = new ArrayList<Integer>();
		// Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[(m-n+1)];
        
        
        List<Integer> bn = sieveOfEratosthenes((int)Math.ceil(Math.sqrt(m)));
        
        for (Integer integer : bn) {
        	
        	
        	int i = (int)Math.ceil(n/(integer+0.0d))*integer;
        	
			while(i<=m){
				if(i==integer){
					i+= integer;
				}
				
				prime[(int) (i-n)] = true;
				
				i += integer; 
			}
		}
        
        
        
        for(int i=0; i<m-n+1; i++){
        	if(!prime[i]){
        		int add = (int) (i+n);
        		for(int j=i+add; j<m-n+1; j = j+add){
        			prime[j] = true;
        		}
        	}
        }
        
        
        // Print all prime numbers
        for(int i = 0; i < m-n+1; i++)
        {
            if(!prime[i])
                list.add((int) (i+n));
        }
        
        return list;
    }
	
	static int ceil(int n, int i){
		if(n%i==0)
			return n;
		return ((n/i)+1)*i;
	}
}
