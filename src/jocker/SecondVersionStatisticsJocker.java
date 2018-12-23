
package jocker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



/**
 *
 * @author KATY
 */
public class SecondVersionStatisticsJocker {
    
    public static void StatisticJocker(Klirwsi klirwsi){
        boolean order = true;
        ArrayList<Integer> allnumbers = new ArrayList();
        HashMap<Integer,Integer> unsort_map = new HashMap<>();
        
        System.out.println();
        System.out.println("This is a statistical data about the most and less lucky numbers in the last 20 draws \n");
        
        allnumbers.addAll(twentyDraws(klirwsi));
        
        for(Integer num : allnumbers){
            if(!unsort_map.containsKey(num))
                unsort_map.put(num, 1);
            else
                unsort_map.replace(num,unsort_map.get(num), unsort_map.get(num) +1);
        }
       
       Map<Integer,Integer> sorted_map = sortByComparator(unsort_map,order); 
       Map<Integer,Integer> temp = sortByComparator(unsort_map,order);
       printMap(sorted_map);
       MostAppearedNumbers(temp);
       LessAppearedNumbers(sorted_map);
       
        
    }
    
    public static void printMap(Map<Integer,Integer> map){
        for(Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }
    
    private static Map<Integer,Integer> sortByComparator(HashMap<Integer,Integer> unsort_map,final boolean order){
        List<Entry<Integer,Integer>> list = new LinkedList<Entry<Integer,Integer>>(unsort_map.entrySet());
        
        //Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<Integer,Integer>>() {
             
            public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2){
                if(order){
                    return o1.getValue().compareTo(o2.getValue());
                }
                else{
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
            
        });
        Map<Integer,Integer> sorted_map = new LinkedHashMap <Integer,Integer>();
        for(Entry <Integer,Integer> entry : list){
           sorted_map.put(entry.getKey(), entry.getValue());  
        }
        return sorted_map;
    }   
         
    public static ArrayList<Integer> twentyDraws(Klirwsi klirwsi){
   
        ArrayList <Integer> allnumbers = new ArrayList();
        HashSet <Integer> klirwsi_numbers = new HashSet<>();
        
        for (int i = 0;i <20; i++){
            klirwsi_numbers.clear();
            klirwsi.klirwsi_numbers();
            klirwsi_numbers.addAll(klirwsi.getKlirwsi_numbers());
     
            for (int num : klirwsi_numbers){
                allnumbers.add(num);
            }
        }
        System.out.println();
        return allnumbers;
    }
    
    public static void MostAppearedNumbers(Map<Integer,Integer> sorted_map){
        int size = sorted_map.size();
        Map<Integer,Integer> cut = new LinkedHashMap<>();
        
        System.out.println("The most frequently appearing numbers are : \n");
        cut.putAll(frequency_most(sorted_map,cut));
        cut.putAll(frequency_most(sorted_map,cut));
        cut.putAll(frequency_most(sorted_map,cut));
       
     }
    
     public static Map<Integer,Integer> frequency_most(Map<Integer,Integer> sorted_map, Map<Integer,Integer> cut){
        Map<Integer,Integer> mynumbers = new LinkedHashMap<>();
        int last = 0;
             
        for(Entry<Integer,Integer> entry : cut.entrySet()){
            if (sorted_map.containsValue(entry.getValue())){
                sorted_map.remove(entry.getKey(), entry.getValue());
            }
        }
        
        for(int item : sorted_map.values()) last = item;
        
        for (Entry<Integer,Integer> entry : sorted_map.entrySet()){
            if(entry.getValue()== last){
              mynumbers.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println("The numbers with appeareance " + last + " times are :");
        for(Entry<Integer,Integer> entry : mynumbers.entrySet()) System.out.println(entry.getKey());
        
        return mynumbers;
    }
    
    
    public static void LessAppearedNumbers(Map<Integer,Integer> sorted_map){
        boolean flag = true;
        int i = 1;    
        int size = sorted_map.size();
        Map<Integer,Integer> cut = new LinkedHashMap<>();
        
        System.out.println("The less frequently appearing numbers are : \n");
        System.out.println("The numbers with 0 appearance are : ");
        
        for(Entry<Integer,Integer> entry : sorted_map.entrySet()){
            if(!sorted_map.containsKey(i)){
                System.out.println(i);
                flag = false;
            }
            i++;
        }
        cut.putAll(frequency_less(sorted_map,cut));
        cut.putAll(frequency_less(sorted_map,cut));
        
        if (flag) cut.putAll(frequency_less(sorted_map,cut));
    }
    
    public static Map<Integer,Integer> frequency_less(Map<Integer,Integer> sorted_map, Map<Integer,Integer> cut){
        Map<Integer,Integer> mynumbers = new LinkedHashMap<>();
        int first = 0;
             
        for(Entry<Integer,Integer> entry : cut.entrySet()){
            if (sorted_map.containsValue(entry.getValue())){
                sorted_map.remove(entry.getKey(), entry.getValue());
            }
        }
        
        for(int item : sorted_map.values()) {
            first = item;
            break;
        }
        
        for (Entry<Integer,Integer> entry : sorted_map.entrySet()){
            if(entry.getValue()== first){
              mynumbers.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println("The numbers with appeareance " + first + " times are :");
        for(Entry<Integer,Integer> entry : mynumbers.entrySet()) System.out.println(entry.getKey());
        
        return mynumbers;
    }
}


  


