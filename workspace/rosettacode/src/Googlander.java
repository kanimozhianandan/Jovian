import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Googlander{
    public static void main(String[] args){
        try {
          Scanner sc = new Scanner(new File("C:\\Users\\kmurugan\\Desktop\\euphora\\GCJ\\GCJforwomen2015\\Googlander\\A-small.in"));
            //Scanner sc = new Scanner(System.in);
            FileWriter fw = new FileWriter("C:\\Users\\kmurugan\\Desktop\\euphora\\GCJ\\GCJforwomen2015\\Googlander\\A-small.txt");
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                // fw.write("Case #"+(i+1)+": ");
                 System.out.print(("Case #"+(i+1)+": "));
                int row = sc.nextInt();
                int col = sc.nextInt();
                
                              
                if(row == 1){
                    System.out.println(1);
                   // fw.write(row);
                }
                
                else if(row <= col){
                    int opts = col * (row-1);
                    //fw.write(opts);
                    System.out.println(opts);
                }
                
                else{
                    int opts=0;
                    for(int l=col-1;l>=1;l--){
                    for(int j=row;j>=1;j--){
                        if (l > 1) opts += (j-1) * l - 1;
                        else opts += 1;
                      }
                    }
                    
                   
                   System.out.println(opts);
                   // fw.write(opts);
                }
                
                fw.flush();
                fw.append("\n");
            }
            
          
        }
        
        catch(Exception e){
            
        }
    }
}