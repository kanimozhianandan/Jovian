import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/*
 *  Find the min number of persons to be added with shyness level represented.
 */

public class StandingOvation{
	public static void main(String[] args){
		try{
		Scanner sc = new Scanner(new File("/home/kani/Desktop/A-large.in"));
		int cases = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<cases;i++){
		   arr.clear();	
           int s_max = sc.nextInt();
           String s = sc.next();
           for(char a:s.toCharArray()) {arr.add((int) a - 48);}
           int threshold= 0, count = 0, min_adds = 0, s_val = 0;
           for(int j=0;j<s_max+1;j++){
        	  s_val = arr.get(j);
        	  if(threshold >= j) threshold += s_val;
        	  else {count += 1; min_adds = j-threshold; threshold += min_adds + s_val;} 
        	//  System.out.println("j:"+j+"threshols:"+threshold+"count:"+count);
           }
        System.out.println("Case #"+(i+1)+": "+count);   	
		}
	}
	catch (Exception e){
		
	}
	}
}
