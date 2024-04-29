import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<String> mbtis = new ArrayList<>();
            if (N >= 33) {
                bw.write(String.valueOf(0));
                bw.newLine();
                continue;
            }
            
            for (int j = 0; j < N; j++) {
                String mbti = st.nextToken();
                mbtis.add(mbti);
            }
            int result = calculateMinimumPsychologicalDistance(mbtis);
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
    }


    public static int calculateMinimumPsychologicalDistance(List<String> mbtis) {
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < mbtis.size() - 2; i++) {
            for (int j = i + 1; j < mbtis.size() - 1; j++) {
                for (int k = j + 1; k < mbtis.size(); k++) {
                    int pd = calculatePsychologicalDistanceBetweenThree(mbtis.get(i), mbtis.get(j), mbtis.get(k));
                    if (pd < minimum) {
                        minimum = pd;
                    }
                }
            }
        }
        return minimum;
    }

    public static int calculatePsychologicalDistanceBetweenThree(String mbti1, String mbti2, String mbti3) {
        int distance1 = calculatePsychologicalDistanceBetweenTwo(mbti1, mbti2);
        int distance2 = calculatePsychologicalDistanceBetweenTwo(mbti1, mbti3);
        int distance3 = calculatePsychologicalDistanceBetweenTwo(mbti2, mbti3);
        int result = distance1 + distance2 + distance3;

        return result;
    }

    public static int calculatePsychologicalDistanceBetweenTwo(String mbti1, String mbti2) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if (mbti1.charAt(i) != mbti2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
