public class Test2 {

    static node insert(node root,int insertnumber){

        if(root == null){
            return new node(insertnumber);
        }

        if(insertnumber > root.data){
           root.right =  insert(root.right,insertnumber);
        }else{
           root.left = insert(root.left,insertnumber);
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

        node root = null;

        root = insert(root,50);
        root = insert(root,30);
        root = insert(root,70);
        root = insert(root,20);
        root = insert(root,40);
        root = insert(root,60);
        root = insert(root,80);

        inorder(root);

        System.out.println();

        preorder(root);

        System.out.println();

        postorder(root);








    }
}
