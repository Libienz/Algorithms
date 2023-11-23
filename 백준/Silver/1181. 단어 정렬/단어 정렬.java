import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Word> words = new ArrayList<>();
        int wordCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < wordCount; i++) {
            String wordString = br.readLine();
            Word word = new Word(wordString);
            if (words.contains(word)) {
                continue;
            }
            words.add(word);
        }

        Collections.sort(words);
        for (Word word : words) {
            bw.write(word.getWord() + "\n");
        }
        bw.flush();
    }

    static class Word implements Comparable<Word> {

        private String word;

        public Word(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }

        @Override
        public int compareTo(Word o) {
            if (word.length() == o.word.length()) {
                //알파벳 순 정렬
                return word.compareTo(o.word);
            }
            return this.word.length() - o.word.length();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Word word1 = (Word) o;
            return Objects.equals(word, word1.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

    }

}
