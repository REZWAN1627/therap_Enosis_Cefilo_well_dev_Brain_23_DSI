package DSA;

import java.util.Objects;

public class AvlTree {
    private AvlTree leftChild;
    private AvlTree rightChild;
    private int height;
    private int value;

    public AvlTree() {
    }

    public AvlTree(int value) {
        this.value = value;
    }

    public static AvlTree insertAvl(AvlTree root, Integer value) {

        if (Objects.isNull(root)) {
            return new AvlTree(value);
        }
        if (value < root.getValue()) {
            AvlTree insert = insertAvl(root.getLeftChild(), value);
            root.setLeftChild(insert);
        }

        if (value > root.getValue()) {
            AvlTree insert = insertAvl(root.getRightChild(), value);
            root.setRightChild(insert);
        }
        setHeight(root);
        return balance(root);
    }

    private static AvlTree balance(AvlTree root) {

        if (isLeftHeavy(root)) {
            if (balanceFactor(root.getLeftChild()) < 0) {
                System.out.println("Left rotate " + root.getLeftChild().getValue());
                root.setLeftChild(rotateLeft(root.getLeftChild()));
            }
            System.out.println("Right rotate " + root.getValue());
            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.getRightChild()) > 0) {
                System.out.println("Right Rotate " + root.getRightChild().getValue());
                root.setRightChild(rotateRight(root.getRightChild()));
            }
            System.out.println("Left rotate " + root.getValue());
            return rotateLeft(root);
        }
        return root;
    }

    private static AvlTree rotateLeft(AvlTree root) {
        var newRoot = root.getRightChild();
        root.setRightChild(newRoot.getLeftChild());
        newRoot.setLeftChild(root);
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private static AvlTree rotateRight(AvlTree root) {
        var newRoot = root.getLeftChild();
        root.setLeftChild(newRoot.getRightChild());
        newRoot.setRightChild(root);
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private static boolean isLeftHeavy(AvlTree root) {
        return balanceFactor(root) > 1;
    }

    private static boolean isRightHeavy(AvlTree root) {
        return balanceFactor(root) < -1;
    }

    private static int balanceFactor(AvlTree root) {
        return (Objects.isNull(root)) ? 0 : height(root.getLeftChild()) - height(root.getRightChild());
    }

    private static int height(AvlTree root) {
        return Objects.isNull(root) ? -1 : root.getHeight();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private static void setHeight(AvlTree root) {
        root.setHeight(
                Math.max(
                        height(root.getLeftChild()),
                        height(root.getRightChild())
                ) + 1
        );
    }

    public AvlTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AvlTree leftChild) {
        this.leftChild = leftChild;
    }

    public AvlTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(AvlTree rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "node -> " + value;
    }
}
