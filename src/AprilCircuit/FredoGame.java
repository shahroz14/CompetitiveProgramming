package AprilCircuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FredoGame {
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line1 = br.readLine().trim();
		int t = Integer.parseInt(line1);
		
		
		
		for(int j=0; j<t; j++){
			
			String[] line2 = br.readLine().trim().split(" ");
			int a = Integer.parseInt(line2[0]);
			int n = Integer.parseInt(line2[1]);
			
			int[] arr = new int[n];
			
			String[] line3 = br.readLine().trim().split(" ");
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(line3[i]);
			
			String[] ammoLeft = ammoLeft(arr, a).split(" ");
			
			if(ammoLeft[0].equals("Yes"))
				System.out.println("Yes "+ammoLeft[1]);
			else
				System.out.println("No "+ammoLeft[1]);
			
			
		}
		
		
		
		
	}
	
	
	static String ammoLeft(int[] arr, int ammo){
		int ammoLeft = ammo;
		int n = arr.length;
		for(int i=0; i<n; i++){
			
			if(ammoLeft <= 0)
				return "No "+i;
			
			if(arr[i]==0)
				ammoLeft--;
				
			if(arr[i]==1)
				ammoLeft += 2;
		}
		
		return "Yes "+ammoLeft;
	}
	
}
