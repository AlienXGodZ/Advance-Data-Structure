public class Test16 {

    static int height(node root){

        if(root == null){
            return 0;
        }

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        return 1 + Math.max(leftheight,rightheight);

    }

    static int diameter(node root){

        if(root == null){
            return 0;
        }

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        int currentdiameter = leftheight + rightheight;

         int leftdiameter = diameter(root.left);
        int rightdiameter = diameter(root.right);

        return Math.max(currentdiameter,Math.max(leftdiameter,rightdiameter));




    }


    public static void main(String[] args){

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);


        System.out.println("Maximum height:" + diameter(root));


    }
}
