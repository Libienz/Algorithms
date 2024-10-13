import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        int result = bfs(A, B);
        System.out.println(result);
    }

    private static int bfs(long A, long B) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.value == B) {
                return current.count;
            }

            long multiply = current.value * 2;
            long append = current.value * 10 + 1;

            if (multiply <= B) {
                queue.offer(new Node(multiply, current.count + 1));
            }

            if (append <= B) {
                queue.offer(new Node(append, current.count + 1));
            }
        }

        return -1;
    }

    private static class Node {
        long value;
        int count;

        Node(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
