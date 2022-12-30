package algorithm_ex.two_pointer;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumSales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int daySize = sc.nextInt();
        int winSize = sc.nextInt();
        int winSum = 0;
        int maxSale = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < daySize; i++) {
            arr.add(sc.nextInt());
        }

        for (int i = 0; i < winSize; i++) {
            winSum += arr.get(i);
        }
        maxSale = winSum;
        for (int i = winSize; i < daySize; i++) {
            winSum -= arr.get(i-winSize);
            winSum += arr.get(i);
            if (winSum > maxSale) {
                maxSale = winSum;
            }
        }

        System.out.println(maxSale);

    }
}
