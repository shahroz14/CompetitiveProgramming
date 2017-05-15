package rookierank2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Four {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] moves = new int[n][n];
		int[][] check = new int[n][n];
		fillCheck(check, n);
		//System.out.println(minMoves(check, new Pair(0, 0), 1, 3, n));
		for(int i=1; i<n; i++){
			for(int j=1; j<n; j++){
				fillCheck(check, n);
				moves[i][j] = minMoves(check, new Pair(0, 0), i, j, n);
			}
		}
		printMoves(moves, n);
	}
	
	static void printMoves(int[][] moves, int n){
		for(int i=1; i<n; i++){
			for(int j=1; j<n; j++){
				if(moves[i][j] != Integer.MAX_VALUE)
					System.out.print(moves[i][j]+" ");
				else
					System.out.print("-1 ");
			}
			System.out.println("");
		}
	}
	
	public static int minMoves(int[][] check, Pair from, int a, int b, int n){
		
		Queue<Pair> que = new  LinkedList<Pair>();
		check[from.x][from.y] = 0;
		while(check[n-1][n-1]==Integer.MAX_VALUE && from != null){
			
			addPossiblePair(que, check, from, a, b, n);
			//printCheck(check, n);
			//System.out.println("Queue "+que);
			from = que.poll();
		}
		return check[n-1][n-1];

	}
	
	static void printCheck(int[][] check, int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(check[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static void addPossiblePair(Queue<Pair> que, int[][] check, Pair from, int a, int b, int n){
		
		Pair p1 = new Pair(from.x+a, from.y+b);
		Pair p2 = new Pair(from.x+a, from.y-b);
		Pair p3 = new Pair(from.x-a, from.y+b);
		Pair p4 = new Pair(from.x-a, from.y-b);
		Pair p5 = new Pair(from.x+b, from.y+a);
		Pair p6 = new Pair(from.x+b, from.y-a);
		Pair p7 = new Pair(from.x-b, from.y+a);
		Pair p8 = new Pair(from.x-b, from.y-a);
		if(isValid(p1, n) && check[p1.x][p1.y]==Integer.MAX_VALUE){
			que.add(p1);
			check[p1.x][p1.y] = check[from.x][from.y]+1;
		}
		if(isValid(p2, n) && check[p2.x][p2.y]==Integer.MAX_VALUE){
			que.add(p2);
			check[p2.x][p2.y] = check[from.x][from.y]+1;
		}
		if(isValid(p3, n) && check[p3.x][p3.y]==Integer.MAX_VALUE){
			que.add(p3);
			check[p3.x][p3.y] = check[from.x][from.y]+1;
		}
		if(isValid(p4, n) && check[p4.x][p4.y]==Integer.MAX_VALUE){
			que.add(p4);
			check[p4.x][p4.y] = check[from.x][from.y]+1;
		}
		if(isValid(p5, n) && check[p5.x][p5.y]==Integer.MAX_VALUE){
			que.add(p5);
			check[p5.x][p5.y] = check[from.x][from.y]+1;
		}
		if(isValid(p6, n) && check[p6.x][p6.y]==Integer.MAX_VALUE){
			que.add(p6);
			check[p6.x][p6.y] = check[from.x][from.y]+1;
		}
		if(isValid(p7, n) && check[p7.x][p7.y]==Integer.MAX_VALUE){
			que.add(p7);
			check[p7.x][p7.y] = check[from.x][from.y]+1;
		}
		if(isValid(p8, n) && check[p8.x][p8.y]==Integer.MAX_VALUE){
			que.add(p8);
			check[p8.x][p8.y] = check[from.x][from.y]+1;
		}
		
		
	}
	
	public static boolean isValid(Pair a, int n){
		if(a.x>=0 && a.x<n && a.y>=0 && a.y<n)
			return true;
		return false;
	}
	
	static void fillCheck(int[][] check, int n){
			for(int j=0; j<n; j++){
				Arrays.fill(check[j], Integer.MAX_VALUE);
			}
	
	}
	
}

class Pair{
	int x;
	int y;
	
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public boolean equals(Object obj1){
		Pair p = (Pair) obj1;
		if(this.x==p.x && this.y==p.y)
			return true;
		return false;
	}
	
	public String toString(){
		return this.x+", "+this.y;
	}
		
}
