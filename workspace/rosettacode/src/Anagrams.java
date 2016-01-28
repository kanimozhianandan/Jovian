import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;


public class Anagrams {

    public static void main(String[] args) {
        
        try {
            FileInputStream f = new FileInputStream("anagrams.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(f));
            
                
            }
            
         catch (FileNotFoundException e) {
            System.out.println("File anagrams.txt not found in the path specified");
        }
        
    }

}
