import java.util.ArrayList;

public class Test22 {

    static void addedge(ArrayList<ArrayList<Integer>>graph,int u,int v){

        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    public static void main(String[] args){

        int vertices = 3;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1);
        addedge(graph,1,2);

        for(int i = 0; i < vertices; i++){

            System.out.println(i + "--->" + graph.get(i));

        }


    }
}
