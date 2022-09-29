//  Description:
//          Reads a file javakeywords.txt and uses Bag ADT to insert entries from file into
//          a bag. Program takes parameters and checks if parameters are existing entries in the bag.
//          Tests for unused methods are commented off using javadoc.
//

public final class ArrayBag<T> implements BagInterface<T>
{
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 100;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    //private methods
    private void checkIntegrity() //if integrityOK is false, throw an exception
    {
        if (!integrityOK)
        {
            throw new SecurityException("ArrayBag object is corrupt.");
        }
    }

    private int getIndexOf(T anEntry)
    {
        int loc = -1;
        boolean found = false;
        int index = 0;

        while(!found && (index<numberOfEntries))
        {
            if(anEntry.equals(bag[index]))
            {
                found = true;
                loc = index;
            }
            index++;
        }
        return loc;
    }

    private T removeEntry(int givenIndex)
    {
        T result = null;
        if(!isEmpty() && (givenIndex >=0))
        {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries-1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }


    //BagInterface methods
    public ArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int desiredCapacity) //class constructor
    {
        /**
         * checks if the bag created exceeds MAX_CAPACITY
         */
        if(desiredCapacity <= MAX_CAPACITY)
        {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        }
        else
        {
            throw new IllegalStateException("Attempt to create a bag whose " +
                    "capacity exceeds allowed maximum.");
        }
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    private boolean isArrayFull()
    {
        return numberOfEntries >= bag.length;
    }

    public boolean add(T newEntry) {
        checkIntegrity();
        boolean result = true;
        if (isArrayFull()) //Checks if array is full; if not, add entry
        {
            result = false;
        }
        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    public T remove()
    {
        checkIntegrity();
        T result = null;
        if(numberOfEntries > 0)
        {
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null; //sets last entry to null
            numberOfEntries--; //decrements numberOfEntries
        }
        return result;
    }

    public boolean remove(T anEntry)
    {
        int index = getIndexOf(anEntry); //gets index of parameter
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }

    public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int count = 0;
        for(int i = 0; i < numberOfEntries; i++)
        {
            if(anEntry.equals(bag[i]))
            {
                count++;
            }
        }
        return count;
    }

    public boolean contains(T anEntry)
    {
        checkIntegrity();
        boolean found = false;
        int i = 0;
        while(!found && (i<numberOfEntries))
        {
            if(anEntry.equals(bag[i]))
            {
                found = true;
            }
            i++;
        }
        return found;
    }

    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++)
        {
            result[i] = bag[i];
        }
        return result;
    }
}
