package algorithm_ex.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

// 피자집 선택하고 거리를 재느냐
// 거리를 재나가면서 피자집을 선택하느냐 ...
// 피자집 조합으로 모든 경우의 구하자

public class Pizza {

    static int N,M,p_count,h_count;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Coord> ph_arr = new ArrayList<>();
    static ArrayList<Coord> h_arr = new ArrayList<>();
    static ArrayList<ArrayList<Coord>> choiced_ph_arr = new ArrayList<>();
    static int min_dist = Integer.MAX_VALUE;
    static int min_dist_sum = 0;

    public static void getShortest() {
        for (ArrayList<Coord> comb : choiced_ph_arr) {

            for (Coord house : h_arr) {
                for (Coord c : comb) {// c는 조합으로 나온 4개의 피잣집중 하나
                    int dist_h_to_p = Math.abs(c.row - house.row) + Math.abs(c.col - house.col);
                    if (min_dist > dist_h_to_p) { //각 집에서 4개의 피잣집중 어느게 젤 가까운지
                        min_dist = dist_h_to_p;
                    }
                }
                //집하나에서 가장 가까운 피자집의 거리 찾음 min_dist
                min_dist_sum += min_dist;
                min_dist = Integer.MAX_VALUE;
            }
            //여기까지 돌고 나온 min_dist_sum은 하나의 피자집 조합에 대한 배달 최소거리의 합
            if (answer > min_dist_sum) {
                answer = min_dist_sum;
            }
            min_dist_sum = 0;
        }
    }
    public static void choicePHouse(int choice_count, ArrayList<Coord> arr, int index) {
        if (index == ph_arr.size()) {
            if (choice_count != M) {
                return;
            }
        }
        if (choice_count == M ) {
            //System.out.println("arr = " + arr);
            ArrayList<Coord> temp = (ArrayList<Coord>) arr.clone(); // 깊은 복사 참조값을 넘기면 안된다고!!
            choiced_ph_arr.add(temp);
        }
        else {

            Coord c = ph_arr.get(index);
            arr.add(c);
            //System.out.println("arr = " + arr);
            choicePHouse(choice_count+1,arr,index+1);
            arr.remove((Coord) c);
            choicePHouse(choice_count, arr, index + 1);



        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        p_count = 0;
        h_count = 0;



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    p_count++;
                    ph_arr.add(new Coord(i, j));
                } else if (map[i][j] == 1) {
                    h_count++;
                    h_arr.add(new Coord(i, j));
                }
            }
        }
        choicePHouse(0, new ArrayList<>(), 0);
        getShortest();
        System.out.println(answer);
        //System.out.println(choiced_ph_arr);





    }
}
