package techgig2021.finals;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		List<Road> roads = new ArrayList<>();
		
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int numberOfHospitals = 0;
		int maxRoadsAllowed = 0;
		if (stdin.hasNext()) {
			numberOfHospitals = stdin.nextInt();
			maxRoadsAllowed = stdin.nextInt();
		}

		for (int i = 0; i < numberOfHospitals; i++) {
			roads.add(new Road(stdin.nextInt()-1, stdin.nextInt()-1));
		}
		
		Graph graph = new Graph(roads, numberOfHospitals);

	}

}

class Road {
	int start, end;

	public Road(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Hospital {
	int number;

	public Hospital(int number) {
		this.number = number;
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