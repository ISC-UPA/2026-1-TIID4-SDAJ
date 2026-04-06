package oop;

public class Node {
    int data;
    Node left, right;
    int height;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    @Override
    public String toString() {
        return (left != null ? left.data : "null") + "<-" + data + "->" + (right != null ? right.data : "null");
    }
}

