package techgig2021.semifinals;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		List<Road> roads = new ArrayList<>();
		
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfHouses = 0;
		int numberOfRoads = 0;
		if (stdin.hasNext()) {
			numberOfHouses = stdin.nextInt();
			numberOfRoads = stdin.nextInt();
		}

		for (int i = 0; i < numberOfRoads; i++) {
			roads.add(new Road(stdin.nextInt()-1, stdin.nextInt()-1, stdin.nextInt()));
		}
		Graph graph = new Graph(roads, numberOfHouses);
		printShortestPath(graph, 0, numberOfHouses - 1, numberOfHouses);
	}
	
	private static void getRoute(int[] prev, int i, List<Integer> route) {
		if (i >= 0) {
			getRoute(prev, prev[i], route);
			route.add(i);
		}
	}

	public static void printShortestPath(Graph graph, int rahulHouse, int gfHouse, int numberOfHouses) {

		
		
		PriorityQueue<House> queue;
		queue = new PriorityQueue<>(Comparator.comparingInt(house -> house.cost));
		queue.add(new House(rahulHouse, 0));

		List<Integer> minDisFromRahulHouse;
		minDisFromRahulHouse = new ArrayList<>(Collections.nCopies(numberOfHouses, Integer.MAX_VALUE));

		minDisFromRahulHouse.set(rahulHouse, 0);

		boolean[] done = new boolean[numberOfHouses];
		done[rahulHouse] = true;

		// stores predecessor of a vertex (to a print path)
        int[] prev = new int[numberOfHouses];
        prev[rahulHouse] = -1;
        
        List<Integer> route = new ArrayList<>();
		
		while (!queue.isEmpty()) {
			House house = queue.poll();

			int u = house.number;

			for (Road road : graph.adjacantList.get(u)) {
				int v = road.end;
				int cost = road.cost;
				
				int normalizedCost = (cost - minDisFromRahulHouse.get(u)) < 0 ? 0 : (cost - minDisFromRahulHouse.get(u));
				
				if (!done[v] && (minDisFromRahulHouse.get(u) + normalizedCost) < minDisFromRahulHouse.get(v)) {
					minDisFromRahulHouse.set(v, minDisFromRahulHouse.get(u) + normalizedCost);
					prev[v] = u;
					queue.add(new House(v, minDisFromRahulHouse.get(v)));
				}
			}

			done[u] = true;
		}

		if (gfHouse != rahulHouse) {
			getRoute(prev, gfHouse, route);
            System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
            		rahulHouse, gfHouse, minDisFromRahulHouse.get(gfHouse), route);
            route.clear();
		} else {
			System.out.print("NOT POSSIBLE");
		}
	}


}

class Road {
	int start, end, cost;

	public Road(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

class House {
	int number, cost;

	public House(int number, int cost) {
		this.number = number;
		this.cost = cost;
	}
}

class Graph {

	List<List<Road>> adjacantList = null;

	Graph(List<Road> roads, int numberOfHouses) {
		adjacantList = new ArrayList<>();

		for (int i = 0; i < numberOfHouses; i++) {
			adjacantList.add(new ArrayList<>());
		}

		for (Road road : roads) {
			adjacantList.get(road.start).add(road);
		}
	}
}
