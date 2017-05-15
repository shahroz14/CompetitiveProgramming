package worldCodeSprint9;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class KingdomDiv {
	static int mod = 1000000007;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashSet<Integer>[] adjList = new HashSet[n+1];
		
		for(int i=1; i<=n; i++)
			adjList[i] = new HashSet<Integer>();
		
		prepareAdjacencyList(in, adjList, n);
		
		
	
	}
	
	public static void insertLeafNodesinQueue(HashSet<Integer>[] adjList){
		
		
		
	}
	
	public static void prepareAdjacencyList(Scanner in, HashSet<Integer>[] adjList, int n){
		for(int i=1; i<n; i++){
			int u = in.nextInt();
			int v = in.nextInt();
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
	}
	
}
