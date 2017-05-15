package codeAgon;

public class Learn {
	public static void main(String[] args) {
		double start = System.nanoTime();
		//int[] arr = {1212, 5453, 433, 232};
		String str = "";
		for(int i=0; i<10000; i++)
			str = str + i+"\n";
		System.out.println(str);
		System.out.println((System.nanoTime()-start)/1000000+" ms");
	}
}
