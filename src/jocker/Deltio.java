
package jocker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;



public class Deltio {
    
    private int deltioId;
     
    private HashSet<Integer> numbers = new HashSet<Integer>();
    private HashSet<Integer> jockernumbers = new HashSet<Integer>();
 
    public int DeltioId(){
        DeltioGenerator id = new DeltioGenerator();
        this.deltioId = DeltioGenerator.getId();
        return this.deltioId;
    }

    public int getDeltioId() {
        return deltioId;
    }

    public HashSet<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(HashSet<Integer> numbers) {
        this.numbers = numbers;
    }

    public HashSet<Integer> getJockernumbers() {
        return jockernumbers;
    }

    public void setJockernumbers(HashSet<Integer> jockernumbers) {
        this.jockernumbers = jockernumbers;
    }

   
    
     
    
            
      
             
      
             
         
        
        
    
}

    