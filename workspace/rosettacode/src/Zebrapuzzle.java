import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class Zebrapuzzle {
    static ArrayList<Integer> houseorder = new ArrayList<Integer>();
    static ArrayList<String> housecolor = new ArrayList<String>();
    static ArrayList<String> housepets = new ArrayList<String>();
    static ArrayList<String> housedrinks = new ArrayList<String>();
    static ArrayList<String> housesmokes = new ArrayList<String>();
    static ArrayList<String> nationality = new ArrayList<String>();

    public static void main(String[] args) {
        houseorder.add(1);
        houseorder.add(2);
        houseorder.add(3);
        houseorder.add(4);
        houseorder.add(5);
        housecolor.add("red");
        housecolor.add("white");
        housecolor.add("yellow");
        housecolor.add("blue");
        housecolor.add("green");
        housepets.add("dog");
        housepets.add("birds");
        housepets.add("horse");
        housepets.add("cats");
        housepets.add("zebra");
        housedrinks.add("water");
        housedrinks.add("milk");
        housedrinks.add("beer");
        housedrinks.add("tea");
        housedrinks.add("coffee");
        housesmokes.add("Prince");
        housesmokes.add("Blend");
        housesmokes.add("Dunhill");
        housesmokes.add("PallMall");
        housesmokes.add("BlueMaster");
        nationality.add("English");
        nationality.add("Norwegian");
        nationality.add("Danish");
        nationality.add("German");
        nationality.add("Swedish");

        ruleSet();

    }

    private String color;
    private String pet;
    private String drinks;
    private String smokes;
    private Integer order;
    private String nation;
    private Zebrapuzzle left;
    private Zebrapuzzle right;

    public Zebrapuzzle(String nation, String color, String pet, String drinks, String smokes, Integer order) {
        this.setColor(color);
        this.setPet(pet);
        this.setDrinks(drinks);
        this.setSmokes(smokes);
        this.setOrder(order);
        this.setNation(nation);
    }

    public Zebrapuzzle getLeft() {
        return left;
    }

    public void setLeft(Zebrapuzzle left) {
        this.left = left;
    }

    public Zebrapuzzle getRight() {
        return right;
    }

    public void setRight(Zebrapuzzle right) {
        this.right = right;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getSmokes() {
        return smokes;
    }

    public void setSmokes(String smokes) {
        this.smokes = smokes;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean accepts() {
        if (((nation == "English") & (color != "red")) |
                ((nation == "Swedish") & (pet != "dog")) |
                ((nation == "Danish") & (drinks != "tea")) |
                ((color == "green") & (drinks != "coffee")) |
                ((color == "yellow") & (smokes != "Dunhill")) |
                ((smokes == "PallMall") & (pet != "birds")) |
                ((smokes == "Dunhill") & (pet != "horse")) |
                ((order == 3) & (drinks != "milk")) |
                ((order == 1) & (nation != "Norwegian")) |
                ((order == 2) & (color != "blue")) |
                ((smokes == "BlueMaster") & (drinks != "beer")) |
                ((smokes == "Prince") & (nation != "German")) |
                ((color == "white") & (order == 1)) |
                ((color == "green") & (order == 1)) |
                ((color == "green") & (order == 3))

        ) {
            return false;
        }
        
        else if ( ((color == "red") & (nation != "English")) |
                  ((pet == "dog") & (nation != "Swedish")) |
                  ((drinks == "tea") & (nation != "Danish")) |
                  ((drinks == "coffee") & (color != "green")) |
                  ((smokes == "Dunhill") & (color != "yellow")) |
                  ((pet == "birds") & (smokes != "PallMall")) |
                  ((pet == "horse") & (smokes != "Dunhill")) |
                  ((drinks == "milk") & (order != 3)) |
                  ((nation == "Norwegian") & (order != 1)) |
                  ((color == "blue") & (order != 2)) |
                  ((drinks == "beer") & (smokes != "BlueMaster")) |
                  ((nation == "German") & (smokes != "Prince")) 
                 )  return false;
        
        return true;
    }

   
    public boolean validrightneigh(Zebrapuzzle next) {
        
        try {
            
        } catch (Exception e) {

        }
        return false;
    }

    public void addifalreadynotexists(Vector<Zebrapuzzle> vv) {
        if (!vv.contains(this)) {
            vv.addElement(this);
        }

    }

    public static void ruleSet() {
        Vector<Zebrapuzzle> combinations = new Vector<Zebrapuzzle>();
        Vector<Vector<Zebrapuzzle>> collcombinations = new Vector<Vector<Zebrapuzzle>>();
        Random rgen = new Random(); 
        ArrayList<String> templist = new ArrayList<String>();
        int max_iter = 5 * 4 * 3 * 2 ;
        while (max_iter > 0){
            combinations.clear();
       simple: for(int i=0;i<5;i++){  
           String pnation = nationality.get(rgen.nextInt(5));
           String ppcolor = housecolor.get(rgen.nextInt(5));
           String ppet = housepets.get(rgen.nextInt(5));
           String pdrink = housedrinks.get(rgen.nextInt(5));
           String psmoke =  housesmokes.get(rgen.nextInt(5));
           if(!templist.contains(psmoke) || !templist.contains(ppcolor) || !templist.contains(pnation) || !templist.contains(pdrink) || !templist.contains(ppet)){
                   Zebrapuzzle rule = new Zebrapuzzle(pnation, ppcolor ,ppet,pdrink ,psmoke, i+1);
                   combinations.add(rule);
           }
           else{
                break simple;
           }
           templist.add(pnation);
           templist.add(ppcolor);
           templist.add(ppet);
           templist.add(pdrink);
           templist.add(psmoke);
        }
        
        if(is_valid(combinations)){
            collcombinations.add(combinations);
            
        }
        max_iter = max_iter - 5;
        }
        
        for(Vector<Zebrapuzzle> coll : collcombinations){
            for(Zebrapuzzle c : coll){
                System.out.println(coll.size());
                System.out.println(c.order + c.color + c.drinks + c.smokes + c.nation);
            }
        }
        // collcombinations.removeIf(combination -> !is_neighvalid(combination));
        
        //System.out.println(collcombinations.size());
           
        }
    

    private static boolean is_neighvalid(Vector<Zebrapuzzle> combination) {
        for(Zebrapuzzle p: combination){
            Zebrapuzzle pleft = p.getLeft();
            Zebrapuzzle next = p.getRight();
            if (((p.color == "white") & (pleft.getColor() == "green")) |
                    ((p.smokes == "Blend") & (pleft.getPet() == "cats")) |                    
                    ((p.nation == "Norwegian") & (pleft.getColor() == "blue")) |
                    ((p.drinks == "water") & (pleft.getSmokes() == "Blend")) 
                    ) {
                return true;
            }
            
            else if (((p.color == "green") & (next.getColor() == "white")) |
                    ((p.pet == "cats") & (next.getSmokes() == "Blend")) |                    
                    ((p.color == "blue") & (next.getNation() == "Norwegian")) |
                    ((p.smokes == "Blend") & (next.getDrinks() == "water")) 
                    ) {
                return true;
            }
            
        }
        return false;
    }

    private static boolean is_valid(Vector<Zebrapuzzle> combinations) {
        for(Zebrapuzzle p: combinations){ 
        if (((p.nation == "English") & (p.color != "red")) |
                ((p.nation == "Swedish") & (p.pet != "dog")) |
                ((p.nation == "Danish") & (p.drinks != "tea")) |
                ((p.color == "green") & (p.drinks != "coffee")) |
                ((p.color == "yellow") & (p.smokes != "Dunhill")) |
                ((p.smokes == "PallMall") & (p.pet != "birds")) |
                ((p.smokes == "Dunhill") & (p.pet != "horse")) |
                ((p.order == 3) & (p.drinks != "milk")) |
                ((p.order == 1) & (p.nation != "Norwegian")) |
                ((p.order == 2) & (p.color != "blue")) |
                ((p.smokes == "BlueMaster") & (p.drinks != "beer")) |
                ((p.smokes == "Prince") & (p.nation != "German")) |
                ((p.color == "white") & (p.order == 1)) |
                ((p.color == "green") & (p.order == 1)) |
                ((p.color == "green") & (p.order == 3))

        ) return false;
        
        
        else if ( ((p.color == "red") & (p.nation != "English")) |
                  ((p.pet == "dog") & (p.nation != "Swedish")) |
                  ((p.drinks == "tea") & (p.nation != "Danish")) |
                  ((p.drinks == "coffee") & (p.color != "green")) |
                  ((p.smokes == "Dunhill") & (p.color != "yellow")) |
                  ((p.pet == "birds") & (p.smokes != "PallMall")) |
                  ((p.pet == "horse") & (p.smokes != "Dunhill")) |
                  ((p.drinks == "milk") & (p.order != 3)) |
                  ((p.nation == "Norwegian") & (p.order != 1)) |
                  ((p.color == "blue") & (p.order != 2)) |
                  ((p.drinks == "beer") & (p.smokes != "BlueMaster")) |
                  ((p.nation == "German") & (p.smokes != "Prince")) 
                 )  return false;
        
        }
        return true;
    }

  

   
}

