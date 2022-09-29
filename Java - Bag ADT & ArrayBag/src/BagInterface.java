//  Description:
//          Reads a file javakeywords.txt and uses Bag ADT to insert entries from file into
//          a bag. Program takes parameters and checks if parameters are existing entries in the bag.
//          Tests for unused methods are commented off using javadoc.
//

public interface BagInterface<T>
{
    public int getCurrentSize();
    public boolean isEmpty();
    public boolean add(T newEntry);
    public T remove();
    public boolean remove(T anEntry);
    public void clear();
    public int getFrequencyOf(T anEntry);
    public boolean contains(T anEntry);
    public T[] toArray();
}
