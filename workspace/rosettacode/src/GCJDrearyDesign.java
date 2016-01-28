import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Scanner;

public class GCJDrearyDesign{
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\kmurugan\\Desktop\\euphora\\GCJ\\GCJforwomen2015\\DrearyDesign\\B-large1.in"));
            FileWriter fw = new FileWriter("C:\\Users\\kmurugan\\Desktop\\euphora\\GCJ\\GCJforwomen2015\\DrearyDesign\\B-large1.txt");
           // Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                
                int k = sc.nextInt();             
                int v = sc.nextInt();
                fw.write("Case #"+(i+1)+": ");
                System.out.print("Case #"+(i+1)+": ");
                int choices = (int) Math.pow(k+1, 3); //number of possible choices with k+1 values.
                int j = 0;
                int bland_choice = 0;
                if (k == v){
                   fw.append(String.valueOf(choices)+"\n");
                    //System.out.print(choices+"\n");
                }
                
                else if (v == 0 || k < v){
                    fw.append(String.valueOf(k+1)+"\n");
                    //System.out.print(k+1+"\n");
                }
               
                
                else{
                    for(int a=0;a<=k;a++){
                        for(int b=0;b<=k;b++){
                            for(int c=0;c<=k;c++){
                                int f = Math.abs(a-b);
                                int s = Math.abs(b-c);
                                int t = Math.abs(c-a);
                                if(((f > v) || (s > v)) || (t > v)) { bland_choice = bland_choice + 1; };
                            }
                        }
                    }
                  
                fw.append(String.valueOf(choices - bland_choice)+"\n");
              //   System.out.print(choices - bland_choice+"\n");
                
               }
                
                
                
                fw.flush();
                
            }
            
            fw.close();
            sc.close();
        
    }
        catch(Exception e){
        }
}
}