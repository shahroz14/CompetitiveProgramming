package worldCodeSprint9;

import java.util.Scanner;

public class GradingStudents {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0; i<n; i++){
			int k = in.nextInt();
			if(k%5>=3&&k>37){
				System.out.println(k+ 5 - (k%5));
				continue;
			}
			
			System.out.println(k);
				
			
			
		}
	}
}
