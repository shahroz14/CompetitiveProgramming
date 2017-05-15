package universityCodesprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GameOfTwoStack {
	
	static HashMap<String, Integer> map;
	static int[] suma ;
	static int[] sumb ;
	static int x;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(in.readLine());
		double start = System.nanoTime();
		for(int k = 0; k < g; k++){
			String[] nmx = in.readLine().split(" ");
			int n = Integer.parseInt(nmx[0]);
			int m = Integer.parseInt(nmx[1]);
			x = Integer.parseInt(nmx[2]);
			
			map = new HashMap<String, Integer>();
			String[] sa = in.readLine().split(" ");
			String[] sb = in.readLine().split(" ");
			int[] a = new int[n];
			int[] b = new int[m];
			suma = new int[n];
			sumb = new int[m];
			for(int i=0; i<n; i++){
				a[i] = Integer.parseInt(sa[i]);
			}
			suma[0] = a[0];
			
			for(int i=1; i<n; i++){
				suma[i] = suma[i-1]+a[i];
			}
			
			
			for(int i=0; i<m; i++){
				b[i] = Integer.parseInt(sb[i]);
			}
			sumb[0] = b[0];
			
			for(int i=1; i<m; i++){
				sumb[i] = sumb[i-1]+b[i];
			}
			
			
			int ans = stackGame(a, b, 0, 0, x);
			
			if(ans==0)
				System.out.println("0");
			else
				System.out.println(ans-1);
			//System.out.println((System.nanoTime()-start)/1000000+" ms");
			//System.out.println(-1);
			//System.out.println(map);
		}
	}
	
	static int rangeSum(int[] sum, int i, int j){
		if(i==0)
			return sum[j];
		return sum[j]-sum[i-1];
	}
	
	
	static int stackGame(int[] a, int[] b, int ia, int ib, int left){
	
		if(left<0 || ia > a.length-1 && ib > b.length-1)
			return 0;
		
		if(rangeSum(suma, ia, a.length-1)+rangeSum(sumb, ib, b.length-1)<= left){
			//System.out.println(a.length + b.length - ia - ib+1+" vds");
			return a.length + b.length - ia - ib+1;
		}
		
		
		int ans = 0;
		
		if(map.containsKey(ia+","+ib))
			return map.get(ia+","+ib);
		
		int ans1 = 0;
		int ans2 = 0;
		
		if(ia<a.length)
			ans1 = stackGame(a, b, ia+1, ib, left-a[ia]);
		if(ib<b.length)
			ans2 = stackGame(a, b, ia, ib+1, left-b[ib]);
		
		ans = 1 + Math.max(ans1, ans2);
		
		map.put(ia+","+ib, ans);
		
		return ans;
		
	}
}
