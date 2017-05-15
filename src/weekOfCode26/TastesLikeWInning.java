package weekOfCode26;

import java.math.BigInteger;
import java.util.Scanner;

public class TastesLikeWInning {
	public static void main(String[] args) {
		BigInteger b = new BigInteger("2");
		b=b.pow(1000);
		System.out.println(b);
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x = (int) Math.pow(2, m)-1;
		int tot = (int) Math.pow(x, n);
		if(n%2==0)
			System.out.println(tot-x);
		else
			System.out.println(tot);
	}
}
