package MinimumSpanningTree;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrimsWithHeap2 {

    class node1 { 
          
        int dest; 
        int weight; 

        node1(int a, int b) 
        { 
            dest = a; 
            weight = b; 
        } 
    } 

    static class node { 
        int vertex; 
        int key; 
    } 

    static class Graph {  
        int V; 
        LinkedList<node1>[] adj; 
  
        Graph(int e) 
        { 
            V = e; 
            adj = new LinkedList[V]; 
            for (int o = 0; o < V; o++) 
                adj[o] = new LinkedList<>(); 
        } 
    } 

    static class comparator implements Comparator<node> { 
  
        @Override
        public int compare(node node0, node node1) 
        { 
            return node0.key - node1.key; 
        } 
    } 

    public void addEdge(Graph graph, int src, int dest, int weight) 
    {
        node1 node0 = new node1(dest, weight); 
        node1 node = new node1(src, weight); 
        graph.adj[src].addLast(node0); 
        graph.adj[dest].addLast(node); 
    }

    // Complete the prims function below.
    static int prims(Graph graph,int n, int[][] edges, int start) {


         Boolean[] mstset = new Boolean[n]; 
        node[] e = new node[n]; 

        int[] parent = new int[n];

        for (int o = 0; o < n; o++) 
            e[o] = new node(); 

        for (int o = 0; o < n; o++) { 
   
            mstset[o] = false; 
            e[o].key = Integer.MAX_VALUE; 
            e[o].vertex = o; 
            parent[o] = -1; 
        } 

        mstset[start-1] = true; 

        e[start-1].key = 0; 

        TreeSet<node> queue = new TreeSet<node>(new comparator()); 

         for (int o = 0; o < n; o++) 
            queue.add(e[o]);

        while (!queue.isEmpty()) { 
  
            node node0 = queue.pollFirst(); 
   
            mstset[node0.vertex] = true; 
  
            for (node1 iterator : graph.adj[node0.vertex]) { 
  
                if (mstset[iterator.dest] == false) {  
                    if (e[iterator.dest].key > iterator.weight&&iterator.weight!=0) { 
                        queue.remove(e[iterator.dest]); 
                        e[iterator.dest].key = iterator.weight; 
                        queue.add(e[iterator.dest]); 
                        parent[iterator.dest] = node0.vertex; 
                    } 
                } 
            } 
        }  

        int sum=0;

        for(int i=0;i<n;i++)
        {
            sum+=e[i].key;
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = edgesItem;
            }
        }

        int start = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Graph graph=new Graph(n);

        PrimsWithHeap2 sol=new PrimsWithHeap2();

        for(int i=0;i<m;i++)
        {
            sol.addEdge(graph,edges[i][0]-1,edges[i][1]-1,edges[i][2]);
        }

        int result = prims(graph,n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
