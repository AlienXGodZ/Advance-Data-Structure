public class Test8{

    static boolean search(node root,int key){

        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(key > root.data){
            return search(root.right,key);
        }
        return search(root.left,key);


    }

    static node insert(node root,int value){


        if(root == null){
            return new node(value);
        }


        if(value > root.data){
            root.right = insert(root.right,value);
        }

        else{
            root.left = insert(root.left,value);

        }

        return root;

    }

    static node delete(node root,int value){

        if(root == null){
            return null;
        }

        if(value > root.data){
            root.right = delete(root.right,value);
        }
        else if(value < root.data){
            root.left = delete(root.left,value);
        }

        else{

            if(root.left == null){
                return root.right;
            }

            if(root.right == null){
                return root.left;
            }

            node sucessor = findmin(root.right);

            root.data = sucessor.data;

            root.right = delete(root.right,sucessor.data);




        }

        return root;





    }

    static node findmin(node root){

        while(root.left != null){
            root = root.left;
        }
        return root;

    }





    public static void main(String[] args){

        node root = null;

        root = insert(root,50);
        root = insert(root,20);
        root = insert(root,70);
        root = insert(root,10);
        root = insert(root,30);
        root = insert(root,60);
        root = insert(root,80);

        if(search(root,60)){
            System.out.println("FOUND");
        }else{
            System.out.println("NOT FOUNDED");
        }



        root = delete(root,70);


    }
}