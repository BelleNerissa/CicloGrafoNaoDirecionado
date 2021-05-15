package com.pucmges.graph;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	private final List<Vertex> vertices;
	private final List<Edge> edges;

	/**
	 * Metodo construtor
	 * 
	 */
	public Graph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	public Graph(List<Vertex> vertices, List<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}

	/**
	* 	retorna lista de vertices do grafo
	 */
	public List<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * retorna lista de vertices do grafo      .
	 */
	public List<Edge> getEdges() {
		return edges;
	}

	/**
	 * Remove aresta do grafo
	 * 
	 */
	public void removeEdge(Edge edge) {
		edges.remove(edge);
	}

	/**
	 * Pesquisa por vertices vizinhos
	 * 
	 */
	public Set<Vertex> getNeighbors(Vertex node) {
		Set<Vertex> neighbors = new HashSet<Vertex>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node)) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	/**
	 * Adiciona arestas de origem e retorno (grafo não direcionado)
	 */
	public void addBidirectionalEdge(Point src, Point dest) {
		Vertex sourceVertex = new Vertex("Vertex (" + src.getX() + "," + src.getY() + ")", src);
		Vertex destinationVertex = new Vertex("Vertex (" + dest.getX() + "," + dest.getY() + ")", dest);

		if (!vertices.contains(sourceVertex)) {
			vertices.add(sourceVertex);                                                                           
		}

		if (!vertices.contains(destinationVertex)) {
			vertices.add(destinationVertex);
		}

		edges.add(new Edge(sourceVertex, destinationVertex));
		edges.add(new Edge(destinationVertex, sourceVertex));
	}

	@Override
	public String toString() {
		return "Graph [vertices=" + vertices + ", edges=" + edges + "]";
	}
}
