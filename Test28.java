import java.util.ArrayList;
import java.util.Stack;

public class Test28{

    static void dfs(int[][] graph,int start){

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[graph.length];

        stack.push(start);

        while(!stack.isEmpty()){

            int current = stack.pop();

            if(!visited[current]) {

                visited[current] = true;

            }

            System.out.print(current + " ");

            for(int i = graph.length - 1; i >=0 ; i--) {

                if (!visited[i] && graph[current][i] == 1) {

                    stack.push(i);
                }
            }
        }
    }

    public static void main(String[] args){

        int[][] graph = {{0,1,1,0,0},
                {1,0,0,1,1},
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,1,0,0,0}};

        dfs(graph,0);

    }
}