package BinaryTrees;

public class BinaryTree<AnyType> {
    public BinaryNode<AnyType> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(AnyType x) {
        root = new BinaryNode<>(x);
    }

    public int size(BinaryNode<AnyType> tree) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }

    public int height(BinaryNode<AnyType> root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void inorderPrint(BinaryNode<AnyType> root) {
        if (root == null) {
            return;
        }

        inorderPrint(root.left);
        System.out.print(root.element + " ");
        inorderPrint(root.right);
    }

    public void preorderPrint(BinaryNode<AnyType> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.element + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public void postorderPrint(BinaryNode<AnyType> root) {
        if (root == null) {
            return;
        }

        postorderPrint(root.left);
        postorderPrint(root.right);
        System.out.print(root.element + " ");
    }

    public int max(BinaryNode<AnyType> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int max = (int) root.element;
        int leftMax = max(root.left);
        int rightMax = max(root.right);

        if (leftMax > max) {
            max = leftMax;
        } else {
            max = rightMax;
        }

        return max;
    }

    public void printEven(BinaryNode<AnyType> root) {
        if (root == null) {
            return;
        }

        printEven(root.left);
        if ((int) root.element % 2 == 0) {
            System.out.print(root.element);
        }
        printEven(root.right);

    }

    public void parentOf(BinaryNode<AnyType> root, AnyType x) {
        if (root == null) {
            return;
        }


        if (root.left.element == x || root.right.element == x) {
            System.out.println(root.element);
        } else {
            parentOf(root.left, x);
            parentOf(root.right, x);
        }
    }

    public int numberOfLeaves(BinaryNode<AnyType> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return numberOfLeaves(root.left) + numberOfLeaves(root.right);
    }

    public int numberOfFullNodes(BinaryNode<AnyType> root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.right != null) {
            return 1 + numberOfFullNodes(root.left) + numberOfFullNodes(root.right);
        } else {
            return numberOfFullNodes(root.left) + numberOfFullNodes(root.right);
        }
    }

    public BinaryNode<AnyType> deleteLeaves(BinaryNode<AnyType> root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root = null;
            return null;
        }

        root.left = deleteLeaves(root.left);
        root.right = deleteLeaves(root.right);

        return root;
    }

    public int maxDepth(BinaryNode<AnyType> root) {
        if (root == null) {
            return -1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }

    public int depthOf(BinaryNode<AnyType> root, AnyType k){
        if (root == null){
            return -1;
        }

        int distance = -1;
        distance += depthOf(root.left) +
        if (root.element == k){
            return distance;
        }
    }


}
