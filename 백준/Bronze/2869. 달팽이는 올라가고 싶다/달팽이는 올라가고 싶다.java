import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int height = V - A;
        int climbHeightPerDay = A - B;

        //height까지 가기 위해서 며칠이 필요한가
        int day = 0;
        if (height % climbHeightPerDay == 0) {
            day = height / climbHeightPerDay;
        } else {
            day = height / climbHeightPerDay + 1;
        }
        bw.write(String.valueOf(day + 1));
        bw.flush();
    }

}