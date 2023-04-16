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
    public int compareTo(Coord o) {
        if (o.x == this.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}
public class CoordSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        ArrayList<Coord> arr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(new Coord(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(arr);

        for (Coord c : arr) {
            System.out.print(c.getX() + " " + c.getY());
            System.out.println();
        }

    }
}
