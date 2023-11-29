import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> cardDeck = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            cardDeck.add(i);
        }
        while (cardDeck.size() != 1) {
            cardDeck.poll();
            cardDeck.add(cardDeck.poll());
        }

        Integer lastCard = cardDeck.poll();
        bw.write(String.valueOf(lastCard));
        bw.flush();
    }



}