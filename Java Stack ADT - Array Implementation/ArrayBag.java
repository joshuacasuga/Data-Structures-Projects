//
//  Name:       Casuga, Joshua
//  Project:    #3
//  Due:        10/21/2022
//  Course:     cs-2400-01-f22
//
//  Description:
//              Creates an array object with the properties of a bag enforced onto it.
//
public class ArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 256;
    private static final int MAX_CAPACITY = 10000;

    public ArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int desiredCapacity)
    {
        if (desiredCapacity <= MAX_CAPACITY)
        {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
        }
        else {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }

    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry)
    {
        boolean result = true;
        if (numberOfEntries >= bag.length){
            result = false;
        }
        else{
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }

        return result;
    }

    public T remove()
    {
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    public boolean remove(T anEntry) {
        return false;
    }

    public void clear()
    {
        while (!isEmpty()){
            remove();
        }
    }

    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    public boolean contains(T anEntry) {
        return false;
    }

    public T[] toArray() {
        return null;
    }

    private T removeEntry(int givenIndex)
    {
        T result = null;

        if (!isEmpty() && givenIndex >= 0){
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }

        return result;
    }

    private void checkCapacity(int capacity)
    {
        if(capacity>MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose" +
                    "capacity exceeds allowed maximum of " + MAX_CAPACITY);
    }
}