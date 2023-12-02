import java.util.*;
import java.io.*;

public class Main {
    private static Long id = 0L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            people.add(new Person(w, h));
        }

        for (Person p : people) {
            int rank = 1;
            for (Person o : people) {
                if (p.id == o.id) {
                    continue;
                }
                if (p.compareTo(o) > 0) {
                    rank++;
                }
            }
            bw.write(String.valueOf(rank) + " ");
        }
        bw.flush();
        
    }

    static class Person implements Comparable<Person> {

        private long id;
        private int weight;
        private int height;

        public Person(int weight, int height) {
            this.id = Main.id++;
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Person o) {
            if (o.height < this.height && o.weight < this.weight) {
                return -1;
            }
            if (o.height > this.height && o.weight > this.weight) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", weight=" + weight +
                    ", height=" + height +
                    '}';
        }
    }
}