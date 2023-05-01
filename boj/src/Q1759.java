import java.util.*;

public class Q1759 {

    static int l;
    static int c;
    static ArrayList<Character> arr;
    static ArrayList<Boolean> used;
    static ArrayList<String> codes;

    public static void dfs(int ch, String code, int idx) {
        //arr에서 l개를 뽑아냈다. -> 유효한 암호인지 검증
        if (ch == l) {
            char[] ca = code.toCharArray();
            boolean vowelExist = false; //모음이 1개이상 존재하는가?
            boolean isAscending = true; //오름차순인가?
            int constantsCnt = 0; //자음의 숫자

            char prevChar = 0;

            for (char c : ca) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelExist = true;
                } else {
                    constantsCnt++;
                }

                if (prevChar > c) {
                    isAscending = false;
                }

            }
            //자음이 2개 이상이고 모음이 존재하며 오름차순으로 정렬되었다면 codes에 추가
            if (constantsCnt >= 2 && vowelExist && isAscending) {
                codes.add(code);
            }

        }
        else {
            for (int i = idx; i < arr.size(); i++) {
                Character cur = arr.get(i);
                if (code.indexOf(cur) != -1) {
                    continue;
                }
                //cur 문자를 암호에 사용한다.
                dfs(ch+1, code + cur, i + 1);
                //사용하지 않는다. -> 다음 루프로

            }

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        l = sc.nextInt(); //l개의 알파벳 소문자로 이루어진 암호 부가적으로 최소 1개의 모음과 최소 두개의 자음으로 이루어진 암호
        c = sc.nextInt(); //c가지 문자가 주어짐

        //정적변수 객체 생성
        arr = new ArrayList<>();
        used = new ArrayList<>();
        codes = new ArrayList<>();


        for (int i = 0; i < c; i++) {
            arr.add(sc.next().charAt(0));
            used.add(false);
        }

        //암호로 가능한 문자 배열을 정렬 시킨다.
        Collections.sort(arr);

        //순열 비슷하게 4개의 문자를 고르고 유효한지까지 dfs에서 검증한다.
        dfs(0, "", 0);

        //암호로 적합한 조합은 codes에 포함됨
        //codes 사전순 정렬
        Collections.sort(codes);

        //출력
        for (String code : codes) {
            System.out.println(code);
        }
    }

}
