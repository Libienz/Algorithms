package algorithm_ex.sorting_searching;

import java.lang.reflect.Array;
import java.util.*;


class Cache {
    int size;
    int[] cache;

    public Cache(int size) {
        this.size = size;
        cache = new int[size];
        for (int i = 0; i < size; i++) {
            cache[i] = 0;
        }
    }

    public int cacheHit(int work) {
        for (int i = 0; i < size; i++) {
            if (cache[i] == work) {
                return i;
            }
        }
        return -1;
    }

    public void add(int work) {

        int idx = cacheHit(work);

        //cache miss
        if (idx == -1) {

            for (int i = size-1; i>=1; i--) {
                cache[i] = cache[i - 1];
            }
            cache[0] = work;

        }
        //cache hit
        else {

            for (int i = idx; i >= 1; i--) {
                cache[i] = cache[i - 1];
            }
            cache[0] = work;

        }


    }

    @Override
    public String toString() {
        String str = "";
        for (int i : cache) {
            str += (i+" ");
        }
        return str;
    }
}
public class LRU {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); //캐시 크기
        int N = sc.nextInt(); //작업 개수
        Cache cache = new Cache(S);

        for (int i = 0; i < N; i++) {
            cache.add(sc.nextInt());
        }

        System.out.println(cache);


    }
}
