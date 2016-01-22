import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class GCJPower {
	static final int base = 9000;
	static HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		try {
			// Scanner sc = new Scanner(new
			// File("/home/kani/euphora/GCJ/PowerLevels/A-small.in"));
			Scanner sc = new Scanner(System.in);
			int tests = sc.nextInt();
			
			for (int i = 0; i < tests; i++) {
				int digits = sc.nextInt();
				System.out.print("Case #" + (i + 1) + ": ");
				int multifact_digits = Integer.MAX_VALUE;
				
				if (digits < 4) {
					System.out.println("...");
				} 
				else if (hmap.containsValue(digits)) {
					for(int key:hmap.keySet())if (hmap.get(key) == digits) {System.out.println("got comtaims");System.out.println(key);break;}
				} 
				else {
					int ls = 1;
					for(int l:hmap.values()){
						if (l > digits){
							
							for(int kk:hmap.keySet())if (hmap.get(kk) == l)ls=kk;  
							gen_multifac(ls, multifact_digits, digits);
							System.exit(0);
						}
					}
					
					gen_multifac(ls, multifact_digits, digits);
					
				    
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void gen_multifac(int l, int facts, int digits) {
		System.out.println("j:"+l);
		for (int j = l; facts > digits; j++) {
			facts = fact_digits(base, j);
			
		}
		System.out.println(facts);
		//1hmap.put(j, facts);
		
	}

	private static int fact_digits(int base, int j) {
		int factorial = 1;
		for (int k = j; k < base; k = k + j) {
			factorial = factorial * (base - k);
		}
		String st = Integer.toString(factorial);
		System.out.println(st);
		hmap.put(st.toCharArray().length, base);
		return st.toCharArray().length;
	}

}