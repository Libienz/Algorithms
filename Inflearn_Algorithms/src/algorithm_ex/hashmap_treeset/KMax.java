package algorithm_ex.hashmap_treeset;
import java.util.*;

public class KMax {

    static int n;
    static int k;
    static ArrayList<Integer> sums;
    static ArrayList<Integer> chs;
    static ArrayList<Integer> arr;


    //dfs로 조합 모든 경우 구하는 거 아직도 미숙...
    public static void dfs(int choiced, int si) {
//        System.out.println("choiced = " + choiced);
//        System.out.println("si = " + si);
        if (choiced == 3) {
            int sum = 0;
            for (Integer i : chs) {
                sum += i;
//                System.out.print(i + " ");
            }


            //같은 것이 있다면 cnt 않음으로 같으면 sums에 넣지 않는다.
            if (!sums.contains(sum)) {
                sums.add(sum);
            }
        } else {

            for (int i = si; i < arr.size(); i++) {
                //현재 보고있는 i를 뽑는다.
                chs.add(arr.get(i));
                dfs(choiced + 1, i+1);
                //현재 보고있는 i를 뽑지 않는다.
                chs.remove(arr.get(i));
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //static 변수들 초기화
        n = sc.nextInt();
        k = sc.nextInt();
        sums = new ArrayList<>();
        arr = new ArrayList<>();
        chs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }


        //k개를 골라서 합한 모든 경우의 수 구하기 위해 dfs 사용]
        //합들은 static 변수인 sums에 저장
        int choiced = 0;
        dfs(choiced, 0);

        Collections.sort(sums);
        Integer res;
        if (0 > sums.size() - k) {
            System.out.println(-1);
            return;
        }
        res = sums.get(sums.size() - k);
        System.out.println(res);
//        System.out.println("sums = " + sums);
    }
}