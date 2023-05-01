package algorithm_ex.recursive;

import java.util.LinkedList;
import java.util.*;

class Node {
    int num;
    Node lt,rt;

    public Node(int num) {
        this.num = num;
    }
}

class Tree {

    Node root;
    public Tree(Node root) {
        this.root = root;
    }
}
public class TreeTravel {
    //왼 -> 중 -> 오
    public static void midOrder(Node t) {
        if (t == null) {
            return;
        }
        midOrder(t.lt);
        System.out.print(t.num + " ");
        midOrder(t.rt);
    }
    public static void preOrder(Node t) {
        //가운데 출력
        if (t == null) {
            //do nothing
            return;
        }
        System.out.print(t.num + " ");
        //왼쪽
        preOrder(t.lt);
        //오른쪽
        preOrder(t.rt);

    }

    public static void postOrder(Node t) {
        //왼 -> 오 -> 중
        if (t == null) {
            return;
        }
        postOrder(t.lt);
        postOrder(t.rt);
        System.out.print(t.num + " ");

    }
    public static void main(String[] args) {
        //tree 초기화
        Tree t = new Tree(new Node(1));
        t.root.lt = new Node(2);
        t.root.rt = new Node(3);
        t.root.lt.lt = new Node(4);
        t.root.lt.rt = new Node(5);
        t.root.rt.lt = new Node(6);
        t.root.rt.rt = new Node(7);

        //전위 순회: 가운데 -> 왼쪽 -> 오른쪽
        preOrder(t.root);
        System.out.println();
        midOrder(t.root);
        System.out.println();
        postOrder(t.root);
        System.out.println();

        //중위 순회

        //후위 순회

    }
}
