package algorithm_ex.stack_queue;

import java.io.CharArrayWriter;
import java.util.Scanner;
import java.util.Stack;


// 스택 이용해서 처리할 것임 스택에 막대들을 넣어놓는다
// ()가 같이 나올 때 스택에 들어있는 막대가 몇개인지 세자 3개라면 자르면 6개가 된다.
// 막대 하나가 끝났다 그다음에 자른다면? 조각은 곱하기 2개가 되는 것이 아니라 하나만 추가됨
// 그말인 즉슨 처음자르는 것인지 두번째 이상으로 자르는 것인지 판별 필요



public class CuttingStick {

    public static int cutStick(String str) {

        Stack<Character> stack = new Stack<>();
        //초기에 peek하기 위해서 첫번째는 그냥 집어넣기
        char[] ch_arr = str.toCharArray();
        stack.push(ch_arr[0]);

        int curr_ever_cutted_count = 0;
        int all_stick = 1;
        int res_count = 0;

        for (int i = 1; i<ch_arr.length; i++) {
            if (ch_arr[i] == ')' && stack.peek() == '(') { //레이저 입갤
                stack.push(ch_arr[i]);
                all_stick--;
                res_count += curr_ever_cutted_count;
                res_count += (all_stick-curr_ever_cutted_count) * 2;
                curr_ever_cutted_count += all_stick-curr_ever_cutted_count;
            }
            else if (ch_arr[i] == ')') { //막대 하나 끝
                //한번도 안짤린게 끝난 건지 어케 알지 .. 문제조건봐라조건
                //여기가 문제 팝해서 빼면 이전게 ( 일수도 ...
                stack.push(ch_arr[i]);
                curr_ever_cutted_count--;
                all_stick--;

            }
            else {
                all_stick++;
                stack.push(ch_arr[i]);
            }
        }
        return res_count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(cutStick(str));
    }
}
