
//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: The GraphAlgorithmsInterface that contains methods for graph traversal
//
import java.util.Queue;
import java.util.Stack;

public interface GraphAlgorithimsInterface<T> {
    public Queue<T> getBreadthFirstTraversal(T origin);

    public Queue<T> getDepthFirstTraversal(T origin);

    public Stack<T> getTopologicalOrder();

    public int getShortestPath(T begin, T end, Stack<T> path);

    public double getCheapestPath(T begin, T end, Stack<T> path);
}
