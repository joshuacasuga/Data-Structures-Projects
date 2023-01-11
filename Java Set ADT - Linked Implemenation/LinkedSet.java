//  Description:
//              Uses Set ADT to insert entries into Linked Sets.
//              Linked Sets are compared using subset(), union(), and equals() methods.
//
public final class LinkedSet<T> implements SetInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedSet()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class Node
    {
        private T data;
        private Node next;
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
        private T getData()
        {
            return data;
        }
        private void setData(T newData)
        {
            data = newData;
        }
        private Node getNextNode()
        {
            return next;
        }
        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    }

    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode!=null))
        {
            if(anEntry.equals(currentNode.data))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries==0;
    }

    public boolean add(T newEntry) {
        if(contains(newEntry))
        {
            return false;
        }
        else
        {
            Node newNode = new Node(newEntry);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
            numberOfEntries++;
            return true;
        }
    }

    public T remove() {
        T result = null;
        if(firstNode!=null)
        {
            result = firstNode.getData();
            firstNode = firstNode.next; //removes first node from chain
            numberOfEntries--;
        }
        return result;
    }

    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if(nodeN!=null)
        {
            nodeN.data = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    public void clear() {
        while(!isEmpty())
            remove();
        numberOfEntries = 0;
    }

    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;

        while((loopCounter < numberOfEntries) && (currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
            {
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode!=null))
        {
            if(anEntry.equals(currentNode.data))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int i=0;
        Node currentNode = firstNode;
        while((i<numberOfEntries) && (currentNode!=null))
        {
            result[i] = currentNode.data;
            i++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

    public String toString()
    {
        Node currentNode = firstNode;
        StringBuilder result = new StringBuilder();
        if(isEmpty())
        {
            result.append("{}");
            return result.toString();
        }
        else if (!isEmpty() && currentNode!=null && currentNode.getNextNode()==null)
        {
            result.append("{ " + currentNode.getData() + " }");
            return result.toString();
        }
        result.append("{ ");
        while(currentNode!=null)
        {
            if(currentNode.getNextNode()!=null)
            {
                result.append(currentNode.getData() + ",");
                currentNode = currentNode.getNextNode();
            }
            else
            {
                result.append(currentNode.getData() + " }");
                return result.toString();
            }
            result.append(currentNode.getData() + ",");
            currentNode = currentNode.getNextNode();
        }
        return result.toString();
    }

    public boolean subset(SetInterface rhs) {
        boolean result = false;
        Node currentNode = firstNode;
        if(currentNode!=null)
        {
            if (!rhs.contains(currentNode.getData()))
            {
                return false;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
            result = true;
        }
        else
        {
            result = true;
        }
        return result;
    }

    public boolean equals(SetInterface rhs) {
        boolean result = false;
        if(getCurrentSize() == rhs.getCurrentSize())
        {
            Node currentNode = firstNode;
            int index = 0;
            while((index<numberOfEntries) && (currentNode!=null))
            {
                if(!rhs.contains(currentNode.getData()))
                {
                    return false;
                }
                else
                {
                    index++;
                    currentNode=currentNode.getNextNode();
                }
            }
            result = true;
        }
        return result;
    }

    public SetInterface union(SetInterface rhs)
    {
        SetInterface<T> both = new LinkedSet<>();
        for(int i=0; i<numberOfEntries; i++)
        {
            both.add(toArray()[i]);
        }
        for(int j=0; j<rhs.getCurrentSize(); j++)
        {
            both.add((T)rhs.toArray()[j]);
        }
        return both;
    }
}
