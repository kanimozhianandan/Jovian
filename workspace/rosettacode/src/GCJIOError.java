import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class GCJIOError{
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\kmurugan\\Desktop\\euphora\\GCJ\\GCJforwomen2015\\IOError\\A-small.in"));
            FileWriter fw = new FileWriter("C:\\Users\\kmurugan\\Desktop\\euphora\\GCJ\\GCJforwomen2015\\IOError\\A-small.txt");
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                int B = sc.nextInt();
                String patt = sc.next();
                fw.write("Case #"+(i+1)+": ");
                int j = 0;
                String patt_new = patt.replaceAll("I", "1").replaceAll("O","0");
                while(j<B*8){
                int charcode = Integer.parseInt(patt_new.join("", patt_new.substring(j, j+8)), 2);
                fw.append(new Character((char)charcode).toString());
                j = j+8;
                }
            fw.append("\n");
            fw.flush();
            }

             fw.close();       
             sc.close();  
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}