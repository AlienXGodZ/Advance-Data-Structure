import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test26 {


    static void dfs(int[][] graph,int current,boolean[] visited){

        visited[current] = true;

        System.out.print(current + " ");

        for(int i = 0; i < graph.length; i++){

            if(!visited[i] && graph[current][i] == 1) {

                dfs(graph,i,visited);

            }
        }
    }


    public static void main(String[] args){

        int[][] graph = {{0,1,1,0,0},
                         {1,0,0,1,1},
                         {1,0,0,0,0},
                         {0,1,0,0,0},
                         {0,1,0,0,0}};

        boolean[] visited = new boolean[graph.length];

        dfs(graph,0,visited);

    }
}
