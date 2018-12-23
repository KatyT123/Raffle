
package jocker;


import java.util.HashSet;
import java.util.Scanner;

public class Player {

    private int afm;
    private Deltio id = new Deltio();
    private HashSet<Deltio> deltia = new HashSet<>();
    private HashSet<Integer> numbers = new HashSet<>();
    private HashSet <Integer> jockernumbers = new HashSet<>();
    
     

    public HashSet<Deltio> getDeltia() {
        return deltia;
    }
  
    public Player() {
    }

    public Player(int afm) {
        this.afm = afm;

    }

    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public void play() {
        Deltio deltio = new Deltio();
        System.out.println("New deltio created with id number : " + deltio.DeltioId());
        deltio.setNumbers(play_numbers());
        deltio.setJockernumbers(jocker_numbers());
        this.deltia.add(deltio);

    }
    public HashSet<Integer> play_numbers(){ 
          
        Scanner sc = new Scanner(System.in);
        System.out.println("To add ordinary numbers give at least 5 numbers between 1 and 45 separated with comma ");
        String readnumbers = sc.nextLine();
        String [] tempnum = readnumbers.split(",");
        for (String s : tempnum) {
            if (isnumbersok(Integer.parseInt(s.trim())))
                    this.numbers.add(Integer.parseInt(s.trim()));
        }
        if (checksizenumbers(this.numbers)){
            System.out.println("player numbers are : " + this.numbers.toString());
            return this.numbers;
        }else return null;    
    }
        
    public HashSet<Integer> jocker_numbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("To add Jocker number give at least 1 number between 1 and 20 separated with comma ");
        String readnumbers = sc.nextLine();
        String[] tempnum = readnumbers.split(",");

        for (String s : tempnum) {
            if (isjockernumberok(Integer.parseInt(s.trim())))
               this.jockernumbers.add(Integer.parseInt(s.trim()));
        }
        if (checksizejockernumber(this.jockernumbers)){
            System.out.println("player joker numbers are : " + this.jockernumbers.toString());
            return this.jockernumbers;
        }else {
            return null;
        }
    }

    public HashSet<Integer> getNumbers() {
        return numbers;
    }

    public HashSet<Integer> getJockernumbers() {
        return jockernumbers;
    }
 
    private boolean isnumbersok(int num) {
         return(num >= 1 && num <= 45);           
    }

    private boolean checksizenumbers(HashSet numbers){
        return (numbers.size() >= 5 && numbers.size() <= 45);        
    }
    
    private boolean isjockernumberok(int num){
        return (num >= 1 && num <= 20);
    }
    
    private boolean checksizejockernumber(HashSet jockernumbers){
        return (jockernumbers.size() >= 1 && jockernumbers.size() <= 20);
    }

    }
        
        
    

