import java.util.ArrayList;
import java.util.Scanner;

public class BribethePrisoners {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int count;
        for (int i = 0; i < T; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            int p = sc.nextInt();
            int q = sc.nextInt();
            for (int j = 0; j < q; j++)
                arr.add(sc.nextInt());
            if (q == 1)
                System.out.println(p - q);
            else {
                count = Integer.MAX_VALUE;
                int bribe = 0;
                ArrayList<Integer> arr_c = new ArrayList<>();
                int low, high;
                for (Integer f : arr) {

                    bribe = (f - 1) + (p - f);
                    arr_c.add(f);
                    low = p;
                    high = p;
                    for (Integer s : arr) {

                        if (s != f) {
                            for (Integer a : arr_c) {
                                if (a < s && (s - a - 1) < low)
                                    low = a;
                                if (a > s && (a - s - 1) < high)
                                    high = a;
                            }
                            arr_c.add(s);
                        }
                        bribe += (s - low - 1 + high - s - 1);
                    }

                    System.out.println("bribe:" + bribe);
                    if (bribe < count)
                        count = bribe;

                    arr_c.clear();
                    bribe = 0;
                }

                System.out.println(count);
            }

            arr.clear();
        }

    }
}