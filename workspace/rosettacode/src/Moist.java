import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Moist {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("/home/kani/Desktop/A-small.in"));
			int n = sc.nextInt();
			List<String> cards = new ArrayList<String>();
			int count = 0;
			for (int i = 0; i < n; i++) {
				count = 0;
				int no_cards = sc.nextInt();
				cards.clear();
				sc.nextLine();
				for (int j = 0; j < no_cards; j++)cards.add(sc.nextLine());
			    String name = cards.get(0);
				for (String comp : cards) {

					if (name != comp && (comp).compareTo(name) < 0) {
						count ++;
					}
					
				}

				System.out.println("Case #"+(i+1)+": "+count);
			}
		
		} 
		catch (FileNotFoundException e) {
		}
		
	}
}
