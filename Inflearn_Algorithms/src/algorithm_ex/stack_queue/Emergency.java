package algorithm_ex.stack_queue;

import java.sql.SQLOutput;
import java.util.*;

class Patient {

    private int severity;
    private int pnum;

    public Patient(int sev, int pnum) {
        this.severity = sev;
        this.pnum = pnum;
    }
    public int getSeverity() {
        return severity;
    }

    public int getPnum() {
        return pnum;
    }
}
public class Emergency {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n명의 환자
        int m = sc.nextInt(); //m번째 환자는 몇번째로 진료를 받을까?
        //pq? or q?
        Queue<Patient> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int severity = sc.nextInt();
            int pnum = i;
            Patient p = new Patient(severity, pnum);
            q.add(p);
        }

        //q에 현황 구성 완료
        //진료 시작

        int cnt = 0;

        while (!q.isEmpty()) {
            boolean moreSevere = false;
            Patient cur = q.poll();
            int cs = cur.getSeverity();
            for (Patient p : q) {
                //현재 환자보다 위독한 환자가 있다면
                if (cs < p.getSeverity()) {
//                    System.out.println("cs = " + cs);
//                    System.out.println("p = " + p.getSeverity());
                    moreSevere = true;
                    q.add(cur);
                    break;
                }
            }
            //더 심각한 환자가 있다면 다시 다음환자를 본다.
            if (moreSevere) {
                continue;
            }
            //더 심각한 환자가 없음
            //현재 환자를 진료한다.
            if (cur.getPnum() == m) {
//                System.out.println("cs = " + cs);
                System.out.println(++cnt);
                return;
            }
            else {
                cnt++;
            }


        }

    }

}
