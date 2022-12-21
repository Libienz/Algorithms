package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Coord {

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

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
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class CoordSort {

    public static void coordSort(List<Coord> arr) {

        Coord min = new Coord(Integer.MAX_VALUE,Integer.MAX_VALUE);
        for (int j = 0; j<arr.size(); j++) {
            int min_index = -1;

            for (int i = j; i<arr.size(); i++) {
                if (arr.get(i).getX() < min.getX()) {
                    min = arr.get(i);
                    min_index = i;
                }
                else if (arr.get(i).getX() == min.getX()) {
                    if (arr.get(i).getY() < min.getY()) {
                        min = arr.get(i);
                        min_index = i;
                    }
                }
            }
            //System.out.println(min);
            Coord tmp = arr.get(j);
            arr.set(j,min);
            arr.set(min_index,tmp);
            min = new Coord(Integer.MAX_VALUE,Integer.MAX_VALUE);
            min_index = -1;
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Coord> coord_arr = new ArrayList<>();

        for (int i = 0; i<num; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            Coord coord = new Coord(x,y);
            coord_arr.add(coord);
        }

        coordSort(coord_arr);

        for (Coord c : coord_arr) {
            System.out.print(c.getX() + " " + c.getY() + "\n");
        }


    }
}
