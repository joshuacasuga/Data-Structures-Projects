//
//  Name:       Casuga, Joshua
//  Project:    #4
//  Course:     cs-2400-01-f22
//
//  Description: The TreeInterface. Includes methods specific
//  to trees.
//
public interface TreeInterface<T> {
    public T getRootData();

    public int getHeight();

    public int getNumberOfNodes();

    public boolean isEmpty();

    public void clear();
}