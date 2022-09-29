//  Description:
//          Reads a file javakeywords.txt and uses Bag ADT to insert entries from file into
//          a bag. Program takes parameters and checks if parameters are existing entries in the bag.
//          Tests for unused methods are commented off using javadoc.
//

import java.io.File;
import java.util.Scanner;

public class JavaKeywords {

    public static void main(String[] args) throws Exception {
        System.out.println("Java Keywords by J. Casuga" + "\n");

        //Uses File and Scanner to read javakeywords.txt
        File file = new File("javakeywords.txt");
        Scanner sc = new Scanner(file);
        BagInterface<String> keywordsBag = new ArrayBag<>();

        //Adds entries from javakeywords.txt to bag
        while(sc.hasNext())
        {
            keywordsBag.add(sc.next());
        }

        //prints size of bag
        System.out.println(keywordsBag.getCurrentSize() + " Java keywords loaded." + "\n");

        //checks if parameters entered are existing entries in the bag
        for (String arg : args)
        {
            if(keywordsBag.contains(arg))
            {
                System.out.println(arg + " is a keyword.");
            }
            else
            {
                System.out.println(arg + " is not a keyword.");
            }
        }

        /**
         * Tests for all unused methods


         //tests isEmpty() method
         System.out.println("\n" + keywordsBag.isEmpty()); //checks if bag is empty (should return false)

         //tests remove() method
         System.out.println(keywordsBag.getCurrentSize()); //size of bag before removing entry
         keywordsBag.remove(); //removes last entry in bag
         System.out.println(keywordsBag.getCurrentSize()); //size of bag after removing entry

         //tests remove(T anEntry) method
         System.out.println(keywordsBag.contains("volatile")); //checks if specific entry is present in bag (should return true)
         keywordsBag.remove("volatile"); //removes specific entry in bag
         System.out.println(keywordsBag.contains("volatile")); //checks if specific entry is present in bag (should return false)

         //tests getFrequencyOf() method
         System.out.println(keywordsBag.getFrequencyOf("while")); //checks frequency of "while" in bag (should return 1)

         //tests clear() method & isEmpty() method
         keywordsBag.clear(); //removes all entries in bag
         System.out.println(keywordsBag.isEmpty()); //checks if bag is empty (should return true)


         */
    }
}