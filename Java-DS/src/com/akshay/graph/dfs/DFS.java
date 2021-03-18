package com.akshay.graph.dfs;

import com.akshay.graph.Vertex;

import java.util.List;
import java.util.Stack;

public class DFS {

	Stack<Vertex> stack;

	public DFS() {
		stack = new Stack<>();
	}

	public void dfs(List<Vertex> list) {
		for (Vertex v : list) {
			if (!v.isVisited()) {
				v.setVisited(true);
				dfsWithStack(v);
			}
		}
	}

	// Its mostly simmiliar to Tree Level order treversal [If we replace stack with queue]
	private void dfsWithStack(Vertex rootVertex) {
		this.stack.push(rootVertex);
		while (!stack.isEmpty()) {
			Vertex actualVertex = this.stack.pop();
			System.out.println(actualVertex.getName() + "  ");
			for (Vertex vertex : actualVertex.getNeighbour()) {
				if (!vertex.isVisited()) {
					vertex.setVisited(true);
					this.stack.push(vertex);
				}
			}
		}
	}
}
