import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members.add(new Member(age, name));
        }

        Collections.sort(members);

        for (Member member : members) {
            bw.write(String.format("%d %s\n", member.age, member.name));
        }
        bw.flush();
    }

    static class Member implements Comparable<Member> {

        private static Long id = 0L;

        private Long memberId;
        private int age;
        private String name;

        public Member(int age, String name) {
            this.memberId = id++;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (o.age == this.age) {
                return (int) (this.memberId - o.memberId);
            }
            return this.age - o.age;
        }
    }
}