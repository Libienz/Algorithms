package algorithm_ex.sorting_searching;

import java.lang.reflect.Array;
import java.util.*;

public class LRU {
    public static int cacheHit(int[] cache, int work) {
        for (int j = 0; j < cache.length; j++) {
            //hit
            if (cache[j] == work) {
                return j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); //캐시 사이즈
        int n = sc.nextInt(); //작업의 개수

        int[] cache = new int[s];

        for (int i = 0; i < n; i++) {
            int work = sc.nextInt();
            int hi = cacheHit(cache, work); //hit idx
            //hit
            if (hi != -1) {
                for (int j = hi; j > 0; j--) {
                    cache[j] = cache[j-1];
                }
                cache[0] = work;
            }
            //miss
            else {
                int tmp = cache[0];
                for (int j = s-1; j > 0; j--) {
                    cache[j] = cache[j-1];
                }
                cache[0] =work;
            }
        }


        for (int i = 0; i < cache.length; i++) {
            System.out.print(cache[i] + " ");
        }


    }
}
