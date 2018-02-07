import java.util.*;
import edu.duke.*;
/**
 * You will write a program to determine the word that occurs the most often in a file. 
 * If more than one word occurs as the most often, then return the first such word found. 
 * You should make all words lowercase before counting them. 
 * Thus, “This” and “this” will both be counted as the lowercase version of “this”. 
 * You should not consider punctuation, so “end” and “end,” will be considered different words. 
 * Use the WordFrequencies program in the lesson as a starting point.
 * 
 * For more information about what the exercise is about, please refer to the readme file.
 * 
 * @author (Abraham Ferrero) 
 * @version (25/OCT/2017)
 */
public class WordFrequencies {
    //We create a constructor with two arrayLists
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    //This method will find unique words in a selected file and store them in the arrayList myWords
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource f = new FileResource();
        // For testing purposes, to see of our resulst are ok when working with small examples: System.out.println(f.asString());
        //For each word in a file, convert it to lowercase, and locate the index number:
        for(String word : f.words()){
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            /* add it to the arraylist myWords if it is a new one, then add a slot to myFreqs
             * with value one.*/
            if (index == -1){
                myWords.add(word);
                myFreqs.add(1);
            }
            /* If it is not a new word, get the myFreqs value located in the index of myWords
             * and add one to that value with the "getter" and "setter"
             */
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
    }
    
    public void tester(){
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        for(int i=0; i < myWords.size(); i++){
            System.out.println(myWords.get(i) + "\t" + myFreqs.get(i));
        }
        findIndexOfMax();
    }
    
    public void findIndexOfMax(){
        //findUnique();
        int value = myFreqs.get(0);
        int maxIndex = value;
        String word = myWords.get(0);
        String maxWord = word;
        for (int i=0; i < myFreqs.size(); i++){
           int index = myFreqs.get(i);
           word = myWords.get(i);
           if (index > maxIndex){
               maxIndex = index;
               //To take the first occurence of the word with the max value if there's a tie:
               maxWord = word;
               
            }
           else{
               maxIndex = maxIndex;
               maxWord = maxWord;
            }
        }
        System.out.println("The word that occurs most often and its count are: "+ maxWord +" "+ maxIndex );
    }
}
