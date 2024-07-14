import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = Integer.parseInt(br.readLine());

        int res = bfs(S);

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static int bfs(int S) {
        Queue<EmojiStatus> q = new LinkedList<>();
        boolean[][] visited = new boolean[10000][10000];
        int sec = 0;
        q.add(new EmojiStatus(1, 0));
        visited[1][0] = true;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                EmojiStatus cur = q.poll();
                if (cur.emojiCount == S) {
                    return sec;
                }
                if (cur.canPaste()) {
                    EmojiStatus paste = cur.paste();
                    if (!visited[paste.emojiCount][paste.clipBoardCount]) {
                        visited[paste.emojiCount][paste.clipBoardCount] = true;
                        q.add(paste);
                    }
                }
                if (cur.canCopy()) {
                    EmojiStatus copy = cur.copy();
                    if (!visited[copy.emojiCount][copy.clipBoardCount]) {
                        visited[copy.emojiCount][copy.clipBoardCount] = true;
                        q.add(copy);
                    }
                }
                if (cur.canPop()) {
                    EmojiStatus pop = cur.pop();
                    if (!visited[pop.emojiCount][pop.clipBoardCount]) {
                        visited[pop.emojiCount][pop.clipBoardCount] = true;
                        q.add(pop);
                    }
                }
            }
            sec++;
        }
        return -1;
    }

    private static class EmojiStatus {
        int emojiCount;
        int clipBoardCount;

        public EmojiStatus(int emojiCount, int clipBoardCount) {
            this.emojiCount = emojiCount;
            this.clipBoardCount = clipBoardCount;
        }

        public boolean canPaste() {
            return clipBoardCount != 0;
        }

        public boolean canPop() {
            return emojiCount > 0;
        }

        public boolean canCopy() {
            return emojiCount > 0;
        }

        public EmojiStatus paste() {
            return new EmojiStatus(emojiCount + clipBoardCount, clipBoardCount);
        }

        public EmojiStatus copy() {
            return new EmojiStatus(emojiCount, emojiCount);
        }

        public EmojiStatus pop() {
            return new EmojiStatus(emojiCount - 1, clipBoardCount);
        }
    }
}
