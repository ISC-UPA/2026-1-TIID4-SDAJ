package oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    Node root;
    int size;

    public Tree() {
        this.root = null;
        this.size = 0;
    }

    // ─── show (impresión en consola estilo árbol) ───────────────────────────────
    public void show() {
        System.out.println();
        _show(root, "", true);
        System.out.println();
    }

    private void _show(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            _show(node.right, prefix + (isLeft ? "│   " : "    "), false);
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
            _show(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    // ─── maxDepth ───────────────────────────────────────────────────────────────
    public int maxDepth() {
        return _maxDepth(root);
    }

    private int _maxDepth(Node node) {
        if (node == null) return 0;
        return Math.max(_maxDepth(node.left), _maxDepth(node.right)) + 1;
    }

    // ─── minDepth ───────────────────────────────────────────────────────────────
    public int minDepth() {
        return _minDepth(root);
    }

    private int _minDepth(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        if (node.left == null)  return _minDepth(node.right) + 1;
        if (node.right == null) return _minDepth(node.left)  + 1;
        return Math.min(_minDepth(node.left), _minDepth(node.right)) + 1;
    }

    // ─── search ─────────────────────────────────────────────────────────────────
    public boolean search(int data) {
        return _search(root, data);
    }

    private boolean _search(Node node, int data) {
        if (node == null)       return false;
        if (node.data == data)  return true;
        if (data < node.data)   return _search(node.left,  data);
        else                    return _search(node.right, data);
    }


    // ─── inOrder (impresión) ────────────────────────────────────────────────────
    public void inOrder() {
        System.out.println();
        _inOrder(root);
        System.out.println();
    }

    private void _inOrder(Node node) {
        if (node != null) {
            _inOrder(node.left);
            System.out.print(node.data + ", ");
            _inOrder(node.right);
        }
    }

    // ─── inOrderList ────────────────────────────────────────────────────────────
    public List<Integer> inOrderList() {
        return _inOrderList(root);
    }

    private List<Integer> _inOrderList(Node node) {
        if (node == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.addAll(_inOrderList(node.left));
        result.add(node.data);
        result.addAll(_inOrderList(node.right));
        return result;
    }

    // ─── treeBFS ────────────────────────────────────────────────────────────────
    public List<List<Integer>> treeBFS() {
        return _treeBFS(root);
    }

    private List<List<Integer>> _treeBFS(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<int[]> queue = new LinkedList<>();  // int[] = {nodeRef via map, level}
        // Usamos una queue de pares (Node, level) con Object[]
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 0});

        while (!q.isEmpty()) {
            Object[] pair = q.poll();
            Node node  = (Node) pair[0];
            int  level = (int)  pair[1];

            if (levels.size() == level) levels.add(new ArrayList<>());
            levels.get(level).add(node.data);

            if (node.left  != null) q.add(new Object[]{node.left,  level + 1});
            if (node.right != null) q.add(new Object[]{node.right, level + 1});
        }
        return levels;
    }

    // ─── insert ─────────────────────────────────────────────────────────────────
    public void insert(int data) {
        root = _insert(root, data);
        size++;
    }

    private Node _insert(Node node, int data) {
        if (node == null) return new Node(data);

        if (data <= node.data)
            node.left  = _insert(node.left,  data);
        else
            node.right = _insert(node.right, data);

        node = _treeAVL(node);
        return node;
    }

    // ─── delete ─────────────────────────────────────────────────────────────────
    public void delete(int data) {
        root = _delete(root, data);
    }

    private Node _delete(Node node, int data) {
        if (node == null) return null;

        if (data < node.data)
            node.left  = _delete(node.left,  data);
        else if (data > node.data)
            node.right = _delete(node.right, data);
        else {
            if (node.left  == null) return node.right;
            if (node.right == null) return node.left;

            Node temp = minValueNode(node.right);
            node.data  = temp.data;
            node.right = _delete(node.right, temp.data);
            size--;
        }

        node = _treeAVL(node);
        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // ─── AVL balancing ──────────────────────────────────────────────────────────
    private Node _treeAVL(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        // Left Left
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // Left Right
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // Right Left
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node rightRotate(Node y) {
        System.out.println("Rotate right on node " + y.data);
        Node x  = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left  = T2;
        y.height = 1 + Math.max(getHeight(y.left),  getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left),  getHeight(x.right));
        return x;
    }

    private Node leftRotate(Node x) {
        System.out.println("Rotate left on node " + x.data);
        Node y  = x.right;
        Node T2 = y.left;
        y.left  = x;
        x.right = T2;
        x.height = 1 + Math.max(getHeight(x.left),  getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left),  getHeight(y.right));
        return y;
    }
}
    

