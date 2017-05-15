package WeekOfCode28;



import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;


public class ValueOfFriendship {
	public static void main(String[] args) {
		
		//System.out.println(getValue(4));
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int i=0; i<q; i++){
			
			int n = in.nextInt();
			int m = in.nextInt();
			
			int[][] fc = new int[m][2];
			
			int[] arr = new int[n+1];
			int[] root = new int[n+1];
			
			for(int j=0; j<=n; j++)
				arr[j] = j;
			
			for(int j=0; j<m; j++){
				fc[j][0] = in.nextInt();
				fc[j][1] = in.nextInt();
				union(arr, Math.min(fc[j][0], fc[j][1]), Math.max(fc[j][0], fc[j][1]));
			}
			
			for(int j=1; j<=n; j++){
				root[j] = root(arr, j);
			}
			//System.out.println(Arrays.toString(arr));
			//System.out.println(Arrays.toString(root));
			
			HashMap<Integer, Friendship> friendCircleMap = new HashMap<Integer, Friendship>();
			
			for(int j=1; j<=n; j++){
				
				if(friendCircleMap.containsKey(root[j]))
					friendCircleMap.get(root[j]).addToFriendCircle(j);
				
				else{
					friendCircleMap.put(root[j], new Friendship(root[j]));
					friendCircleMap.get(root[j]).addToFriendCircle(j);
				}	
			}
			
			/*SortedSet<Map.Entry<Integer, Friendship>> sortedset = new TreeSet<Map.Entry<Integer, Friendship>>(
		            new Comparator<Map.Entry<Integer, Friendship>>() {
		                @Override
		                public int compare(Map.Entry<Integer, Friendship> e1,
		                        Map.Entry<Integer, Friendship> e2) {
		                	if(e1.getValue().getSize()>e2.getValue().getSize())
		                		return -1;
		                	if(e1.getValue().getSize()<e2.getValue().getSize())
		                		return 1;
		                    return 0;
		                }
		            });*/

		  
			
			for(int j=0; j<m; j++){
				friendCircleMap.get(root[fc[j][0]]).addCall();
			}
			//System.out.println(friendCircleMap);
			//sortedset.addAll(friendCircleMap.entrySet());
			//System.out.println(sortedset);
			BigInteger ans = new BigInteger("0");
			
			
			Iterator<Entry<Integer, Friendship>> itr = friendCircleMap.entrySet().iterator();
			int[][] rootMap = new int[friendCircleMap.size()][2];
			BigInteger prev = new BigInteger("0");
			int k = 0;
			while(itr.hasNext()){
				Friendship f = itr.next().getValue();
				rootMap[k][0] = f.getSize();
				rootMap[k++][1] = f.root;
			}
			
			mergeSort(rootMap, 0, rootMap.length-1);
			int left = 0;
			//System.out.println(rootMap[1][0]);
			for(int j=rootMap.length-1; j>=0; j--){
				
				Friendship f = friendCircleMap.get(rootMap[j][1]);
				//System.out.println("aaa "+f.getValue(prev));
				ans = ans.add(f.getValue(prev));
				prev = f.getTailValue(prev);
				left += f.call-f.getSize();
				
				//System.out.println("answer = "+ans+"  previous = "+prev);
			}
			ans = ans.add(prev.multiply(new BigInteger(String.valueOf(left))));
			System.out.println(ans);
		}
	}
	
	public static void mergeSort(int[][] array, int p, int r){
		int q;
		if(p<r){
			q = (p+r)/2;
			mergeSort(array, p, q);
			mergeSort(array, q+1, r);
			merge(array, p, q, r);
		}
	}
	
	public static void merge(int[][] array, int low, int mid, int high){
		int[][] left = new int[mid-low+2][2];
		int[][] right = new int[high-mid+1][2];
		int a=0, b=0;
		
		
		for(int i=0; i<left.length-1; i++){
			left[i][0] = array[low+i][0];
			left[i][1] = array[low+i][1];
		}
		left[left.length-1][0] = Integer.MAX_VALUE;

		
		for(int i=0; i<right.length-1; i++){
			right[i][0] = array[mid+1+i][0];
			right[i][1] = array[mid+1+i][1];
		}
		right[right.length-1][0] = Integer.MAX_VALUE;
		
		
		for(int i=low; i<=high; i++){
			if(left[a][0]<=right[b][0]){
				array[i][0] = left[a][0];
				array[i][1] = left[a++][1];
			}
			else{
				array[i][0] = right[b][0];
				array[i][1] = right[b++][1];
			}
		}
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
}

class Friendship{
	
	HashSet<Integer> friends;
	int call;
	int root;
	
	public String toString(){
		return friends.toString()+"   ----->Size = "+getSize()+"\n";
	}
	
	public Friendship(int root) {
		friends = new HashSet<Integer>();
		this.root = root;
		call = 1;
	}
	
	public BigInteger getTailValue(BigInteger prev){
		long n = getSize();
		return prev.add(new BigInteger(String.valueOf(n*(n-1))));
	}
	
	public BigInteger getValue(BigInteger prev){
		
		long n = getSize();
		BigInteger value = new BigInteger("0");
		while(n>1){
			//BigInteger b = new BigInteger(String.valueOf(n*(n-1)));
			//System.out.println(new BigInteger(prev.toString()).add(b));
			value = value.add(prev.add(new BigInteger(String.valueOf(n*(n-1)))));
			n--;
		}
		return value;
	}
	
	
	public boolean contains(int friendID){
		return friends.contains(friendID);	
	}
	
	public void addToFriendCircle(int friendID){
		friends.add(friendID);
	}
	
	public int getSize(){
		return friends.size();
	}
	
	public void addCall(){
		call++;
	}
	
}
