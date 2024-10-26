import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] nums = arr.substring(1, arr.length() - 1).split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }
            boolean reversed = false;
            boolean error = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    reversed = !reversed;
                } else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }
            if (error) {
                bw.write("error\n");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (reversed) {
                    Iterator<Integer> it = deque.descendingIterator();
                    while (it.hasNext()) {
                        sb.append(it.next());
                        if (it.hasNext()) {
                            sb.append(",");
                        }
                    }
                } else {
                    Iterator<Integer> it = deque.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next());
                        if (it.hasNext()) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
                bw.write(sb.toString());
            }
        }
        bw.flush();
    }
}
