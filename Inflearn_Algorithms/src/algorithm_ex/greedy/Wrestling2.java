//package algorithm_ex.greedy;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class Wrestling2 {
//
//    public static int getMaxSelection(List<Spec> playerList, int num) {
//        int max_w = playerList.get(0).getWeight();
//        int count = 1;
//        for (int i = 1; i < num; i++) {
//            if (playerList.get(i).getWeight() > max_w) {
//                count++;
//                max_w = playerList.get(i).getWeight();
//            }
//        }
//        return count;
//    }
//    public static void main(String[] args) {
//
//
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        //Map<Integer, Integer> spec = new HashMap<>();
//        List<Spec> player_list = new ArrayList<>();
//        for (int i = 0; i < num; i++) {
//            int height = sc.nextInt();
//            int weight = sc.nextInt();
//            player_list.add(new Spec(height, weight));
//
//        }
//        Collections.sort(player_list);
//        System.out.println("player_list = " + player_list);
//        System.out.println(getMaxSelection(player_list,num));
//
//    }
//}
