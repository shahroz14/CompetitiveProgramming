package spoj;

import java.math.BigInteger;


public class Karatsuba {
	public static void main(String[] args) {
	    //wrong answer
	    System.out.println(karatsuba("100","087"));
	    System.out.println();
	}

	private static String karatsuba(String X, String Y) {
		
		int xLen = X.length();
		int yLen = Y.length();
		
	    if (xLen<2 || yLen<2){
	    	//System.out.println("mul "+X.multiply(Y))
	    	return new BigInteger(X).multiply(new BigInteger(Y)).toString();
	        
	    }

	    String X1 = X.substring(0, (int)Math.ceil(xLen/2));
	    String Xr = X.substring((int)Math.ceil(xLen/2), xLen);
	    String Y1 = Y.substring(0, (int)Math.ceil(yLen/2));
	    String Yr = Y.substring((int)Math.ceil(yLen/2), yLen);
	    System.out.print("\n\nX1="+X1+" Xr="+Xr+"\n Y1="+Y1+" Yr"+Yr+"\nAns =");
	    

	    String X1Y1 = karatsuba(X1,Y1);
	    BigInteger x1y1 = new BigInteger(X1Y1);
	    String XrYr = karatsuba(Xr,Yr);
	    BigInteger xryr = new BigInteger(XrYr);
	    
	    String X1Yr_Y1Xr = karatsuba(new BigInteger(X1).add(new BigInteger(Xr)).toString(),new BigInteger(Y1).add(new BigInteger(Yr)).toString());
	    BigInteger x1yr_y1xr = new BigInteger(X1Yr_Y1Xr); 
	    x1yr_y1xr = x1yr_y1xr.subtract(x1y1).subtract(xryr);
	    
	    BigInteger ten = new BigInteger("10");
	    int max = Math.max(xLen, yLen);
	    BigInteger ans = x1y1.multiply(ten.pow(max)).add(x1yr_y1xr.multiply(ten.pow(max/2))).add(xryr);
	    if(ans.equals(new BigInteger("0"))){
	    	String ans0 = "";
	    	for(int i=0; i<=max/2; i++){
	    		//System.out.println("sas");
	    		ans0+="0";
	    	}
	    	return ans0;
	    }
	    return ans.toString();

	}
}
