package algorithm_ex.about_string;

import java.util.Scanner;


public class Crypto {

    public static int b2d (String bnum) {

        char[] bs = bnum.toCharArray();
        int res = 0;
        int sp = 0;
        while (bs[sp] == '0') {
            sp++;
        }
        for (int i = sp; i < bs.length; i++) {
            res = (res * 2) + bs[i] - 48;
//            System.out.println("res = " + res);
//            int c = '0';
//            System.out.println("c = " + c);
//            System.out.println("res = " + res);
//            System.out.println("bs = " + (int) bs[i]);


        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String cs = sc.next(); //cryptonized string

//        cs = cs.replaceAll("#", "1");
//        cs = cs.replaceAll("*", "0");

        String bs = "";
        char[] chars = cs.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                bs += 1;
            } else {
                bs += 0;
            }
        }
//        System.out.println("bs = " + bs);

        int clen = bs.length() / len;
        for (int i = 0; i < len; i++) {
            String ch = bs.substring(0, clen);
            bs = bs.substring(7, bs.length());
//            System.out.println("ch = " + ch);
            System.out.print((char)b2d(ch));
        }

    }

}
