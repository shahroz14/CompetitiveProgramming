package weekOfCode26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BestDivisor {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int max = 0;
		int best = n;
		List<Integer> list = getDivisor(n);
		int temp = 0;
		for (Integer integer : list) {
			temp = getDigitsSum(integer);
			if(temp>max){
				max = temp;
				best = integer;
			}
		}
		
		System.out.println(best);
	}
	
	public static int getDigitsSum(int n){
		int sum = 0;
		while(n>0){
			sum += n%10;
			n = n/10;
		}
		return sum;
	}
	
	public static List<Integer>getDivisor(int n){
		List<Integer> l = new ArrayList<Integer>();
		for(int i=1; i<=n;i++){
			if(n%i==0)
				l.add(i);
		}
		return l;
	}
}
