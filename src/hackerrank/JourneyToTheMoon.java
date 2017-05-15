package hackerrank;

public class JourneyToTheMoon {
	public static void main(String[] args) {
		
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
