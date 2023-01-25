package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Conference implements Comparable<Conference>{
    private int sTime;
    private int fTime;

    public int getsTime() {
        return sTime;
    }

    public void setsTime(int sTime) {
        this.sTime = sTime;
    }

    public int getfTime() {
        return fTime;
    }

    public void setfTime(int fTime) {
        this.fTime = fTime;
    }

    public Conference(int sTime, int fTime) {
        this.sTime = sTime;
        this.fTime = fTime;
    }

    @Override
    public int compareTo(Conference o) {
        if (this.fTime == o.fTime) {
            return this.sTime - o.sTime;
        }

        return this.fTime - o.fTime;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "sTime=" + sTime +
                ", fTime=" + fTime +
                '}';
    }
}
public class Counsle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int cnt = 0;
        int idx = 0;

        ArrayList<Conference> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(new Conference(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(arr);
        System.out.println("arr = " + arr);

        for (int i = 0; i < size; i++) {
            Conference cur = arr.get(i);
            if (i == 0) {
                cnt++;
                idx = 0;
            } else {
                Conference prev = arr.get(idx);
                if (prev.getfTime() <= cur.getsTime()) {
                    cnt++;
                    idx = i;

                }
                else {
                    continue;
                }
            }

        }

        System.out.println(cnt);
    }
}
