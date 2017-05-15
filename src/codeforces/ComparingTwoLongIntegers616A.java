package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComparingTwoLongIntegers616A {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String num1 = in.readLine();
		String num2 = in.readLine();
		if(compare(num1,num2)>0)
			System.out.println(">");
		else if(compare(num1,num2)<0)
			System.out.println("<");
		else
			System.out.println("=");
		
	}
	
	
	public static int compare(String num1, String num2){
		num1 = gRN(num1);
		num2 = gRN(num2);
		int l1 = num1.length();
		int l2 = num2.length();
		
		if(l1>l2)
			return 1;
		else if(l1<l2)
			return -1;
		
		else{
			int i = 0;
			for(i=0; i<l1; i++){
				if(num1.charAt(i)>num2.charAt(i))
					return 1;
				else if(num1.charAt(i)<num2.charAt(i))
					return -1;
			}
		}
		
		return 0;
		
	}
	
	public static String gRN(String num1){
		int n = num1.length();
		int i=0;
		while(i < n && num1.charAt(i)=='0')
			i++;
		if(i==n)
			return "0";
		return num1.substring(i);
	}
	
	
	
}
