//package algorithm_ex.greedy;
//
//import java.util.*;
//
//class Spec implements Comparable<Spec>{
//    @Override
//    public String toString() {
//        return "Spec{" +
//                "height=" + height +
//                ", weight=" + weight +
//                '}';
//    }
//
//    private int height;
//    private int weight;
//
//    public Spec(int height, int weight) {
//        this.height = height;
//        this.weight = weight;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    @Override
//    public int compareTo(Spec o) { //매개변수 ???? 뭐가 넘어노는 건지
//        return o.height-this.height; // 내림차순
//        // 입력인자로 들어온 애가 메소드를 호출한 객체의 값보다 크면 양수
//        // 같으면 0
//        // 입력인자로 들어온 애가 메소드를 호출한 객체의 값보다 작으면 음수
//    }
//}
//public class Wrestling {
//
//    public static int getMaxSelection(List<Spec> playerList,int num) {
//
//
//        int[] get_eli = new int[num];
//        int eli_count = 0;
//        //System.out.println("count = " + count);
//        for (int i = 0; i < playerList.size()-1; i++) { //i 선수와 j 선수의 비교
//            for (int j = i+1; j < playerList.size(); j++) {
//                if (playerList.get(i).getHeight() > playerList.get(j).getHeight() && playerList.get(i).getWeight() > playerList.get(j).getWeight()) {
//                    //count--;
//                    get_eli[j]= 1;
//                    //System.out.println(i+ " " +j); //여러번 빠지는 경우 어쩔꺼야 ..
//                }
//                else if (playerList.get(i).getHeight() < playerList.get(j).getHeight() && playerList.get(i).getWeight() < playerList.get(j).getWeight()) {
//                    get_eli[i] = 1;
//                    //count--;
//                }
//            }
//        }
//
//        for (int i : get_eli) {
//            if (i == 1) {
//                eli_count += 1;
//            }
//        }
//        return num - eli_count;
//    }
//    public static void main(String[] args) {
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
//        System.out.println(getMaxSelection(player_list,num));
//
//    }
//}
