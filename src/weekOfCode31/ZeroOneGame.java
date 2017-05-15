package weekOfCode31;

import java.util.Scanner;

public class ZeroOneGame {
	
	static StringBuilder ans = new StringBuilder("");
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		
		
		for( int k=0; k<q; k++){
			
			int n = in.nextInt();
			
			
			int[] gameStr = new int[n];
			
			for (int i=0; i<n; i++)
				gameStr[i] = in.nextInt();
			
			f(gameStr);
		}
			
			System.out.println(ans);
		
	}

	
	
	static void f(int[] gameStr) {
		int n = gameStr.length;
		boolean[] ch = new boolean[n];
		
		for(int i=1; i<n-1; i++){
			if(gameStr[i-1]==0 && gameStr[i]==1 && gameStr[i+1]==0)
				ch[i] = true;
		}
		
		StringBuilder newGame = new StringBuilder(rebuildGame(ch, gameStr));
		
		int cnt = n - newGame.length();
		/*System.out.println(newGame+" "+cnt);*/
		int zS = 0;
		
		for(int i=0; i<newGame.length(); i++){
			if(newGame.charAt(i)=='0')
				zS += 1;
			else {
				if(zS>2)
					cnt += zS-2;
				zS = 0;
			}
		}
		
		if(zS > 2 & n > 2)
			cnt += zS-2;
		
		/*System.out.println(cnt);*/
		
		if(cnt%2==0)
			ans.append("Bob\n");
		else
			ans.append("Alice\n");
		
		
	}
	
	static String rebuildGame(boolean[] ch, int[] gameStr){
		
		int n = gameStr.length;
		StringBuilder sb = new StringBuilder();
		//sb.append(gameStr[0]);
		for(int i=0; i<n; i++){
			if(!ch[i])
				sb.append(gameStr[i]);
		}
		/*if(n>1)
			sb.append(gameStr[n-1]);*/
		
		
		return sb.toString();
	}
	
	
}
