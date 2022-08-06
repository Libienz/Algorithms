package recursive;

import java.util.ArrayList;
import java.util.Collections;

class Node1 {
    int data;
    Node1 lt;
    Node1 rt;

    public Node1(int data) {
        this.data = data;
    }
}
class Tree1 {
    Node1 root;

    public Tree1(Node1 root) {
        this.root = root;
    }

    public int DFS(int level, Node1 root) {


        if (root.lt == null && root.rt == null) {
            return level;
        }
        else {
            return Math.min(DFS(level + 1, root.lt),DFS(level + 1, root.rt));

        }
    }

    public int getShortestLeaf() {
        return DFS(0,root);
    }
}
public class ShortestPathToLeaf {

    public static void main(String[] args) {

        Node1 root = new Node1(1);
        root.lt = new Node1(2);
        root.rt = new Node1(3);
        root.lt.lt = new Node1(4);
        root.lt.rt = new Node1(5);
        Tree1 tree1 = new Tree1(root);

        System.out.println(tree1.getShortestLeaf());
    }


}
