import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] heights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] diffs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffs[i] = heights[i + 1] - heights[i];
        }
        
        Arrays.sort(diffs);
        
        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += diffs[i];
        }
        
        bw.write(result + "\n");
        bw.flush();
    }
}