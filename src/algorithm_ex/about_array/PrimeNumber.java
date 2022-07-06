package algorithm_ex.about_array;

import java.util.ArrayList;
import java.util.Scanner;

//2의 배수로 나누어진다는 소리는 2로 나누어진다는 소리 3의 배수도 마찬가지

public class PrimeNumber {

    public static boolean isPrime(int num) {

        if (num == 2) {
            return true;
        }
        if(num%2 == 0) {
            return false;
        }

        for (int i = 3; i<= num/2; i=i+2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void solution(int num, ArrayList<Boolean> eras) {
        for (int i = 0; i<eras.size(); i++) {
            if(eras.get(i)) { //소수라면
                for(int j = i*2; j<=num; j=j+i) {
                    eras.set(j,false);
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Boolean> eras = new ArrayList<>();
        eras.add(false);
        eras.add(false);

        for (int i = 2; i<=num; i++) {
            eras.add(true);
        }

        solution(num, eras);
/*        for (int i = 0; i<eras.size(); i++) {
            System.out.print(eras.get(i)+" ");
        }*/
        int count =0;
        for (int i = 0; i< eras.size(); i++) {
            if (eras.get(i)) count++;
        }
        System.out.println(count);
    }
}
/*    //거름망

*//*
    public static boolean isOdd(int num) {
        if(num%2 == 0) {
            return false;
        }
        return true;
    }
*//*
*//*
    public static boolean isMultipleOf(int num, int div) {
        if(num % div == 0) return true;
        return false;
    }
*//*

    public static int getErasNum(Integer num) {
        return (int) Math.pow(num,0.5) +1;
    }

    public static void numOfPrime(int num, ArrayList<Integer> erastones) {
        int count = 0;
        int erastonesNum = getErasNum(num);
        for (int i = 2; i<=num; i++) {
            if (isPrime(i)) {
                count++;
                for (int j =0; j<erastones.size(); j++) {
                    if(erastones.get(j) > i && erastones.get(j) % i == 0) {
                        erastones.remove(j);
                    }
                }
                if (Math.pow(i,2) > num) {
                    return;
                }
            }
        }
    }
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int input_num = sc.nextInt();

        ArrayList<Integer> erastones = new ArrayList<>();
        for (int i = 2; i<=input_num; i++) {
            erastones.add(i);
        }
        *//*for (int i = 0; i<erastones.size(); i++) {
            System.out.println(erastones.get(i));
        }*//*

        numOfPrime(input_num,erastones);
        System.out.println(erastones.size());

    }*/

