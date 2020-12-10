import java.util.*;

public class Graph {
    private LinkedList<Integer> edgeList[];
    private boolean visited[];

    //Graph creation
    Graph(int vertices) {
        edgeList = new LinkedList[vertices];
        visited = new boolean[vertices ];
        for(int i=0;i < vertices;i++){
            visited[i] = false;
        }
        for (int i = 0; i < vertices; i++) {
            edgeList[i] = new LinkedList();
        }
    }

    void addEdge(int src, int dest) {
        edgeList[src].add(dest);
    }

    //Bfs algorithm -- Δ Κ Π
    void BFS(int vertex) {

        LinkedList<Integer> queue = new LinkedList();
        //visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            vertex = queue.poll();
            System.out.print((vertex + 1) + " ");

            Iterator<Integer> it = edgeList[vertex].listIterator();
            while (it.hasNext()) {
                int nextVertex = it.next();
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(8);
        g.addEdge(0, 1); // 1 - 2
        g.addEdge(0, 2); // 1 - 3
        g.addEdge(1, 4); // 2 - 5
        g.addEdge(4, 5); // 5 - 6
        g.addEdge(1, 5); // 2 - 6
        //g.addEdge(1, 5);
        System.out.println("Following is Breath first search");
        g.BFS(0);
    }
}
