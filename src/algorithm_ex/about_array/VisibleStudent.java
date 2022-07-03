package algorithm_ex.about_array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisibleStudent {
/*
    선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는

    선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
*/
    public static int numOfVisible(List<Integer> height_list) {
        int current_max = 0;
        int num_of_vis = 0;
        for (int i=0; i<height_list.size(); i++) {
            if (current_max < height_list.get(i)) {
                current_max = height_list.get(i);
                num_of_vis++;
            }

        }
        return num_of_vis;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<Integer> height_list = new ArrayList<>();

        for (int i = 0; i<size; i++) {
            height_list.add(sc.nextInt());
        }
        //배열 완성
        System.out.println(numOfVisible(height_list));
    }
}
