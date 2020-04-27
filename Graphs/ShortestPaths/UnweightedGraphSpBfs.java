//complexity=0(V+E)
package ShortestPaths;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class UnweightedGraphSpBfs {
	
	// This class represents a directed graph using adjacency 
    // list representation 
    static class Graph  
    { 
        int V; // No. of vertices 
        Vector<Integer>[] adj; // No. of vertices 
  
        static int level; 
  
        // Constructor 
        @SuppressWarnings("unchecked") 
        Graph(int V) 
        { 
            this.V = V; 
            this.adj = new Vector[V]; 
  
            for (int i = 0; i <  V; i++) 
                this.adj[i] = new Vector<>(); 
        } 
        
        public void addEdge(int v, int w) 
        {  
        	adj[v].add(w); // Add w to v's list. 
        }
        
        // print shortest path from a source vertex 's' to 
        // destination vertex 'd'. 
        public int printShortestPath(int[] parent, int s, int d) 
        { 
            level = 0; 
  
            // If we reached root of shortest path tree 
            if (parent[s] == -1) 
            { 
                System.out.printf("Shortest Path between"+  
                                "%d and %d is %s ", s, d, s); 
                return level; 
            } 
  
            printShortestPath(parent, parent[s], d); 
  
            level++; 
            
            System.out.printf("%d ", s); 
  
            return level; 
        } 
        
        // finds shortest path from source vertex 's' to 
        // destination vertex 'd'. 
  
        // This function mainly does BFS and prints the 
        // shortest path from src to dest.
        public int findShortestPath(int src, int dest) 
        { 
            boolean[] visited = new boolean[this.V]; 
            int[] parent = new int[this.V]; 
  
            // Initialize parent[] and visited[] 
            for (int i = 0; i < this.V; i++)  
            { 
                visited[i] = false; 
                parent[i] = -1; 
            } 
  
            // Create a queue for BFS 
            Queue<Integer> queue = new LinkedList<>(); 
  
            // Mark the current node as visited and enqueue it 
            visited[src] = true; 
            queue.add(src); 
  
            while (!queue.isEmpty())  
            { 
  
                // Dequeue a vertex from queue and print it 
                int s = queue.peek(); 
  
                if (s == dest) 
                    return printShortestPath(parent, s, dest); 
                queue.poll(); 
  
                // Get all adjacent vertices of the dequeued vertex s 
                // If a adjacent has not been visited, then mark it 
                // visited and enqueue it 
                for (int i : this.adj[s])  
                { 
                    if (!visited[i])  
                    { 
                        visited[i] = true; 
                        queue.add(i); 
                        parent[i] = s; 
                    } 
                } 
            } 
            return 0; 
        } 
    } 
    
 // Driver Code 
    public static void main(String[] args) 
    { 
  
        // Create a graph given in the above diagram 
        int V = 4; 
        Graph g = new Graph(V); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        int src = 0, dest = 3; 
        System.out.printf("\nShortest Distance between" +  
                            " %d and %d is %d\n", src,  
                            dest, g.findShortestPath(src, dest)); 
    } 

}
