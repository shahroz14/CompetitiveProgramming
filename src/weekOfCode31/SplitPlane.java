package weekOfCode31;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitPlane {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		
		for(int k=0; k<q; k++){
			
			int n = in.nextInt();
			for(int j=0; j<n; j++){
				
				int x1 = in.nextInt();
				int y1 = in.nextInt();
				int x2 = in.nextInt();
				int y2 = in.nextInt();
				
				List<HorizontalLine> hLines = new ArrayList<HorizontalLine>();
				List<VerticalLine> vLines = new ArrayList<VerticalLine>();
				
				if(x1==x2){
					
					vLines.add(new VerticalLine(x1, y1, y2));
				}
				else
					hLines.add(new HorizontalLine(x1, x2, y1));
				
				
			}
			
			
			
		}
		
		
		
	}
	
}


class HorizontalLine {
	int x1;
	int x2;
	int y;
	
	
	
	HorizontalLine(int x1, int x2, int y){
		this.x1 = x1;
		this.x2 = x2;
		this.y = y;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		HorizontalLine line = (HorizontalLine) obj;
		int lsx = line.getSmallerX();
		int lgx = line.getLargerX();
		int llsx = this.getSmallerX();
		int llgx = this.getLargerX();
		if(llgx >= lsx || lgx >= llsx)
			return true;
		return false;
	}
	
	
	int getSmallerX(){
		return Math.min(x1, x2);
	}
	
	int getLargerX(){
		return Math.max(x1, x2);
	}
}


class VerticalLine {
	
	int x;
	int y1;
	int y2;
	
	
	
	VerticalLine(int x, int y1, int y2){
		this.x = x;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	@Override
	public boolean equals(Object obj) {
		VerticalLine line = (VerticalLine) obj;
		return this.x== line.x;
	}
	
}