/*
 * CodeJam for Women 2016
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codjjam{
public static void main(String[] args) {
    try{
              Scanner sc = new Scanner(System.in);
             
              int n = sc.nextInt();
              for(int i=0;i<n;i++){
                  int items = sc.nextInt();
                  System.out.print("Case #"+(i+1)+": ");
                  List<Integer> arr = new ArrayList<Integer>();
                  for(int j=0;j<items*2;j++){
                      arr.add(sc.nextInt());
                  }
                  List<Integer> new_arr = new ArrayList<Integer>();
                  while (new_arr.size() != items){
                      Integer min = arr.get(0); //since the list is sorted
                      new_arr.add(min);
                      int tmp = arr.indexOf((min/3) * 4);
                      arr.remove(tmp);
                      arr.remove(0);
                  }
                  
                  new_arr.stream().forEach(p -> System.out.print(p + " "));
                  System.out.println();
                  
              }
}
    catch (Exception e){
        
    }
}
}