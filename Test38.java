import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test38{

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

    static void dijkstra(ArrayList<ArrayList<edge>> graph,int start,int vertices){

        int[] distance = new int[vertices];

        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[start] = 0;

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) ->(Integer.compare(a.distance,b.distance)));

        pq.add(new pair(start,0));

        while(!pq.isEmpty()){

            pair currentpair = pq.poll();

            int current = currentpair.vertices;
            int currentdistance = currentpair.distance;

            if(currentdistance > distance[current]){

                continue;

            }

            for(edge Edge : graph.get(current)){

                int neighbour = Edge.to;
                int weight = Edge.weight;

                int newdistance = distance[current] + weight;

                if(newdistance < distance[neighbour]){

                    distance[neighbour] = newdistance;

                    pq.add(new pair(neighbour,newdistance));

                }

            }

        }

        for(int i = 0; i < vertices; i++){

            System.out.println("Directed From " + start  + " to "  + i  + " = "  + distance[i]);

        }
    }


    public static void main(String[] args){

        int vertices = 3;

        ArrayList<ArrayList<edge>> graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1,10);
        addedge(graph,0,2,3);
        addedge(graph,2,1,4);

        dijkstra(graph,0,vertices);


    }
}