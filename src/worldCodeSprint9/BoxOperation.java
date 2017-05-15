package worldCodeSprint9;


import java.util.Scanner;

public class BoxOperation {
	

	
	public static void main(String[] args) {
		//System.out.println(Math.floor(-3d/2));
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] BIT = new int[n+1];
		int[] x = new int[n+1];
		
		for(int i=1; i<=n; i++){
			x[i] = in.nextInt();
			//update(BIT, i, x[i]);
		}
		
		for(int i=0; i<q; i++){
			int query = in.nextInt();
			switch(query){
				case 1:
					int l = in.nextInt()+1;
					int r = in.nextInt()+1;
					int c = in.nextInt();
					
					for(int j=l; j<=r; j++)
						x[j]+=c;
					
					break;
				
				
				case 2:
					int l2 = in.nextInt()+1;
					int r2 = in.nextInt()+1;
					double d = in.nextDouble();
					
					for(int j=l2; j<=r2; j++)
						x[j] = (int) Math.floor(x[j]/d);
						
					break;
				
				case 3:
					int l3 = in.nextInt()+1;
					int r3 = in.nextInt()+1;
					
					int min = Integer.MAX_VALUE;
					for(int j=l3; j<=r3; j++){
						if(x[j]<min)
							min = x[j];
					}
					System.out.println(min);
					break;
					
				case 4:
					int l4 = in.nextInt()+1;
					int r4 = in.nextInt()+1;
					
					long sum = 0;
					
					
					for(int j=l4; j<=r4; j++)
						sum += x[j];
					
					System.out.println(sum);
					break;
			}
		}
		
	}
	
	public static void update(int[] BIT, int x, int delta)
	{
		int n = BIT.length;
	      for(; x <= n; x += x&-x)
	        BIT[x] += delta;
	}
	
	
	public static int query(int[] BIT, int x)
	{
	     int sum = 0;
	     for(; x > 0; x -= x&-x)
	        sum += BIT[x];
	     return sum;
	}
}
