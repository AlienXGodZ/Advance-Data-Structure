public class Test14 {

    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
        }
    }

    static int count = 0;

    // Find Kth smallest element
    static node kthSmallest(node root, int k) {

        if (root == null) {
            return null;
        }

        // Go LEFT
        node result = kthSmallest(root.left, k);

        if (result != null) {
            return result;
        }

        // Visit current node
        count++;

        if (count == k) {
            return root;
        }

        // Go RIGHT
        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {

        node root = new node(50);

        root.left = new node(30);
        root.right = new node(70);

        root.left.left = new node(20);
        root.left.right = new node(40);

        root.right.left = new node(60);
        root.right.right = new node(80);

        int k = 1;

        node result = kthSmallest(root, k);

        if (result != null) {
            System.out.println(
                    k + "th smallest = " + result.data
            );
        } else {
            System.out.println("Kth smallest not found");
        }
    }
}