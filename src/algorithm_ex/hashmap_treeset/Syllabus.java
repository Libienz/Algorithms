package algorithm_ex.hashmap_treeset;



import java.util.Scanner;



public class Syllabus {

    public static boolean isContain(String must,char ch) {
        char[] ch_arr = must.toCharArray();
        for (int i = 0; i<must.length(); i++) {
            if (ch_arr[i] == ch) {
                return true;
            }
        }
        return false;
    }
    public static String isProper(String must, String schedule) {

        int must_ind = 0;
        char[] sch_arr = schedule.toCharArray();

        for (int i = 0; i<schedule.length(); i++) {
            if (!isContain(must,sch_arr[i])) { //must에 안들어있는 다른 것
                continue;
            }
            else {
                if (must.charAt(must_ind) == sch_arr[i]) {
                    must_ind++;
                    continue;

                }
                else return "NO";
            }
        }

        try {
            must.charAt(must_ind);
        }
        catch (StringIndexOutOfBoundsException e) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String must = sc.next();
        String schedule = sc.next();

        System.out.println(isProper(must, schedule));

    }
}
