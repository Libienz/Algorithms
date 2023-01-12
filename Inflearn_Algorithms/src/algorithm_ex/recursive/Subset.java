package algorithm_ex.recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class Subset {
    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void DFS(int num) {
        if (num > n) {
            System.out.println(arr);
        } else {
            //쓴다.
            arr.add(num);
            DFS(num + 1);
            //안쓴다.
            arr.remove(arr.size() - 1);
            DFS(num + 1);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        DFS(1);

    }
}
