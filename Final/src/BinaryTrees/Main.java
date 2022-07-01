package BinaryTrees;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(3);
        tree.root.left = new BinaryNode<>(2);
        tree.root.right = new BinaryNode<>(1);
        tree.root.left.right = new BinaryNode<>(7);
        tree.root.left.left = new BinaryNode<>(5);
        tree.root.right.left = new BinaryNode<>(1);
        tree.root.right.right = new BinaryNode<>(6);
        tree.root.left.left.left = new BinaryNode<>(8);
        tree.root.right.left.left = new BinaryNode<>(10);


        System.out.println(tree.numberOfFullNodes(tree.root));



    }
}
