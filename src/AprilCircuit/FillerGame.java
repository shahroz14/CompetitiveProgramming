package AprilCircuit;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class FillerGame {
	
	
	
	public static void main(String[] args) throws IOException {
		
		IS io = new IS();
		io.is = System.in;
		
		//BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		//String[] line1 = br.readLine().trim().split(" ");
		int m = io.ni();
		int n = io.ni();
		int q = io.ni();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++){
			int[][] mat = new int[m][n];
			for(int j=0; j<m; j++){
				String input = io.ns();
				for(int k=0; k<n; k++){
					mat[j][k] = Integer.parseInt(input.charAt(k)+"");
				}
			}
			sb.append(game(init(mat),0)+"\n");
		}
		
		System.out.println(sb);
		
	}
	
	
	static int[][] init(int[][] mat) {
		
		int[][] initMat = new int[mat.length][];
		
		for(int i=0; i<mat.length; i++){
			initMat[i] = new int[mat[i].length];
			for(int j=0; j<mat[i].length; j++){
				if(mat[i][j]==1)
					initMat[i][j] = 0;
					
				else
					initMat[i][j] = countElem(mat, i, j);
			}
		}
		
		return initMat;
	}
	
	
	static int countElem(int[][] mat, int i, int j){
		
		int cnt = 0;
		
		if(isValid(mat.length, mat[0].length, i-1, j) && mat[i-1][j]==0)
			cnt++;
		
		if(isValid(mat.length, mat[0].length, i+1, j) && mat[i+1][j]==0)
			cnt++;
		
		if(isValid(mat.length, mat[0].length, i, j-1) && mat[i][j-1]==0)
			cnt++;
		
		if(isValid(mat.length, mat[0].length, i, j+1) && mat[i][j+1]==0)
			cnt++;
		
		return cnt;
		
	}
	
	
	static int game(int[][] mat, int pId){
		
		int m = mat.length;
		
		for(int i=0; i<m; i++){
			for(int j=0; j<mat[i].length; j++){
				if(mat[i][j]!=0){
					
					int[][] nS = newState(mat, i, j);
					int rslt = game(nS, switchPlayer(pId));
				
					if(rslt == pId)
						return pId;
				}
			}
		}
		
		return switchPlayer(pId);
		
	}
	
	static void printMatrix(int[][] mat) {
		StringBuilder sb = new StringBuilder();
		int n = mat.length;
		for(int i=0;i<n; i++){
			sb.append(Arrays.toString(mat[i])+"\n");
		}
		System.out.println("\n\n"+sb);
	}
	
	static int[][] newState(int[][] mat, int i, int j){
		
		int m = mat.length;
		int n = mat[0].length;
		int[][] newMat = clone(mat);
		
		if(isValid(m, n, i+1, j) && newMat[i+1][j] != 0 )
			newMat[i+1][j]--;
		
		if(isValid(m, n, i-1, j) && newMat[i-1][j] != 0)
			newMat[i-1][j]--;
		
		if(isValid(m, n, i, j-1) && newMat[i][j-1] != 0)
			newMat[i][j-1]--;
		
		if(isValid(m, n, i, j+1) && newMat[i][j+1] != 0)
			newMat[i][j+1]--;
		
		newMat[i][j] = 0;
		
		return newMat;
		
	}
	
	static int[][] clone(int[][] mat){
		
		int n = mat.length;
	
		int[][] newMat = new int[mat.length][];
		
		for(int i=0; i<n; i++){
			newMat[i] = new int[mat[i].length];
			for( int j=0;j<mat[i].length; j++)
				newMat[i][j] = mat[i][j];
		}
		
		return newMat;
	}
	
	
	static boolean isValid(int m, int n, int i,int j){
		if(i>=0 && i<m && j>=0 && j<n)
			return true;
		return false;
	}
	
	
	static int switchPlayer(int pId){
		if(pId==0)
			return 1;
		return 0;
	}
	
	
	static boolean isWon(int[][] mat) {
		
		for(int i=0; i<mat.length; i++){
			int n = mat[i].length;
			for(int j=0; j<n; j++){
				if(mat[i][j]!=0)
					return false;
			}
		}
		return true;
	}
	
}


class IS {
	
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	 int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	double nd() { return Double.parseDouble(ns()); }
	char nc() { return (char)skip(); }
	
	String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	int ni()
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
	
	long nl()
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
