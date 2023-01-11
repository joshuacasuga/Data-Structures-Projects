//
//  Name:       Casuga, Joshua
//  Project:    #4
//  Course:     cs-2400-01-f22
//
//  Description: The implementation for a binary tree. Includes
//  constructors for binary trees, accessor and mutator methods for
//  binary tree data. Implements the BinaryTreeInterface.
//
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
    protected BinaryNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootData) {
        root = new BinaryNode<>(rootData);
    }

    public BinaryTree(T rootData, BinaryTree<T> leftTree,
            BinaryTree<T> rightTree) {
        initializeTree(rootData, leftTree, rightTree);
    }

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
            BinaryTreeInterface<T> rightTree) {
        initializeTree(rootData, (BinaryTree<T>) leftTree,
                (BinaryTree<T>) rightTree);
    }

    private void initializeTree(T rootData, BinaryTree<T> leftTree,
            BinaryTree<T> rightTree) {
        root = new BinaryNode<>(rootData);
        if ((leftTree != null) && !leftTree.isEmpty())
            root.setLeftChild(leftTree.root.copy());
        if ((rightTree != null) && !rightTree.isEmpty())
            root.setRightChild(rightTree.root.copy());
    }

    public T getRootData() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return root.getData();
    }

    public int getHeight() {
        int height = 0;
        if (root != null)
            height = root.getHeight();
        return height;
    }

    public int getNumberOfNodes() {
        int numberOfNodes = 0;
        if (root != null)
            numberOfNodes = root.getNumberOfNodes();
        return numberOfNodes;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public Iterator<T> getPreorderIterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> getPostorderIterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> getInorderIterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> getLevelOrderIterator() {
        throw new UnsupportedOperationException();
    }

    public void setRootData(T rootData) {
        root.setData(rootData);
    }

    protected void setRootNode(BinaryNode<T> rootNode) {
        root = rootNode;
    }

    protected BinaryNode<T> getRootNode() {
        return root;
    }
}