# JAVA_algorithm

인프런 자바 알고리즘 학습 기록을 위한 레포

<details>
<summary>01 String Section</summary>
<div markdown="1">

### 01-01
문자열 안에서 특정 문자 찾는 문제 

```java
c = sc.next().charAt(0); 캐릭터는 이렇게 입력받기
String.toCharArray(); 문자열을 캐릭터의 배열로! 향상된 for문에 유용
Character.toLowerCase(c); 캐릭터를 소문자로 
```
### 01-02
문자열 내에서 대소문자 반전시키는 문제 
```java
빈문자열에 바꾼걸 하나씩 붙여나간다는 아이디어 떠오르면 굿 
Character.isLowerCase(c);와 같은 메소드로 대소문자 확인가능
아스키 코드로도 가능 
대문자는 아스키코드 65 < c < 90
소문자는 아스키코드 97 < c < 122
```
### 01-03
입력된 문장 속 가장 길이가 긴 단어 찾는 문제
```java
최댓값 알고리즘 >> 맥스를 갱신해나가는 방식으로 푼다.
        
첫번째 방법
        
String[] str_arr = str.split(" ");

두번째 방법 indexOf는 못찾으면 -1 반환하기에
        
While(str.indexOf(" ") != -1) {
    //substring 을 통해 잘라나간다.
};

</div>
</details>
```
