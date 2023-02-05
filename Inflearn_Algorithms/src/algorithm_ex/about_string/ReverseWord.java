package algorithm_ex.about_string;


import java.util.Scanner;


public class ReverseWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int len = s.length();
            int lt = 0;
            int rt = len - 1;
            char[] chars = s.toCharArray();

            while (lt <= rt) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
            System.out.println(chars);
        }
    }
}

