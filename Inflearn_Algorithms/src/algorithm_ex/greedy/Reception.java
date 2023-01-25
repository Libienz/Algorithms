package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Participent implements Comparable<Participent> {

    private int aTime;
    private int lTime;

    public Participent(int aTime, int lTime) {
        this.aTime = aTime;
        this.lTime = lTime;
    }

    public int getaTime() {
        return aTime;
    }

    public void setaTime(int aTime) {
        this.aTime = aTime;
    }

    public int getlTime() {
        return lTime;
    }

    public void setlTime(int lTime) {
        this.lTime = lTime;
    }

    @Override
    public int compareTo(Participent o) {
        if (o.getaTime() == this.getaTime()) {
            return this.getlTime() - o.getlTime();
        }
        return this.getaTime() - o.getaTime();
    }

    @Override
    public String toString() {
        return "Participent{" +
                "aTime=" + aTime +
                ", lTime=" + lTime +
                '}';
    }
}
public class Reception {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Participent> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(new Participent(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(arr);
//        int cnt = 0;
        int max = Integer.MIN_VALUE;

        //제일 빨리 도착하는 친구의 시간부터 제일 늦게 떠나는 친구의 시간까지 몇명이 있는지 확인한다
        for (int i = arr.get(0).getaTime(); i < arr.get(size - 1).getlTime(); i++) {
            int cnt = 0;
            for (Participent p : arr) {
                //아직 도착 안함
                if (p.getaTime() > i) {
                    continue;
                }
                //도착 해있음
                else {
                    //아직 안떠났다면
                    if (p.getlTime() > i) {
                        cnt++;
                    }
                }
            }
            if (max < cnt) {
                max = cnt;
            }
        }
        System.out.println(max);

    }
}
