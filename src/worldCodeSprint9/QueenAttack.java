package worldCodeSprint9;


import java.util.Scanner;


public class QueenAttack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Point q = new Point(in.nextInt(), in.nextInt());
		
		Point lOb = new Point(q.getX(), 0);
		Point rOb = new Point(q.getX(), n+1);
		Point uOb = new Point(n+1, q.getY());
		Point dOb = new Point(0, q.getY());
		Point uLOb = setUpLeftObs(n, q);
		Point uROb = setUpRightObs(n, q);
		Point dLOb = setDownLeftObs(n, q);
		Point dROb = setDownRightObs(n, q);
		
		
		for(int i=0; i<k; i++){
			Point temp = new Point(in.nextInt(), in.nextInt());
			
			if(q.isOnLeft(temp) && q.getManhattanDist(lOb)>q.getManhattanDist(temp)){
				lOb = temp;
			}
			
			if(q.isOnRight(temp) && q.getManhattanDist(rOb)>q.getManhattanDist(temp)){
				rOb = temp;
			}
			
			if(q.isOnUp(temp) && q.getManhattanDist(uOb)>q.getManhattanDist(temp)){
				uOb = temp;
			}
			
			if(q.isOnDown(temp) && q.getManhattanDist(dOb)>q.getManhattanDist(temp)){
				dOb = temp;
			}
			
			if(q.isOnUpLeft(temp) && q.getManhattanDist(uLOb)>q.getManhattanDist(temp)){
				uLOb = temp;
			}
			
			if(q.isOnUpRight(temp) && q.getManhattanDist(uROb)>q.getManhattanDist(temp)){
				uROb = temp;
			}
			
			if(q.isOnDownLeft(temp) && q.getManhattanDist(dLOb)>q.getManhattanDist(temp)){
				dLOb = temp;
			}
			
			if(q.isOnDownRight(temp) && q.getManhattanDist(dROb)>q.getManhattanDist(temp)){
				dROb = temp;
			}
			
		}
		
		System.out.println(calculate(q, lOb, rOb, uOb, dOb, uLOb, uROb, dLOb, dROb));
		
	}
	
	static Point setUpLeftObs(int n, Point q){
		int m = Math.min(n+1-q.getX(), q.getY());
		return new Point(q.getX()+m, q.getY()-m);
	}
	
	static Point setUpRightObs(int n, Point q){
		int m = Math.min(n+1-q.getX(), n+1-q.getY());
		return new Point(q.getX()+m, q.getY()+m);
	}
	
	static Point setDownLeftObs(int n, Point q){
		int m = Math.min(q.getX(), q.getY());
		return new Point(q.getX()-m, q.getY()-m);
	}
	
	static Point setDownRightObs(int n, Point q){
		int m = Math.min(q.getX(), n+1-q.getY());
		return new Point(q.getX()-m, q.getY()+m);
	}
	
	
	static long calculate(Point q, Point l, Point r, Point u, Point d, Point uL, Point uR, Point dL, Point dR){
		long moves = 0;
		
		moves += getDistanceFromUp(q, u);
		moves += getDistanceFromRight(q, r);
		moves += getDistanceFromLeft(q, l);
		moves += getDistanceFromDown(q, d);
		moves += getDistanceFromLeft(q, uL);
		moves += getDistanceFromLeft(q, uR);
		moves += getDistanceFromLeft(q, dL);
		moves += getDistanceFromLeft(q, dR);
		
		return moves;
	}
	
	static long getDistanceFromUp(Point q, Point u){
		return Math.abs(q.getX()-u.getX())-1;
	}
	
	static long getDistanceFromDown(Point q, Point d){
		return Math.abs(q.getX()-d.getX())-1;
	}
	
	static long getDistanceFromLeft(Point q, Point l){
		return Math.abs(q.getY()-l.getY())-1;
	}
	
	static long getDistanceFromRight(Point q, Point r){
		return Math.abs(q.getY()-r.getY())-1;
	}
	
	
	
}

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	int getX(){
		return x;
	}
	
	int getY(){
		return y;
	}
	
	int getManhattanDist(Point r){
		return Math.abs(r.getX()-getX())+Math.abs(r.getY()-getY());
	}
	
	boolean isOnRight(Point r){
		if(getX()==r.getX() && r.getY()>getY())
			return true;
		return false;
	}
	
	boolean isOnLeft(Point r){
		if(getX()==r.getX() && getY()>r.getY())
			return true;
		return false;
	}
	
	boolean isOnUp(Point r){
		if(getY()==r.getY() && getX()<r.getX())
			return true;
		return false;
	}
	
	boolean isOnDown(Point r){
		if(getY()==r.getY() && getX()>r.getX())
			return true;
		return false;
	}
	
	boolean isOnUpLeft(Point r){
		int m = Math.abs(r.getX()-getX());
		if(Math.abs(r.getY()-getY())==m && getX()<r.getX() && getY()>r.getY())
			return true;
		return false;
	}
	
	boolean isOnUpRight(Point r){
		int m = Math.abs(r.getX()-getX());
		if(Math.abs(r.getY()-getY())==m && getX()<r.getX() && getY()<r.getY())
			return true;
		return false;
	}
	
	boolean isOnDownLeft(Point r){
		int m = Math.abs(r.getX()-getX());
		if(Math.abs(r.getY()-getY())==m && getX()>r.getX() && getY()>r.getY())
			return true;
		return false;
	}
	
	boolean isOnDownRight(Point r){
		int m = Math.abs(r.getX()-getX());
		if(Math.abs(r.getY()-getY())==m && getX()>r.getX() && getY()<r.getY())
			return true;
		
		return false;
	}
}