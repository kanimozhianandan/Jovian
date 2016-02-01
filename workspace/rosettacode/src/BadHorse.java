import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BadHorse {
	public static void main(String[] args) {
		try {
			  Scanner sc = new Scanner(new
			  File("/home/kani/euphora/GCJ/A-small.in"));
			  
		    //Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			ArrayList<String> arr = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				
				int m = sc.nextInt();
				sc.nextLine();
				System.out.print("Case #" + (i + 1) + ": ");
				for (int j = 0; j < m; j++) {
					String str = sc.nextLine();
					StringTokenizer st = new StringTokenizer(str, " ");
					//System.out.println(st.countTokens());
					while (st.hasMoreTokens()) {
						String name = (String) st.nextToken();
						if (!arr.contains(name))
							arr.add(name);
					}
				
					
					}
				if (arr.size() % 2 != 0)System.out.println("NO");
			    else System.out.println("YES");
				arr.clear();
			}

		} catch (Exception e) {

		}

	}
}
