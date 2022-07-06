package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

public class CalcScore {
    public static int calcScore(ArrayList<Integer> corr_list) {
        int weight = 0;
        int res = 0;

        for (int i : corr_list) {
            if(i == 0) {
                weight = 0;
            }
            else {
                res = res+i+weight;
                weight++;
            }

        }
        return res;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_of_prob = sc.nextInt();
        ArrayList<Integer> correct_list = new ArrayList<>();
        for (int i = 0; i<num_of_prob; i++) {
            correct_list.add(sc.nextInt());
        }


        System.out.println(calcScore(correct_list));

    }
}
