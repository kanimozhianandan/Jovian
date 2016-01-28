import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Abundantdeficientperfectdivisor {

    public static void main(String[] args) {
        /*
         * Perfect divisor - Logic is that to find perfect divisors of a number.
         * IT's enough to check in the range (min divisor). 
         * For eg :
         * n = 50. n is divisible by 2. so check in 1 to (n/2) range. 
         * n = 25. min low n divisor is 5. so check in 1-5 range.
         *
         */
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        List<Integer> abundant = new ArrayList<Integer>();
        List<Integer> deficient = new ArrayList<Integer>();
        List<Integer> perfect = new ArrayList<Integer>();
        long start = System.currentTimeMillis();
        
        for (int i = 1; i <= 20000; i++) {
           
            int sum = 0;
            int range = 0;
            List<Integer> divisors = new ArrayList<Integer>();
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    range = (i / j);
                    break;
                }
            }

            // get the divisor of the already existing range
            if (map.keySet().contains(range)) {
                divisors.addAll(map.get(range));
            }

            // if no such divisor exist
            else {
                for (int k = 2; k <= range; k++) {
                    if (i % k == 0) {
                        divisors.add(i / k);
                    }
                }
            }
            
            if (i != 1){
                divisors.add(1);
            }
            map.put(Integer.toString(i), divisors);
            // System.out.println("Numbers :"+i);
            // System.out.println(map.get(Integer.toString(i)));
            for (int d : divisors) {
                sum += d;
            }

         
            if (sum == i) {
                perfect.add(i);
            }

            else if (sum < i) {
                deficient.add(i);
            }

            else {
                abundant.add(i);
            }

        }

        System.out.println("Perfect numbers:" + perfect.size());
        System.out.println("Abundant numbers:" + abundant.size());
        System.out.println("Deficient numbers:" + deficient.size());
        System.out.println("Time elapsed : " +(System.currentTimeMillis()-start) + "ms");

    }

}
