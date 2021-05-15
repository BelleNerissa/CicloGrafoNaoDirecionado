package com.pucmges.app;

import java.awt.Point;
import java.util.List;
import java.util.Scanner;

import com.pucmges.graph.CycleUtil;
import com.pucmges.graph.Graph;

public class App {
	public static void clearScreen() {  
		Scanner scan = new Scanner(System.in);
     	System.out.print("\n\n Pressione qualquer tecla para continuar. ");
    	 scan.nextLine();
		System.out.print("\033[H\033[2J");  
		System.out.flush(); 
		scan.close();
		 
	} 
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addBidirectionalEdge(new Point(0, 0), new Point(0, 1));
		g.addBidirectionalEdge(new Point(0, 1), new Point(3, 1));
		g.addBidirectionalEdge(new Point(3, 1), new Point(3, 0));
		g.addBidirectionalEdge(new Point(3, 0), new Point(0, 0));
		g.addBidirectionalEdge(new Point(3, 1), new Point(6, 1));
		g.addBidirectionalEdge(new Point(6, 1), new Point(6, 0));
		g.addBidirectionalEdge(new Point(6, 0), new Point(3, 0));
		long start = System.currentTimeMillis();
		CycleUtil cycleUtil = new CycleUtil(g);
		List<Graph> cycles = cycleUtil.listAllCycles();
		long end = System.currentTimeMillis();
		for (Graph cycle : cycles) {
			System.out.println("Caminho dos vertices do ciclo: ");
			System.out.println("\t"+ cycle.getVertices());
		}
		System.out.print ("⏲️   Tempo de execução: " + (end - start) + " ms (milisegundos)");
		clearScreen();
	}


}
