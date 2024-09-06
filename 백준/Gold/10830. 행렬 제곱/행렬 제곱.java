import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static long B;
    private static long[][] matrix;
    private static Map<Long, long[][]> exponentedMatrix = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Long.parseLong(st.nextToken());
            }
        }

        exponentedMatrix.put(1L, matrix);
        long[][] res = exponentMatrix(matrix, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(String.valueOf(res[i][j] % 1000) + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }

    public static long[][] matrixMultiply(long[][] matrix1, long[][] matrix2) {
        long[][] res = new long[matrix1.length][matrix1[0].length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                long summation = 0L;
                for (int k = 0; k < res.length; k++) {
                    summation += matrix1[i][k] * matrix2[k][j];
                }
                res[i][j] = summation % 1000L;
            }
        }
        return res;
    }

    public static long[][] exponentMatrix(long[][] matrix, long exp) {
        long[][] memoized = exponentedMatrix.get(exp);
        if (memoized != null) {
            return memoized;
        }

        long[][] res = new long[matrix.length][matrix[0].length];
        long[][] halfExponented = exponentMatrix(matrix, exp / 2);
        if (exp % 2 == 0) {
            res = matrixMultiply(halfExponented, halfExponented);
        } else {
            res = matrixMultiply(halfExponented, exponentMatrix(matrix, (exp / 2) + 1));
        }

        exponentedMatrix.put(exp, res);
        return res;
    }
}

