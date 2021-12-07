import java.util.Arrays;
import java.util.ArrayList; 

public class RoboModel {
	private boolean [][] Graph;
	
	public RoboModel (int numNodes) {
		 Graph = new boolean [numNodes][numNodes];
		 for (int i = 0; i < numNodes; i++) {
			 for (int g = 0; g < numNodes; g++) {
				 Graph[i][g] = false;
			 }
		 }
	}
	public int graphLength() {
		return Graph.length;
	}
	public void setConnections(int NodeNumber, int Connection) {
		if (NodeNumber >= graphLength() || Connection >= graphLength() || NodeNumber < 0 ||
				Connection < 0) {
			
		}
		else {
		Graph[NodeNumber][Connection] = true;
		}
	}
	
	public Boolean isSolvable(int startingnode) {
		int Length = Graph.length;
		//Creates an array to keep track of visited
		String visited[];
		visited = new String [Length];
		//fixes nullpointerexception
		for (int a = 0; a < Length; a++) {
			visited[a] = ".";
		}
		//Creates queue
		Queue<Integer> solveQueue = new QueueImplementation<Integer>();
		//Assigns first spot for queue
		solveQueue.add(startingnode);
		while (solveQueue.isEmpty() == false) {
			int current = solveQueue.Peek();
			solveQueue.remove();
			for (int i = 0; i < Graph.length; i++) {
				if (Graph[current][i] == true && !visited[i] .equals("visited")) {
					solveQueue.add(i);
				}
			}
			//Marks as visited
			if (!visited[current] .equals("visited")) {
				visited[current] = "visited";
			}
			
		}
		for (int o = 0; o < visited.length; o++) {
			if (!visited[o] .equals("visited")) {
				return false;
			}
		}
		return null;
	}
	
}
