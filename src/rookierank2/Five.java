package rookierank2;

import java.util.HashMap;
import java.util.Scanner;

public class Five {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie trie = new Trie(new Node('*'));
		for(int i=0; i<n; i++){
			String s = in.next();
			trie.addWord(s);
		}
	}
}

class Node{
	
	char ch;
	boolean isEnd;
	HashMap<Character, Node> child;
	
	Node(char c){
		ch = c;
		child = new HashMap<Character, Node>();
	}
	
	boolean contains(char ch){
		return child.containsKey(ch);
	}
	
	void add(char ch){
		child.put(ch, new Node(ch));
	}
	
	Node getChild(char ch){
		return child.get(ch);
	}
	
	@Override
	public String toString(){
		return ch+"";
	}
	
}

class Trie{
	
	Node root;
	
	Trie(Node n){
		root = n;
	}
	
	void addWord(String s){
		int n = s.length();
		Node temp = root;
		for(int i=0; i<n; i++){
			char ch = s.charAt(i);
			if(!temp.contains(ch))
				temp.add(ch);
			temp = temp.getChild(ch);
			if(i==n-1)
				temp.isEnd = true;
		}
	}
	
	void printAllWords(Node temp){
		
		
	}
	
	
}
