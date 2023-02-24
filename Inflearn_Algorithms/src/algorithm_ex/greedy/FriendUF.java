package algorithm_ex.greedy;


import java.util.ArrayList;
import java.util.Scanner;

public class FriendUF {

    public static int[] arr;

    //그룹 번호 리턴
    public static int find(int p) {
        if (arr[p] == p) {
            return p;
        } else {
            return find(arr[p]);
        }
    }

    public static void union(int p1, int p2) {
        int g1 = find(p1);
        int g2 = find(p2);
        if (g1 != g2) {
            if (g1 > g2) {
                arr[g1] = g2;
            } else {
                arr[g2] = g1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //학생 수
        int m = sc.nextInt(); //숫자 쌍의 개수
        arr = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();

            //p1과 p2는 friend
            union(p1, p2);
        }

        int f1 = sc.nextInt();
        int f2 = sc.nextInt();
//        System.out.println("f1 = " + f1);
//        System.out.println("f2 = " + f2);
        if (find(f1) == find(f2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");

        }
//        for (int num : arr) {
//            System.out.println(num);
//
//        }

    }

}
