package WorldCodeSprint;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class RoadsAndLibraries {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i=0; i<t; i++){
			int n = in.nextInt();
			int m = in.nextInt();
			long cLib = in.nextLong();
			long cRoad = in.nextLong();
			int[] cities = new int[n];
			
			for(int j=0; j<n; j++)
				cities[j] = j;
			
			for(int j=0; j<m; j++){
				int a = in.nextInt();
				int b = in.nextInt();
				union(cities, a-1, b-1);
			}
			
			if(cLib <= cRoad){
				System.out.println(cLib*n);
			}
			else{
				HashMap<Integer, Integer> map = getRootMap(cities);
				//System.out.println(map);
				System.out.println(cost(map, cRoad, cLib));
			}
			
		}
	}
	
	static HashMap<Integer, Integer> getRootMap(int[] arr){
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++){
			
			int root = root(arr, i);
			if(map.containsKey(root)){
				int val = map.get(root)+1;
				map.put(root, val);
			}
			else
				map.put(root, 1);
		}
		
		
		return map;
	}
	
	static long cost(HashMap<Integer, Integer> map, long cRoad, long cLib){
		long cost = 0;
		Set<Entry<Integer, Integer>> set = map.entrySet();
		
		Iterator<Entry<Integer, Integer>> itr = set.iterator();
		while(itr.hasNext()){
			
			Entry<Integer, Integer> e = itr.next();
			
			cost += ((e.getValue()-1)*cRoad)+cLib;
		}
		
		return cost;
		
	}
	
	static int root(int[] arr, int i){
		while(arr[i]!=i){
			i = arr[i];
		}
		return arr[i];
	}
	
	static void union(int[] arr, int a, int b){
		int rootA = root(arr,a);
		int rootB = root(arr, b);
		arr[rootB] = rootA;
	}
	
	static boolean find(int[] arr, int a, int b){
		if(root(arr, a)==root(arr, b))
			return true;
		return false;
	}
}
