package algorithm_ex.about_string;

import java.util.Scanner;

public class Crypto {
    public static String decrypt(String str,int len) {
        int need_decrypt = len;
        int bitnum = str.length()/len;
        String ostr = str;
        String res = "";
        while(0<need_decrypt) {
            int asci_num = 0;
            for (int i = 0; i<bitnum; i++) {
                if(ostr.charAt(i) == '#') {
                    asci_num = asci_num * 2 + 1;
                }
                else {
                    asci_num = asci_num * 2 + 0;
                }
            }
            ostr = ostr.substring(7);
            res += (char)asci_num;
            need_decrypt--;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String str = sc.next();
        //System.out.println(len);
        //System.out.println(str);
        System.out.println(decrypt(str,len));
    }
}
