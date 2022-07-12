# JAVA_algorithm

인프런 자바 알고리즘 학습 기록을 위한 레포

<details>
<summary>01 String Section</summary>
<div markdown="1">

### 01-01
문자열 안에서 특정 문자 찾는 문제 

```java
c = sc.next().charAt(0); //캐릭터는 이렇게 입력받기
String.toCharArray(); //문자열을 캐릭터의 배열로! 향상된 for문에 유용
Character.toLowerCase(c); //캐릭터를 소문자로 
```
### 01-02
문자열 내에서 대소문자 반전시키는 문제 
```java
//빈문자열에 바꾼걸 하나씩 붙여나간다는 아이디어 떠오르면 굿 
Character.isLowerCase(c);//와 같은 메소드로 대소문자 확인가능
//아스키 코드로도 가능 
//대문자는 아스키코드 65 < c < 90
//소문자는 아스키코드 97 < c < 122
```
### 01-03
입력된 문장 속 가장 길이가 긴 단어 찾는 문제
```java
//최댓값 알고리즘 >> 맥스를 갱신해나가는 방식으로 푼다.
        
//첫번째 방법
        
String[] str_arr = str.split(" "); 


//두번째 방법 indexOf는 못찾으면 -1 반환하기에
        
while(str.indexOf(" ") != -1) {
    //substring 을 통해 잘라나간다.
};
```
### 01-04 
문자열 배열 다 뒤집어서 보여주기
```java
//자바에서 스트링에 대한 연산을 한다면 객체가 수정되는 것이 아니라 새로운 객체가 계속해서 만들어짐
//이런 것 때문에 나온게 String Builder. 여러가지 연산을 제공하며 객체를 마구 만들어내지 않음

String tmp = new StringBuilder(x).reverse().toString();

//좀 더 직접적인 방법도 알아두자
while(lt<rt) {} //요거는 문자의 개수가 홀수건 짝수건 딱 맞게 바꿔줄 수 밖에 없다는점 
String.valueOf(s)//요거는 문자배열을 문자열로 바꿔줄 수 있는 메소드!
```
### 01-05
문자열 배열 다 뒤집어서 보여주기
```java
while(lt<rt) {} //적극활용 둘다 알파벳을 가리킬때 스왑한다. lt와 rt가 따로 움직이도록
Character.isAlphabetic(ch);//요거 통해서 알파벳인지 쉽게 알 수 있다.
//뭐뭐인지 확인하는 is 메소드는 거의 스태틱인듯 --> 생각해보니 그럴 수 밖에
//명확한 구조가 중요하다 설계 잘하고 들어가면 금방 푸는 문제


```
### 01-06
중복된 캐릭터 제거 문제
```java 
indexOf()//요게 없으면 -1을 반환한다는 것을 이용해서
//자기위치와 처음 발견된 indexof의 결과가 다르다? 제거
str.indexOf(str.charAt(i)) == i
```
### 01-07
회문 문자열인지 검사하는 알고리즘 
```java 
//내가 푼거는 reverse 시켜서 String.equals 사용
//강사의 풀이방식은 문자열의 length / 2 로 자르고 반대편과 비교해나가면서
//틀린게 있다면 NO하도록 --> 요게 오버헤드가 더 라이트한듯.. 반성
for (int i = 0; i <= ch_arr.length / 2; i++) {
    if (ch_arr[i] != ch_arr[ch_arr.length - i]) {
        return false;
    }
    continue;
}
```
### 01-08
회문 문자열인지 검사하는 알고리즘 but 특수문자 무시
```java 
//나는 특수문자를 제거한 캐릭터 배열을 새로 만들어 특수문자가 제거된 문자열을 만듬
//강좌에서는 replaceAll과 정규식을 이용했다.
str = str.toUppercase().replaceAll("[^A-Z]", "");// 대문자 A-Z가 아니면 빈문자화 시켜라
//replaceAll은 첫번째 인자를 두번째 인자로 바꾸는 메소드
```
### 01-09
문자열 사이에서 숫자만 추출해서 '자연수로' 만들기
```java 
//정규식 이용해서 숫자가 아닌 것들 제거
//나는 Integer.valueOf()메소드 사용했다. 정규식 꼭 익혀두자
//강좌에서는 문자 0의 아스키 코드값이 48인것을 이용해서 *10을 해나가는 방식 사용
answer = answer * 10 + (x-48);
Character.isDigit(x);// 요거 사용할 수도 있다.
Integer.parseInt(answer);// 파스인트 요거도 정수로 바꿔준다.
```
### 01-10
문자 거리
```java 
/* 내가 푼 방식
    c가 있는 위치 모든 인덱스 뽑아와서 리스트로 nest 변수를 사용했어야 되었음..
    각 문자의 위치와 c와의 거리비교 최솟값 가져와서 출력 요게 루프가 좀 지저분함 c의 모든 인덱스와 비교해야 해서
   
*/

/* 강사의 방식
    오른쪽으로 갔다가 왼쪽으로 한번 더가면서 '갱신' 방식 ㄷㄷ 개깔끔
    str.charAt() 요거 좀 쓰셈 간편함 
*/
    
```
### 01-11
문자열 압축 문제
```java 
/* 별다른 아이디어 없이 설계 잘 하면 되는 문제
    빈문자열에 붙여나가기
    마지막에 dummy space 남겨서 푸는게 강사의 방식 but 다른 방식으로도
    할 수 있으면 노상관 */
    
```
### 01-12
암호 변환 문제
```java 
/*  10진수는 char로 캐스트 하면 바뀐다.
    강사와 나의 커다란 아이디어 차이 없음
    다만 나는 need_decrypt 변수 설정 while문의 조건으로 사용
    강사는 replace로 2진수로 바꿨다. 
    */
    str.substring(0,7).replace('#','1').replace('*','0');
    Integer.parseInt(str,2); // 두번째 인자가 진법
    
```
</div>
</details>

<details>
<summary>02 Array Section</summary>
<div markdown="1">

### 02-01

```java
/*
배열에서 앞의 수보다 크면 출력하는 문제
그냥 탐색 돌면서 전 인덱스와 비교하면 된다 끝.
*/
```
### 02-02
```java
/*
    학생들의 키 리스트가 주어질 떄 보이는 학생의 수를 찾는 문제
    나는 탐색해나가면서 현재 인덱스 시점의 최댓값을 갱신 시켜나감
    또한 처음에 다안보인다고 설정해놓고 순회하면서 이전 인덱스가 이후 인덱스보다 값이 
    더 큰게 있으면 안보이니까 하나씩 더해 나갔음
    강사랑 똑같음.
*/
```
### 02-03
가위바위보 누가 이겼는지 
```java
/*
가위바위보 if else로 나눈다.
 */
```
### 02-04
사이즈 크기만큼의 피보나치 수열 만들기
```java
/*
가위바위보 if else로 나눈다.
 */
```
### 02-05
주어진 숫자 보다 작은 수 중 소수의 개수 구하기
```java
/*
자세히 보자 어려웠다 나는..
첫번째 시도 : 소수는 약수를 1과 자신만을 가지는 수
수가 주어지면 1부터 자기자신까지 루프를 돌며 약수의 개수를 카운팅하는
isPrime 메소드를 생성. 이 함수를 다시 루프에 사용하며 소수의 개수 세는 naive 방식 
-> 시간초과
두번째 시도 : 절반 떼어내기 방법
어차피 1부터 자기자신까지 나머지를 확인하며 약수를 세는 과정에서
절반보다 큰수는 다 자기자신의 약수가 될 수 없으니 루프의 크기를 절반으로 줄인다
-> 시간초과
세번째 시도 : 짝수까지 걸러내기 짝수는 2를 제외하고는 소수가 될 수 없다.
짝수는 조건문으로 거른다 
-> 시간초과 
결국 2부터 배수들을 지워나간다.
작은 소수의 배수들부터 지워나가면 찐 소수만 남는다. 왜? 자기보다 작은 소수의 배수를 지웠는데 
소수로 남아있다는 것은 자기보다 작은 수가 자신의 약수가 되지 않았다는 뜻       
 */
```
### 02-06
주어진 숫자 뒤집은 숫자가 prime인지 확인하기
```java
/*
뒤집는 방식은 StringBuilder.reverse 쓰든가 아니면 while(lt<rt) 쓰든가
둘 중 하나 골라서 사용하자 나는 두가지 다 실습 해봄
isPrime은 간단하게 구현해도 좋다
 */
public static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
        return false;
        }
        if (num ==2 ) {
        return true;
        }
        for(int i =2;i<num; i++){
            if(num%i==0){
            return false;
            }
        }
        
        return true;
}
//손코딩으로 풀라고 하면 숫자를 어떻게 뒤집어야 할까?
public static int reverseInt(int num) {
    int tmp = num;
    int res = 0;
    while(tmp>0) {
        res = res*10 + tmp%10;
        tmp = tmp/10;
    }
    return res;
}
```
### 02-07
ox문제 가중치를 포함한 학생의 점수 계산하지
```java
/*
연속득점에 점수 가중치가 있는 문제 생각한대로 어렵지 않게 풀면된다

 */
```
### 02-08
학생 등수 계산하기 .. 난 왜 이게 어렵지
```java
/*
내가 푼방식 : 임시 배열에 점수리스트 정렬하고 원래 배열의 원소가
정렬된 배열에서 인덱스 번호가 몇번인지로 찾았음
버블소트 직접 구현했고 <-- 여기서 시간 오래걸림
오름차순 정렬을 다시 한번 뒤집었다.

강사의 방식 : 간단 이중포문 돌면 끝 자기보다 큰애들이 발견될때마다 등수 하나씩
높인다.

 */

```
### 02-09
격자판의 sum 중 가장 큰 sum 구하기
```java
/*
sum의 종류는 3가지 모두 구해서 최대를 찾는다 끝

 */
```


### 02-10
2차원 배열에서 봉우리 개수 구하기
```java
/*
2차원 배열 선언하고 조건문 잘세우면 끝
조건문 잘세우면 아닐 때 quit 하게 할 수도 있다.
*/
```

### 02-11
임시반장 정하기 은근 쉬운데?
```java
int[][] arr = new int[5][5]; //이런게 있다고 칠 때  
arr[0]; // 이거는 하나의 배열을 말한다.
//이거 이용 1번학생의 몇반이었는지 배열과 다른 학생들의 몇반이었는지의 배열을
//everSame메소드에 전달해서 카운트하는 방식으로 풀었다.
//1부터 사용할거면 그냥 넉넉히 만들자

```
### 02-12
멘토링 가능한 경우의 수
```java
//학생들의 모든 경우의 수를 돌며 멘토링이 가능한지 여부 메소드로 확인
int count = 0;
for (int i = 1; i<=num_of_student; i ++) { //i -> mento
    for (int j = 1; j<=num_of_student; j++) { //j -> menti
        if( i==j) continue;
        if(ableToTeach(i,j,test_res)) count++;
    }
}

```
</div>
</details>

<details>
<summary>03 Two pointers, Sliding window </summary>
<div markdown="1">

### 03-01
두개의 배열 합병 과정에서 투포인터 사용해서 정렬하기
```java
//두개의 배열에서 lt를 하나씩
//farr[f_lt] 와 sarr[s_lt] 비교 
//while문 사용하자 딱봐도 사용하라고 만든 문제
```

### 03-02
공통원소 구하기
```java
//한쪽 배열 고정하고 contains 함수 쓰니까 시간 초과 나오네.. 더 효율적인 방법 필요
//퀵소트 쓰고 투포인터쓰니까 정답이 나왔다.
//간단한 정렬은 컬렉션 프레임워크로 Array.sort(a); 이런시긍로 사용하면 된다.
//아래는 퀵소트
//강사는 포인터중 아무쪽이나 한쪽이 끝나면 공통원소가 없다고 했는데 그렇지 않을 텐데?

private static void quickSort(int[] arr,int start, int end) {
        int part=partition(arr,start,end);
        if(start<part-1) quickSort(arr,start,part-1);
        if(end>part) quickSort(arr,part,end);
        }

private static int partition(int[] arr,int start,int end) {
        int pivot=arr[(start+end)/2];
        while(start<=end) {
        while(arr[start]<pivot) start++;
        while(arr[end]>pivot) end--;
        if(start<=end) {
        swap(arr,start,end);
        start++;
        end--;
        }
        }
        return start;
        }

private static void swap(int[] arr,int start,int end) {
        int tmp=arr[start];
        arr[start]=arr[end];
        arr[end]=tmp;
        return;
        }
```
### 03-03
주어진 윈도우 범위내에서 최대 매출 찾기
```java
//이중 포문 사용해서 모두 비교했더니 타임 리밋 ??
// 근데 어차피 다 비교해야 하는거 이중포문 안돌고 풀 수가 있나..??
// 반복문 중첩 없앨 수 있다 -1번째를 빼고 window + 1번째를 더함으로써 .. 코드 참조
```
### 03-04
연속 부분 수열
```java
//부분 수열의 시작이 어디냐로 케이스 분류 이중 포문 돌렸다.

```
### 03-05
연속 부분 수열
```java
//부분 수열의 시작이 어디냐로 케이스 분류 이중 포문 돌렸다.

```
</div>
</details>
