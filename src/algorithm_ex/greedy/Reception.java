package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class StayTime implements Comparable<StayTime>{

    private int start;
    private int finish;

    @Override
    public String toString() {
        return "StayTime{" +
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

    public StayTime(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }



    @Override
    public int compareTo(StayTime o) {
        return this.getFinish() - o.getFinish(); //끝나는 시간 오름차순으로
    }
}
public class Reception {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<StayTime> arr = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            arr.add(new StayTime(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(arr);

        System.out.println(getSameTimeMaxNumOfPeople(arr));

    }

    private static int getSameTimeMaxNumOfPeople(List<StayTime> arr) {

        int size = arr.get(arr.size() - 1).getFinish();
        //System.out.println("size = " + size);
        int[] same_time_num = new int[size + 1];
        for (StayTime person : arr) {
            int start = person.getStart();
            int finish = person.getFinish();

            for (int i = start; i < finish; i++) {
                same_time_num[i]++;
            }
        }

        int max = Integer.MIN_VALUE;

        for (int n : same_time_num) {
            if (n > max) {
                max = n;
            }
        }

        return max;
    }
}
