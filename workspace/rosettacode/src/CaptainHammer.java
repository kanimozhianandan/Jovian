import java.io.File;
import java.util.Scanner;

public class CaptainHammer{
	public static void main(String[] args){
		 Scanner sc = new Scanner(new
				  File("/home/kani/euphora/GCJ/A-small.in"));
				  
	    // Scanner sc = new Scanner(System.in);
	    double g = 9.8;
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			int v = sc.nextInt();
			int d = sc.nextInt();
			float t = v/d;
			double theta = g*t*t/2*d;
			double angle = Math.toDegrees(theta);
			System.out.println(angle);
		}
		
	}
}
