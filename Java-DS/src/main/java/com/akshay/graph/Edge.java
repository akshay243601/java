package com.akshay.graph;

public class Edge {
	private int fromNodeIndex;
	private int toNodeIndex;

	public Edge(int fromNodeIndex, int toNodeIndex, int distance) {
		super();
		this.fromNodeIndex = fromNodeIndex;
		this.toNodeIndex = toNodeIndex;
		this.distance = distance;
	}

	private int distance;

	public int getToNodeIndex() {
		return toNodeIndex;
	}

	public void setToNodeIndex(int toNodeIndex) {
		this.toNodeIndex = toNodeIndex;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getFromNodeIndex() {
		return fromNodeIndex;
	}

	public void setFromNodeIndex(int fromNodeIndex) {
		this.fromNodeIndex = fromNodeIndex;
	}

	public int getNeighbourNodeIndex(int nodeindex) {
		if (getFromNodeIndex() == nodeindex) {
			return getToNodeIndex();
		} else {
			return getFromNodeIndex();
		}
	}

}
