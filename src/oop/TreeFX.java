package oop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// ─── Visualizador JavaFX ─────────────────────────────────────────────────────
public class TreeFX extends Application {

    // ── Parámetros visuales ──────────────────────────────────────────────────
    private static final double NODE_RADIUS = 22; // radio del círculo
    private static final double LEVEL_GAP = 80; // separación vertical entre niveles
    private static final double MIN_H_GAP = 50; // separación horizontal mínima entre nodos
    private static final Color NODE_FILL = Color.web("#4A90D9");
    private static final Color NODE_STROKE = Color.web("#2C5F8A");
    private static final Color EDGE_COLOR = Color.web("#888888");
    private static final Color TEXT_COLOR = Color.WHITE;

    // ── Punto de entrada de la aplicación ────────────────────────────────────
    @Override
    public void start(Stage stage) {
        Node root = buildSampleTree(); // <- sustituir por tu árbol real
        ScrollPane scrollPane = buildTreeView(root);

        stage.setScene(new Scene(scrollPane, 900, 600));
        stage.setTitle("Binary Tree - JavaFX");
        stage.show();
        System.out.println("Árbol visualizado con JavaFX");
    }

    // ════════════════════════════════════════════════════════════════════════
    // buildTreeView(Node root)
    // Recibe la dirección del nodo raíz y devuelve un ScrollPane listo
    // para insertarse en cualquier Scene o layout.
    // ════════════════════════════════════════════════════════════════════════
    public ScrollPane buildTreeView(Node root) {
        Pane pane = new Pane();

        if (root != null) {
            // Calcular la anchura total que necesita el árbol para posicionar el root
            double treeWidth = calcTreeWidth(root, 0);
            double startX = treeWidth / 2.0 + 40; // centro horizontal
            double startY = 50; // margen superior

            // Dibujar de forma recursiva
            drawTree(pane, root, startX, startY, treeWidth / 4.0, 0);
        }

        ScrollPane scrollPane = new ScrollPane(pane);
        scrollPane.setFitToWidth(false);
        scrollPane.setFitToHeight(false);
        scrollPane.setStyle("-fx-background: white;");
        return scrollPane;
    }

    // ════════════════════════════════════════════════════════════════════════
    // drawTree – recursión DFS principal
    // Parámetros:
    // pane = contenedor donde se agregan los nodos
    // node = nodo actual
    // x, y = coordenadas del centro de ESTE nodo
    // hGap = mitad del espacio horizontal asignado a este subárbol
    // level = profundidad (0 = raíz)
    // ════════════════════════════════════════════════════════════════════════
    private void drawTree(Pane pane, Node node, double x, double y,
            double hGap, int level) {
        if (node == null)
            return;

        // Coordenadas de los hijos
        double childY = y + LEVEL_GAP;
        double nextGap = Math.max(hGap / 2.0, MIN_H_GAP);

        // ── Dibujar aristas ANTES que los nodos (quedan detrás) ──
        if (node.left != null) {
            drawEdge(pane, x, y, x - hGap, childY);
            drawTree(pane, node.left, x - hGap, childY, nextGap, level + 1);
        }
        if (node.right != null) {
            drawEdge(pane, x, y, x + hGap, childY);
            drawTree(pane, node.right, x + hGap, childY, nextGap, level + 1);
        }

        // ── Dibujar el nodo actual ──
        drawNode(pane, node.data, x, y);
    }

    // ════════════════════════════════════════════════════════════════════════
    // drawNode – Circle + Text centrado
    // ════════════════════════════════════════════════════════════════════════
    private void drawNode(Pane pane, int data, double x, double y) {
        Circle circle = new Circle(x, y, NODE_RADIUS);
        circle.setFill(NODE_FILL);
        circle.setStroke(NODE_STROKE);
        circle.setStrokeWidth(2);

        Text text = new Text(String.valueOf(data));
        text.setFont(Font.font("System", FontWeight.BOLD, 14));
        text.setFill(TEXT_COLOR);

        // Centrar el texto dentro del círculo
        text.setX(x - text.getLayoutBounds().getWidth() / 2);
        text.setY(y + text.getLayoutBounds().getHeight() / 4);

        pane.getChildren().addAll(circle, text);
    }

    // ════════════════════════════════════════════════════════════════════════
    // drawEdge – línea entre el borde del nodo padre y el del hijo
    // ════════════════════════════════════════════════════════════════════════
    private void drawEdge(Pane pane,
            double x1, double y1,
            double x2, double y2) {
        // Calcular el ángulo para que la línea empiece/termine en el borde del círculo
        double angle = Math.atan2(y2 - y1, x2 - x1);

        double startX = x1 + NODE_RADIUS * Math.cos(angle);
        double startY = y1 + NODE_RADIUS * Math.sin(angle);
        double endX = x2 - NODE_RADIUS * Math.cos(angle);
        double endY = y2 - NODE_RADIUS * Math.sin(angle);

        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(EDGE_COLOR);
        line.setStrokeWidth(1.8);

        pane.getChildren().add(line); // se agrega ANTES del nodo → queda detrás
    }

    // ════════════════════════════════════════════════════════════════════════
    // calcTreeWidth – estima el ancho total del subárbol para centrar la raíz
    // Usa el número de nodos en el nivel más ancho × separación mínima
    // ════════════════════════════════════════════════════════════════════════
    private double calcTreeWidth(Node node, int depth) {
        if (node == null)
            return 0;
        double leftW = calcTreeWidth(node.left, depth + 1);
        double rightW = calcTreeWidth(node.right, depth + 1);
        return Math.max(MIN_H_GAP * 2, leftW + rightW + MIN_H_GAP);
    }

    // ════════════════════════════════════════════════════════════════════════
    // buildSampleTree – construye el mismo árbol del main() de Tree.java
    // Sustituir esta función por la raíz de tu propio árbol
    // ════════════════════════════════════════════════════════════════════════
    private Node buildSampleTree() {
        // Inserta los mismos datos: [7, 3, 13, 19, 8, 14, 15, 18]
        // con balanceo AVL para reproducir exactamente el árbol de Tree.java
        Tree tree = new Tree();
        int[] datos = { 7, 3, 13, 19, 8, 14, 15, 18 };
        for (int d : datos)
            tree.insert(d);
        return tree.root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
