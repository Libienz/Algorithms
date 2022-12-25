package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            arr.add(sc.nextInt()); //primitive type이 자동으로 boxing되어서 arrayList에 들어간다.
            if (i == 0 || arr.get(i - 1) < arr.get(i)) { //Shortcut eval
                System.out.printf("%d ", arr.get(i));
            }
        }

    }
}
