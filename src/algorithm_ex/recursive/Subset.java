package algorithm_ex.recursive;

import java.util.Scanner;

public class Subset {

    static int num;
    static int[] check;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        check = new int[num + 1];

        DFS(1); //1을 쓸지 말지
    }

    private static void DFS(int n) {
        if (n == num+1) {
            String tmp = "";
            for (int i = 1; i <= num; i++) {
                if(check[i] == 1) {
                    tmp = tmp +" "+ i;
                }
            }
            if (tmp.length() == 0) {
                return;
            }
            else {
                System.out.println(tmp);

            }

        }
        else {
            check[n] = 1;
            DFS(n + 1);
            check[n] = 0;
            DFS(n + 1);
        }
    }
}
