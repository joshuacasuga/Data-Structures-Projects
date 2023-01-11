/**
 * Name:       Casuga, Joshua
 * Project:    #3
 * Due:        10/21/2022
 * Course:     cs-2400-01-f22
 * Description:
 * An interface that enforces the properties of a Stack onto the Array data type.
 */
public interface StackInterface <T>
{
    /**
     * Adds an entry to the top of the stack
     * @param newEntry The entry to be added
     */
    public void push(T newEntry);

    /**
     * Removes the top entry of the stack
     * @return The removed entry
     */
    public T pop();

    /**
     * Returns the top entry of the stack
     * @return The top entry of the stack
     */
    public T peek();

    /**
     * Checks if the stack is empty
     * @return True if the stack is empty, false if not
     */
    public boolean isEmpty();

    /**
     * Removes all entries in the stack
     */
    public void clear();
}
