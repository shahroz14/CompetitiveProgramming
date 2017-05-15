package WeekOfCode28;



import java.util.HashMap;
import java.util.Iterator;

import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;


public class ChoosingWhiteBalls {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String row = in.next();
		HashMap<WhiteBalls, Double> rowMap = new HashMap<WhiteBalls, Double>();
		WhiteBalls wb = new WhiteBalls(row, n);
		double[] score = new double[k];
		
		rowMap.put(wb, 1d);
		//System.out.println(rowMap);
		for(int j=0; j<k; j++){
			//System.out.println("\n\n\n"+rowMap);
			Set<WhiteBalls> wSet = rowMap.keySet();
			
			Iterator<WhiteBalls> itr = wSet.iterator();
			Double prob = 0d;
			while(itr.hasNext()){
				WhiteBalls w = itr.next();
				prob += w.getProb()*rowMap.get(w);
			}
			score[j] = prob;
			
			HashMap<WhiteBalls, Double> newMap = getNewRowMap(rowMap);
			rowMap.clear();
			rowMap.putAll(newMap);
			
		}
		//System.out.println(Arrays.toString(score));
		double ans = 0.0d;
		for(int j=0; j<k; j++){
			ans += score[j];
		}
		System.out.println(ans);
	}
	
	public static HashMap<WhiteBalls, Double> getNewRowMap(HashMap<WhiteBalls, Double> rowMap){
		
		HashMap<WhiteBalls, Double> newMap = new HashMap<WhiteBalls, Double>();
		Iterator<Entry<WhiteBalls, Double>> itr = rowMap.entrySet().iterator();
		HashMap<String, Double> temp = new HashMap<String, Double>();
		int n = rowMap.size();
		while(itr.hasNext()){
			Entry<WhiteBalls, Double> e = itr.next();
			HashMap<String, Double> wbMap = e.getKey().seqMap;
			Iterator<Entry<String, Double>> itr1 = wbMap.entrySet().iterator();
			while(itr1.hasNext()){
				Entry<String, Double> e1 = itr1.next();
				if(temp.containsKey(e1.getKey())){
					temp.put(e1.getKey(), temp.get(e1.getKey())+(e1.getValue()/n));
				}
				else
					temp.put(e1.getKey(), e1.getValue()/n);
			}
		}
		//System.out.println(temp);
		Iterator<Entry<String, Double>> itr1 = temp.entrySet().iterator();
		while(itr1.hasNext()){
			Entry<String, Double> e = itr1.next();
			newMap.put(new WhiteBalls(e.getKey(), e.getKey().length()), e.getValue());
		}
		//System.out.println(newMap);
		return newMap;
	}

}

class WhiteBalls{
	
	HashMap<String, Double> seqMap;
	double prob;
	String seq;
	int len;
	int whiteCount;
	
	public WhiteBalls(String seq, int n) {
		len = n;
		seqMap = new HashMap<String, Double>();
		this.seq = seq;
		generateSubstring();
		setProb((whiteCount+0.0d)/len);
	}
	
	public void setProb(double prob){
		this.prob = prob;
	}
	
	public void generateSubstring(){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<len; i++){
			String supStr = "";
			if(seq.charAt(i)=='W'&&seq.charAt(len-i-1)=='W'){
				String sub1 = seq.substring(0, i)+seq.substring(i+1, len);
				String sub2 = seq.substring(0, len-i-1)+ seq.substring(len-i, len);
				supStr = getSuperString(sub1, sub2);
				whiteCount++;
			}
			else if((seq.charAt(i)=='B'&&seq.charAt(len-i-1)=='B')){
				String sub1 = seq.substring(0, i)+seq.substring(i+1, len);
				String sub2 = seq.substring(0, len-i-1)+ seq.substring(len-i, len);
				supStr = getSuperString(sub1, sub2);
			}
			else if(seq.charAt(i)=='W'&&seq.charAt(len-i-1)=='B'){
				supStr = seq.substring(0, i)+seq.substring(i+1, len);
				whiteCount++;
			}
				
			else{
				supStr = seq.substring(0, len-i-1)+ seq.substring(len-i, len);
				whiteCount++;
			}
				
			
			if(map.containsKey(supStr))
				map.put(supStr, map.get(supStr)+1);
			
			else
				map.put(supStr, 1);
			
		}
		Iterator<Entry<String, Integer>> itr = map.entrySet().iterator();
		while(itr.hasNext()){
			Entry<String, Integer> entry = itr.next();
			seqMap.put(entry.getKey(), ((entry.getValue()+0.0d)/len));
		}
	}
	
	public String getSuperString(String a, String b){
		int counta=0;
		int countb=0;
		int len = a.length();
		int midIndex = -1;
		int n;
		if(len%2!=0){
			midIndex = len/2;
			n = len/2;
		}
		else
			n = len/2-1;
		
		for(int i=0; i<=n; i++){
			if(a.charAt(i)=='W'){
				if(i==midIndex)
					counta++;
				else
					counta += 2;
			}
			if(b.charAt(i)=='W'){
				if(i==midIndex)
					countb++;
				else
					countb += 2;
			}
		}
		if(counta>countb)
			return a;
		else if(countb>counta)
			return b;
		return a;
	}
	
	public double getProb(){
		return prob;
	}
	
	public String toString(){
		return "\n"+seq+":  "+seqMap.toString()+"\n Answer -> "+prob+"   "+seq;
	}
}