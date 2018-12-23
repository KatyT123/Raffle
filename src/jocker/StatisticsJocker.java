
package jocker;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author KATY
 */
public class StatisticsJocker {
    
    
     public static void StatisticJocker(Klirwsi klirwsi){
        ArrayList<Integer> allnumbers = new ArrayList();
        int [] temp = new int [100];
        int [] freq = new int [100];
        int [] frequency = new int [44];
        int [] number = new int [44];
        int val;int count;
        int j =0;int c=0;
        
        System.out.println();
        System.out.println("This is a statistical data about the most and less lucky numbers in the last 20 draws \n");
        
        allnumbers.addAll(twentyDraws(klirwsi));
        for(Integer n : allnumbers){
            temp[j] = n;
            j++;
        }
        for(int i=0;i<freq.length;i++){
            freq [i] = -1;
        }
        for(int i=0;i<temp.length;i++){
            count = 1;
            for(int k=i+1;k<temp.length;k++){
                if(temp[i]==temp[k]){
                    count++;
                    freq[k] = 0;
                }
            }
            if(freq[i]!=0)
                freq[i] = count;
        }
        for(int i=0; i<temp.length;i++){
            if(freq[i]!=0){
                frequency[c]=freq[i];
                number[c]=temp[i];
                c++;
            }
        }
        MostAppearedNumbers(number,frequency);
        LessAppearedNumbers(number,frequency);
        
    }
       
    public static void LessAppearedNumbers(int [] number, int [] frequency){
        int start = 0;
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> first_less_appereance = new ArrayList<>();
        ArrayList<Integer> second_less_appereance = new ArrayList<>();
        ArrayList<Integer> thirth_less_appereance = new ArrayList<>();
        ArrayList<Integer> notappeared = new ArrayList<>();
        
        for(int i=0; i<number.length;i++){
            temp1.add(number[i]);
        }
        for(int i=0; i<number.length;i++){
            if(!temp1.contains(i+1))
                notappeared.add(i+1);
        }
        if (!notappeared.isEmpty())
           System.out.println ("The numbers wich don't appear at all are : " );
           System.out.println(notappeared.toString()+"\n");
        
        SortingResults(number,frequency);
        start = notappeared.size();
        first_less_appereance.addAll(frequency_less(number,frequency,start));
        start = start + first_less_appereance.size();
        second_less_appereance.addAll(frequency_less(number,frequency,start));
        if (notappeared.isEmpty()){
            start = start + second_less_appereance.size();
            thirth_less_appereance.addAll(frequency_less(number,frequency,start));
        }
    }
    
    public static void MostAppearedNumbers(int [] number, int [] frequency){
        int length = number.length;
        ArrayList<Integer> most_freq = new ArrayList<>();
        ArrayList<Integer> second_freq = new ArrayList<>();
        ArrayList<Integer> thirth_freq = new ArrayList<>();
        
        SortingResults(number,frequency);
        most_freq.addAll(frequency_most(number,frequency,length));
        length = length - most_freq.size();
        second_freq.addAll(frequency_most(number,frequency,length));
        length = length - second_freq.size();
        thirth_freq.addAll(frequency_most(number,frequency,length));
        
     }
    
    public static ArrayList<Integer> frequency_most(int[] number, int [] frequency, int length){
        ArrayList<Integer> mynumbers = new ArrayList<>();
        
        for(int i=0; i<length;i++){
            if (frequency[i] == frequency[length - 1]){
                mynumbers.add(number[i]);
            }
        }
        System.out.println("The numbers with appeareance " + frequency[length-1] + " times are :");
        System.out.println(mynumbers.toString()+"\n");
        return mynumbers;
    }
    
    public static ArrayList<Integer> frequency_less(int [] number, int [] frequency, int start){
        ArrayList<Integer> mynumbers = new ArrayList<>();
        
        for(int i=start; i<number.length;i++){
            if (frequency[i] == frequency[start]){
               mynumbers.add(number[i]);
            }
        }
        System.out.println("The numbers with appereance " + frequency[start] + " times are : ");
        System.out.println(mynumbers.toString()+"\n");
        return mynumbers;
    }
    
    public static void SortingResults(int [] num, int [] freq){

        int temp1; int temp2;
        boolean is_sorted;

        for (int i = 0; i < freq.length; i++) {
            is_sorted = true;
            for (int j = 1; j < (freq.length - i); j++) {

                if (freq[j - 1] > freq[j]) {
                    temp1 = freq[j - 1];
                    temp2 = num[j - 1];
                    freq[j - 1] = freq[j];
                    num[j - 1] = num[j];
                    freq[j] = temp1;
                    num[j] = temp2;
                    is_sorted = false;
                }
            }
            if (is_sorted) break;  
        }
        
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
}


