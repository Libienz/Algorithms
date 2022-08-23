package algorithm_ex.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



/*
젤 많이 주는 애를 고른다
그 다음으로 많이 주는 애를 고른다.

 */
class Request implements Comparable<Request>{

    private int fee;
    private int day;

    @Override
    public String toString() {
        return "Request{" +
                "fee=" + fee +
                ", day=" + day +
                '}';
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Request(int fee, int day) {
        this.fee = fee;
        this.day = day;
    }

    /*public static boolean canYeild(Request[] arr,int r) {

        for (int i = 1; i < r; i++) {
            if (arr[i] ==null)
                return true;
            else
                return false;
        }
        return false;
    }*/

    @Override
    public int compareTo(Request o) {
        if (o.getFee() == this.getFee()) {
            return o.getDay()-this.getDay();//강연료가 같다면 일수가 널널한게 앞쪽으로
        }
        return o.fee - this.fee; // 강연료의 내림차순
    }
}
public class MaxIncome {

    public static void rearrange(Request[] arr, int day) {
        int point =0 ;

        for (int i = 0; i < day; i++) {
            if (arr[i] == null) {
                point = i;
                break;
            }
        }

        for (int i = point; i < day; i++) {
            arr[i] = arr[i + 1];
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Request> req_arr = new ArrayList<>();

        int n = sc.nextInt();
        int latest_day = 0;
        for (int i = 0; i < n; i++) {
            int fee = sc.nextInt();
            int day = sc.nextInt();
            if (day > latest_day) {
                latest_day = day;
            }
            Request request = new Request(fee, day);
            req_arr.add(request);

        }

        Collections.sort(req_arr);

        System.out.println(getMaxIncome(req_arr,latest_day));

    }

    private static int getMaxIncome(List<Request> req_arr,int latest_day) {

        Request arr[] = new Request[latest_day + 1];
        int can_join = 0;


        for (Request r : req_arr) {
            if (arr[r.getDay()] == null) {
                arr[r.getDay()] = r;
            }
            else{

                for (int i = r.getDay(); i >=1 ; i--) {
                    if(arr[i] == null) { //들어갈 수 있음 들어갈 수 있는 애들중에서 제일 나중인 애로 들어갈거임
                        can_join = i;
                    }
                }
                //can_join은 이제 들어갈 수 있는 애들 중 가장 나중 날짜
                if (can_join == 0) { //들어갈 수 없음
                    continue;
                }
                else {
                    arr[can_join] = r;
                    can_join = 0;
                }
                /*if (canYeild(arr, r.getDay())) { //양보가능 한칸씩 땡기기
                    rearrange(arr,r.getDay());
                    arr[r.getDay()] = r;
                }
                else { // 양보 불가능

                    continue;
                }*/
            }
        }
        int sum = 0;
        int count = 0;
        for (Request r : arr) {
            if (r == null) {
                count++;
                System.out.println("null" +" "+  count);
                continue;
            }
            sum += r.getFee();
            System.out.println(r + " " + ++count);
        }

        return sum;
    }
}
