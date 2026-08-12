public class Test13 {

    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
        }
    }

    // Find Lowest Common Ancestor in BST
    static node findLCA(node root, int value1, int value2) {

        while (root != null) {

            // Both values are smaller than root
            if (value1 < root.data && value2 < root.data) {

                root = root.left;

            }

            // Both values are greater than root
            else if (value1 > root.data && value2 > root.data) {

                root = root.right;

            }

            // They are on different sides
            // OR one value is the root
            else {

                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

        node lca = findLCA(root, 20, 40);

        if (lca != null) {
            System.out.println("LCA = " + lca.data);
        } else {
            System.out.println("LCA not found");
        }
    }
}