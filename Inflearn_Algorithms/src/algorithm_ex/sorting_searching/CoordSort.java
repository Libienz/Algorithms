package algorithm_ex.sorting_searching;

import java.util.*;

class Coord implements Comparable<Coord> {
    private int x;
    private int y;

    public Coord(int x, int y) {
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
    public String toString() {
        return x + " " + y;
    }


    @Override
    public int compareTo(Coord c2) {
        Coord c1 = this;
        //c1과 c2를 비교하는 방법을 알려준다.
        //c1과 c2의 x값이 같다면 Y값으로 비교하라
        if (c1.getX() == c2.getX()) {
            return c1.getY() - c2.getY();
        }
        //x값이 같지 않다면 x값으로 비교하라
        return c1.getX() - c2.getX();
    }
}
public class CoordSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Coord> arr = new ArrayList<>();

        //좌표들을 담은 배열 설정
        for (int i = 0; i < size; i++) {
            arr.add(new Coord(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(arr);

        for (Coord coord : arr) {
            System.out.println(coord);
        }

    }


}
