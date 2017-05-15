package weekOfCode26;
import java.util.Arrays;
import java.util.Scanner;

class SievePrimeGenerator {
	static int array[];
	static int primes[];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 int n = in.nextInt();
		 int m = in.nextInt();
		 calculate(n, m);
		 int count= 0;
		 for (int i = 1; i < array.length; i++) {
			if(array[i]-array[i-1]==2){
				count++;
			}
		}
		 System.out.println(count);
	}
	
	public static void calculate(int n, int m) {
 		int j = 0;
 		int sqt = (int) Math.sqrt(m);
 		array = new int[sqt + 1];
 		primes = new int[sqt + 1];
 		//System.out.println(“sqt:” + sqt);
 		initialise(sqt + 1);
 		for (int i = 2; i <= sqt; i++) {
   			if (array[i] == 1) {
   				primes[j] = i;
   				j++;
     			for (int k = i + i; k <= sqt; k += i) {
       				array[k] = 0;
     			}
 			}
 		}
 
 
 		int diff = (m - n + 1);
 		array = new int[diff];
		 initialise(diff);
 		for (int k = 0; k < j; k++) {
 			int div = n / primes[k];
 			div *= primes[k];
 			while (div <= m) {
   				if(div>=n && primes[k]!=div)
   				array[div-n] = 0;
   				div += primes[k];
 			}
 		}
		for (int i = 0; i < diff; i++) {
 			if (array[i] == 1 && (i+n) !=1)
 				System.out.println(i + n);
 			}
 		}
 		public static void initialise(int sqt) {
 			for (int i = 0; i < sqt; i++) {
 				array[i] = 1;
 			}
 		}
}