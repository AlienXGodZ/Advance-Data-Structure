import java.util.ArrayList;
import java.util.PriorityQueue;

public class Test39 {

    static class edge{

        int to;
        int weight;

        edge(int to,int weight){

            this.to = to;
            this.weight = weight;

        }
    }

    static class pair{

        int vertices;
        int distance;

        pair(int vertices,int distance){

            this.vertices = vertices;
            this.distance = distance;

        }
    }

    static void addedge(ArrayList<ArrayList<edge>> graph,int u,int v,int weight){

        graph.get(u).add(new edge(v,weight));
        graph.get(v).add(new edge(u,weight));

    }

    static void prims(ArrayList<ArrayList<edge>> graph,int start,int vertices) {

        boolean[] visited = new boolean[vertices];

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a.distance, b.distance)));

        pq.add(new pair(start, 0));

        int totalcost = 0;


        while (!pq.isEmpty()) {

            pair currentpair = pq.poll();

            int current = currentpair.vertices;
            int currentweight = currentpair.distance;

            if (visited[current]) {

                continue;

            }

            visited[current] = true;

            totalcost += currentweight;


            for (edge Edge : graph.get(current)) {

                if (!visited[Edge.to]) {

                    pq.add(new pair(Edge.to, Edge.weight));

                }
            }
        }

            System.out.println("Minimum Spanning Tree Cost = " + totalcost);

        }


    public static void main(String[] args){

        int vertices = 5;

        ArrayList<ArrayList<edge>> graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1,4);
        addedge(graph,0,2,2);
        addedge(graph,0,3,1);
        addedge(graph,1,3,3);
        addedge(graph,2,3,5);

        prims(graph,0,vertices);

    }
}
