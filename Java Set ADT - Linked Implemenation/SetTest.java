//  Description:
//              Uses Set ADT to insert entries into Linked Sets.
//              Linked Sets are compared using subset(), union(), and equals() methods.
//
public class SetTest {

    public static void main(String[] args)
    {
        System.out.println("Set ADT by J. Casuga");

        //case 1
        SetInterface<Integer> setOne = new LinkedSet<>();
        SetInterface<Integer> setTwo = new LinkedSet<>();
        setOne.add(1);
        setOne.add(2);
        setOne.add(3);
        setTwo.add(2);
        setTwo.add(1);
        setTwo.add(3);
        System.out.println("\n" + "Does Set 1 equal Set 2? " + setOne.equals(setTwo));
        System.out.println("Is Set 1 a subset of Set 2? " + setOne.subset(setTwo));
        System.out.println("Is Set 2 a subset of Set 1? " + setTwo.subset(setOne));
        System.out.println("The union of Set 1 and Set 2 is: " + setOne.union(setTwo));

        //case 2
        SetInterface<Integer> setThree = new LinkedSet<>();
        SetInterface<Integer> setFour = new LinkedSet<>();
        setThree.add(1);
        setFour.add(1);
        setFour.add(2);
        System.out.println("\n" + "Is Set 3 equal to Set 4? " + setThree.equals(setFour));
        System.out.println("Is Set 3 a subset of Set 4? " + setThree.subset(setFour));
        System.out.println("Is Set 4 a subset of Set 3? " + setFour.subset(setThree));
        System.out.println("The union of Set 3 and Set 4 is: " + setFour.union(setThree));

        //case 3
        SetInterface<Integer> setFive = new LinkedSet<>();
        SetInterface<Integer> setSix = new LinkedSet<>();
        setFive.add(1);
        setFive.add(2);
        setFive.add(3);
        setSix.add(2);
        setSix.add(3);
        setSix.add(4);
        setSix.add(5);
        System.out.println("\n" + "Is Set 5 equal to Set 6? " + setFive.equals(setSix));
        System.out.println("Is Set 5 a subset of Set 6? " + setFive.subset(setSix));
        System.out.println("Is Set 6 a subset of Set 5? " + setSix.subset(setFive));
        System.out.println("The union of Set 5 and Set 6 is: " + setFive.union(setSix));

        //case 4
        SetInterface<Integer> setSeven = new LinkedSet<>();
        SetInterface<Integer> setEight = new LinkedSet<>();
        setSeven.add(1);
        setEight.add(2);
        setEight.add(3);
        System.out.println("\n" + "Does Set 7 equal Set 8? " + setSeven.equals(setEight));
        System.out.println("Is Set 7 a subset of Set 8? " + setSeven.subset(setEight));
        System.out.println("Is Set 8 a subset of Set 7? " + setEight.subset(setSeven));
        System.out.println("The union of Set 7 and Set 8 is: " + setSeven.union(setEight));

        //case 5
        SetInterface<Integer> setNine = new LinkedSet<>();
        SetInterface<Integer> setTen = new LinkedSet<>();
        setTen.add(1);
        setTen.add(2);
        setTen.add(3);
        System.out.println("\n" + "Does Set 9 equal Set 10? " + setNine.equals(setTen));
        System.out.println("Is Set 9 a subset of Set 10? " + setNine.subset(setTen));
        System.out.println("Is Set 10 a subset of Set 9? " + setTen.subset(setNine));
        System.out.println("The union of Set 9 and Set 10 is: " + setNine.union(setTen));

        //special cases
        SetInterface<Integer> emptySet = new LinkedSet<>();
        System.out.println("\n" + emptySet.equals(emptySet));
        System.out.println(emptySet.subset(emptySet));
        System.out.println(emptySet.union(emptySet));
        System.out.println(emptySet);

        SetInterface<Integer> singleSet = new LinkedSet<>();
        singleSet.add(1);
        System.out.println(singleSet);
    }
}
