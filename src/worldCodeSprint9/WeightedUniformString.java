package worldCodeSprint9;

import java.util.Scanner;


public class WeightedUniformString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int[] arr = new int[27];
		
		int cnt = 1;
		if(s.length()<=1){
			arr[s.charAt(0)-96] = 1;
		}
		else{
			for(int i=1; i<s.length(); i++){
				if(s.length()>1){
					if(s.charAt(i)==s.charAt(i-1)){
						cnt++;
						continue;
					}
					else{
						
						if(cnt>arr[s.charAt(i-1)-96])
						arr[s.charAt(i-1)-96] = cnt;
						cnt=1;
					}
					
				}
				
			}
			if(s.charAt(s.length()-1)==s.charAt(s.length()-2)){
				//cnt++;
				if(arr[s.charAt(s.length()-1)-96]<cnt){
					arr[s.charAt(s.length()-1)-96] = cnt;
				}
			}
			else{
				if(arr[s.charAt(s.length()-2)-96]<cnt){
					arr[s.charAt(s.length()-2)-96] = cnt;
				}
				if(arr[s.charAt(s.length()-1)-96]<1)
					arr[s.charAt(s.length()-1)-96] = 1;
			}
		}
		
		
		//System.out.println(Arrays.toString(arr));
		int q = in.nextInt();
	l1:	for(int i=0; i<q; i++){
			int k = in.nextInt();
			for(int j=1; j<=26; j++){
				if(k%j==0){
					if((k/j)<=arr[j]){
						System.out.println("Yes");
						continue l1;
					}
				}
			}
			System.out.println("No");
		}
	}
}
