package weekOfCode29;

import java.util.Scanner;

public class DayOfTheProgrammer {
	
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		
		if(year<=1917)
			System.out.println(findDate(256, year, true));
		else if(year==1918)
			System.out.println(findDateIn1918(256, year));
		else
			System.out.println(findDate(256, year, false));
	}
	
	
	public static boolean isLeapYearInGeorgian(int year){
		if(year%400==0||year%4==0 && year%100!=0)
			return true;
		return false;
	}
	
	
	public static boolean isLeapYearInJulian(int year){
		if(year%4==0)
			return true;
		return false;
	}
	
	public static String findDate(int days, int year, boolean isJulian){
	
		int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(isJulian){
			if(isLeapYearInJulian(year))
				months[1] = 29;
		}
		
		else{
			if(isLeapYearInGeorgian(year))
				months[1] = 29;
		}
		
		int tempDays=0, i=0;
		while(days>tempDays){
			tempDays += months[i++];
		}
		tempDays -= months[i-1]; 
		int rem = days-tempDays;
		return String.format("%02d", rem)+"."+String.format("%02d", i)+"."+year;	
	}
	
	
	public static String findDateIn1918(int days, int year){
		int[] months = {31,15,31,30,31,30,31,31,30,31,30,31};
		int tempDays=0, i=0;
		while(days>tempDays){
			tempDays += months[i++];
		}
		tempDays -= months[i-1];
		int rem = days-tempDays;
		return String.format("%02d", rem)+"."+String.format("%02d", i)+"."+year;	
	}
	
	
}
