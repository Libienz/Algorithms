import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node rootNode = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String numberString = br.readLine();
            if (numberString == null || numberString.isBlank()) {
                break;
            }
            Node curNode = new Node(Integer.parseInt(numberString));
            placeNodeToBinarySearchTree(rootNode, curNode);
        }

        printPostOrderTraverse(rootNode, bw);
        bw.flush();
    }

    private static void placeNodeToBinarySearchTree(Node rootNode, Node target) {
        if (target.isBiggerThan(rootNode)) {
            if (rootNode.right == null) {
                rootNode.right = target;
            } else {
                placeNodeToBinarySearchTree(rootNode.right, target);
            }
        } else {
            if (rootNode.left == null) {
                rootNode.left = target;
            } else {
                placeNodeToBinarySearchTree(rootNode.left, target);
            }
        }
    }

    private static void printPostOrderTraverse(Node rootNode, BufferedWriter bw) throws IOException {
        if (rootNode.left != null) {
            printPostOrderTraverse(rootNode.left, bw);
        }
        if (rootNode.right != null) {
            printPostOrderTraverse(rootNode.right, bw);
        }
        bw.write(String.valueOf(rootNode.value));
        bw.newLine();
    }

    private static class Node implements Comparable<Node> {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return o.value - this.value;
        }

        public boolean isBiggerThan(Node target) {
            return this.value >= target.value;
        }
    }
}

