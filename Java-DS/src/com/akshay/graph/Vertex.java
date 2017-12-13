package com.akshay.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private List<Vertex> neighbour;
	private boolean isVisited;

	public Vertex(String name) {
		this.setName(name);
		this.setNeighbour(new ArrayList<>());
	}

	public void addNeighbour(Vertex v) {
		this.neighbour.add(v);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vertex> getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(List<Vertex> neighbour) {
		this.neighbour = neighbour;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
}
