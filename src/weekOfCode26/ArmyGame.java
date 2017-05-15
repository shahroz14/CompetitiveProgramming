package weekOfCode26;

import java.util.Scanner;

public class ArmyGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double n = in.nextDouble();
		double m = in.nextDouble();
		System.out.println((int)Math.ceil(m/2)*(int)Math.ceil(n/2));
	}
}
