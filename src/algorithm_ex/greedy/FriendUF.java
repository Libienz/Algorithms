package algorithm_ex.greedy;


import java.util.Scanner;

public class FriendUF {

    static int[] unf;

    public static int find(int s) { //이것만 이해하면 된다...

        if (s == unf[s]) {
            return s;
        }
        else {
            return unf[s] = find(unf[s]); //이게 경로 압축
        }

    }

    public static void union(int s1, int s2) { //s1이 더 작음
        int fa = find(s1);
        int fb = find(s2);
        if (fa != fb) {
            unf[Math.max(fa,fb)] = Math.min(fa,fb);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s_num = sc.nextInt(); //학생 수
        int r_num = sc.nextInt(); //학생 관계의 개수

        unf = new int[s_num + 1];
        for (int i = 0; i < unf.length; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < r_num; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int max = Math.max(s1, s2);
            int min = Math.min(s1, s2);
            //s1과 s2는 친구
            union(min, max); //s1과 s2가 한 집합이 되도록 만들어라

        }
        int s1 = sc.nextInt(); // 학생 1
        int s2 = sc.nextInt(); // 학생 2

        if (unf[s1] == unf[s2]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        /*for (int i = 0; i < unf.length; i++) {
            System.out.println(unf[i]);
        }*/


    }

}
