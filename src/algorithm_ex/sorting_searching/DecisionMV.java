package algorithm_ex.sorting_searching;

import java.util.Scanner;
/*
* 1. 용량을 전체 길이 나누기 3으로 설정해두고 가능한지 확인
* 2. 가능한지 확인은 차근차근 담으면서 용량 초과하면 다음 dvd로 넘기기
* 3. 가능하지 않다면 용량 1만큼 늘리기
*
 */
public class DecisionMV {

    public static int getMinVol(int num, int dvd, int[] song_arr) {

        int sum = 0;
        for(int n : song_arr) {
            sum+= n;
        }
        int left_dvd = dvd;

        int vol = sum/dvd;
        int dvd_vol = 0;

        while(true) {
            System.out.println("vol : " + vol);
            for (int i = 0; i<num; i++) {
                if (dvd_vol + song_arr[i] <= vol) { //현재 넣고 있는 dvd에 넣을 수 있을 떄
                    if (i == num-1) { //dvd에 마지막 곡을 넣고 있다면 끝
                        dvd_vol += song_arr[i];
                        return vol;
                    }
                    else {
                        dvd_vol += song_arr[i]; //dvd에 넣는다.
                    }
                }
                else { //dvd용량 초과 넣을 수 없음
                    left_dvd--;
                    if (left_dvd == 0) {
                        vol++;
                        dvd_vol = 0;
                        left_dvd = dvd;
                        break;

                    }
                    else {
                        dvd_vol = 0;
                        if (dvd_vol + song_arr[i] <= vol) {
                            if (i == num-1) { //dvd에 마지막 곡을 넣고 있다면 끝
                                dvd_vol += song_arr[i];
                                return vol;
                            }
                            dvd_vol += song_arr[i];
                        }
                        else {
                            vol++;
                            dvd_vol = 0;
                            left_dvd = dvd;
                            break;
                        }
                    }



                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int dvd = sc.nextInt();
        int[] song_arr = new int[num];
        for (int i = 0; i<num; i++) {
            song_arr[i] = sc.nextInt();
        }
        System.out.println(getMinVol(num, dvd, song_arr));
    }
}
