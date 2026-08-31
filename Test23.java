import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test23{

   static void addedge(  ArrayList<ArrayList<Integer>> graph ,int u , int v){

       graph.get(u).add(v);
       graph.get(v).add(u);
   }

   static void bfs( ArrayList<ArrayList<Integer>> graph,int start){

       boolean[] visited = new boolean[graph.size()];

       Queue<Integer> queue = new LinkedList<>();

       visited[start] = true;

       queue.add(start);

       while(!queue.isEmpty()){

           int current = queue.poll();

           System.out.print(current + " ");

           for(int neighbour : graph.get(current)){

               if(!visited[neighbour]){

                   visited[neighbour] = true;

                   queue.add(neighbour);


               }
           }
       }
   }


    public static void main(String[] args){

        int vertices = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1);
        addedge(graph,0,2);
        addedge(graph,1,3);
        addedge(graph,2,3);

        bfs(graph,0);

    }
}