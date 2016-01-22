package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

	// the following function is for a Directed Graph
	// Space complexity : O(|V| + |E|) which is the space for the result.
	// If we exclude the result then it is O(|V|)
	// Time complexity : Same as BFS which is O(|V| + |E|)
	public GraphVertex cloneGraph(GraphVertex gv) {
		if (gv == null) return null;
		
		Queue<GraphVertex> queue = new LinkedList<GraphVertex>();
		HashMap<GraphVertex, GraphVertex> cloneMap = new HashMap<GraphVertex, GraphVertex>();
		
		// add the starting node to the hashmap (create a new copy) and queue
		cloneMap.put(gv, new GraphVertex(gv.getId()));
		queue.add(gv); 
		
		while (!queue.isEmpty()) {
			GraphVertex u = queue.remove(); // get the head of the queue
						
			//Iterate over its edges
			for (GraphVertex v : u.edges()) {				
				
				// check if the edge is present in the map or not and if not 
				// put the neighbor in the queue and make a new copy of the neighbor in the hashmap
				if (!cloneMap.containsKey(v)) {
					cloneMap.put(v, new GraphVertex(v.getId())); 
					queue.add(v); // add the current neighbor from the existing graph to the queue
				}		
				
				/* HOW TO ADD THE NEIGHBOR TO THE CLONED GRAPH VERTEX */ 
				// This is the most important step, do not do --> u.addNeighbor(cloneMap.get(v)); else you will get a concurrentmodificationexception
				// add the neighbor edge/vertex to the edges list from the hashmap
				// We cannot add to u as u is referring to the existing graph
				// Follow the steps carefully
				
				GraphVertex clonedCurrent = cloneMap.get(u); // get the clone of the current vertex you are visiting from the clonedMap
				clonedCurrent.addNeighbor(cloneMap.get(v)); // add the cloned neighbor from the clonedMap to the clonedCurrent vertex
				cloneMap.put(u, clonedCurrent); // add the clonedCurrent vertex with the added cloned edge to the map again 				
			}	
		}
		return cloneMap.get(gv); // Will returned the cloned starting node
	}
	
	public void bfs(GraphVertex gv) {
		
		if (gv == null) return;
		Queue<GraphVertex> queue = new LinkedList<GraphVertex>();
		Set<GraphVertex> visited = new HashSet<GraphVertex>();
		
		queue.add(gv);
		visited.add(gv); // means it is visited
		
		while (!queue.isEmpty()) {
			GraphVertex u = queue.remove(); // remove the head of the queue
			
			System.out.println("Visiting vertex id : " + u.getId());
			
			// Iterate over its edges, mark visited and add to the queue, after checking if it is not already visisted
			for (GraphVertex v : u.edges()) {
				if (!visited.contains(v)) {
					visited.add(v);
					queue.add(v);
				}
			}
		}
 	}
	
	public static void main(String[] args) {
		
		CloneGraph cg = new CloneGraph();
		
		// Creating a directed graph
		GraphVertex gv1 = new GraphVertex(1);
		GraphVertex gv2 = new GraphVertex(2);
		GraphVertex gv3 = new GraphVertex(3);
		GraphVertex gv4 = new GraphVertex(4);
		
		// Adding edges to the graph
		gv1.addNeighbor(gv3);
		
		gv2.addNeighbor(gv4);
		
		gv3.addNeighbor(gv2);
		
		gv4.addNeighbor(gv2);
		gv4.addNeighbor(gv1);
		
		// Perform a BFS on the created directed graph
		cg.bfs(gv1);
		System.out.println("\nBFS Done on existing graph\n");

		// Perform a clone on the graph
		GraphVertex clonedGV1 = cg.cloneGraph(gv1);
		
		// Perform a BFS on the cloned created directed graph
		cg.bfs(clonedGV1);
		System.out.println("\nBFS Done on cloned graph\n");
	}
}

class GraphVertex {
	private int id;
	private ArrayList<GraphVertex> edges;
	
	public GraphVertex(int id) {
		this.id = id;
		edges = new ArrayList<GraphVertex>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void addNeighbor(GraphVertex neighbor) {
		edges.add(neighbor);
	}
	
	public ArrayList<GraphVertex> edges() {
		return edges;
	}
}
