package algorithm_ex.about_array;

import java.util.Scanner;

public class ReversePrime {
    public static String stringReverse(String str) {
        char[] ch_arr = str.toCharArray();
        int lt = 0;
        int rt = ch_arr.length-1;
        char tmp;

        while(lt<rt) {
            tmp = ch_arr[lt];
            ch_arr[lt] = ch_arr[rt];
            ch_arr[rt] = tmp;
            lt++;
            rt--;
        }
        return String.valueOf(ch_arr);
    }
    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        if (num ==2 ) {
            return true;
        }
        for(int i =2;i<num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_of_int = sc.nextInt();
        String num;

        for(int i = 0; i<num_of_int; i++) {
            num = sc.next();
            //StringBuilder stbdr = new StringBuilder(num);
            //num = stbdr.reverse().toString();
            num = stringReverse(num);
            if (isPrime(Integer.valueOf(num))) {
                System.out.print(Integer.valueOf(num)+" ");
            }

        }

    }
}
