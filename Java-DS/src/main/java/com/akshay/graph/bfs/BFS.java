package com.akshay.graph.bfs;

import com.akshay.graph.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	Queue<Vertex> queue = null;

	public BFS() {
		queue = new LinkedList<Vertex>();
	}

	public void bfs(List<Vertex> list) {
		for (Vertex vertex : list) {
			if (!vertex.isVisited()) {
				vertex.setVisited(true);
				bfsVisited(vertex);
			}
		}
	}

	private void bfsVisited(Vertex vertex) {
		queue.add(vertex);
		while (!queue.isEmpty()) {
			Vertex actualVertex = queue.poll();
			System.out.print(actualVertex.getName() + " ");
			for (Vertex v : actualVertex.getNeighbour()) {
				if (!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
	}
}
