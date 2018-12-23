
package jocker;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;



/**
 *
 * @author Aikaterini Tsagkaraki
 */
public class Klirwsi {
    
    private HashSet <Integer> klirwsi_numbers = new HashSet<>();
    private int klirwsi_jocker;
    
    public HashSet<Integer> klirwsi_numbers(){ 
        int val = 0;
        Random rand = new Random();
        klirwsi_numbers.clear();
        while (this.klirwsi_numbers.size()<5){
             val = rand.nextInt(44)+1;
             this.klirwsi_numbers.add(val);    
        }  
        
        System.out.println("The numbers of draw are : " + this.klirwsi_numbers.toString());
        return this.klirwsi_numbers;
    }
    
    public int klirwsi_jocker(){
        int val = 0;
        Random rand = new Random();
        val = rand.nextInt(19)+1;
        this.klirwsi_jocker = 0;
        this.klirwsi_jocker = val;
        System.out.println("The jocker number of draw is : " + this.klirwsi_jocker);
        return this.klirwsi_jocker;
    }

    public HashSet<Integer> getKlirwsi_numbers() {
        return klirwsi_numbers;
    }

    public int getKlirwsi_jocker() {
        return klirwsi_jocker;
    }
             
             
    
}
    

