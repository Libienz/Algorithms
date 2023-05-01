package algorithm_ex.sorting_searching;

import java.util.*;

class Student implements Comparable<Student>{
    int idx;
    int height;

    public Student(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }

    @Override
    public int compareTo(Student o) {
        if (o.height == this.height) {
            return this.idx - o.idx;
        } else {
            return this.height - o.height;
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "idx=" + idx +
                ", height=" + height +
                '}';
    }
}
public class Tricker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Student> sa = new ArrayList<>();
//        arr[0] = sc.nextInt();
        int idx = 0;
        for (int i = 0; i < size; i++) {
            sa.add(new Student(idx++, sc.nextInt()));
        }

        Collections.sort(sa);
//        System.out.println("sa = " + sa);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int id = sa.get(i).idx;
            if (i != id) {
                res.add(id + 1);
            }
        }

//        System.out.println("sa = " + sa);
        Collections.sort(res);

        System.out.print(res.get(0) + " ");
        System.out.print(res.get(res.size() - 1));
    }

}
