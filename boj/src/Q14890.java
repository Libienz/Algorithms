import java.util.*;
import java.io.*;


public class Q14890 {

    private static int N;
    private static int L;
    private static int res;
    private static int[][] map;
    private static boolean[] ramp;
    private static ArrayList<ArrayList<Integer>> rows;
    private static ArrayList<ArrayList<Integer>> cols;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        rows = new ArrayList<>();
        cols = new ArrayList<>();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //row 수집
        for (int i = 0; i < N; i++) {
            rows.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                rows.get(i).add(map[i][j]);
            }
        }

        //col 수집
        for (int i = 0; i < N; i++) {
            cols.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                cols.get(i).add(map[j][i]);
            }
        }



        //rows 체크
        for (ArrayList<Integer> row : rows) {
            if (isFlat(row)) {
//                System.out.println("already flat");
//                System.out.println("row = " + row);
                res++;
            } else {
                if (canBeFlat(row)) {
//                    System.out.println("can be flat");
//                    System.out.println("row = " + row);
                    res++;
                } else {
//                    System.out.println("cannot be flat");
//                    System.out.println("row = " + row);
                }
            }
        }
        //cols 체크
        for (ArrayList<Integer> col : cols) {
            if (isFlat(col)) {
//                System.out.println("already flat");
//                System.out.println("col = " + col);
                res++;
            } else {
                if (canBeFlat(col)) {
//                    System.out.println("can be flat");
//                    System.out.println("col = " + col);
                    res++;
                } else {
//                    System.out.println("cannot be flat");
//                    System.out.println("col = " + col);
                }
            }
        }

        bw.write(res + "");
        bw.flush();

    }

    public static boolean isFlat(ArrayList<Integer> arr) {
        int h = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != h) {
                return false;
            }
        }
        return true;
    }

    public static Boolean canBeFlat(ArrayList<Integer> arr) {

        ramp = new boolean[N];

        int prev = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            int cur = arr.get(i);
            //경사로 필요
            if (prev != cur) {

                //높이 차이가 1이 아닌 경우 fail
                if (Math.abs(prev - cur) != 1) {
                    return false;
                }
                //왼쪽에 경사로 설치
                if (prev < cur) {
                    //경사로를 시작해야 할 부분이 0보다 작다면 fail
                    if (i - L < 0) {
                        return false;
                    }
                    //경사로를 놓아야 하는 곳이 전부 일정한 높이가 아니라면 fail
                    int comp = arr.get(i - 1);
                    for (int j = 1; j <= L; j++) {

                        if (arr.get(i - j) != comp) {
                            return false;
                        }
                        //이미 경사로를 이용한 곳이라면 fail
                        if (ramp[i - j]) {
                            return false;
                        }
                    }
                    //경사로 성공적으로 배치.
                    for (int j = 1; j <= L; j++) {
                        ramp[i - j] = true;
                    }
                }
                //오른쪽에 경사로 설치
                else {
                    //경사로가 끝나야 할 부분이 N보다 크거나 같다면 fail
                    if (i + (L-1) >= N) {
                        return false;
                    }
                    //경사로를 놓아야 하는 곳이 전부 일정한 높이가 아니라면 fail
                    int comp = arr.get(i);
                    for (int j = 1; j < L; j++) {

                        if (arr.get(i + j) != comp) {
                            return false;
                        }
                        //이미 경사로를 이용한 곳이라면 fail
                        if (ramp[i + j]) {
                            return false;
                        }
                    }

                    //경사로 성공적으로 배치.
                    ramp[i] = true;
                    for (int j = 1; j < L; j++) {
                        ramp[i + j] = true;
                    }
                }


            }
            prev = cur;
        }
        return true;
    }



}
