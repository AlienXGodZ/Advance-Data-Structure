public class Test12 {

    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
        }
    }

    // Find maximum node
    static node findmax(node root) {

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    // Find inorder predecessor
    static node findpredecessor(node root, int value) {

        node current = root;
        node predecessor = null;

        while (current != null) {

            if (value > current.data) {

                predecessor = current;
                current = current.right;

            }
            else if (value < current.data) {

                current = current.left;

            }
            else {

                // Node found

                if (current.left != null) {
                    predecessor = findmax(current.left);
                }

                break;
            }
        }

        return predecessor;
    }

    public static void main(String[] args) {

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

        node predecessor = findpredecessor(root, 20);

        if (predecessor != null) {
            System.out.println(
                    "Inorder Predecessor: " + predecessor.data
            );
        } else {
            System.out.println("Predecessor not found");
        }
    }
}