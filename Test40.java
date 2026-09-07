import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test40{

    static class edge{

        int u;
        int v;
        int weight;

        edge(int u,int v,int weight){

            this.u = u;
            this.v = v;
            this.weight = weight;

        }
    }

    static int find(int[] parent,int x){

        if(parent[x] == x){

            return x;

        }

        parent[x] = find(parent,parent[x]);
        return parent[x];

    }

    static void union(int[] parent,int a,int b,int[] rank) {

        int roota = find(parent, a);
        int rootb = find(parent, b);


        if(roota == rootb){

            return;

        }


        if (rank[roota] < rank[rootb]) {

            parent[roota] = rootb;

        } else if (rank[roota] > rank[rootb]) {

            parent[rootb] = roota;

        } else {

            parent[rootb] = roota;
            rank[roota]++;

        }
    }


    static void krushal(ArrayList<edge> graph,int vertices) {

        int[] parent = new int[vertices];

        int[] rank = new int[vertices];

        graph.sort((a,b) -> Integer.compare(a.weight,b.weight));

        for (int i = 0; i < vertices; i++) {

            parent[i] = i;

        }

        int totalweight = 0;
        int edgeused = 0;

        for (edge Edge : graph) {

            int roota = find(parent, Edge.u);
            int rootb = find(parent, Edge.v);

            if(roota != rootb){

                System.out.println(roota + "---" + rootb + " = " + Edge.weight);

            }

            totalweight += Edge.weight;

            union(parent,Edge.u,Edge.v,rank);

            edgeused++;

            if(edgeused == vertices - 1){

                break;

            }
        }

        System.out.println("Minimum Spanning Tree = " + totalweight);

    }

    public static void main(String[] args){

        int vertices = 4;

        ArrayList<edge> graph = new ArrayList<>();

        graph.add(new edge(0,1,4));
        graph.add(new edge( 0,3,1));
        graph.add(new edge(0,2,2));
        graph.add(new edge(1,3,3));
        graph.add(new edge(2,3,5));

        krushal(graph,vertices);

    }
}