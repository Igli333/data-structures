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
        if (array.length == 0) {
            return;
        }
        int middle = array.length / 2;
        root.element = array[middle];
        AnyType[] arrayToPass1 = (AnyType[]) new Object[middle];
        for (int i = 0; i < middle; i++) {
            arrayToPass1[i] = array[i];
        }

        AnyType[] arrayToPass2 = (AnyType[]) new Object[middle];
        for (int i = 0; i < array.length / 2; i++) {
            arrayToPass2[i] = array[2 * i];
        }
        insertFromArray(arrayToPass1, root.left);
        insertFromArray(arrayToPass2, root.right);
    }

    public AnyType find(AnyType x, BinaryNode<AnyType> root) {
        if (root == null) {
            return null;
        }

        if (root.element == x) {
            return root.element;
        }

        if (root.left != null && (int) root.element > (int) x) {
            return find(x, root.left);
        } else if (root.right != null && (int) root.element < (int) x) {
            return find(x, root.right);
        }

        return null;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> root){
        if (root.left == null){
            return root;
        }

        return findMin(root.left);
    }

    private void removeMin(BinaryNode<AnyType> root){
        if (root.left.left == null){
            root.left = root.left.right;
            return;
        }

        removeMin(root.left);
    }

    private BinaryNode<AnyType> findMaxNode(BinaryNode<AnyType> root){
        if (root.right == null){
            return root;
        }

        return findMaxNode(root.left);
    }

    private void removeMax(BinaryNode<AnyType> root){
        if (root.right.right == null){
            root.right = root.right.left;
            return;
        }

        removeMax(root.right);
    }

    public void remove(AnyType x, BinaryNode<AnyType> root){
        if (root == null){
            return;
        }

        if (root.left.element == x){
            BinaryNode<AnyType> max = findMaxNode(root.left);
            removeMax(root.left);
            max.left = root.left.left;
            max.right = root.left.right;
            root.left = max;
            return;
        } else if (root.right.element == x){
            BinaryNode<AnyType> min = findMin(root.right);
            removeMin(root.right);
            min.right = root.right.right;
            min.left = root.right.left;
            root.right = min;
            return;
        }

        if ((int) root.element > (int) x) {
            remove(x, root.left);
        } else if ((int) root.element < (int) x) {
            remove(x, root.right);
        }
    }
}
