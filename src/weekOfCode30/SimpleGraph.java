package weekOfCode30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SimpleGraph {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean[] ver = new boolean[n];
		int[][] graph = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				graph[i][j] = in.nextInt();
			}
		}
		
		List<Triangle> triList = new ArrayList<Triangle>();
		List<Edge> edgesList = new ArrayList<Edge>();
		
		for( int i=0; i<n; i++){
			for( int j=i+1; j<n; j++){
				if( graph[i][j]==1){
					edgesList.add( new Edge( i, j));
				}
			}	
		}
		
		int totalEdges = edgesList.size();
		
		for( int i=0; i<totalEdges-2; i++){
			for( int j=i+1; j<totalEdges-1; j++){
				for( int k=j+1; k<totalEdges; k++){
					if( Triangle.isTriangle( edgesList.get(i), edgesList.get(j), edgesList.get(k))){
						triList.add(new Triangle( edgesList.get(i), edgesList.get(j), edgesList.get(k)));
						
					}
				}
			}
		}
		
		
		HashSet<Integer> rsltSet = getCount( triList);
		
		if(rsltSet.size()>0){
			System.out.println(rsltSet.size());
			for (Integer integer : rsltSet) {
				ver[integer] = true;
			}
			
			for(int k=0; k<n; k++){
				if(ver[k])
					System.out.print((k+1)+" ");
			}
		}
		else {
			System.out.println(n);
			for( int i=1; i<=n; i++)
				System.out.print(i+" ");
		}
		
		
		
	}
	
	static HashSet<Integer> getCount( List<Triangle> triList){
		
		float maxRatio = Float.MIN_VALUE;
		
		HashSet<Integer> vertices = new HashSet<Integer>();
		
		if(triList.size()>0){
			maxRatio = 1.0f/3.0f;
			vertices.add(triList.get( 0).e1.u);
			vertices.add(triList.get( 0).e1.v);
			vertices.add(triList.get( 0).e2.u);
			vertices.add(triList.get( 0).e2.v);
			vertices.add(triList.get( 0).e3.u);
			vertices.add(triList.get( 0).e3.v);
		}
		
		for ( int i=0; i<triList.size(); i++) {
			
			List<Triangle> triTwoList = new ArrayList<Triangle>();
			List<Triangle> triOneList = new ArrayList<Triangle>();
			triTwoList.add(triList.get( i));
			triOneList.add(triList.get( i));
			int twoCV = 0;
			int oneCV = 0;
			
			for ( int j=i+1; j<triList.size(); j++){
				Triangle triJ = triList.get( j);
				if( Triangle.getCommonVertices( triTwoList, triJ) == 2){
					twoCV++;
					triTwoList.add( triJ);
				}
				if( Triangle.getCommonVertices( triTwoList, triJ)==1){
					oneCV++;
					triOneList.add( triJ);
				}
			}
			
			
			if ( twoCV > 0){
				float newRatio = ( 1.0f+twoCV)/(((1+twoCV)*3.0f)-(2.0f*twoCV));
				if( newRatio > maxRatio){
					vertices.clear();
					maxRatio = newRatio;
					for (Triangle triangle : triTwoList) {
						vertices.add(triangle.e1.u);
						vertices.add(triangle.e1.v);
						vertices.add(triangle.e2.u);
						vertices.add(triangle.e2.v);
						vertices.add(triangle.e3.u);
						vertices.add(triangle.e3.v);
					}
				}
				
			}
			else{
				float newRatio = ( 1.0f+oneCV)/(((1+oneCV)*3.0f)-(1.0f*oneCV)); 
				if( newRatio > maxRatio){
					vertices.clear();
					maxRatio = newRatio;
					for (Triangle triangle : triOneList) {
						vertices.add(triangle.e1.u);
						vertices.add(triangle.e1.v);
						vertices.add(triangle.e2.u);
						vertices.add(triangle.e2.v);
						vertices.add(triangle.e3.u);
						vertices.add(triangle.e3.v);
					}
				}
			}
			
			triTwoList.clear();
			
		}
		
		
		return vertices;
	}
	
	
	
}

class Edge{
	
	int u;		//u smaller
	int v;		//v larger
	
	public Edge(int u, int v) {
		if(u < v){
			this.u = u;
			this.v = v;
		}
		else{
			this.u = v;
			this.v = u;
		}
	}
	
	@Override
	public String toString() {
		return u+"->"+v;
	}
	
	@Override
	public boolean equals( Object obj) {
		Edge e1 = null;
		if( obj instanceof Edge)
			e1 = ( Edge) obj;
		if( e1 != null  && e1.u == this.u && e1.v == this.v){
			return true;
		}
		return false;
	}
	
	
	
	
	
}

class Triangle{
	
	Edge e1;
	Edge e2; 
	Edge e3;
	
	static boolean isTriangle( Edge e1, Edge e2, Edge e3){
		if( e1.u == e2.u){
			if( e1.v < e2.v){
				Edge temp = new Edge( e1.v, e2.v);
				if( temp.equals( e3))
					return true;
			}
			else{
				Edge temp = new Edge( e2.v, e1.v);
				if( temp.equals( e3))
					return true;
			}
		}
		return false;
	}
	
	public Triangle( Edge e1, Edge e2, Edge e3) {
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
	}
	
	@Override
	public String toString() {
		return "\t1. "+e1.toString()+"  2. "+e2.toString()+"  3. "+e3.toString();
	}
	
	static int getCommonVertices( List<Triangle> triList, Triangle tri){
		
		HashSet<Integer> vertexSet = new HashSet<Integer>();
		HashSet<Integer> tV = new HashSet<Integer>();
		
		for( Triangle triangle : triList) {
			vertexSet.add( triangle.e1.u);
			vertexSet.add( triangle.e1.v);
			vertexSet.add( triangle.e2.u);
			vertexSet.add( triangle.e2.v);
			vertexSet.add( triangle.e3.u);
			vertexSet.add( triangle.e3.v);
		}
		
		tV.add(tri.e1.u);
		tV.add(tri.e1.v);
		tV.add(tri.e2.u);
		tV.add(tri.e2.v);
		tV.add(tri.e3.u);
		tV.add(tri.e3.v);
		
		int cV = 0;
		
		for ( Integer integer : tV) {
			if(cV==2)
				return 2;
			if( vertexSet.contains(integer))
				cV++;
		}
		
		return cV;
	}
	
	
}
