import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test24{

    static void bfs( int[][] graph,int start){

        boolean[] visited = new boolean[graph.length];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;

        queue.add(start);

        while(!queue.isEmpty()){

            int current = queue.poll();

            System.out.print(current + " ");

            for(int i = 0 ; i < graph.length; i++){

                if(graph[current][i] == 1 && !visited[i]){

                      visited[i] = true;

                      queue.add(i);

                }
            }
        }
    }


    public static void main(String[] args){


       int[][] graph = {{0,1,1,0},
                        {1,0,0,1},
                        {1,0,0,1},
                        {0,1,1,0}};

        bfs(graph,0);

    }
}