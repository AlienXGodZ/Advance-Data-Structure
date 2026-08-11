import java.util.LinkedList;
import java.util.Queue;

public class Test7 {

    static void levelorder(node root) {

        if (root == null) {
            return;
        }

        Queue<node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            node current = queue.remove();

            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }

        }
    }




    public static void main(String[] args){

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

        levelorder(root);





    }
}
