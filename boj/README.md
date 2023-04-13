# boj Java

백준 알고리즘 자바 풀이 

<details>
<summary>dfs, bfs</summary></summary>
<div markdown="1">

### - Q2583
#### 모눈 종이가 색칠된 부분과 그렇지 않은 부분으로 나누어 질때 색칠되지 않은 영역이 어떻게 나뉘는지 에 대한 정보 파악 문제
![img_2.png](img_2.png)
- 상하좌우를 살펴보는 dfs 구현으로 풀었다.
- 시작점을 찾고 dfs start
  - 지나간 곳은 map값을 바로 바꾸었기에 visited배열 사용하지 않음 (다음엔 써보자, 어렵지도 않지만)
  
```java
    public static void dfs(int r, int c) {

        board[r][c] = 1;
        //stack frame의 특징을 이용한 dfs
        //한 방향으로 갈 수 있는 곳 까지 파고든 후 back tracking한다.
        //visit 배열을 사용하지 않고 방문한 곳은 1로 바꾸어 처리
        sa++;
        //상
        if (isAvailableCoord(r - 1, c) && board[r - 1][c] == 0) {
            board[r - 1][c] = 1;
            dfs(r - 1, c);
        }
        //하
        if (isAvailableCoord(r + 1, c) && board[r + 1][c] == 0) {
            board[r + 1][c] = 1;
            dfs(r + 1, c);
        }
        //좌
        if (isAvailableCoord(r, c - 1) && board[r][c - 1] == 0) {
            board[r][c - 1] = 1;
            dfs(r, c - 1);
        }
        //우
        if (isAvailableCoord(r, c + 1) && board[r][c + 1] == 0) {
            board[r][c + 1] = 1;
            dfs(r, c + 1);
        }

    }
```

### - Q2667
#### 정사각형의 지도에서 1이 집을, 0이 집이 없는 곳을 나타낼 때 집의 모임인 단지에 대한 정보를 파악하는 문제
![img_1.png](img_1.png)
- 상하좌우에 집이 이웃될 경우 하나의 단지에 포함되는 것으로 간주
- 나는 for문으로 1인 곳을 찾은뒤에 해당 시점에서 dfs로 단지를 파악했음
  - 파악된 곳을 바로바로 0으로 바꾸어 주었기에 visited 배열 사용하지 않음
  - 추가적으로 나는 상하좌우를 전부 조건문으로 나누는 것이 오히려 캐치하다고 생각하는데 다른 사람들 풀이보면 nx ny로 코드 줄이는 풀이가 많은 듯? 둘 다 알아놓자. 
- 궁금한 점 (고수를 만나면 물어보자)
  - dfs의 parameter가 많아지는 것이 싫어서 static 변수 설정으로 전역변수와 같은 역할을 하는 변수를 만드는데 무분별한 전역변수의 설정이 좋지 않다고 들은 적이 있음 코테 수준에선 이런 풀이 괜찮을까..?


```java
    public static void dfs(int r, int c) {

        board[r][c] = 1;
        //stack frame의 특징을 이용한 dfs
        //한 방향으로 갈 수 있는 곳 까지 파고든 후 back tracking한다.
        //visit 배열을 사용하지 않고 방문한 곳은 1로 바꾸어 처리
        sa++;
        //상
        if (isAvailableCoord(r - 1, c) && board[r - 1][c] == 0) {
            board[r - 1][c] = 1;
            dfs(r - 1, c);
        }
        //하
        if (isAvailableCoord(r + 1, c) && board[r + 1][c] == 0) {
            board[r + 1][c] = 1;
            dfs(r + 1, c);
        }
        //좌
        if (isAvailableCoord(r, c - 1) && board[r][c - 1] == 0) {
            board[r][c - 1] = 1;
            dfs(r, c - 1);
        }
        //우
        if (isAvailableCoord(r, c + 1) && board[r][c + 1] == 0) {
            board[r][c + 1] = 1;
            dfs(r, c + 1);
        }

    }
```


</div>
</details>