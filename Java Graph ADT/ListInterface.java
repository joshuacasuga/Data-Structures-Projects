//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: The ListInterface that includes methods for the List ADT
//
public interface ListInterface<T> {
    public void add(T newEntry);

    public void add(int newPosition, T newEntry);

    public T remove(int givenPosition);

    public void clear();

    public T replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);

    public T[] toArray();

    public boolean contains(T anEntry);

    public int getLength();

    public boolean isEmpty();
}
