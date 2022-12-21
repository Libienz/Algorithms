package algorithm_ex.about_string;

import java.util.Scanner;

public class SpecificReverse {
    public static String optionReverse(String str) {


        char[] ch_arr = str.toCharArray();
        int lt = 0;
        int rt = ch_arr.length-1;
        char tmp;


        while(lt<rt) {
            if (!((65 <= ch_arr[lt] && ch_arr[lt] <= 90) || (97 <= ch_arr[lt] && ch_arr[lt] <= 122))) {lt++;}
            else if(!((65 <= ch_arr[rt] && ch_arr[rt] <= 90) || (97 <= ch_arr[rt] && ch_arr[rt] <= 122))) {rt--;}
            else{
                tmp = ch_arr[lt];
                ch_arr[lt] = ch_arr[rt];
                ch_arr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(ch_arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(SpecificReverse.optionReverse(str));

    }
}
