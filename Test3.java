public class Test3 {

    static node delete(node root,int value){

        if(root == null){
            return null;
        }

        if(value > root.data){
            root.right = delete(root.right,value);
        }else if(value < root.data){
            root.left = delete(root.left,value);
        }

        else{

            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            node successor = findmin(root.right);

            root.data = successor.data;

            root.right = delete(root.right, successor.data);

        }

        return root;


    }

    static node findmin(node root){

        while(root.left != null){
            root = root.left;
        }

        return root;

    }

    static void inorder(node root){

        if(root == null){
            return;
        }


        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);



    }

    static void preorder(node root){

        if(root == null){
            return;
        }

        System.out.print(root.data + " ");

        inorder(root.left);

        inorder(root.right);

    }

    static void postorder(node root){

        if(root == null){
            return;
        }



        inorder(root.left);

        inorder(root.right);

        System.out.print(root.data + " ");


    }


    public static void main(String[] args){

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

       root = delete(root,70);

        inorder(root);

        System.out.println();

        preorder(root);

        System.out.println();

        postorder(root);





    }
}
