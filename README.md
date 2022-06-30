# JAVA_algorithm

인프런 자바 알고리즘 학습 기록을 위한 레포

## 01 String Section
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
