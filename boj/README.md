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

### - Q1759
#### 암호의 조건이 주어질 때 가능한 암호를 모두 구해보기

- 암호는 주어진 문자들에서만 나와야 하고 모음 1개 자음 2개 이상 필요
- 나의 첫번째 시도 
  - 주어진 문자들에서 4개를 뽑아야 하는 상황
  - 모든 경우의 수를 dfs로 고른 후 뽑은 경우의 수가 유효한 암호가 될 수 있는지를 체크함
  - 결국 메모리 초과
- 나의 두번째 시도
  - 모두 구하고 유효한지 체크하는 것이 아닌 
  - 중간 중간 체크할 수 있도록 바꿈 
  - 예로 애초에 뽑을 때 오름차순으로 뽑을 수 밖에 없도록 설계한다던가..
  - 메모리 초과 안남

- 줄일 수 있다면 줄이자 naive하게 빠르게 접근하는 것은 좋지만 너무 naive하면 안된다는 것을 꺠달음

```java
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
```

### - Q1987
#### 보드와 특정 위치의 말이 주어졌을 때 말이 제일 멀리 몇칸을 갈 수 있는가?

- 알파벳으로 채워진 2차원 보드에서 말은 한번 간 칸의 알파벳이 있는 다른 곳으로는 갈 수 없다
- 상하좌우로만 움직임 가능 
- dfs로 파고 들며 모든 경우의 수를 따진다.
- 방문했던 알파벳은 Set에 넣어 중복방문하지 않도록 처리했음 

```java
public static void dfs(int r, int c, int lev) {

        int row = r;
        int col = c;
        if (maxMv < lev) {
            maxMv = lev;
        }

        //상
        row = row -1;
        if (isAvailableIdx(row, col) && !set.contains(board[row][col])) {
            set.add(board[row][col]);
            dfs(row, col, lev + 1);
            set.remove(board[row][col]);
        }
        //하
        row = row + 2;
        if (isAvailableIdx(row, col) && !set.contains(board[row][col])) {
            set.add(board[row][col]);
            dfs(row, col, lev + 1);
            set.remove(board[row][col]);
        }
        //좌
        row = row - 1;
        col = col - 1;
        if (isAvailableIdx(row, col) && !set.contains(board[row][col])) {
            set.add(board[row][col]);
            dfs(row, col, lev + 1);
            set.remove(board[row][col]);
        }
        //우
        col = col + 2;
        if (isAvailableIdx(row, col) && !set.contains(board[row][col])) {
            set.add(board[row][col]);
            dfs(row, col, lev + 1);
            set.remove(board[row][col]);
        }
    }
```

### -Q2580
#### 스도쿠 완성하기
- 가운데 사각형 검사를 구현하는 것이 조금 빡셈
- 또한 시간초과에 걸리지 않기 위해서 특정알고리즘을 사용해야 하는 듯? 
  - 근데 시간복잡도는 똑같은데 .. 입력과 출력으로도 시간초과가 갈리는거보면 크게 신경쓸 필요는 없으려나.. 
- 무튼 구현문제 하나 챙겨간다고 생각하자
- 빡구현일수록 코드부터가 아니라 설계부터하고 들어가자! 들어가서 이것저것 만지다 보면 머리 쥐남

```java
        while (!spaces.isEmpty()) {

            Space s = spaces.poll();
            //가로줄 검증
            ArrayList<Integer> checkSet = generateCheckSet();
            for (int i = 0; i < 9; i++) {
                if (board[s.getR()][i] != 0) {
                    checkSet.remove((Object) board[s.getR()][i]);
                }
            }
            if (checkSet.size() == 1) {
                board[s.getR()][s.getC()] = checkSet.get(0);
                spaces.remove(0);
                continue;
            }
            //세로줄 검증
            checkSet = generateCheckSet();
            for (int i = 0; i < 9; i++) {
                if (board[i][s.getC()] != 0) {
                    checkSet.remove((Object) board[i][s.getC()]);
                }
            }
            if (checkSet.size() == 1) {
                board[s.getR()][s.getC()] = checkSet.get(0);
                spaces.remove(0);
                continue;
            }
            //사각형 검증
            checkSet = generateCheckSet();
            int qr = s.getR() / 3;
            int qc = s.getC() / 3;
            for (int i = qr*3; i < qr*3 + 3; i++) {
                for (int j = qc * 3; j < qc * 3 + 3; j++) {
                    if (board[i][j] != 0) {
                        checkSet.remove((Object) board[i][j]);
                    }
                }
            }
            if (checkSet.size() == 1) {
                board[s.getR()][s.getC()] = checkSet.get(0);
                spaces.remove(0);
                continue;
            }
            //아무런 조건으로도 못찾으면 다시 큐로..
            spaces.add(s);

        }

```
</div>
</details>