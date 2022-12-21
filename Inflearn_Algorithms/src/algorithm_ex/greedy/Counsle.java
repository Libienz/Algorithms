package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class CTime implements Comparable<CTime> {
    private int start;
    private int finish;

    @Override
    public String toString() {
        return "CTime{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public CTime(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(CTime o) {
        if (this.getFinish() == o.getFinish()) {
            return  this.getStart() -o.getStart();
        }
        return this.finish - o.finish; //오름차순
    }
}
public class Counsle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<CTime> arr = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            arr.add(new CTime(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(arr);

       // System.out.println("arr = " + arr);
        System.out.println(getMaxCounsle(arr));

    }

    private static int getMaxCounsle(List<CTime> arr) {

        int count = 0;

        int end_time = arr.get(0).getFinish();
        count++;
        for (int i = 1; i < arr.size(); i++) {
            if (end_time <= arr.get(i).getStart()) {
                count++;
                end_time = arr.get(i).getFinish();
            }
        }
        return count;
    }
}
