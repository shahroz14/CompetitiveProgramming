package weekOfCode29;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BigSorting {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<BigNumber> list = new ArrayList<BigNumber>(n);
		for(int i=0; i<n; i++)
			list.add(new BigNumber(in.next()));
		Collections.sort(list);
		System.out.println(print(list, n));
	}
	
	
	public static String print(ArrayList<BigNumber> list, int n){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++)
			sb.append(list.get(i).toString()+"\n");
		return sb.toString();
	}
	
	
}


class BigNumber implements Comparable<BigNumber>{
	
	String num;
	int length;
	
	public BigNumber() {
		num = "";
	}
	
	public BigNumber(String num){
		this.num = num;
		length = num.length();
		rLZ();
	}
	
	
	@Override
	public int compareTo(BigNumber o) {
		
		if(length > o.length)
			return 1;
		
		else if(length < o.length)
			return -1;
		
		else{
			int i = 0;
			for(i=0; i < length; i++){
				if(num.charAt(i) > o.num.charAt(i))
					return 1;
				else if(num.charAt(i) < o.num.charAt(i))
					return -1;
			}
		}
		return 0;
	}
	
	@Override
	public String toString(){
		return num;
	}
	
	
	public void rLZ(){
		int i=0;
		while(i < length && num.charAt(i)=='0')
			i++;
		if(i==length)
			num = "0";
		num = num.substring(i);
		length = num.length();
	}
	
}