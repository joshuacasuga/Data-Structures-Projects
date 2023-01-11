//
//  Name:       Casuga, Joshua
//  Project:    #3
//  Due:        10/21/2022
//  Course:     cs-2400-01-f22
//
//  Description:
//              An interface that enforces the properties of a bag onto the Array data type.
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