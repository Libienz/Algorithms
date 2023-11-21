import java.util.*;
import java.io.*;

public class Main {

    private static char maxFrequencyCharacter;
    private static int maxFrequency = Integer.MIN_VALUE;
    private static boolean noUniqueAnswer = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        char[] cs = input.toCharArray();

        Map<Character, Integer> characterCount = calcCharacterCount(cs);

        for (char c : characterCount.keySet()) {
            if (maxFrequency < characterCount.get(c)) {
                maxFrequency = characterCount.get(c);
                noUniqueAnswer = false;
                maxFrequencyCharacter = c;
            } else if (maxFrequency == characterCount.get(c)) {
                noUniqueAnswer = true;
            }
        }

        if (noUniqueAnswer) {
            bw.write("?");
        } else {
            bw.write(maxFrequencyCharacter + "");
        }

        bw.flush();
    }

    private static Map<Character, Integer> calcCharacterCount(char[] cs) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : cs) {
            char cahracter = Character.toUpperCase(c);
            charCountMap.put(cahracter, charCountMap.getOrDefault(cahracter, 0) + 1);
        }
        return charCountMap;
    }
}