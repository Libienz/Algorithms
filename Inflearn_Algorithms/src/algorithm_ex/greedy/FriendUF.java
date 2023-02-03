package algorithm_ex.greedy;


import java.util.Scanner;

public class FriendUF {


    //unf: 인덱스 1의 값이 3이라면 1번 학생은 3그룹에 속한다는 뜻
    static int unf[];

    public static void union(int s1, int s2) {

        int g1 = find(s1);
        int g2 = find(s2);

        //s1이 속한 그룹번호 g1과 s2가 속한 그룹번호 g2가 다를 경우 두 그룹을 합친다.
        //find는 파라미터로 넘어간 학생이 속한 그룹 번호를 알려주는 메서드
        if (g1 != g2) {
            unf[g1] = g2;
        }
    }

    //파라미터로 넘어온 학생이 (학생번호) 어느 그룹에 속하는지를 알리는 메서드
    public static int find(int s) {
        if (s == unf[s]) {
            return s;
        } else {
            //return find(unf[s]);
            //위의 코드도 정상동작 but 경로 압축한 버젼은 다음과 같다
            return unf[s] = find(unf[s]);

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();  //학생 명수 (student)
        int r = sc.nextInt(); //숫자 쌍의 개수 (relation)

        unf = new int[s + 1];

        for (int i = 0; i <= s; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < r; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            union(s1, s2);
        }

        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        //문제에서는 s1과 s2가 친구사이인지 확인하고 싶다.
        if (find(s1) == find(s2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
//        for (int i : unf) {
//            System.out.println(i);
//        }
    }

}
