package graphs;

import java.util.ArrayList;
import java.util.Arrays;

// Basically the program is to check if a graph contains a cycle or not
public class CheckGraphIsTree {
	
	public static int V = 5;
	
	public static boolean graphIsTree(GV[] graph) {
		
		boolean visited[] = new boolean[graph.length];
		Arrays.fill(visited, false);
		
		// The call to isCyclicUtil serves multiple purposes
	    // It returns true if graph reachable from vertex 0 is cyclic.
	    // It also marks all vertices reachable from 0.
		if (graphIsTreeUtil(graph[0], visited, null)) {
			return false;
		}
		
		for (int i=0; i<V; i++) {
			if (!visited[graph[i].id()]) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean graphIsTreeUtil(GV u, boolean visited[], GV parent) {
		
		visited[u.id()] = true; // mark visited
		
		// iterate over neighbors
		for (int i=0; i<u.edges().size(); i++) {
			
			GV v = u.edges().get(i);
			
			// If an adjacent is not visited, then recur for that adjacent
			if (!visited[v.id()]) {
				if (graphIsTreeUtil(v, visited, u)) {
					return true;
				}
			}
			
			// If an adjacent is visited and not parent of current vertex,
	        // then there is a cycle.
			else if (v != parent)  {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		GV gv0 = new GV(0);
		GV gv1 = new GV(1);
		GV gv2 = new GV(2);
		GV gv3 = new GV(3);
		GV gv4 = new GV(4);
		
		gv1.addEdge(gv0);
		gv0.addEdge(gv1);
		gv2.addEdge(gv0);
		gv0.addEdge(gv2);
		gv0.addEdge(gv3);
		gv3.addEdge(gv0);
		gv3.addEdge(gv4);
		gv4.addEdge(gv3);
		
		//gv2.addEdge(gv1);
		//gv1.addEdge(gv2);
		
		
		GV[] graph = {gv0, gv1, gv2, gv3, gv4};
		
		System.out.println(graphIsTree(graph));
	}

}

class GV {
	int id;
	public ArrayList<GV> edges;
	
	public GV(int id) {
		this.id = id;
		edges = new ArrayList<GV>();
	}
	
	public void addEdge(GV edge) {
		edges.add(edge);
	}
	
	public int id() {
		return this.id;
	}
	
	public ArrayList<GV> edges() {
		return this.edges;
	}
}
