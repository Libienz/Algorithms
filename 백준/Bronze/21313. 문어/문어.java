import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, List<Integer>> octopusAvailableHands = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int octopusId = 0; octopusId < N; octopusId++) {
            octopusAvailableHands.put(octopusId, createInitialHands());
        }

        for (int octopusId = 0; octopusId < N; octopusId++) {
            List<Integer> sourceOctopusAvailableHands = octopusAvailableHands.get(octopusId);
            List<Integer> destinationOctopusAvailableHands = octopusAvailableHands.get(octopusId + 1);
            if (octopusId == N - 1) {
                destinationOctopusAvailableHands = octopusAvailableHands.get(0);
            }

            int handCandidate = 1;
            while (!sourceOctopusAvailableHands.contains(handCandidate) ||
                    !destinationOctopusAvailableHands.contains(handCandidate)) {
                handCandidate++;
            }

            sourceOctopusAvailableHands.remove((Object) handCandidate);
            destinationOctopusAvailableHands.remove((Object) handCandidate);
            bw.write(String.valueOf(handCandidate));
            bw.write(" ");

        }
        bw.flush();
    }

    private static int min(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static List<Integer> createInitialHands() {
        List<Integer> hands = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            hands.add(i);
        }
        return hands;
    }
}
