package algorithm_ex.sorting_searching;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point implements Comparable<Point> {

    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.getX() == o.getX()) return this.getY() - o.getY(); // 양수일 경우 두 객체의 자리가 바뀐다!!!!
        else return this.getX() - o.getX(); //o는 바로 뒷자리를 가리킴
    }
}
public class PointSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Point> pt_list = new ArrayList<>();
        for (int i = 0; i<num; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pt_list.add(new Point(x,y));
        }
        Collections.sort(pt_list);

        for (Point pt : pt_list) {
            System.out.println(pt.getX() + " " + pt.getY());
        }
    }
}
