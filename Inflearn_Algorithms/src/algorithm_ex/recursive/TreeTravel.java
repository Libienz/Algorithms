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
    public static void bfs(Node t) {

        Queue<Node> q = new LinkedList<>();
        q.add(t);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.num + " ");
                //현재 노드에서 한 스텝에 닿을 수 있는 것들 q에 넣는다.
                Node lt = cur.lt;
                Node rt = cur.rt;

                if (lt != null) {
                    q.add(lt);
                }
                if (rt != null) {
                    q.add(rt);
                }
            }


        }


    }
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
        System.out.println("Pre");
        preOrder(t.root);
        System.out.println();
        System.out.println("Mid");
        midOrder(t.root);
        System.out.println();
        System.out.println("Post");
        postOrder(t.root);
        System.out.println();
        System.out.println("Bfs");
        bfs(t.root);
        System.out.println();
        //중위 순회

        //후위 순회

    }
}
