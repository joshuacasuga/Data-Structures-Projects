//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: The BasicGraphInterface that contains the basic methods for graphs.
//
public interface BasicGraphInterface<T> {
    public boolean addVertex(T vertexLabel);

    public boolean addEdge(T begin, T end, double edgeWeight);

    public boolean addEdge(T begin, T end);

    public boolean hasEdge(T begin, T end);

    public boolean isEmpty();

    public int getNumberOfVertices();

    public int getNumberOfEdges();

    public void clear();
}
