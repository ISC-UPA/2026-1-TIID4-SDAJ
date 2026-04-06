package oop;
import java.util.List;

public class testTree {
    public static void main(String[] args) {

        Tree myTree = new Tree();
            
        int[] datos = {7, 3, 13, 19, 8, 14, 15, 18};

        for (int element : datos) {
            myTree.insert(element);
        }

        System.out.println(myTree.root);

        myTree.show();
        
        TreeUtils.showTree(myTree.root);
        
        myTree.inOrder();
        System.out.println(myTree.inOrderList());
        
        boolean r = myTree.search(20);
        System.out.println("\nBuscar 20: " + r);
        System.out.println(myTree.treeBFS());
        
        System.out.println("Tamaño del árbol: " + myTree.size);
        System.out.println("Profundidad mínima del árbol: " + myTree.minDepth());
        System.out.println("Profundidad máxima del árbol: " + myTree.maxDepth());

        List<List<Integer>> niveles = myTree.treeBFS();
        System.out.println("Niveles del árbol (BFS): " + niveles);
        System.out.println("Para visualizar el árbol, ejecuta oop.TreeFX por separado.");

      
        System.out.println(". . . Hecho");
    }
}
