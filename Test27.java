import java.util.ArrayList;
import java.util.Stack;

public class Test27{

    static void addedge(ArrayList<ArrayList<Integer>> graph,int u ,int v){

        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    static void dfs(ArrayList<ArrayList<Integer>> graph,int start,int vertices){

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[vertices];

        stack.push(start);

        while(!stack.isEmpty()){

            int current = stack.pop();

            if(!visited[current]) {

                visited[current] = true;

            }

            System.out.print(current + " ");

            for(int i = graph.get(current).size() - 1; i >=0 ; i--) {

                int neighbour = graph.get(current).get(i);

                if (!visited[neighbour]) {

                    stack.push(neighbour);
                }
            }
        }
    }

    public static void main(String[] args){

        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < vertices ; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1);
        addedge(graph,0,2);
        addedge(graph,1,3);
        addedge(graph,1,4);

        dfs(graph,0,vertices);

    }
}