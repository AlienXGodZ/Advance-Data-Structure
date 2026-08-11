public class Test9 {

    static node findmin(node root){

        while(root.left != null){
            root = root.left;
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

        node min = findmin(root);

        System.out.println("MINIMUM = " + min.data);


    }
}
