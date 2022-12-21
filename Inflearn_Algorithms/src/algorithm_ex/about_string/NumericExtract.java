package algorithm_ex.about_string;

import java.util.Scanner;

public class NumericExtract {

    public static int extractNum(String str) {
        String obj_str = str.replaceAll("[^0-9]", "");
        System.out.println(obj_str);
        //char[] ch_arr = str.toCharArray();
        //return (Integer)obj_str;
        //문자열을 .. 숫자로 ..
/*        int res = 0;
        char[] ch_arr = obj_str.toCharArray();
        for (int i = ch_arr.length -1; i>=0; i--){
            res *= 10;
            res += ch_arr[i];
        }*/
        int res = Integer.valueOf(obj_str);
        return res;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(extractNum(str));

    }
}
