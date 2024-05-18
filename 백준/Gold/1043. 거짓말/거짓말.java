import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int[] parent;
    private static Set<Integer> truthAwarePeople = new HashSet<>();
    private static List<List<Integer>> parties = new ArrayList<>();
    private static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int awareOfTruthCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < awareOfTruthCount; i++) {
            truthAwarePeople.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> party = new ArrayList<>();
            int peopleCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < peopleCount; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            Integer firstPerson = party.get(0);

            for (int j = 1; j < party.size(); j++) {
                union(firstPerson, party.get(j));
            }
        }

        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int participant : party) {
                if (truthAwarePeople.contains(find(participant))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                res++;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (truthAwarePeople.contains(a)) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
            
        }
    }
}
