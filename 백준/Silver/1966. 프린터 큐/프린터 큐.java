import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                queue.add(new Document(i, Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();
                if (queue.stream().anyMatch(doc -> doc.priority > current.priority)) {
                    queue.add(current);
                } else {
                    count++;
                    if (current.index == M) {
                        bw.write(count + "\n");
                        break;
                    }
                }
            }
        }

        bw.flush();
    }

    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
