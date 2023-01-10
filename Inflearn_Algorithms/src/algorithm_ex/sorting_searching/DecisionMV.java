package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.Scanner;

public class DecisionMV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfSongs = sc.nextInt();
        int numOfDvds = sc.nextInt();
        ArrayList<Integer> songLengths = new ArrayList<>();
        int totalLength = 0;
        for (int i = 0; i < numOfSongs; i++) {
            int length = sc.nextInt();
            songLengths.add(length);
            totalLength += length;
        }

        int vol = totalLength / numOfDvds;
//        System.out.println("vol = " + vol);

        for (int i = vol; i < 10000; i++) {
            //dvd 하나에 i만큼의 용량을 가지고 있을 때
            int dvdVol = i;
            int used = 1;
            for (Integer sl : songLengths) {
                if ((dvdVol - sl) < 0) {
                    used++;
                    dvdVol = i;
                }
                dvdVol -= sl;
            }

//            System.out.println("used = " + used);
            if (used <= numOfDvds) {
                System.out.println(i);
                return;
            }
        }


    }

}
