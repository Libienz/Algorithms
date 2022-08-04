package recursive;

import java.util.Scanner;

public class FindCow {

    public static int countJump(int person, int cow) {

        int dist = cow - person;
        int count; //점프 횟수 세는 변수
        //System.out.println("dist = " + dist);
        if (dist < 0) {
            return count = Math.abs(dist);
        }
        count = dist / 5;
        int remain = dist - count*5;
        if (remain >= 3) {
            count++;
            count+= 5 - remain;
        }
        else {
            count += remain;
        }

        return count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int person = sc.nextInt();
        int cow = sc.nextInt();

        System.out.println(countJump(person, cow));
    }
}
