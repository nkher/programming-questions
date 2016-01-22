package graphs;

public class DijkstrasShortestPath {
	
	public static final int V = 9;
	
	public int minDist(int dist[], boolean sptSet[]) {
		int min = Integer.MAX_VALUE, minInd = -1;
		for (int i=0;i<V;i++) {
			if (dist[i] <= min && !sptSet[i]) {
				min = dist[i];
				minInd = i;
			}
		}
		return minInd;
	}
	
	public void dijkstra(int graph[][], int src) {
		int dist[] = new int[V];
		boolean sptSet[] = new boolean[V];
		
		for (int i=0;i<V;i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src] = 0;
		
		for (int count=0;count<V;count++) {
			
			// pick the min distance vertex
			int u = minDist(dist, sptSet);
			
			// mark it as visited
			sptSet[u] = true;
			
			// iterate over its neighbors
			for (int v=0;v<V;v++) {
				
				if (graph[u][v] > 0 && !sptSet[v] && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = graph[u][v] + dist[u];
				}
			}
		}
		
		printSol(dist);
	}
	
	public void printSol(int dist[]) {
		System.out.println("Vertex \t Distance from source");
		for (int i=0;i<V;i++) {
			System.out.println(i + "\t" + dist[i]);
		}
	}
	
	public static void main(String[] args) {
		
		DijkstrasShortestPath dsp = new DijkstrasShortestPath();
		
		/* Let us create the example graph discussed above */
		   int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
		                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
		                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
		                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
		                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
		                      {0, 0, 4, 0, 10, 0, 2, 0, 0},
		                      {0, 0, 0, 14, 0, 2, 0, 1, 6},
		                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
		                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
		                     };
		   
		   dsp.dijkstra(graph, 0);
	}

}
