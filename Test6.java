public class Test6 {

    static void inorder(node root){

        if(root == null){
            return;
        }



        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);





    }




    public static void main(String[] args){

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

        inorder(root);





    }
}
