import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test42{

    static void addedge(ArrayList<ArrayList<Integer>> graph,int u,int v){

        graph.get(u).add(v);

    }

    static void fillorder(ArrayList<ArrayList<Integer>> graph,Stack<Integer> stack,boolean[] visited,int current){

        visited[current] = true;

        for(int neighbour : graph.get(current)) {

            if (!visited[neighbour]) {

                fillorder(graph, stack, visited, neighbour);

            }
        }

        stack.push(current);

    }

    static void dfsreverse(ArrayList<ArrayList<Integer>> reversegraph,boolean[] visited,int current) {

        visited[current] = true;

        System.out.print(current + " ");

        for (int neighbour : reversegraph.get(current)) {

            if (!visited[neighbour]) {

                dfsreverse(reversegraph, visited, neighbour);

            }
        }
    }

    static void kosaraju(ArrayList<ArrayList<Integer>> graph,int vertices){

        boolean[] visited = new boolean[vertices];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < vertices; i++) {

            if (!visited[i]) {

                fillorder(graph, stack, visited, 0);

            }
        }

            Arrays.fill(visited,false);

            ArrayList<ArrayList<Integer>> reversegraph = new ArrayList<>();

            for(int i = 0; i < vertices; i++){

                reversegraph.add(new ArrayList<>());

            }

            for(int u = 0; u < vertices; u++){

                for(int v : graph.get(u)){

                    reversegraph.get(v).add(u);

                }

            }

            int ssc = 0;

            while(!stack.isEmpty()) {

                int current = stack.pop();

                if (!visited[current]) {

                    ssc++;

                    System.out.print("SCC " + ssc + ": ");

                    dfsreverse(reversegraph, visited, current);

                    System.out.println();

                }
            }

            System.out.println("Total SCCs " + ssc);
        }


    public static void main(String[] args){

        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1);
        addedge(graph,1,2);
        addedge(graph,2,0);
        addedge(graph,1,3);
        addedge(graph,3,4);
        addedge(graph,4,3);

        kosaraju(graph,vertices);

    }


}