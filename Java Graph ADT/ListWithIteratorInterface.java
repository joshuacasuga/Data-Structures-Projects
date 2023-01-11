
//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: The ListIteratorInterface that contains an Iterator method
//  to be implemented with a LinkedList.
//
import java.util.Iterator;

public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T> {
    public Iterator<T> getIterator();
}
