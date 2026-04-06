package oop;

import java.util.function.Function;

public class TreeUtils {
    public static void showTree(Node root) { // Simular un metodo dentro de otro metodo (no permitido en Java) usando una clase auxiliar
        class Auxiliar {
            static void _show(Node node, String prefix, boolean isLeft) {
                if (node != null) {
                    _show(node.right, prefix + (isLeft ? "│   " : "    "), false);
                    System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
                    _show(node.left, prefix + (isLeft ? "    " : "│   "), true);
                }
            }

            static Node minData(Node node) {
                Node current = node;
                while (current.left != null)
                    current = current.left;
                return current;
            }
        } // end Auxiliar

        System.out.println("-->");
        Auxiliar._show(root, "", true);
        System.out.println("dato menor: " +Auxiliar.minData(root).data);
        System.out.println("<--");

        Function<Node, Node> menorData = (Node node) -> {
            Node current = node;
            while (current.left != null)
                current = current.left;
            return current;
        };
        System.out.println("dato menor (lambda): " + menorData.apply(root).data);
        
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        //tree.insert(7);
        int[] datos = {7, 3, 13, 19, 8, 14, 15, 18};
        for (int element : datos) {
            tree.insert(element);
        }

        showTree(tree.root);
    }

}
