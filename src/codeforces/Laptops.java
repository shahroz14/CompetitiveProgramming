package codeforces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Laptops {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Laptop[] lap = new Laptop[n];
		for(int i=0; i<n; i++){
			int p = in.nextInt();
			int q = in.nextInt();
			lap[i] = new Laptop(p, q);
		}
		Arrays.sort(lap, new LapComp());
		//System.out.println(Arrays.toString(lap));
		boolean alex = false;
		int minP = lap[0].p;
		int minQ = lap[0].q;
		for(int i=0; i<n; i++){
			if(lap[i].p > minP && lap[i].q < minQ){
				alex = true;
				break;
			}
			minP = lap[i].p;
			minQ = lap[i].q;
		}
		if(alex)
			System.out.println("Happy Alex");
		else
			System.out.println("Poor Alex");
	}
}

class Laptop{
	
	int p;
	int q;
	
	Laptop(int pr, int qu){
		p = pr;
		q = qu;
	}
	public String toString(){
		return p+","+q;
	}
}

class LapComp implements Comparator<Laptop>{

	@Override
	public int compare(Laptop o1, Laptop o2) {
		if(o1.p==o2.p)
			return o1.q-o2.q;
		return o1.p-o2.p;
	}
	
}