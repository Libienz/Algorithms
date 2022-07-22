package algorithm_ex.sorting_searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LRU {

    public static void getCacheStat(int cache_size,List<Integer> cache, int sch_size, List<Integer> schedule) {

        for (int i = 0; i<sch_size; i++) {

            if (cache.contains(schedule.get(i))) { // hit

                int ind = cache.indexOf(schedule.get(i));
                int tmp = cache.get(ind);
                //System.out.println("ind " + ind + " tmp " + tmp);

                for (int j = ind-1; j>=0; j--) {
                    cache.set(j+1,cache.get(j));
                }
                cache.set(0,tmp);
                //System.out.println("hit " + schedule.get(i));

            }
            else { // miss
                for (int j = cache_size -1; j>0; j--) {
                    cache.set(j,cache.get(j-1));
                }
                //System.out.println("miss " + schedule.get(i));
                cache.set(0,schedule.get(i));
            }
        }


        for (int i = 0; i<cache_size; i++) {
            System.out.print(cache.get(i) + " ");
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cache_size = sc.nextInt();
        int schedule_size = sc.nextInt();
        List<Integer> cache = new ArrayList<>();
        List<Integer> schedule = new ArrayList<>();

        for (int i = 0; i<schedule_size; i++) {
            schedule.add(sc.nextInt());

        }
        for (int i = 0; i<cache_size; i++) {
            cache.add(0);
        }

        getCacheStat(cache_size,cache,schedule_size,schedule);
    }
}
