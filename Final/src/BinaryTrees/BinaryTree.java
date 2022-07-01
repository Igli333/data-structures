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


        if ((root.left != null && root.left.element == x) || (root.right != null && root.right.element == x)) {
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

    public int depthOf(BinaryNode<AnyType> root, AnyType k) {
        if (root == null) {
            return -1;
        }

        int depth = -1;

        if (root.element == k || (depth = depthOf(root.left, k)) >= 0 || (depth = depthOf(root.right, k)) >= 0) {
            return depth + 1;
        }

        return depth;
    }

    public int depth(BinaryNode<AnyType> root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public int sumPairs(BinaryNode<AnyType> root, int k) {
        if (root == null) {
            return 0;
        }

        if ((root.left != null && (int) root.element + (int) root.left.element == k)
                || (root.right != null && (int) root.element + (int) root.right.element == k)) {
            return 1 + sumPairs(root.left, k) + sumPairs(root.right, k);
        } else if ((root.left != null && (int) root.element + (int) root.left.element == k)
                && (root.right != null && (int) root.element + (int) root.right.element == k)) {
            return 2 + sumPairs(root.left, k) + sumPairs(root.right, k);
        } else {
            return sumPairs(root.left, k) + sumPairs(root.right, k);
        }
    }

    public boolean equal(BinaryNode<AnyType> r1, BinaryNode<AnyType> r2) {
        if (r1 == null && r2 == null) {
            return true;
        }

        if ((r1 == null && r2 != null) || (r1 != null && r2 == null)) {
            return false;
        }

        return r1.element.equals(r2.element) && equal(r1.left, r2.left) && equal(r1.right, r2.right);
    }

    public boolean isBST(BinaryNode<AnyType> root) {
        if (root == null) {
            return true;
        }

        if ((int) root.element > (int) root.left.element && (int) root.element < (int) root.right.element) {
            return isBST(root.left) && isBST(root.right);
        }

        return false;
    }

    public boolean isBalanced(BinaryNode<AnyType> root) {
        if (root == null) {
            return true;
        }

        if (depth(root.left) - depth(root.right) > 1 || depth(root.right) - depth(root.left) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public void kDepthElements(BinaryNode<AnyType> root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.element + "");
            return;
        }

        kDepthElements(root.left, k - 1);
        kDepthElements(root.right, k - 1);

    }

    public int kSum(BinaryNode<AnyType> root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 0) {
            return (int) root.element;
        }

        return kSum(root.left, k - 1) + kSum(root.right, k - 1);
    }

    public int kBiggest(BinaryNode<AnyType> root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (k == 0) {
            return (int) root.element;
        }

        return Math.max(kBiggest(root.left, k - 1), kBiggest(root.right, k - 1));
    }

    public int kFullNodes(BinaryNode<AnyType> root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 0) {
            if (root.left != null && root.right != null) {
                return 1;
            }
            return 0;
        }

        return kFullNodes(root.left, k - 1) + kFullNodes(root.right, k - 1);
    }

    public void buildSymmetric(BinaryNode<AnyType> root) {
        if (root == null) {
            return;
        }
        buildSymmetric(root.left);
        buildSymmetric(root.right);
        BinaryNode<AnyType> temp = root.left;
        root.left = root.right;
        root.right = temp;

    }


}
