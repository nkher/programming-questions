package CareerCup.Google.Latest;

public class CountTrianglesInUndirectedGraph {

	// TC = O(n^3)
	public static int countTriangles(int[][] graph) {
		int count = 0;
		int V = graph.length;
		
		for (int v=0; v<V; v++) {
			
			for (int u=v+1; u<V; u++) {
				
				if (graph[v][u] == 0) { // if there is no edge from vertex v to u
					continue;
				}
				
				// check again for another round vertices
				for (int k=u+1; k<V; k++) {
					if (graph[v][k] == 0) {
						continue;
					}
					count += graph[u][k] == 1 ? 1 : 0;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		int graph[][] =   { {0,1,1,1,1},  //a
							{0,0,1,0,0},  //b
							{0,1,0,1,0},  //c
							{1,0,1,0,0},  //d 
							{0,1,0,0,0}}; //e
		
		// triangles are -> [a -> b -> c -> a] AND [a -> d -> e -> a]
		
		System.out.println("Total number of triangles in graph : " + countTriangles(graph));
	}

}
