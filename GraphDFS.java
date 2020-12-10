// DFS algorithm in Java
// DFS Algorithm Complexity
// The time complexity of the DFS algorithm is represented in the form of O(V + E),
// where V is the number of nodes and E is the number of edges.
// The space complexity of the algorithm is O(V).

import java.util.*;

class GraphDFS {
    private LinkedList edgeList[]; // Η λίστα με τις ακμες
    private boolean visited[]; // η λιστα με τις κορυφες που εχουμε παει

    // Graph creation - constructor
    GraphDFS(int vertices) {
        edgeList = new LinkedList[vertices ]; // αρχικοποιηση της λιστας με μεγεθος οσες ειναι οι κορυφες
        visited = new boolean[vertices ]; // αρχικοποιηση του πινακα επισκεψεων

        for (int i = 0; i < (vertices ); i++)
            edgeList[i] = new LinkedList(); // δημιουργια πινακα με LinkedLists για να γινει ο γραφος α->β
    }

    // Add edges
    void addEdge(int src, int dest) { // συναρτηση για την εισοδο ακμων στο αντικειμενο γραφος
        edgeList[src].add(dest);
    }

    // DFS algorithm //Δκβ
    void DFS(int vertex) { // εισοδος συγκεκριμεκης κορυφης
        visited[vertex] = true; // πρωτη επισκεψη = true
        System.out.print((vertex  + 1) + " "); // εκτυπωση της κορυφης

        Iterator<Integer> it = edgeList[vertex].listIterator();
        while (it.hasNext()) {
            int nextVertex = it.next();
            if (!visited[nextVertex])
                DFS(nextVertex);
        }
    }

    public static void main(String args[]) {
        GraphDFS g = new GraphDFS(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 5);
        //g.addEdge(4, 5);
        //g.addEdge(5, 0);
        System.out.println("Following is Depth First Traversal");

        g.DFS(0);
    }
}