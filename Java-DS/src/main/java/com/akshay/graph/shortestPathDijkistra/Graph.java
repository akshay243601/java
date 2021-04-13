package com.akshay.graph.shortestPathDijkistra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, Vertex<T>> allVertex = new HashMap<>();
    private List<Edge<T>> allEdges = new ArrayList<>();
    private boolean isDirected = false;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public Map<T, Vertex<T>> getAllVertex() {
        return allVertex;
    }

    public void setAllVertex(Map<T, Vertex<T>> allVertex) {
        this.allVertex = allVertex;
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(List<Edge<T>> allEdges) {
        this.allEdges = allEdges;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public void addEdge(T id1, T id2, int weight) {
        Vertex<T> v1 = null;
        if(this.allVertex.containsKey(id1)) {
            v1 = this.allVertex.get(id1);
        } else {
            v1 = new Vertex<>(id1);
            this.allVertex.put(id1, v1);
        }

        Vertex<T> v2 = null;
        if(this.allVertex.containsKey(id2)) {
            v2 = this.allVertex.get(id2);
        } else {
            v2 = new Vertex<>(id2);
            this.allVertex.put(id2, v2);
        }
        Edge<T> edge = new Edge<T>(v1, v2, weight);
        v1.addNeighbour(v2, edge);
        if(isDirected) {
            v2.addNeighbour(v1, edge);
        }
    }
}
