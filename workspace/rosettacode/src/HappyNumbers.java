/**
 * Find Happynumbers.
 * Starting with any +ve integer, replace the number by the sum of the squares of its digits and repeat the process until number = 1.
 * Those ending with 1 are happy numbers, other are unhappy numbers.
 * @author kmurugan
 *
 */
public class HappyNumbers{
    
    public static boolean happy(int n){
        int square = n*n;           
        return n == 1;
        
        
    }
    public static void main(String[] argc){
        for(int i=1,cnt=0;cnt<8;i++){
            if(happy(i))
            {
                System.out.println(i);
                cnt ++;
            }
        }
                        
    }
}