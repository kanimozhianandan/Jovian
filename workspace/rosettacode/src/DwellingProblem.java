import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DwellingProblem {
    static ArrayList<String> names = new ArrayList<String>();
    static ArrayList<Integer> house = new ArrayList<Integer>();

    public static void main(String[] args) {

        names.add("Baker");
        names.add("Cooper");
        names.add("Smith");
        names.add("Miller");
        names.add("Fletcher");

        house.add(1);
        house.add(2);
        house.add(3);
        house.add(4);
        house.add(5);

        checkcombinations();

    }

    private String name;
    private int h;

    public DwellingProblem(String name, int h) {
        this.setname(name);
        this.sethouse(h);

    }

    public void setname(String name) {
        name = this.name;
    }

    public void sethouse(int h) {
        h = this.h;
    }

    public String getname() {
        return name;
    }

    public int gethouse() {
        return h;
    }

    public static boolean is_valid(List<String> hm) {

        if ((hm.indexOf("Baker") + 1 == 5) | (hm.indexOf("Cooper") + 1 == 1) | (hm.indexOf("Fletcher") + 1 == 1)
                | (hm.indexOf("Fletcher") + 1 == 5))
            return false;

        return true;
    }

    public static boolean deep_valid(ArrayList<String> names2) {

        try {
            if ((names2.indexOf("Miller") < names2.indexOf("Cooper")) |
                    (Math.abs(names2.indexOf("Fletcher") - names2.indexOf("Smith")) == 1) |
                    (Math.abs(names2.indexOf("Fletcher") - names2.indexOf("Cooper")) == 1))
                return false;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;

    }

    private static void checkcombinations() {
        
        ArrayList<String> hs = new ArrayList<String>();         
        generate_permutations(hs, names);
        
        
        
        /*  for (ArrayList<String> ns:hs){
              System.out.println(ns.get(0) + ns.get(1) + ns.get(2) + ns.get(3) +ns.get(4));
          }*/
    }

    private static void generate_permutations(ArrayList<String> prefix, ArrayList<String> n) {
         if (n.size() == 0) System.out.println();
         else{
           
         for(int i=0;i<n.size();i++){
             ArrayList<String> nclass = new ArrayList<String>();
             for(String next:n) if (!next.equals(n.get(i))){nclass.add(next);};
             prefix.add(n.get(i));
             generate_permutations(prefix, nclass); 
          }
        }
        
    }
}
