
//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: The VertexInterface that includes methods for the Vertex data structure.
//
import java.util.Iterator;

public interface VertexInterface<T> {
    public T getLabel();

    public void visit();

    public void unvisit();

    public boolean isVisited();

    public boolean connect(VertexInterface<T> endVertex, double edgeWeight);

    public boolean connect(VertexInterface<T> endVertex);

    public Iterator<VertexInterface<T>> getNeighborIterator();

    public Iterator<Double> getWeightIterator();

    public boolean hasNeighbor();

    public VertexInterface<T> getUnvisitedNeighbor();

    public void setPredecessor(VertexInterface<T> predecessor);

    public VertexInterface<T> getPredecessor();

    public boolean hasPredecessor();

    public void setCost(double newCost);

    public double getCost();
}
