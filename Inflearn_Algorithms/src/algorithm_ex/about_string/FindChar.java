package algorithm_ex.about_string;

import java.util.Scanner;


public class FindChar {
    public static void main (String[] args) {

        String str;
        char c;
        int count = 0;

        Scanner sc = new Scanner(System.in);
        str = sc.next(); //sc.next()는 공백이 발생하기 전까지의 입력 가져온다. enter 전까지 가져오고 싶으면 sc.nextLine()
        c = sc.next().charAt(0); //String의 메소드 charAt()
        str = str.toLowerCase(); //String의 메소드 toLowerCase()
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) == Character.toLowerCase(c)) { // Character의 static method
                count++;
            }
        }

        System.out.println(count);


    }
}
