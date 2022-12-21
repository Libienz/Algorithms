package algorithm_ex.about_string;

import java.util.ArrayList;
import java.util.Scanner;

public class InterChar {

    public static int getAbsoluteVal(int num) {
        if(num<0) return -1*num;
        else return num;
    }
    public static int arr_min(ArrayList<Integer> arr) {
        int min_val = 101;
        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i)<min_val) min_val = arr.get(i);
        }

        return min_val;
    }
    public static ArrayList<Integer> getAllIndex(String str, char c) {
        //일단 c의 위치 다딴다
        ArrayList<Integer> index_c = new ArrayList<Integer>();
        //boolean is_first = true;
        int nested = 0;
        while(str.indexOf(c) != -1) {
            index_c.add(str.indexOf(c)+nested);
            nested+=str.indexOf(c) + 1;
            str = str.substring(str.indexOf(c)+1);
        }
        return index_c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        ArrayList<Integer> all_index = getAllIndex(str, c);
        ArrayList<Integer> distance_list = new ArrayList<Integer>();
        for (int i =0; i<str.length(); i++) {
            for(int j=0; j<all_index.size();j++) {
                distance_list.add(getAbsoluteVal(i-all_index.get(j)));
            }
            System.out.printf("%d ",arr_min(distance_list));
            distance_list.clear();
        }
    }
}
