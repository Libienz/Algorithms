import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        if (!isVowelRemovedStringSame(str1, str2)) {
            bw.write("NO");
            bw.flush();
            return;
        }

        if (!isStartAndEndCharacterSame(str1, str2)) {
            bw.write("NO");
            bw.flush();
            return;
        }

        if (!canBeSameByRearrange(str1, str2)) {
            bw.write("NO");
            bw.flush();
            return;
        }

        bw.write("YES");
        bw.flush();
    }

    private static boolean canBeSameByRearrange(String str1, String str2) {
        int[] charCount = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
            charCount[str2.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isStartAndEndCharacterSame(String str1, String str2) {
        return str1.charAt(0) == str2.charAt(0) && str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1);
    }

    private static boolean isVowelRemovedStringSame(String str1, String str2) {
        String filteredStr1 = removeVowels(str1);
        String filteredStr2 = removeVowels(str2);

        return filteredStr1.equals(filteredStr2);
    }

    private static String removeVowels(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!isVowel(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
