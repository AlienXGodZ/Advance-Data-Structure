public class Test11{

    static node findsuccessor(node root,int value){

        node current = root;
         node successor = null;

         while(current != null){

             if(value > current.data){
                 current = current.right;
             }else if(value < current.data){
                 successor = current;
                 current = current.left;
             }

             else{

                 if(current.right != null){
                     successor = findmin(current.right);
                 }
                 break;




             }

         }

         return successor;


    }

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

         node successor = findsuccessor(root,60);

         if(successor != null){
             System.out.println("Inorder Successor:" + successor.data);
         }else{
             System.out.println("Successor not found");
         }

    }
}