package weekOfCode26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SatisfactoryPairs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		int count = 0;
		int st = 0;
		//List<Integer> f = getAllFactors(n);
		HashSet<String> set = new HashSet<String>();
		
		
		
		for(int x=1; x<=n/2; x++){
			for(int y=1; ; y++){
					if(x+2*y>n)
						break;
					if(n%GCD(x,y)!=0)
						continue;
				for(double a=1; a<n/2 ; a++){
					st++;
					if(a*x+(a+1)*y>n){
						break;
					}
					double b = (n-a*x)/y;
					if(isInt(b)){
						if(set.contains(a+"+"+b))
							continue;
						set.add(a+"+"+b);
						//System.out.println((int)a+"*"+x+" + "+(int)b+"*"+y+" = "+n);
						count++;
					}
				}
			}
		}
		//System.out.println("statements "+st);
		System.out.println(count);
	}
	
	static boolean isInt(double n){
		if(n==Math.ceil(n))
			return true;
		return false;
	}
	
	static int GCD(int a, int b){
		if(b==0)
			return a;
		return GCD(b, a%b);
	}
	
	static List<Integer> getAllFactors(int n){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=2; i<=n; i++){
			if(n%i==0)
				list.add(i);
		}
		return list;
	}
}
