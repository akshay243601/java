package com.akshay.graph.shortestPathDijkistra;

public class Edge<T> {
    private Vertex<T> v1;
    private Vertex<T> v2;
    private int weight;

    public Edge(Vertex<T> v1, Vertex<T> v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Vertex<T> getV1() {
        return v1;
    }

    public void setV1(Vertex<T> v1) {
        this.v1 = v1;
    }

    public Vertex<T> getV2() {
        return v2;
    }

    public void setV2(Vertex<T> v2) {
        this.v2 = v2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", weight=" + weight +
                '}';
    }
}
