package weekOfCode29;

import java.awt.geom.Rectangle2D;
import java.util.Scanner;

public class ACricleAndASquare {
	
	static boolean[][] canvas;
	static int cw = 10;
	static int ch = 10;
	
	public static void main(String[] args) {
		Coordinate[] c = getOtherCoordinates(new Coordinate(4, 1), new Coordinate(3, 3));
		System.out.println(c[1]);
		Scanner in = new Scanner(System.in);
		cw = in.nextInt();
		ch = in.nextInt();
		canvas = new boolean[500][500];
		Line l = new Line(new Coordinate(6, 2), new Coordinate(2,4));
		l.drawLineOnCanvas();
		Line l1 = new Line(new Coordinate(2, 4), new Coordinate(4, 8));
		l1.drawLineOnCanvas();
		Line l2 = new Line(new Coordinate(6, 2), new Coordinate(8, 6));
		l2.drawLineOnCanvas();
		
		//double ry = in.nextDouble();
		//double rx = in.nextDouble();
		//double r = in.nextDouble();
		/*double y1 = in.nextDouble();
		double x1 = in.nextDouble();
		double y3 = in.nextDouble();
		double x3 = in.nextDouble();
		Coordinate c1 = new Coordinate(x1, y1);
		Coordinate c3 = new Coordinate(x3, y3);
		if(c1.getY() < c3.getY())
			makeRhombus(c1, c3);
		else
			makeRhombus(c3, c1);
		//makeCircle(new Coordinate(rx, ry), r);*/
		printCanvas();
		
	}
	
	public static void makeNewRhombus(Coordinate c1, Coordinate c3){
		
		Coordinate[] c = getOtherCoordinates(c1, c3);
	}
	
	public static boolean isInCanvas(int x, int y){
		if(x >= 0 && x < 500 && y >=0 && y < 500)
			return true;
		return false;
	}
	
	public static void setPixel(int x, int y){
		if(isInCanvas(x, y))
			canvas[x][y] = true;
	}
	
	
	private static void makeCircle(Coordinate cen, double rad){
		for(int i=0; i<ch; i++){
			for(int j=0; j<cw; j++){
				if(cen.isInRange(new Coordinate(i, j), rad))
					canvas[i][j] = true;
			}
		}
	}
	
	private static void makeRhombus(Coordinate c1, Coordinate c3){
		
		Coordinate[] c = getOtherCoordinates(c1, c3);
		Coordinate c2 = c[0];
		Coordinate c4 = c[1];
		//System.out.println(c1+"\n"+c2+"\n"+c3+"\n"+c4);
		Line l1 = new Line(c1, c2);
		//System.out.println(l1 +": c1 "+l1.c1+"   c2"+l1.c2);
		l1.drawLineOnCanvas();
		Line l2 = new Line(c1, c4);
		//System.out.println(l2 +": c1 "+l2.c1+"   c2"+l2.c2);
		l2.drawLineOnCanvas();
		Line l3 = new Line(c2, c3);
		//System.out.println(l3 +": c1 "+l3.c1+"   c2"+l3.c2);
		l3.drawLineOnCanvas();
		Line l4 = new Line(c4, c3);
		//System.out.println(l4 +": c1 "+l4.c1+"   c2"+l4.c2);
		l4.drawLineOnCanvas();
		//scan
		for(int i=0; i<500; i++){
			int start = -1;
			for(int j=0; j<500; j++){
				if(canvas[i][j]){
					start = j;
					break;
				}
			}
			int last = 500;
			for(int j=499; j>=0; j--){
				if(canvas[i][j]){
					last = j;
					break;
				}
			}
			
			for(int j=start; j>0 && j<=last && last<500; j++){
				canvas[i][j] = true;
				
			}
		}
	}
	
	private static Coordinate[] getOtherCoordinates(Coordinate c1, Coordinate c3){
		Coordinate[] c = new Coordinate[2];
		double side = c1.getEuclideanDistance(c3)/2;
		for(int i=0; i<ch; i++){
			for(int j=0; j<cw; j++){
				Coordinate temp = new Coordinate(i,j);
				System.out.println(side+" "+c1.getEuclideanDistance(temp));
				if(c1.getEuclideanDistance(temp)==side && c3.getEuclideanDistance(temp)==side){
					if(c[0]==null)
						c[0] = temp;
					else
						c[1] = temp;
				}
			}
		}
		
		return c;
	}
	
	public static void printCanvas(){
		
		for(int i=0; i<ch; i++){
			for(int j=0; j<cw; j++){
				if(canvas[i][j])
					System.out.print("#");
				else
					System.out.print(".");
			}
			System.out.println("");
		}
	}
	
}


class Coordinate{
	
	private double x;
	private double y;
	private String or = "";
	
	public Coordinate() {
		
	}
	
	public Coordinate(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+", "+y+") ";
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public double getEuclideanDistance(Coordinate c){
		double xd = Math.pow(getX()-c.getX(), 2d);
		double yd = Math.pow(getY()-c.getY(), 2d);
		return (xd+yd);
	}
	
	public boolean isInRange(Coordinate c, double dist){
		if(getEuclideanDistance(c) <= dist)
			return true;
		return false;
	}
	
	
	
}

class Line{
	
	Coordinate c1;
	Coordinate c2;
	double slope;
	boolean type = false; // false -> type1 ; true -> type2
	
	public Line(Coordinate c1, Coordinate c2) {
		if(c1.getY() > c2.getY()){
			Coordinate t = c1;
			c1 = c2;
			c2 = t;
		}
		this.c1 = c1;
		this.c2 = c2;
		setSlope();
		setType();
	}
	
	private void setType(){
		if(c1.getX()>c2.getX())
			type = false;
		else
			type = true;
	}
	
	private void setSlope(){
		slope = Math.abs(c1.getX()-c2.getX())/Math.abs(c1.getY()-c2.getY());
	}
	
	
	@Override
	public String toString() {
		return "y = "+slope+"x + k";
	}
	
	
	public void drawLineOnCanvas(){
		if(!type){
			if(slope > 1){
				double y0 = c1.getY();
				int k = 0;
				for(int i = (int)c1.getX(); i >= c2.getX(); i--){
					ACricleAndASquare.setPixel(i, (int)Math.round(y0+((1/slope)*k++)));
				}
			}
			else{
				double x0 = c1.getX();
				int k = 0;
				for(int j = (int)c1.getY(); j <= c2.getY(); j++){
					ACricleAndASquare.setPixel( (int)Math.round(x0-(slope*k++)), j );
				}
			}
		}
		
		else{
			//type 2
			if(slope > 1){
				double y0 = c1.getY();
				int k = 0;
				for(int i = (int)c1.getX(); i <= c2.getX(); i++){
					ACricleAndASquare.setPixel(i, (int)Math.round(y0+((1/slope)*k++)));
				}
			}
			else{
				double x0 = c1.getX();
				int k = 0;
				for(int j = (int)c1.getY(); j <= c2.getY(); j++){
					ACricleAndASquare.setPixel( (int)Math.round(x0+(slope*k++)), j );
				}
			}
		}
	}
	
}
