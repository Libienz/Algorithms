package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ranking {

    public static int rank = 1;

    public static ArrayList<Integer> sort(ArrayList<Integer> kor_score_list) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i<kor_score_list.size(); i++) {
            res.add(kor_score_list.get(i));
        }

        for(int i = 0; i<res.size(); i++) {
            for(int j = 0; j<res.size()-i-1; j++) {
                if (res.get(j)> res.get(j+1)) {
                    int tmp;
                    tmp = res.get(j);
                    res.set(j, res.get(j+1));
                    res.set(j+1,tmp);
                }
            }
        }
        return res;
    }
    public static void arrReverse(ArrayList<Integer> arr) {
        int lt = 0; int rt= arr.size()-1;
        while(lt<rt) {
            int tmp = arr.get(lt);
            arr.set(lt,arr.get(rt));
            arr.set(rt,tmp);
            lt++; rt--;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_of_student = sc.nextInt();
        ArrayList<Integer> korean_score_list = new ArrayList<>();
        ArrayList<Integer> rank_list = new ArrayList<>();

        for (int i = 0; i<num_of_student; i++) {
            korean_score_list.add(sc.nextInt());
            rank_list.add(i+1);
        }




        ArrayList<Integer> res = sort(korean_score_list);
        arrReverse(res);
        for (int i = 0; i<korean_score_list.size(); i++) {
            //System.out.println(res.get(i) + " ");
            System.out.print(res.indexOf(korean_score_list.get(i))+1 + " ");
            //System.out.print(korean_score_list.get(i) + " ");
        }

    }
}
/*

System.out.println("");
        System.out.print(res.indexOf(korean_score_list.get(i))+ " ");
        System.out.println("");
        System.out.print(korean_score_list.get(i) + " ");
        */
