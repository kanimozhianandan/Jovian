import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class GCJPowerLevels{
    public static void main(String[] args){
        try {
           //Scanner sc = new Scanner(new File("C:\\Users\\kmurugan\\Desktop\\euphora\\GCJ\\GCJforwomen2015\\Powerlevels\\A-small.in"));
            Scanner sc = new Scanner(System.in);
           // FileWriter fw = new FileWriter("C:\\Users\\kmurugan\\Desktop\\euphora\\GCJ\\GCJforwomen2015\\Powerlevels\\A-small.txt");
            int n = sc.nextInt();
            HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
            for(int i=1;i<=n;i++){
                int digits = sc.nextInt();
                int fac = Integer.MAX_VALUE;
                if(!hmap.containsKey(digits)){
                    while(fac > digits){
                        int k=1;
                        
                    }
                }
                
                
            }
        }
        catch(Exception e){
            
        }
        }
    }