package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrangeCounter {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong();
		
		long n = 1000000000000l;
		List<Long> list = new ArrayList<Long>();
		list.add(0l);
		
		for(long i=3; i<=n; i*=2)
			list.add(list.get(list.size()-1)+i);
		
		long upBound = 0l;
		for(int i=0; i<list.size(); i++){
			if(t==list.get(i)){
				System.out.println("1");
				return;
			}
			if(t<list.get(i)){
				upBound = list.get(i);
				break;
			}
		}
		System.out.println(upBound-t+1);
	}
}
