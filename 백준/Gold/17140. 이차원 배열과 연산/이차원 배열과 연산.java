import java.util.*;
import java.io.*;

public class Main {

    private static int r;
    private static int c;
    private static int k;
    private static final int START_ARR_SIZE = 3;
    private static final int MAX_ARR_SIZE = 100;
    private static int[][] arr;
    private static ArrayList<ArrayList<Integer>> rows;
    private static ArrayList<ArrayList<Integer>> cols;


    public static void main(String[] arsg) throws IOException{


/*        //sort test
        ArrayList<Integer> ta = new ArrayList<>();
        ta.add(1);
        ta.add(3);
        ArrayList<Integer> sort = sort(ta);
        System.out.println("sort = " + sort);*/

        //요소들 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        rows = new ArrayList<>();
        cols = new ArrayList<>();
        arr = new int[MAX_ARR_SIZE][MAX_ARR_SIZE];

        for (int i = 0; i < START_ARR_SIZE; i++) {
            rows.add(new ArrayList<>());
            cols.add(new ArrayList<>());
        }
        for (int i = 0; i < START_ARR_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < START_ARR_SIZE; j++) {
                int cur = Integer.parseInt(st.nextToken());
                rows.get(i).add(cur);
                cols.get(j).add(cur);
            }
        }

        int sec = 0;

        while (true) {
            //arr[r][c]의 값이 k가 된다면 연산 종료
            if (
                    rows.size() > r
                    && cols.size() > c
                    && rows.get(r).get(c) == k) {
                bw.write(sec + "");
                bw.flush();
                break;
            }
            //혹은 100초가 지나면 연산 종료
            if (sec >= 100) {
                bw.write(-1 + "");
                bw.flush();
                break;
            }
            if (rows.size() >= cols.size()) {
                rOperation();
            }
            else if (rows.size() < cols.size()){
                cOperation();
            }
            sec++;

        }




    }

    public static void rOperation() {
        //모든 행에 대해서 정렬 수행
        ArrayList<ArrayList<Integer>> tmpRows = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tmpCols = new ArrayList<>();

        int maxSize = Integer.MIN_VALUE;

        for (ArrayList<Integer> row : rows) {
            ArrayList<Integer> sorted = sort(row);
            if (sorted.size() >= maxSize) {
                maxSize = sorted.size();
            }
            tmpRows.add(sorted);
        }

        //0채우기
        for (ArrayList<Integer> tmpRow : tmpRows) {
            int curSize = tmpRow.size();
            for (int i = 0; i < maxSize - curSize; i++) {
                tmpRow.add(0);
            }
        }
        int colSize = tmpRows.get(0).size();

        //cols 상태 맞추기
        for (int i = 0; i < colSize; i++) {
            tmpCols.add(new ArrayList<>());
        }

        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < tmpRows.size(); j++) {
                tmpCols.get(i).add(tmpRows.get(j).get(i));
            }
        }

        rows.clear();
        cols.clear();
        rows = tmpRows;
        cols = tmpCols;
    }
    public static void cOperation() {
        //모든 열에 대해서 정렬 수행
        ArrayList<ArrayList<Integer>> tmpRows = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tmpCols = new ArrayList<>();

        int maxSize = Integer.MIN_VALUE;

        for (ArrayList<Integer> col : cols) {
            ArrayList<Integer> sorted = sort(col);
            if (sorted.size() >= maxSize) {
                maxSize = sorted.size();
            }
            tmpCols.add(sorted);
        }

        //0채우기
        for (ArrayList<Integer> tmpCol : tmpCols) {
            int curSize = tmpCol.size();
            for (int i = 0; i < maxSize - curSize; i++) {
                tmpCol.add(0);
            }
        }

        int rowSize = tmpCols.get(0).size();
        //rows 상태 맞추기
        for (int i = 0; i < rowSize; i++) {
            tmpRows.add(new ArrayList<>());
        }

        for (int i = 0; i < tmpCols.get(0).size(); i++) {
            for (int j = 0; j < tmpCols.size(); j++) {
                tmpRows.get(i).add(tmpCols.get(j).get(i));
            }
        }


        rows.clear();
        cols.clear();
        rows = tmpRows;
        cols = tmpCols;
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> arr) {

        Map<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : arr) {
            if (num == 0) {
                continue;
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        while (!freq.isEmpty()) {
            int minFreqKey = 0;
            int minFreq = Integer.MAX_VALUE;
            for (Integer key : freq.keySet()) {
                Integer curFreq = freq.get(key);
                if (curFreq < minFreq) {
                    minFreqKey = key;
                    minFreq = curFreq;
                }
                if (curFreq == minFreq) {
                    if (minFreqKey > key) {
                        minFreqKey = key;
                        minFreq = curFreq;
                    }
                }

            }
            freq.remove(minFreqKey);
            res.add(minFreqKey);
            res.add(minFreq);
        }

        return res;
    }
    static class ArraySizeInfo {
        private int rowSize;
        private int colSize;

        public ArraySizeInfo(int rowSize, int colSize) {
            this.rowSize = rowSize;
            this.colSize = colSize;
        }
    }
}
