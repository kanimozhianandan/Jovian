import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Find the items in itemlist that cost to max "credit". 
 */

public class StoreCredit {
	public static void main(String[] args) {
		try {
			 Scanner sc = new Scanner(new
			 File("/home/kani/Desktop/A-large.in"));
			//Scanner sc = new Scanner(System.in);
			int cases = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int credit = 0, items = 0, item1 = -1, item2 = -1;
			for (int i = 0; i < cases; i++) {
				System.out.print("Case #"+(i+1)+": ");
				credit = sc.nextInt();
				items = sc.nextInt();
				for (int j = 0; j < items; j++) {
					arr.add(sc.nextInt());
				}

				sumsearch: for (int a=0;a < items; a++) {
					for (int b=0;b <items; b++) {
						if (a != b && arr.get(a) + arr.get(b) == credit) {
							item1 = a+1;
							item2 = b+1;
							break sumsearch;
						}
					}
				}
				if (item1 > item2) {int tmp = item1; item1 = item2; item2 = tmp;}
				System.out.println(item1 + " " + item2);

				arr.clear();
			}
		} catch (Exception e) {

		}
	}
}
