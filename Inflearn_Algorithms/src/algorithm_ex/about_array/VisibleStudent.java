package algorithm_ex.about_array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisibleStudent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int res = 0; //보이는 학생 수
        int subMax = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(sc.nextInt());
        subMax = arr.get(0); //맨 앞은 항상 보임 subMax 갱신
        res++; //맨 앞은 항상 보임
        for (int i = 1; i < cnt; i++) {
            arr.add(sc.nextInt());
            if (subMax < arr.get(i)) { //현재 보는 학생이 subMax보다 크다면
                subMax = arr.get(i); //subMax갱신
                res++; //보이는 학생 ++
            }
        }
        System.out.println(res);
    }
}
