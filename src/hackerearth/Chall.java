package hackerearth;

import java.util.Scanner;

public class Chall {
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int j=0; j<t; j++){
            int t0 = in.nextInt();
            int t1 = in.nextInt();
            int t2 = in.nextInt();
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            float d = in.nextFloat();
            
            double tt1 = Math.ceil(60*(d/v1));
            double tt2 = Math.ceil(60*(d/v2));
            //System.out.println(tt1+" "+tt2);
            if(t0<=t1 && t0<=t2){
                System.out.println((int)Math.min(t1+tt1,t2+tt2));
                continue;
            }
            else if(t0<=t1){
                System.out.println((int)(t1+tt1));
                continue;
            }
            else if(t0<=t2){
                 System.out.println((int)(t2+tt2));
                continue;
            }
            else{
                System.out.println("-1");
            }
        }
	}
}
