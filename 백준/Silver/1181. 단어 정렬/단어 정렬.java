import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> words = new ArrayList<>();
        int wordCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();
            if (words.contains(word)) {
                continue;
            }
            words.add(word);
        }

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for (String word : words) {
            bw.write(word + "\n");
        }
        bw.flush();
    }

}
