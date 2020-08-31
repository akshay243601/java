package com.akshay.graph.shortestPathDijkistra;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private T name;
    private boolean isVisited;
    private List<Edge<T>> edges = new ArrayList<>();

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<T>> edges) {
        this.edges = edges;
    }

    public List<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }

    private List<Vertex<T>> neighbours = new ArrayList<>();

    public Vertex(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void addNeighbour(Vertex<T> v, Edge<T> edge) {
        this.edges.add(edge);
        this.neighbours.add(v);
    }
}
