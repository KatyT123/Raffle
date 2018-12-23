
package jocker;
/******
Aikaterini Tsagkaraki
******
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;




public class Jocker {

    
    public static void main(String[] args) {
        
       Player player = new Player(15234324);
       Deltio deltio = new Deltio();
       Klirwsi klirwsi = new Klirwsi();
       
       player.play();
       System.out.println();
       klirwsi.klirwsi_numbers();
       klirwsi.klirwsi_jocker();
       isPlayerAWinner(player,klirwsi);
       
       /*Two versions for Jocker Statistics
        *First with arrays
        *Second with collesctions
        */
       
       
       StatisticsJocker.StatisticJocker(klirwsi);
       //SecondVersionStatisticsJocker.StatisticJocker(klirwsi);
       
}
    public static boolean isPlayerAWinner(Player player,Klirwsi klirwsi){
       
        boolean flag = false;
        HashSet<Deltio> deltia = player.getDeltia();
        
        for(Deltio d : deltia){
            if (isDeltioAWinner(d,klirwsi)){
                System.out.println("The winner is a person with AFM : " + player.getAfm()+ "  Congratulations! ");
                flag = true;
                break;
            }
        }
        if (flag == false) System.out.println("Sorry the player with AFM : " + player.getAfm()+ "is not a winner! ");
        
        return flag;
    }
    
    public static boolean isDeltioAWinner(Deltio deltio, Klirwsi klirwsi){
        
        boolean flag = false;
        int jocker = klirwsi.getKlirwsi_jocker();
        HashSet<Integer> numbers = deltio.getNumbers();
        HashSet<Integer> kirwsi_numbers = klirwsi.getKlirwsi_numbers();
        HashSet<Integer> jocker_numbers = deltio.getJockernumbers();
        ArrayList matches = new ArrayList();
        
        for ( int num : kirwsi_numbers){
            if (numbers.contains(num))
               matches.add(num);
        }
        if (matches.size()== 4){
            flag = true;
            System.out.println("This deltio is a winner with 4 numbers ! : " + matches.toString());
        }
        if (matches.size()== 5){
            flag = true;
            if (jocker_numbers.contains(jocker))
                System.out.println("This deltio is a winner with 5+1!And Jocker 5+1! The winner numbers are :" + matches.toString() + " " 
        + jocker);
            else System.out.println("This deltio is a winner with 5 numbers ! : " + matches.toString());
        }   
        return flag;
    }
}
    
   