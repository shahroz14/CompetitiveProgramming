package weekOfCode26;

import java.util.HashSet;
import java.util.Scanner;

public class Satisf {
	public static void main(String[] args) {
		//System.out.println(calcPairs(calculateB(2, 3, 36),2));
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		int count = 0;
		
		HashSet<String> set = new HashSet<String>();
		
		for(int x=1; x<=Math.sqrt(n) ; x++){
			for(int y=1; y<=Math.sqrt(n); y++){
					if(n%GCD(x,y)==0){
						set.add(x+" "+y);
					}
			}
		}
		
		for (String string : set) {
			String[] xy = string.split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			System.out.println("Set is :"+string+" -->"+calcPairs(calculateB(x, y, n), x));
			count += calcPairs(calculateB(x, y, n), x);
		}
		System.out.println(count);
		//System.out.println(set.size());
	}
	
	static int calcPairs(int b, int x){
		int p = b/x;
		if(p>1)
			p = p/2;
		return p;
	}
	
	static int calculateB(int x, int y, int n){
		double b = 0;
		double a=1;
		while(a<n/2){
			b = (n-a*x)/y;
			if(b==Math.ceil(b))
				break;
			b=0;
			a++;
		}
		return (int) b;
	}
	
	static int GCD(int a, int b){
		if(b==0)
			return a;
		return GCD(b, a%b);
	}
			
	
			
	
}
