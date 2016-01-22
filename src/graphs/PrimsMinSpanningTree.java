package graphs;


/*
 * Time Complexity of the above program is O(V^2). 
 * If the input graph is represented using adjacency list, then the time complexity of Prim’s algorithm 
 * can be reduced to O(E log V) with the help of binary heap. We will soon be discussing O(E Log V) algorithm as a separate post.
 */

public class PrimsMinSpanningTree {
	
	public static final int V = 5;
	
	// A utility function to find the vertex with minimum key value, from
	// the set of vertices not yet included in MST
	// This actually returns the index of the min vertex in the key array
	public int minKey(int key[], boolean mstSet[]) {
		int min = Integer.MAX_VALUE, minInd = 0;
		
		for (int i=0;i<V;i++) {
			if (!mstSet[i] && key[i] < min) {
				min = key[i];
				minInd = i;
			}
		}
		return minInd;
	}
	
	public void primMST(int graph[][]) {
		
		int parent[] = new int[V]; // stores the constructed mst
		boolean mstSet[] = new boolean[V];
		int key[] = new int[V];
		
		// initialize all keys as infinite
		for (int i=0;i<V;i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		key[0] = 0; // making the first key or starting key accessible first
		parent[0] = -1;
		
		for (int count=0;count<V-1;count++) {
			
			// get the min vertex
			int u = minKey(key, mstSet);
			
			// add the picked vertex to the mstSet
			mstSet[u] = true;
			
			// Update key value and parent index of the adjacent vertices of
	        // the picked vertex. Consider only those vertices which are not yet
	        // included in MST
			for (int v=0;v<V;v++) {
				
				// only if there is an edge in between u and v
				// v is unvisited that is, it is not yet included in the mst
				// graph[u][v] < key[v]
				if (graph[u][v] > 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		
		printMST(parent, V, graph);
	}
	
	public void printMST(int parent[], int n, int graph[][]) {
		System.out.println(" Edge \t Weight");
		for (int i=1;i<V;i++) {
			System.out.println(parent[i] + " - " +  i + "\t" + graph[parent[i]][i]);
		}
	}
	
	public static void main(String[] args) {
		
		  int graph[][] = {{0, 2, 0, 6, 0},
                  {2, 0, 3, 8, 5},
                  {0, 3, 0, 0, 7},
                  {6, 8, 0, 0, 9},
                  {0, 5, 7, 9, 0},
                 };
		  
		  PrimsMinSpanningTree primMST = new PrimsMinSpanningTree();
		  primMST.primMST(graph);
	}
}


