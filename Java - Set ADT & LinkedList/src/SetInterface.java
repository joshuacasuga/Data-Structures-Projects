//  Description:
//              Uses Set ADT to insert entries into Linked Sets.
//              Linked Sets are compared using subset(), union(), and equals() methods.
//
public interface SetInterface<T>
{
    /**
     * Gets current size of a set
     * @return Size of the set
     */
    int getCurrentSize();

    /**
     * Checks if a set is empty
     * @return True if set is empty, false if not
     */
    boolean isEmpty();

    /**
     * Adds an entry to the set
     * @param newEntry The entry to be added
     * @return True if operation was successful, false if not
     */
    boolean add(T newEntry);

    /**
     * Removes the first node in the chain
     * @return The removed entry, if it was successful or not, or null
     */
    T remove();

    /**
     * Removes a certain node in the chain
     * @param anEntry The entry to be removed
     * @return True if removal was successful, false if not
     */
    boolean remove(T anEntry);

    /**
     * Removes all entries in the set
     */
    void clear();

    /**
     * Counts how many times a piece of data occurs in the set
     * @param anEntry The entry to be counted
     * @return The number of times anEntry appears in the set
     */
    int getFrequencyOf(T anEntry);

    /**
     * Checks if a certain piece of data is in the set
     * @param anEntry The entry to locate
     * @return True if the set contains the entry, false if not
     */
    boolean contains(T anEntry);

    /**
     * Returns a newly allocated array of all entries in the Linked List
     * @return A newly allocated array of all entries in the Linked List
     */
    T[] toArray();

    /**
     * Compares the set that calls it to the parameter set; checks if it is a subset of the parameter set
     * @param rhs The set to be compared
     * @return True if the set that called it is a subset of rhs, false if not
     */
    boolean subset(SetInterface rhs);

    /**
     * Compares the set that calls it to the parameter set; checks if it is equal to the parameter set
     * @param rhs The set to be compared
     * @return True if the set that called it is equal to rhs, false if not
     */
    boolean equals(SetInterface rhs);

    /**
     * Returns a new set that stores the data as a list of non-repeated values
     * @param rhs The set to be compared
     * @return A new set that stores the data as a list of non-repeated values
     */
    SetInterface union(SetInterface rhs);

    /**
     * Returns a formatted string of the data in a set
     * @return A formatted string of the data in a set
     */
    String toString();
}
