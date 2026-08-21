public class Test15 {

  static int height(node root){

      if(root == null){
          return 0;
      }

      int leftheight = height(root.left);
      int rightheight = height(root.right);

      return 1 + Math.max(leftheight,rightheight);

  }


    public static void main(String[] args){

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

        root.left.left.left = new node(10);

        System.out.println("Maximum height:" + height(root));



    }
}
