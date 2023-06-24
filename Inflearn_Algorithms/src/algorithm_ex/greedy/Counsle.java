package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Conference implements Comparable<Conference> {
    private int st;
    private int ft;

    public Conference(int st, int ft) {
        this.st = st;
        this.ft = ft;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getFt() {
        return ft;
    }

    public void setFt(int ft) {
        this.ft = ft;
    }

    @Override
    public int compareTo(Conference o) {
        if (o.getFt() == this.getFt()) {
            return this.getSt() - o.getSt();
        }
        return this.getFt() - o.getFt();
    }

    @Override
    public String toString() {
        return "Conference{" +
                "st=" + st +
                ", ft=" + ft +
                '}';
    }
}
public class Counsle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt(); //회의 개수
        ArrayList<Conference> arr = new ArrayList<>();
        ArrayList<Conference> timeTable = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            int st = sc.nextInt(); //회의 시작시간
            int ft = sc.nextInt(); //회의 종료시간
            Conference cf = new Conference(st, ft);
            arr.add(cf);

        }


        Collections.sort(arr);
//        System.out.println("arr = " + arr);

        timeTable.add(arr.get(0));
        for (int i = 1; i < cnt; i++) {
            if (timeTable.get(timeTable.size()-1).getFt() <= arr.get(i).getSt()) {
                timeTable.add(arr.get(i));
            }
        }

        System.out.println(timeTable.size());

    }
}
