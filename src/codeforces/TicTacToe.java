package codeforces;

import java.util.Scanner;

public class TicTacToe {

	static final String ILLEGAL = "illegal";
	static final String FIRSTWON = "the first player won";
	static final String SECONDWON = "the second player won";
	static final String FIRST = "first";
	static final String SECOND = "second";
	static final String DRAW = "draw";
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String l1 = in.nextLine();
		String l2 = in.nextLine();
		String l3 = in.nextLine();
		String gameState = l1+l2+l3;
		if(isIllegal(gameState)){
			System.out.println(ILLEGAL);
			return;
		}
		if(isWon(gameState, 'X')){
			System.out.println(FIRSTWON);
			return;
		}
		if(isWon(gameState, '0')){
			System.out.println(SECONDWON);
			return;
		}
		if(whichPlayer(gameState)==-1){
			System.out.println(DRAW);
			return;
		}
			
		if(whichPlayer(gameState)==0){
			System.out.println(FIRST);
			return;
		}
		if(whichPlayer(gameState)==1){
			System.out.println(SECOND);
			return;
		}
		
		
		
		
	}
	
	
	
	static int whichPlayer(String gameState){
		// 0 first, 1 second;
		int cnt = 0;
		for(int i=0; i<gameState.length(); i++)
			if(gameState.charAt(i)!='.')
				cnt++;
		if(cnt==9)
			return -1;
		if(cnt%2==0)
			return 0;
		return 1;
	}
	
	static boolean isIllegal(String gameState){
		int xCnt = 0;
		int nCnt = 0;
		boolean xWon = isWon(gameState, 'X');
		boolean nWon = isWon(gameState, '0');
		if(xWon && nWon)
			return true;
		for(int i=0; i<gameState.length(); i++) {
			if(gameState.charAt(i)=='X')
				xCnt++;
			if(gameState.charAt(i)=='0')
				nCnt++;
		}
		
		if(nCnt>xCnt || (nWon && xCnt>nCnt) || (xWon && nCnt>=xCnt) || (xCnt-nCnt>1))
			return true;
		
		return false;
	}
	
	static boolean isWon(String gameState, char m){
		
		if(gameState.charAt(0)==m && gameState.charAt(1)==m && gameState.charAt(2)==m)
			return true;
		if(gameState.charAt(3)==m && gameState.charAt(4)==m && gameState.charAt(5)==m)
			return true;
		if(gameState.charAt(6)==m && gameState.charAt(7)==m && gameState.charAt(8)==m)
			return true;
		if(gameState.charAt(0)==m && gameState.charAt(4)==m && gameState.charAt(8)==m)
			return true;
		if(gameState.charAt(2)==m && gameState.charAt(4)==m && gameState.charAt(6)==m)
			return true;
		if(gameState.charAt(0)==m && gameState.charAt(3)==m && gameState.charAt(6)==m)
			return true;
		if(gameState.charAt(1)==m && gameState.charAt(4)==m && gameState.charAt(7)==m)
			return true;
		if(gameState.charAt(2)==m && gameState.charAt(5)==m && gameState.charAt(8)==m)
			return true;
		
		return false;
	}
	
	
}
