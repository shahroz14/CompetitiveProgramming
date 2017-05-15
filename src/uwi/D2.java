package uwi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class D2 {
	
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	int[][] poles;
	long[] wdcum, wcum;
	
	
	
	
	
	void solve()
	{
		int n = ni(), K = ni();
		poles = new int[n][];
		for(int i = 0;i < n;i++){
			poles[i] = new int[]{ni(), ni()};
		}
		Arrays.sort(poles, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		
		wdcum = new long[n+1];
		wcum = new long[n+1];
		for(int i = 0;i < n;i++){
			wdcum[i+1] = wdcum[i] + (long)poles[i][1] * poles[i][0];
			wcum[i+1] = wcum[i] + poles[i][1];
		}
		
		long[] dp = dp(n, K);
		
		out.println(dp[n]);
	}
	
	
	
	
	
	
	
	long f(int l, int r, long[] dp)
	{
		if(l == r)return dp[l];
		return dp[l] + (wdcum[r] - wdcum[l]) - poles[l][0] * (wcum[r]-wcum[l]);
	}
	
	
	
	
	
	
	
	public long[] dp(int n, int rep)
	{
		rep = Math.min(rep, n);
		long[] dp = new long[n+1];
		Arrays.fill(dp, Long.MAX_VALUE / 10);
		dp[0] = 0;
		
		int[] args = new int[n+1];
		for(int k = 0;k < rep;k++){
			int sup = n;
			for(int i = n;i >= k+1;i--){
				long min = Long.MAX_VALUE;
				int arg = -1;
				for(int j = args[i];j <= sup;j++){
//					long v = (j > i-1 ? 0 : f[j][i-1]) + dp[j];
					long v = f(j, i, dp);
					
					if(v < min){
						min = v;
						arg = j;
					}
					
						
				}
				dp[i] = min;
				args[i] = arg;
				sup = arg;
			}
			dp[k] = Long.MAX_VALUE / 10;
		}
		return dp;
	}
	
	
	
	
	
	
	
	
	void run() throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty())
			tr(System.currentTimeMillis()-s+"ms");
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception { new D2().run(); }
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}