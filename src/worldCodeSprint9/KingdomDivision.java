package worldCodeSprint9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class KingdomDivision {
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] arr = new int[n+1];
		
		for(int i=0; i<=n; i++)
			arr[i] = i;
		
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		for(int i=1; i<n; i++){
			int u = in.nextInt();
			int v = in.nextInt();
			union(arr, u, v);
			if(map.containsKey(u)){
				map.get(u).add(v);
			}
			else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(v);
				map.put(u, list);
			}
		}
		//System.out.println("Root is "+ root(arr, 2));
		//System.out.println(map);
		MyTreeNode root = new MyTreeNode(root(arr, 2));
		Queue<MyTreeNode> q = new LinkedBlockingQueue<MyTreeNode>();
		MyTreeNode temp = root;
		q.add(temp);
		
		while(!q.isEmpty()){
			temp = q.poll();
			List<Integer> list = map.get(temp.getData());
			if(list!=null){
				temp.addChildren(list);
				Iterator<MyTreeNode> itr = temp.getChildren().iterator();
				while(itr.hasNext()){
					q.add(itr.next());
				}
			}
			
		}
		System.out.println(calculate(root)/2);
		//System.out.println(root.getChildren().get(2).getChildren().get(0));
		//System.out.println(root.toString());
		
	
	}
	
	static int calculate(MyTreeNode root){
		int mod = 1000000007;
		long ans = 1;
		List<MyTreeNode> children = root.getChildren();
		if(children==null)
			return 1;
		Iterator<MyTreeNode> itr = children.iterator();
		while(itr.hasNext()){
			int t = calculate(itr.next())%mod;
			//System.out.println("Root "+root+"---> "+t);
			ans = (ans * t)%mod;
		}
		if(ans==1)
			return 2;
		return (int) (ans%mod);
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

class MyTreeNode{
    private Integer data = null;
    private List<MyTreeNode> children = new ArrayList<MyTreeNode>();
    private MyTreeNode parent = null;

    public MyTreeNode(int data) {
        this.data = data;
    }

    public void addChild(MyTreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(int data) {
        MyTreeNode newChild = new MyTreeNode(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(List<Integer> children) {
    	
        for(Integer t : children) {
        	MyTreeNode t1 = new MyTreeNode(t);
            t1.setParent(this);
            this.children.add(t1);
        }
    }

    public List<MyTreeNode> getChildren() {
        return children;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private void setParent(MyTreeNode parent) {
        this.parent = parent;
    }

    public MyTreeNode getParent() {
        return parent;
    }
    
    public String toString(){
    	String str = "";
    	
    	Queue<MyTreeNode> q = new LinkedBlockingQueue<MyTreeNode>();
    	q.add(this);
    	
    	while(!q.isEmpty()){
    		MyTreeNode t = q.poll();
    		str += t.getData()+"\n";
    		Iterator<MyTreeNode> itr = t.getChildren().iterator();
    		while(itr.hasNext()){
    			q.add(itr.next());
    		}	
    	}
    	
    	return str;
    }
}