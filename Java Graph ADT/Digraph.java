
//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: The Digraph class that contains implementation for the basic graph interface
//  and graph algorithms interface. 
//
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Digraph<T> implements GraphInterface<T> {
    private HashMap<T, VertexInterface<T>> vertices;
    private int edgeCount;

    public Digraph() {
        vertices = new HashMap<>();
        edgeCount = 0;
    }

    public boolean addVertex(T vertexLabel) {
        VertexInterface<T> addOutcome = vertices.put(vertexLabel, new Vertex<>(vertexLabel));
        return addOutcome == null;
    }

    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if ((beginVertex != null) && (endVertex != null)) {
            result = beginVertex.connect(endVertex, edgeWeight);
        }
        if (result) {
            edgeCount++;
        }
        return result;
    }

    public boolean addEdge(T begin, T end) {
        return addEdge(begin, end, 0);
    }

    public boolean hasEdge(T begin, T end) {
        boolean found = false;
        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        if ((beginVertex != null) && (endVertex != null)) {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor)) {
                    found = true;
                }
            }
        }
        return found;
    }

    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    public int getNumberOfVertices() {
        return vertices.size();
    }

    public int getNumberOfEdges() {
        return edgeCount;
    }

    public void clear() {
        vertices.clear();
        edgeCount = 0;
    }

    public void resetVertices() {
        Iterator<VertexInterface<T>> vertexIterator = vertices.values().iterator();
        while (vertexIterator.hasNext()) {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    }

    public Queue<T> getBreadthFirstTraversal(T origin) {
        resetVertices();
        Queue<T> traversalOrder = new PriorityQueue<>();
        Queue<VertexInterface<T>> vertexQueue = new PriorityQueue<>();
        VertexInterface<T> originVertex = vertices.get(origin);
        originVertex.visit();
        traversalOrder.add(origin);
        vertexQueue.add(originVertex);

        while (!vertexQueue.isEmpty()) {
            VertexInterface<T> frontVertex = vertexQueue.remove();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

            while (neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited()) {
                    nextNeighbor.visit();
                    traversalOrder.add(nextNeighbor.getLabel());
                    vertexQueue.add(nextNeighbor);
                }
            }
        }
        return traversalOrder;
    }

    public Queue<T> getDepthFirstTraversal(T origin) {
        // not implemented
        return null;
    }

    public Stack<T> getTopologicalOrder() {
        // not implemented
        return null;
    }

    public int getShortestPath(T begin, T end, Stack<T> path) {
        resetVertices();
        boolean done = false;
        Queue<VertexInterface<T>> vertexQueue = new PriorityQueue<>();
        VertexInterface<T> originVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        originVertex.visit();

        vertexQueue.add(originVertex);
        while (!done && !vertexQueue.isEmpty()) {
            VertexInterface<T> frontVertex = vertexQueue.remove();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            while (!done && neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited()) {
                    nextNeighbor.visit();
                    nextNeighbor.setCost(1 + frontVertex.getCost());
                    nextNeighbor.setPredecessor(frontVertex);
                    vertexQueue.add(nextNeighbor);
                }
                if (nextNeighbor.equals(endVertex)) {
                    done = true;
                }
            }
        }
        int pathLength = (int) endVertex.getCost();
        path.push(endVertex.getLabel());

        VertexInterface<T> vertex = endVertex;
        while (vertex.hasPredecessor()) {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
        }

        return pathLength;
    }

    public double getCheapestPath(T begin, T end, Stack<T> path) {
        resetVertices();
        boolean done = false;
        PriorityQueue<EntryPQ> priorityQueue = new PriorityQueue<>();
        VertexInterface<T> originVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);
        priorityQueue.add(new EntryPQ(originVertex, 0, null));

        while (!done && !priorityQueue.isEmpty()) {
            EntryPQ frontEntry = priorityQueue.remove();
            VertexInterface<T> frontVertex = frontEntry.getVertex();

            if (!frontVertex.isVisited()) {
                frontVertex.visit();
                frontVertex.setCost(frontEntry.getCost());
                frontVertex.setPredecessor(frontEntry.getPredecessor());

                if (frontVertex.equals(endVertex)) {
                    done = true;
                } else {
                    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
                    Iterator<Double> edgeWeights = frontVertex.getWeightIterator();

                    while (neighbors.hasNext()) {
                        VertexInterface<T> nextNeighbor = neighbors.next();
                        Double weightOfEdgeToNeighbor = edgeWeights.next();

                        if (!nextNeighbor.isVisited()) {
                            double nextCost = weightOfEdgeToNeighbor + frontVertex.getCost();
                            priorityQueue.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
                        }
                    }
                }
            }
        }
        double pathCost = endVertex.getCost();
        path.push(endVertex.getLabel());
        VertexInterface<T> vertex = endVertex;
        while (vertex.hasPredecessor()) {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
        }
        return pathCost;
    }

    private class EntryPQ implements Comparable<EntryPQ>, java.io.Serializable {
        private VertexInterface<T> vertex;
        private VertexInterface<T> previousVertex;
        private double cost;

        private EntryPQ(VertexInterface<T> vertex, double cost, VertexInterface<T> previousVertex) {
            this.vertex = vertex;
            this.previousVertex = previousVertex;
            this.cost = cost;
        }

        public VertexInterface<T> getVertex() {
            return vertex;
        }

        public VertexInterface<T> getPredecessor() {
            return previousVertex;
        }

        public double getCost() {
            return cost;
        }

        public int compareTo(EntryPQ otherEntry) {
            if (cost < otherEntry.getCost()) {
                return -1;
            } else if (cost > otherEntry.getCost()) {
                return 1;
            } else {
                return 0;
            }
        }

        public String toString() {
            return vertex.toString() + " " + cost;
        }
    }

}