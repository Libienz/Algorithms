import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int heartRowPosition;
    private static int heartColPosition;
    private static int leftArmLength;
    private static int rightArmLength;
    private static int waistLength;
    private static int leftLegLength;
    private static int rightLegLength;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        // 심장 위치 찾기
        findHeartPosition(N, map);
        calcLength(N, map);

        bw.write((heartRowPosition + 1) + " " + (heartColPosition + 1));
        bw.newLine();
        bw.write(leftArmLength + " " + rightArmLength + " " + waistLength + " " + leftLegLength + " " + rightLegLength);
        bw.flush();
    }

    private static void findHeartPosition(int N, char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    heartRowPosition = i + 1;
                    heartColPosition = j;
                    return;
                }
            }
        }
    }

    private static void calcLength(int N, char[][] map) {
        int startRow = heartRowPosition;
        int startCol = heartColPosition - 1;

        // 왼쪽 팔 길이 구하기
        while (startRow >= 0 && startCol >= 0 && startCol < N && startRow < N && map[startRow][startCol] == '*') {
            leftArmLength++;
            startCol--;
        }

        startRow = heartRowPosition;
        startCol = heartColPosition + 1;

        // 오른쪽 팔 길이 구하기
        while (startRow >= 0 && startCol >= 0 && startCol < N && startRow < N && map[startRow][startCol] == '*') {
            rightArmLength++;
            startCol++;
        }

        startRow = heartRowPosition + 1;
        startCol = heartColPosition;

        // 허리 길이 구하기
        while (startRow >= 0 && startCol >= 0 && startCol < N && startRow < N && map[startRow][startCol] == '*') {
            waistLength++;
            startRow++;
        }

        startRow = heartRowPosition + waistLength + 1;
        startCol = heartColPosition - 1;

        // 왼쪽 다리 길이 구하기
        while (startRow >= 0 && startCol >= 0 && startCol < N && startRow < N && map[startRow][startCol] == '*') {
            leftLegLength++;
            startRow++;
        }

        startRow = heartRowPosition + waistLength + 1;
        startCol = heartColPosition + 1;

        // 오른쪽 다리 길이 구하기
        while (startRow >= 0 && startCol >= 0 && startCol < N && startRow < N && map[startRow][startCol] == '*') {
            rightLegLength++;
            startRow++;
        }
    }
}
