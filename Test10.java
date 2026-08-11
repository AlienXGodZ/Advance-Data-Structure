public class Test10 {

    static node findmax(node root){

        while(root.right != null){
            root = root.right;
        }
        return root;

    }



    public static void main(String[] args){

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

        node max = findmax(root);

        System.out.println("MAXIMUM = " + max.data);


    }
}
