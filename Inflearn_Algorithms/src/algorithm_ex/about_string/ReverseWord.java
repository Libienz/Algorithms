package algorithm_ex.about_string;


import java.util.Scanner;


public class ReverseWord {

    public static void main(String[] args) {

        int lt, rt;
        char tmp;// tmp는 스왑에 사용될 캐릭터
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for (int i = 0; i < cnt; i++) {
            char[] str = sc.next().toCharArray();
            lt = 0;
            rt = str.length - 1;

            while (lt < rt) { //문자열의 길이가 홀수든 짝수든 상관없다.
                tmp = str[lt];
                str[lt] = str[rt];
                str[rt] = tmp;
                lt++;
                rt--;
            }
            String s = String.valueOf(str);
            System.out.println(s);

        }

    }
}

