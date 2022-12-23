package algorithm_ex.about_string;

import java.util.Scanner;

public class Crypto {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        String cryp = sc.next();
        String subCryp;
        String res = "";
        cryp = cryp.replace('*', '0').replace('#', '1');

        for (int i = 0; i < cnt; i++) {
            subCryp = cryp.substring(i * 7, i * 7 + 7);
            int ch = Integer.parseInt(subCryp, 2);
            res += (char)ch;
        }
        System.out.println(res);

    }

}
