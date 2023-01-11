//
//  Name:       Casuga, Joshua
//  Project:    #4
//  Course:     cs-2400-01-f22
//
//  Description: The BinaryTreeInterface. Includes mutator methods
//  specific to binary trees. Extends TreeInterface and TreeIteratorInterface
//
public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T> {
    public void setRootData(T rootData);

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
            BinaryTreeInterface<T> rightTree);
}