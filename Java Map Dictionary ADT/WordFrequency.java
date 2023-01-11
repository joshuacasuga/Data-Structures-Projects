//
//  Name:       Casuga, Joshua
//  Homework:   #1
//  Due:        11/9/2022
//  Course:     cs-2400-01-f22
//
//  Description:
//              Main application that reads the file "usconstitution.txt".
//              Program uses DictionaryInterface and MapDictionary to add words
//              to a dictionary. Numbers and punctuation are not included in the dictionary.
//              In the dictionary, each unique word is saved and each instance of that word
//              is counted and returned to the user. The total amount of words is also returned.
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Word Frequency by J. Casuga" + "\n");
        System.out.println("Count Word");
        System.out.println("----- -------------------- ");

        DictionaryInterface<String, Integer> wordTable = new MapDictionary<>();
        Scanner sc = new Scanner(new File("usconstitution.txt"));
        sc.useDelimiter("\\W+");
        while(sc.hasNext()){
            String nextWord = sc.next();
            if(nextWord.matches("[a-zA-Z]+")){
                nextWord = nextWord.toLowerCase();
                Integer frequency = wordTable.getValue(nextWord);
                if(frequency == null){
                    wordTable.add(nextWord, new Integer(1));
                }
                else{
                    frequency++;
                    wordTable.add(nextWord, frequency);
                }
            }
        }
        sc.close();

        Iterator<String> keyIterator = wordTable.getKeyIterator();
        int total = 0;
        while(keyIterator.hasNext()){
            String str = keyIterator.next();
            System.out.println(wordTable.getValue(str) + "\t" + str);
            total += wordTable.getValue(str);
        }
        System.out.println("Total: " + total);
    }
}
