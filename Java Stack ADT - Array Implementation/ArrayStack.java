//
//  Name:       Casuga, Joshua
//  Project:    #3
//  Due:        10/21/2022
//  Course:     cs-2400-01-f22
//
//  Description:
//              Creates an array object with the properties of a stack enforced onto it.
//
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T>
{
    private BagInterface<T> stack;

    public ArrayStack()
    {
        stack = new ArrayBag<>();
    }

    public void push(T newEntry)
    {
        stack.add(newEntry);
    }

    public T pop()
    {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        else{
            return stack.remove();
        }
    }

    public T peek()
    {
        T top = pop();
        push(top);
        return top;
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public void clear()
    {
        stack.clear();
    }
}