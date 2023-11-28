import javax.print.Doc;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                q.add(new Document(j, Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            //진단
            while (true) {
                if (q.peek().weight >= maxWeight(q)) {
                    Document poll = q.poll();
                    if (poll.id == M) {
                        bw.write(String.valueOf(count + 1) + "\n");
                        bw.flush();
                        break;
                    }
                    count++;
                } else {
                    q.add(q.poll());
                }
            }

        }
    }

    static class Document implements Comparable<Document> {

        private int id;
        private int weight;

        public Document(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(Document o) {
            if (o.weight == this.weight) {
                return o.id - this.id;
            }
            return o.weight - this.weight;
        }
    }

    public static int maxWeight(Queue<Document> q) {

        int maxWeight = Integer.MIN_VALUE;
        for (int i = 0; i < q.size(); i++) {
            Document cur = q.poll();
            if (maxWeight < cur.weight) {
                maxWeight = cur.weight;
            }
            q.add(cur);
        }
        return maxWeight;
    }
}