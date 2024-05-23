import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Node> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            Node node = new Node(root, left, right);
            tree.add(node);
        }

        preOrderTraversal(tree.get(0), bw);
        bw.newLine();
        midOrderTraversal(tree.get(0), bw);
        bw.newLine();
        postOrderTraversal(tree.get(0), bw);
        bw.flush();
    }

    public static void preOrderTraversal(Node node, BufferedWriter bw) throws IOException {
        bw.write(node.root);
        if (!node.left.equals(".")) {
            Node leftNode = findNode(node.left);
            preOrderTraversal(leftNode, bw);
        }
        if (!node.right.equals(".")) {
            Node rightNode = findNode(node.right);
            preOrderTraversal(rightNode, bw);
        }
    }

    public static void midOrderTraversal(Node node, BufferedWriter bw) throws IOException {
        if (!node.left.equals(".")) {
            Node leftNode = findNode(node.left);
            midOrderTraversal(leftNode, bw);
        }
        bw.write(node.root);
        if (!node.right.equals(".")) {
            Node rightNode = findNode(node.right);
            midOrderTraversal(rightNode, bw);
        }
    }

    public static void postOrderTraversal(Node node, BufferedWriter bw) throws IOException {
        if (!node.left.equals(".")) {
            Node leftNode = findNode(node.left);
            postOrderTraversal(leftNode, bw);
        }
        if (!node.right.equals(".")) {
            Node rightNode = findNode(node.right);
            postOrderTraversal(rightNode, bw);
        }
        bw.write(node.root);
    }


    private static Node findNode(String root) {
        for (Node node : tree) {
            if ((node.root.equals(root))) {
                return node;
            }
        }
        throw new RuntimeException();
    }

    private static class Node {
        String root;
        String left;
        String right;

        public Node(String root, String left, String right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
}
