package weekOfCode26;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImprovedHArdHomework {
	public static void main(String[] args) {
		List<Integer> list;
		//System.out.println(df.format(Math.sin(1)));
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		list = generateValues(n);
		double start = System.nanoTime();
		DecimalFormat df = new DecimalFormat("##.000000000");
		double max = -4.000d;
		for(int xi=0; xi<list.size(); xi++){
			int x = list.get(xi);
			if(x>n)
				break;
			for(int yi=0; yi<list.size(); yi++){
					int y =list.get(yi);
					if(x+y>n)
						break;
					int z = n-x-y;
					//System.out.println(x+" "+y+" "+z);
					if(x+y+z==n){
						double sineSum = Math.sin(x)+Math.sin(y)+Math.sin(z);
						if(sineSum>max)
							max = sineSum;
					}
			}
		}
		System.out.println(df.format(max));
		//System.out.println("Time Taken : "+(System.nanoTime()-start)/1000000+" ms");
	}
	
	static List<Integer> generateValues(int n){
		List<Integer> list = new ArrayList<Integer>();
		int i=0;
		double a = 0;
		while(a<=n){
			a = ((2*i)*Math.PI);
			int x = (int) Math.ceil(a);
			if(x>0)
				list.add(x);
			list.add(x+1);
			list.add(x+2);
			i++;
		}
		return list;
	}
}
