package BinaryTrees;

public class BinarySearchTree<AnyType> {
    public BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(AnyType x) {
        root = new BinaryNode<>(x);
    }

    public void insert(AnyType x) {
        while (root != null) {
            if ((int) x > (int) root.element) {
                root = root.right;
            } else if ((int) x < (int) root.element) {
                root = root.right;
            }
        }

        root = new BinaryNode<>(x);
    }

    public AnyType findMax(BinaryNode<AnyType> root) {
        if (root.right == null) {
            return root.element;
        }

        return findMax(root.right);
    }

    public AnyType findParentOf(BinaryNode<AnyType> root, AnyType x) {
        if (root == null) {
            return null;
        }

        if (root.left.element == x || root.right.element == x) {
            return root.element;
        }

        if ((int) x > (int) root.element) {
            return findParentOf(root.right, x);
        } else if ((int) x < (int) root.element) {
            return findParentOf(root.left, x);
        }

        return null;

    }

    public void insertFromArray(AnyType[] array, BinaryNode<AnyType> root) {
        int middle = array.length / 2;
        root.element = array[middle];
        AnyType[] arrayToPass1 = (AnyType[]) new Object[middle];
        for (int i = 0; i < middle; i++) {
            arrayToPass1[i] = array[i];
        }

        AnyType[] arrayToPass2 = (AnyType[]) new Object[middle];
        for (int i = middle + 1; i < array.length; i++) {
            arrayToPass2[i] = array[i];
        }
        insertFromArray(arrayToPass1, root.left);
        insertFromArray(arrayToPass2, root.right);
    }
}
