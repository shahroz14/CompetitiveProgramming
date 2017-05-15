package weekOfCode31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpanningTreeFunction {
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		EW[] edges = new EW[m];
		
		
		
		
		for(int i=0; i<m; i++) {
			inp = br.readLine().split(" ");
			int u = Integer.parseInt(inp[0]);
			int v = Integer.parseInt(inp[1]);
			int a = Integer.parseInt(inp[2]);
			int b = Integer.parseInt(inp[3]);
			
			
			
			if(v<u){
				int temp = v;
				v = u;
				u = temp;
			}
			
			EW t = new EW(u, v, a, b);
			edges[i] = t;
			
		}
		
		double k = 100;
		double k_ = 0;
		double v = 50;
		int i = 1;
		double[] ans = null;
		
		while(Math.abs(k-k_) > 1e-9 ){
			
			Arrays.sort(edges, new MyComparator(v));
			
			ans = kruskal(edges, v);
			
			if(ans[0]<0)
				k = v;
			else 
				k_ = v;
			
			v = (k+k_)/2;
			
		}
		
		System.out.println(properFraction((long)ans[1], (long)ans[2]));
		
		
		
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
		arr[rootA] = rootB;
	}
	
	static boolean find(int[] arr, int a, int b){
		if(root(arr, a)==root(arr, b))
			return true;
		return false;
	}
	
	
	static double[] kruskal(EW[] list, double k) {
		int n = list.length;
		
		DisjointSet ds = new DisjointSet();
		
		for(int i=0; i<n; i++)
			ds.makeSet(i);
		
		double[] ans = new double[3];
		
		
		
		for (EW ew : list) {
			
			if(ds.findSet(ew.u)!=ds.findSet(ew.v)){
				ds.union(ew.u, ew.v);
				ans[0] += ew.a - ew.b*k;
				ans[1] += ew.a;
				ans[2] += ew.b;
			}
			
		}
		
		return ans;
		
	}
	
	
	static double getAns(List<EW> arr, double k){
		//System.out.println(arr);
	
		double ans = 0;
		for(int i=0; i<arr.size(); i++){
			ans += arr.get(i).a - arr.get(i).b*k;
		}
		//System.out.println("--- "+ans);
		return ans;
	}
	
	
	static String properFraction(long p, long q){
		
		long GCD = GCD(p, q);
		if(GCD>0){
			p = p/GCD;
			q = q/GCD;
		}
		
		return p+"/"+q;
	}
	
	static long GCD(long a, long b){
		if(b==0)
			return a;
		return GCD(b, a%b);
	}
	
}


class EW {
	
	int a;
	int b;
	int u;
	int v;
	
	static int p;
	static int q;
	
	public EW(int u, int v, int a, int b) {
		this.a = a;
		this.b = b;
		this.u = u;
		this.v = v;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return u+","+v+"-->"+ a+" "+b;
	}
}


class MyComparator implements Comparator<EW>{
	
	double k;
	
	public MyComparator(double k) {
		this.k = k;
	}
	
	@Override
	public int compare(EW o1, EW o2) {
		
		if((o2.a - k*o2.b) - (o1.a - k*o1.b) > 0)
			return 1;
		else if( (o2.a - k*o2.b) - (o1.a - k*o1.b) < 0)
			return -1;
		return 0;
		
	}
}


class DisjointSet {

    private Map<Long, Node> map = new HashMap<Long, Node>();

    class Node {
        long data;
        Node parent;
        int rank;
    }

    /**
     * Create a set with only one element.
     */
    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    /**
     * Combines two sets together to one.
     * Does union by rank
     *
     * @return true if data1 and data2 are in different set before union else false.
     */
    public boolean union(long data1, long data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        //if they are part of same set do nothing
        if (parent1.data == parent2.data) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    /**
     * Finds the representative of this set
     */
    public long findSet(long data) {
        return findSet(map.get(data)).data;
    }

    /**
     * Find the representative recursively and does path
     * compression as well.
     */
    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }
}
