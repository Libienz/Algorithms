import java.util.*;

public class Q1780 {

    private static int n; //초기 n*n 크기의 종이가 있다
    static int[][] paper;
    static int zeroPaperCount;
    static int minusOnePaperCount;
    static int plusOnePaperCount;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        divideAndConquer(0, 0, n);
        System.out.println(minusOnePaperCount);
        System.out.println(zeroPaperCount);
        System.out.println(plusOnePaperCount);

    }

    /**
     * @param rs rowStart
     * @param cs colStart
     * @param size
     */
    public static void divideAndConquer(int rs, int cs, int size) {

        if (isCoherent(rs, cs, size)) {
            switch (paper[rs][cs]) {
                case 0:
                    zeroPaperCount++;
                    break;
                case 1:
                    plusOnePaperCount++;
                    break;
                case -1:
                    minusOnePaperCount++;
                    break;
                default:
                    break;
            }
        } else {
            int newSize = size / 3;
            divideAndConquer(rs, cs, newSize); //상좌
            divideAndConquer(rs + newSize, cs, newSize); //상중
            divideAndConquer(rs + newSize * 2, cs, newSize); //상우
            divideAndConquer(rs, cs +newSize, newSize); //중좌
            divideAndConquer(rs + newSize, cs + newSize, newSize); //중중
            divideAndConquer(rs + newSize * 2, cs + newSize, newSize); //중우
            divideAndConquer(rs, cs + newSize * 2, newSize); //하좌
            divideAndConquer(rs + newSize, cs + newSize * 2, newSize); //하중
            divideAndConquer(rs + newSize * 2, cs + newSize * 2, newSize); //하우

        }
    }


    public static boolean isCoherent(int rs, int cs, int size) {
        //shortCut
        if (size == 1) {
            return true;
        }

        int prev = paper[rs][cs];
        for (int i = rs; i < rs + size; i++) {
            for (int j = cs; j < cs + size; j++) {
                if (paper[i][j] != prev) {
                    return false;
                }
            }
        }
        return true;
    }
}
