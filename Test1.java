class node{
       int data;
       node left;
       node right;

       node(int value){
           data = value;
           left = null;
           right = null;
       }
}

public class Test1 {

    static boolean search(node root,int key){

        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(key > root.data){
          return  search(root.right,key);
        }

      return search(root.left,key);

    }


    public static void main(String[] args){

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

        if(search(root,60)){
            System.out.println("FOUND");
        }else{
            System.out.println("NOT FOUND");
        }



    }

}
