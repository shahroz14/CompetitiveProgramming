package universityCodesprint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SeparateNumbers {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0; i<t; i++){
			String s = in.next();
			BigInteger rslt = separate(s.trim());
			if(rslt.equals(new BigInteger("-1")))
				System.out.println("NO");
			else
				System.out.println("YES "+rslt);
		}
	}
	
	static BigInteger separate(String s){
		
		int len = s.length();
		if(len==0||s.charAt(0)=='0')
			return new BigInteger("-1");
		
		List<BigInteger> list = getPossibleStartNumbers(s);
		Iterator<BigInteger> itr = list.iterator();
		while(itr.hasNext()){
			BigInteger num = itr.next();
			BigInteger point = num;
			int nextStart = countDigits(point);
			while(nextStart < len){
				
				nextStart = search(s, point.add(new BigInteger("1")), nextStart)+1;
				point.add(new BigInteger("1"));
				if(nextStart==0)
					break;
			}
			if(nextStart==len){
				return num;
			}
		}
		return new BigInteger("-1");
	}
	
	static int countDigits(BigInteger n){
		String s = n.toString();
		return s.length();
	}
	
	static List<BigInteger> getPossibleStartNumbers(String s){
		List<BigInteger> list = new ArrayList<BigInteger>();
		int n = s.length();
		for(int end = 1; end <= n/2; end++){
			while(s.charAt(end)=='0')
				end++;
			list.add(new BigInteger(s.substring(0, end)));
			
		}
		return  list;
	}

	
	
	static int search(String s, BigInteger n, int start){
		int l = s.length();
		int size = countDigits(n);
		for(int end=start+1; end <= start+size+1 && end <= l; end++){
			BigInteger sr = new BigInteger(s.substring(start, end));
			if(sr.equals(n))
				return end-1;
		}
		return -1;
	}

}
