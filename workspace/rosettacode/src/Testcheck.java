import java.util.ArrayList;
import java.util.Collections;

public class Testcheck{
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(3);
        a.add(1);
        a.add(3);
        b.add(7);
        b.add(8);
        b.add(9);
        int flag=10;
        int i = 0;
        while(i < 3*2){
             Collections.shuffle(a);
             if(((a.get(0) + b.get(0)) == flag) && ((a.get(1) + b.get(1)) == flag) && 
                ((a.get(2) + b.get(2)) == flag)){
                i = 100;
                System.out.println("YES");
                break;
             }
             i++;
    }
        if(i != 100){
            System.out.println("NO");
        }
    }
}