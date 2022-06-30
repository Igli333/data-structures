package BinaryTrees;

public class BinaryNode<AnyType> {
    public BinaryNode<AnyType> left;
    public BinaryNode<AnyType> right;
    public AnyType element;

    public BinaryNode(AnyType element) {
        this.element = element;
        left = right = null;
    }
}
