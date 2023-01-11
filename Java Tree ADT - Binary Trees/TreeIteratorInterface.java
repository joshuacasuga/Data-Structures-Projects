//
//  Name:       Casuga, Joshua
//  Project:    #4
//  Course:     cs-2400-01-f22
//
//  Description: The TreeIteratorInterface. Includes iterator methods
//  for tree traversal -- preorder, postorder, inorder, and level order
//
import java.util.Iterator;

public interface TreeIteratorInterface<T> {
    public Iterator<T> getPreorderIterator();

    public Iterator<T> getPostorderIterator();

    public Iterator<T> getInorderIterator();

    public Iterator<T> getLevelOrderIterator();
}