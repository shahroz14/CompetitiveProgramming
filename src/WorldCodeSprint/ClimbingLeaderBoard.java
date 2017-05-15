package WorldCodeSprint;

import java.util.Scanner;
import java.util.TreeMap;


public class ClimbingLeaderBoard {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0; i<n; i++){
			int score = in.nextInt();
			if(!map.containsKey(score)){
				map.put(score, map.size()+1);
			}
		}
		
		
		
		
		int m = in.nextInt();
		
		int aliceScore = 0;
		
		for(int i=0; i<m; i++){
			aliceScore = in.nextInt();
			
			if(aliceScore > map.lastKey())
				sb.append(1+"\n");
			
			else{
				if(map.ceilingKey(aliceScore)==aliceScore)
					sb.append(map.get(map.ceilingKey(aliceScore))+"\n");
				else
					sb.append(map.get(map.ceilingKey(aliceScore))+1+"\n");
			}
		}
		System.out.println(sb);
	}
	
}

