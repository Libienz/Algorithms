import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        bw.write(String.valueOf(calcAverage(numbers)) + "\n");
        bw.write(String.valueOf(calcMedian(numbers)) + "\n");
        bw.write(String.valueOf(calcModeNumber(numbers)) + "\n");
        bw.write(String.valueOf(calcRange(numbers)) + "\n");
        bw.flush();
    }

    public static Long calcAverage(List<Integer> numbers) {
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / (double) numbers.size();
        return Math.round(average);
    }

    public static int calcMedian(List<Integer> numbers) {

        List<Integer> temp = new ArrayList<>();
        for (int num : numbers) {
            temp.add(num);
        }

        Collections.sort(temp);
        return temp.get(temp.size() / 2);
    }

    public static int calcModeNumber(List<Integer> numbers) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int num : numbers) {
            numberCount.put(num, numberCount.getOrDefault(num, 0) + 1);
        }

        int count = Integer.MIN_VALUE;
        List<Integer> modeNumbers = new ArrayList<>();

        for (int key : numberCount.keySet()) {
            if (numberCount.get(key) > count) {
                count = numberCount.get(key);
                modeNumbers.clear();
                modeNumbers.add(key);
            }
            else if (numberCount.get(key) == count) {
                modeNumbers.add(key);
            }
        }


        if (modeNumbers.size() == 1) {
            return modeNumbers.get(0);
        } else {
            Collections.sort(modeNumbers);
            return modeNumbers.get(1);
        }
    }

    public static int calcRange(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        return max - min;
    }

}