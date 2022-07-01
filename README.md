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
</div>
</details>

