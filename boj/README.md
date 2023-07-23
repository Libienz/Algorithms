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

### - Q2580
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
### - Q14889
#### 짝수명의 인원이 주어질 때 능력치 차이가 최소가 되는 두 팀으로 나누기
- dfs 조합으로 팀을 나눈 후 팀의 능력을 계산하여 모든 케이스를 살펴봄으로써 해결 가능
- 순열과 조합, 그리고 중복순열을 dfs로 구현하는 법을 기억하자! 
- 참고로 2개를 뽑는 순열은 dfs보다는 이중루프가 간단하다 첨부터 이렇게 갔으면 삽질 안했는데..

```java
    public static int getTeamAbility(ArrayList<Integer> team) {
        int ability = 0;
        //팀에서 임의 두명을 뽑았을 때의 능력치를 더해나가고 리턴한다.
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i == j) {
                    continue;
                }
                ability += ab[team.get(i)][team.get(j)];
            }
        }
        return ability;
    }

    public static void combinationDfs(int ch, int idx) {
        if (ch == n / 2) {
            //팀고르기 끝 team1에는 선수들이 편성되어있음
            //team1에 편성되지 못한 선수들은 team2로!
            for (int i = 0; i < n; i++) {
                if (!team1.contains(i)) {
                    team2.add(i);
                }
            }
            //각팀의 능력치를 구한다.
            int team1Ability = getTeamAbility(team1);
            int team2Ability = getTeamAbility(team2);

            //능력치의 차를 계산한다.
            int diff = Math.abs(team1Ability - team2Ability);

            //능력치의 차가 최소인지 확인한다.
            if (diff < minDiff) {
                minDiff = diff;
            }
            team2.clear();
        } else {
            for (int i = idx; i < n; i++) {
                //i번 선수를 team1에 포함한다
                team1.add(i);
                combinationDfs(ch + 1, i + 1);
                used[i] = true;
                //i번 선수를 team1에 포함하지 않는다
                team1.remove((Object) i);
            }
        }
    }
```

### - Q9019
#### 연산 d,s,l,r이 정해짐 -> input에서 output으로 바꾸는 데에 최소한의 연산을 거칠 때 사용된 연산 정보를 출력하는 문제
- 최소라는 키워드 bfs와 밀접하게 연관되어 있다는 것 기억하시오
  - level별로 순회하니
- 다만 몇번만에 가능하냐를 묻는 문제가 아닌 연산과정을 알려달라는 문제기에 나는 HistoryInteger라는 새로운 클래스로 어떤 연산을 거쳐 왔는지 저장하도록 했음
  - 근데.. 세상.. 다른 사람 코드 보니 왤케 간단함?
  - History Integer 없이 그냥 Command를 배열로써 해결하는데 흠.. 길이는 훨씬 짧은데 일단은 내가 직관적으로 이해할 수 있는게 좋은 것이긴 하니까 
  - 아이디어가 떠오르지 않는다면 이런 사소한 것 가지고 오래 붙잡고 있을 필요는 없을 것 같다. 
- 참고로 dfs, bfs에서 내가 시간초과 내는 경우는 대부분 visited를 제대로 설정하지 않은 것 !
- 이번에도 visited를 만들긴 했지만 전체적 시간복잡도를 고려하지 않은 visited를 만들어서 왜 시간초과가 나는지 30분동안 뻘짓함 
  - boolean[] 이걸 만들고 처음에 초기화 해 놓은 것과
  - ArrayList를 만들고 isContan을 이너루프에서 하는 것 성능차이 있을 수 밖에 없음
  - 애초에 시간복잡도가 n배 차이남 (boolean[]는 idx를 통해 접근 가능하지만 ArrayList는 매번 for루프 하나 더 돌아야 함)

```java
        //각 케이스별로 첫번째 숫자를 두번째 숫자로 옮기기 위한 최소 연산을 찾는다.
        for (ArrayList<Integer> tc : cases) {

            int in = tc.get(0);
            int out = tc.get(1);
            boolean[] visited = new boolean[10001];
            for (int i = 0; i < visited.length; i++) {
                visited[i] = false;
            }
            //in에서 out으로 되기 위한 최소 연산을 구하자
            Queue<HistoryInteger> q = new LinkedList<>();
            int level = 0;
            HistoryInteger hi = new HistoryInteger(in, "");
            q.add(hi);
            visited[hi.getNum()] = true;
            //bfs start
            while (!q.isEmpty()) {
                int len = q.size();
                for (int i = 0; i < len; i++) {

                    HistoryInteger cur = q.poll();

                    if (cur.getNum() == out) {
                        System.out.println(cur.getOpHistory());
                        q.clear();
                        break;
                    } else {

                        //현재 숫자에서 4가지 연산한 결과들
                        int d = Calculator.d(cur.getNum());
                        int s = Calculator.s(cur.getNum());
                        int l = Calculator.l(cur.getNum());
                        int r = Calculator.r(cur.getNum());

                        //이미 만들어봤던 숫자로 돌아가는 것은 최단이 아님 q에 넣지 않는다.
                        if (!visited[d]) {
                            q.add(new HistoryInteger(d, cur.getOpHistory() + "D"));
                            visited[d] = true;
                        }
                        if (!visited[s]) {
                            q.add(new HistoryInteger(s, cur.getOpHistory() + "S"));
                            visited[s] = true;
                        }
                        if (!visited[l]) {
                            q.add(new HistoryInteger(l, cur.getOpHistory() + "L"));
                            visited[l] = true;
                        }
                        if (!visited[r]) {
                            q.add(new HistoryInteger(r, cur.getOpHistory() + "R"));
                            visited[r] = true;
                        }

                    }
                }
                level++;
            }
        }
```

### - 5014
#### 엘레베이터가 위로 u층 아래로 d층만 움직일 수 있을 때 특정 floor에 도달하기 위한 최소한의 움직임 수
- 보자마자 이제는 bfs문제인 것을 알 수 있다.
- 문제 꼼꼼히 읽자 놓치는 정보가 아직 많다.
```java 

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                if (cur == g) {
                    System.out.println(level);
                    q.clear();
                    useStair = false;
                    break;
                } else {
                    // 방문한적 없고 범위에 포함되는 올바른 층이면 cur + u 층을 가는 경우를 따져본다
                    int dest = cur + u;
                    if (dest <= f && dest >= 1 && !visited[dest]) {
                        q.add(dest);
                        visited[dest] = true;
                    }
                    // 방문한적 없고 범위에 포함되는 올바른 층이면 cur + d 층을 가는 경우를 따져본다
                    dest = cur - d;
                    if (dest <= f && dest >= 1 && !visited[dest]) {
                        q.add(dest);
                        visited[dest] = true;
                    }

                }
            }
            level++;
        } 
```

### - Q15684
#### 사다리에 최소 몇개의 다리를 추가해야 모든 세로선이 자기자신으로 회귀하는지 찾으시오
- DFS 모든 가로선 추가의 경우의 수를 따지면 된다.
- 다만 이문제의 핵심은 (적어도 내가 느낀 핵심) DFS 그 자체보다 문제를 어떻게 잘 추상화하는지 인듯
- 사다리를 어떤 자료구조로 표현할지 다리가 연결된 것은 어떻게 표현할지 이런 부분들을 처음부터 잘 정립해야 함
- 처음에 난잡하게 풀었다가 올바르게 동작하는 코드는 만들었지만 시간초과였음
- 후에 표현방법을 간결하게 만드니 자연스레 로직이 간결해지고 시간복잡도가 많이 줄었다. (똑같은 DFS인데)

```java 
    public static void dfs(int left, int rInd, int cInd) {
        //정해진 개수만큼 추가할 사다리를 모두 고른 상태 
        if (left == 0) {
            //고른 상태가 정답이 되었을 때 
            if (isAllColumnReturnToItsNumber()) {
                solvable = true;
            }
            return;
        } else {
            //가로선 고르기
            //2차원 인덱스를 기억하고 있기에 보고 있던 열의 나머지 부분을 추가적으로 체크 
            for (int j = cInd; j < n - 1; j++) {
                if (map[rInd][j] == 0 && map[rInd][j + 1] == 0) {
                    map[rInd][j] = 1;
                    map[rInd][j + 1] = -1;
                    //가로선 하나 선택 완료
                    dfs(left - 1,rInd,j);
                    //해당 가로선 쓰지 않음
                    map[rInd][j] = 0;
                    map[rInd][j + 1] = 0;
                }
            }
            //보고 있던 열 다봤음 다음 열부터 다시 
            for (int i = rInd + 1; i < h; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == 0 && map[i][j + 1] == 0) {
                        map[i][j] = 1;
                        map[i][j + 1] = -1;
                        //가로선 하나 선택 완료
                        dfs(left - 1,i,j + 2);
                        //back tracking 해당 가로선을 선택 안한 것으로 하고 다음 가로선들 체크
                        map[i][j] = 0;
                        map[i][j + 1] = 0;

                    }
                }
            }
        }
    }
```

### - Q16956
#### 양이 늑대에게 잡아먹히지 않도록 울타리를 설치하라 
- 양이 늑대에게 잡아 먹히는 것을 막을 수 없는 경우는 양과 늑대가 변을 공유하고 있을 때 뿐
- 따로 체크해준다.
- 그렇지 않다면 어떠한 경우에도 지킬 수 있음
- dfs로 늑대가 갈 수 있는 곳 모두에 'F'를 저장한다. 
- 양 주변에 'F'가 있다면 울타리로 막는다. 

```java 
    public static void dfs(int r, int c) {
        visited[r][c] = true;
        if (map[r][c] == 'S') {

        }

        int row, col;

        //상
        row = r - 1;
        col = c;
        if (isValidIdx(row,col) && !visited[row][col] && map[row][col] == '.') {
            map[row][col] = 'F';
            dfs(row, col);
        }
        //하
        row = r + 1;
        col = c;
        if (isValidIdx(row, col) && !visited[row][col] && map[r + 1][c] == '.') {
            map[row][col] = 'F';
            dfs(row, col);
        }
        //좌
        row = r;
        col = c - 1;
        if (isValidIdx(row,col)&& !visited[row][col] && map[r][c-1] == '.') {
            map[row][col] = 'F';
            dfs(row, col);
        }
        //우
        row = r;
        col = c + 1;
        if (isValidIdx(row,col)&& !visited[row][col] && map[r][c+1] == '.') {
            map[row][col] = 'F';
            dfs(row, col);
        }
    }
```

### - Q2468
#### 비가 왔을 때 잠기지 않는 안전한 Sector 개수를 구하라
- 비의 양에 따라 루프를 돌며 각각의 양만큼 비가 왔을 때 나누어지는 섹터를 일일이 계산
- 섹터를 판별하는 것은 DFS로 visited배열과 함께 
- 어렵지 않은 문제 상하좌우 DFS

```java 
    public static void dfs(int row, int col) {

        int r = row;
        int c = col;

        visited[row][col] = true;

        //상
        r = row - 1;
        c = col;
        if (isValidIdx(r,c) && !visited[r][c] && map[r][c] != 0) {
            dfs(r, c);
        }
        //하
        r = row + 1;
        c = col;
        if (isValidIdx(r,c) && !visited[r][c] && map[r][c] != 0) {
            dfs(r, c);
        }
        //좌
        r = row;
        c = col - 1;
        if (isValidIdx(r,c) && !visited[r][c] && map[r][c] != 0) {
            dfs(r, c);
        }
        //우
        r = row;
        c = col + 1;
        if (isValidIdx(r,c) && !visited[r][c] && map[r][c] != 0) {
            dfs(r, c);
        }
    }

```

### - Q6593
#### 건물을 탈출하는데 최소 몇 스텝이나 걸릴까?
- 특별하지 않은 문제이지만 삽질을 하며 깨달은 게 많은 문제
- 문제는 층까지 나누어진 건물을 탈출하는 최소 단계를 물어보지만 차원을 하나 더 늘린 char[][][] map으로 간단히 해결할 수 있음
- 메모리 초과
  - 계속 메모리초과가 나길래 visited 배열 쪽을 봤는데 내가 굉장히 착각을 하고 있었다.
  - visited는 도착해서 cur를 수정하는 것은 의미가 없다! 가기 전에 상하좌우 따질 때 갈 수 있다면 visited를 체크해야 의미가 있음
  - 도착해서 visited true로 찍으면 그전에 여러번 큐에 들어갈 가능성이 있기 때문!
- move 배열을 통한 분기 줄이기
  - 이거 그렇게 어렵지 않다 moveX, moveY, moveZ들이 각 인덱스에서 하나만 1이 되도록 설정하면 끝! 그러면 for 문으로 불러왔을 때 한칸씩만 움직임
```java
//for를 통한 동서남북상하 분기를 위한 
static int[] moveX = {-1, 1, 0, 0, 0, 0};
static int[] moveY = {0, 0, -1, 1, 0, 0};
static int[] moveZ = {0, 0, 0, 0, -1, 1};
```

```java 
//핵심 bfs
    public static int bfs(int sf, int sr, int sc) {

        Queue<Coord> q = new LinkedList<>();
        Coord start = new Coord(sf, sr, sc);
        q.add(start);
        int step = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Coord cur = q.poll();
//                System.out.println("cur = " + cur);
//                visited[cur.floor][cur.row][cur.col] = true;
                if (map[cur.floor][cur.row][cur.col] == 'E') {
                    q.clear();
                    return step;
                }
                int nf, nr, nc;


                for (int m = 0; m < moveX.length; m++) {
                    nf = cur.floor + moveZ[m];
                    nr = cur.row + moveY[m];
                    nc = cur.col + moveX[m];
                    if (isAvailableCoord(nf, nr, nc) && map[nf][nr][nc] != '#' && !visited[nf][nr][nc]) {
                        q.add(new Coord(nf, nr, nc));
                        visited[nf][nr][nc] = true; //visited 위치가 여기가 되야 더 많은 케이스를 절약할 수 있음!
                    }
                }


            }
            step++;

        }

        return -1;
    }

```

### - 13459
#### 보드를 기울이며 파란공이 아닌 빨간공만 구멍에 넣어라
- bfs문제이지만 요구조건이 많은 문제 
- 문제를 꼼꼼히 읽고 처음에 전략 세우는 것이 중요하다고 알려주는 문제.. 
- 조건이 많으니 반례 테케도 각각의 조건에 따라 무수히 쏟아짐 
- 나는 공이 빠져도 공위치를 남겨놓았었는데 공이 빠지면 공이 없어지는 거임.. 지레 짐작하고 조건 무시하면 안됨 이거 하나때문에 99프로에서 계속 오답
- 너무 진을 많이 빼서 조건 분기를 그냥 주욱 갈겨놨는데 최적화는 구슬넣기2에서 진행해보자..
- 그래도 roll 함수 구현은 겁나 잘한 듯 이런 아이디어 다음에도 떠올랐으면 좋겠다 
- 자매품 13460 차이가 아예 없음 가능하다 아니다 1,0으로 나누어 출력하는 것이 아닌 실제 단계가 얼마나 걸리는지를 바꾸면 끝
```java

public static Co roll(Co pos, int rw, int cw, int nr, int nc) {
        Co tmp = new Co(pos.r, pos.c);
        while (board[tmp.r + rw][tmp.c + cw] != '#') {
            if (tmp.r + rw == nr && tmp.c + cw == nc) {
                return tmp;
            }
            tmp.r = tmp.r + rw;
            tmp.c = tmp.c + cw;

            if (board[tmp.r][tmp.c] == 'O') {
                tmp.in = true;
            }
        }
        return tmp;
}

```

### - 12851
#### 직선 상 술래잡기 몇 스텝만에 잡을 수 있는가 또한 잡을 수 있는 경우의 수가 몇가지 인가
- 간단한 bfs문제이지만 도달할 수 있는 경우의 수가 몇가지인지도 체크해야 하는 문제
- 처음엔 visited를 사용하지 않고 모든 경우를 따져보아야 하나 생각했지만 메모리 초과 발생
- 메모리 문제로 visited를 안쓸 수는 없는 상황. 그럼 어떻게 해야 할까?
- 일전에 삽질한 문제 덕분에 빠르게 풀 수 있었다. Q6593 참고!
- visited는 실제로 도착하기 전에 다음 위치를 계산할 때 찍어야 의미가 있다고 삽질하며 크게 깨달은 적이 있었다.
- 이유는 같은 q에 추가하는 단계에서 같은 것이 여러 개 추가될 수 있기 때문 
- 하지만 이 문제에서는 visited를 도착해서 찍어야 한다! 해당 위치에 도착하기 전까지는 경로가 몇개인지 여러개 카운트를 해야 하기 때문
- 이것이 이 문제의 핵심!
```java

  public static int bfs() {
    int level = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(n);
    while (!q.isEmpty()) {
      int len = q.size();

      for (int i = 0; i < len; i++) {
        Integer curP = q.poll(); //현재 술래의 위치
        visited[curP] = true;
        if (curP == k) {
          //술래가 찾은 경우
          ++count;
          continue;
        }
        if (count > 0) {
          continue;
        }
        //술래가 걸었을 경우: X-1 혹은 X+1로 이동 가능
        if (curP - 1 >= 0 && curP -1 <=100000 && !visited[curP-1]) {
//                    visited[curP - 1] = true;
          q.offer(curP - 1);
        }
        if (curP + 1 >= 0 && curP + 1 <= 100000 && !visited[curP + 1]) {
//                    visited[curP + 1] = true;
          q.offer(curP + 1);
        }
        //술래가 순간이동 한 경우: 2*X 위치로 이동 가능
        if (curP * 2 >= 0 && curP * 2 <= 100000 && !visited[curP * 2]) {
//                    visited[curP * 2] = true;
          q.offer(curP * 2);
        }
      }

      if (count > 0) {
        return level;
      }
      level++;

    }

    return -1;
  }

```

### - 12851
#### 직선 상 술래잡기 몇 스텝만에 잡을 수 있는가 또한 잡는 경우 경로를 출력
- 간단한 bfs문제, but 경로를 관리하는 것 추가로 생각해야 함. 
- 오지게 삽질했다. 첫번째로 경로를 저장하기 위해 history를 저장할 수 있는 노드 객체를 만들어서 해결해보려고 했음
```java
class Node {

  int position;
  String route;

  public Node(int position) {
    this.position = position;
    route = "" + position;

  }

} 
```
- 이렇게 하고 다음 스텝에 갈 수 있는 곳이 있으면 현재 노드를 clone해서 경로에 맞는 새로운 히스토리를 추가했다.
- 이렇게 설정하면 마지막에 도착한 노드를 까보면 지금까지 거쳐온 경로를 모두 알 수 있음
- 제일 무난한 풀이방법이라 생각했으나 시간초과에 걸림
- 시간초과에 걸린 이유는 새로 만들어지는 노드마다 history를 관리해야 하기 때문 히스토리 크기가 크다면 시간이 오래걸릴 수 밖에 그리고 clone이 수시로 일어나니까..
- 결국 이문제의 핵심은 경로 관리에서 바로 이전 위치, 즉 내가 어디서 왔는지만 관리하느냐, 아니면 경로 전체를 관리하느냐에서 갈린다.
- 내가 노드로 푼 방법은 경로 전체를 관리하는 것이고 다음에 보이는 풀이 방법이 방문한 곳에서 내가 이전에 있던 곳만 따지는 풀이 방법이다.

```java

        bfs();
        Stack<Integer> st = new Stack<>();

        String route = "";
        int pos = parent[k];
        while (pos != -2) {
            st.push(pos);
            pos = parent[pos];
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println(k);
```
- parent[k]는 k에 도달한 놈이 이전에 어디있었는지를 말함 이렇게 바로 이전 경로들만 추적해 나가면 시간초과에 걸리지 않는다.



### - 2210
#### DFS 기초 문제 
- 간단한 dfs문제 꼬는 부분 하나 없다. 그냥 모든 경우의 수를 dfs를 통해 구하면 끝
```java
    public static void dfs(int r, int c, int count, int sequence) {
        if (count == MOVE_COUNT) {
//            int res = sequence / 10;
                set.add(sequence);
        } else {
            for (int i = 0; i < moveR.length; i++) {
                int newR = r + moveR[i];
                int newC = c + moveC[i];
                if (newR >= 0 && newR < BOARD_WIDTH && newC >= 0 && newC < BOARD_HEIGHT) {
                    int newSequence = sequence * 10;    
                    newSequence += board[newR][newC];
                    dfs(newR, newC, count + 1, newSequence);
                }
            }
        }

    }
```

### - 1780
#### 2차원 배열이 coherent한 구성인지 확인, 그렇지 않다면 부분 배열이 coherent할 때까지 9분할 해나가는 문제
#### Divide & Conquer
- 간단한 문제지만 배열 분할 하는 것에서 애를 많이 먹었다
- 첫번째 풀이에서 배열 분할은 다음과 같이 해결했다.
```java 
    /**
     * @param rs rowStart
     * @param cs colStart
     * @param size
     */
    public static void divideAndConquer(int rs, int cs, int size) {
        ....
        ....
    }
```
- 원래의 종이에서 subPaper는 세가지 parameter로 표현 가능함을 이용했다.(rs, cs, size )
- size가 9인 원본 종이에서 rs = 0, cs = 0, size = 3의 부분종이는 9등분 했을 때 좌상의 부분종이를 가리키도록 되는 것이다
- 또한 size가 9인 원본 종이에서 rs = 0, cs = 0, size = 1인 부분종이는 좌상을 다시 9등분했을 때의 좌상을 가리키게 된다. 
- 나머지 풀이는 어렵지 않으나 (그냥 재귀로 해결 가능) 배열을 분할한 것을 어떻게 표현할 것인지의 아이디어를 챙겨가도록 하자 


### - 14502
#### 벽 3개를 세워서 전염병의 확산을 막을 때 어떻게 세우는 것이 가장 큰 안전영역을 가져오는가?
#### naive하게 모든 경우의 수를 따져 해결
- 벽 3개를 세울 때 가능한 모든 경우의 수를 구한다.
- 각 경우의 수처럼 벽을 세웠을 때 안전 지대를 count한다. 
- 전염병의 확산을 진행시키고 안전지대를 count해야 하는데 확산은 dfs를 이용하여 적용했다. 
- 어렵지 않은 문제인데 나름 자주 보이는 문제 예전에 소프트웨어 마에스트로 코테에서 본적 있음
- 조합은 다음과 같이 구현가능. 
```java
for (int i = 0; i < mapHeight * mapWidth; i++) {
    for (int j = i + 1; j < mapHeight * mapWidth; j++) {
        for (int k = j + 1; k < mapHeight * mapWidth; k++) {
            int row, col;
            //새로운 벽 1의 좌표
            int r1 = i / mapWidth;
            int c1 = i % mapWidth;
            //새로운 벽 2의 좌표
            int r2 = j / mapWidth;
            int c2 = j % mapWidth;
            //새로운 벽 3의 좌표
            int r3 = k / mapWidth;
            int c3 = k % mapWidth;
            
        ... 중략...
        }
    }
}

```
- 3개 이상의 것을 고르는 조합은 dfs를 이용하여 구현함이 현명해보인다. 지금은 3개니까 루프로 단순 해결했다.
- 그렇기에 꼬아서 낼려면 한도 끝도 없는 문제인 듯 함 
- 하지만 보통 이런 류의 문제가 4개 이상을 선택하도록 주어지진 않는 듯하다.
- 전염병의 확산을 구현한 dfs의 코드는 다음과 같이 간단하다.
```java 
    public static void infect(int r, int c, int[][] tmpMap, boolean[][] visited) {

        //4방향 살펴보기
        for (int i = 0; i < moveR.length; i++) {
            int newR = r + moveR[i];
            int newC = c + moveC[i];
            //유효 인덱스 검사
            if (!(newR >= 0 && newR < mapHeight && newC >= 0 && newC < mapWidth)) {
                continue;
            }
            if (tmpMap[newR][newC] == 0 ) {
                tmpMap[newR][newC] = 2;
                visited[newR][newC] = true;
                infect(newR, newC, tmpMap, visited);
            }
        }
    }
```
- 문제를 소화할 수 있는 만큼씩 잘라서 이해하고 차근차근 구현하는 것이 중요하다는 것을 명심하자


### - 17141, 17142
#### 바이러스를 어떻게 배치했을 때 Spread Time이 최소가 되는가
#### naive하게 모든 경우를 따져 해결 with DFS, BFS
- 바이러스를 배치하는 모든 경우의 수를 DFS로 따진다.
- 각 경우의 수처럼 바이러스를 배치했을 때 SpreadTime을 count.
- 문제가 어렵진 않은데 볼륨이 크다 (요구하는 게 많음)
- 잘라서 소화하자 특히 한번에 주루룩 쓰고 돌리지 말고 좀 기능단위로 테스트 진행하면서 천천히가라 그게 결국엔 젤 빠른 방법이다.
- DFS로 모든 경우의 수 따지는 코드 (2차원 좌표를 save하며 조합해나갈때 다음 재귀에서 해당 row의 처리 한번 해야 하는 것 잊지말자 )
```java    

    public static void combinationDFS(int left, int r, int c, ArrayList<Integer> virusPutIdxs) {

        //모든 바이러스를 배치한 경우
        if (left == 0) {
            //지도 깊은 복사 임시 지도에 옮겨넣는다. 
            int[][] tmpMap = new int[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    tmpMap[i][j] = map[i][j];
                    if (map[i][j] == 2) {
                        tmpMap[i][j] = 0;
                    }
                }
            }
            //지정한 위치에 바이러스 배치
            for (int i = 0; i < virusPutIdxs.size() / 2; i++) {
                Integer vr = virusPutIdxs.get(i * 2);
                Integer vc = virusPutIdxs.get(i * 2 + 1);
                tmpMap[vr][vc] = 2;
            }
            //해당 경우의 지도 추가
            virusDropCaseMaps.add(tmpMap);

        } else {
            if (r == mapSize) {
                return;
            }
            //해당 열의 나머지 부분 체크
            //조합 진행 인덱스의 r과 c중 r열의 c+1부터 나머지 확인하는 것
            for (int j = c; j < mapSize; j++) {
                int nextC = (j + 1) % mapSize;
                int nextR = r;
                if (nextC == 0) {
                    nextR += 1;
                }

                if (map[r][j] == 2) {
                    //바이러스를 현재 위치에 투하
                    virusPutIdxs.add(r);
                    virusPutIdxs.add(j);
                    combinationDFS(left-1, nextR, nextC, virusPutIdxs);

                    //바이러스를 현재 위치에 투하하지 않는다.
                    virusPutIdxs.remove(virusPutIdxs.size() - 1);
                    virusPutIdxs.remove(virusPutIdxs.size() - 1);
                    //다음 루프로
                }
            }
            //다음 열부터 진행
            for (int i = r+1; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {

                    int nextC = (j + 1) % mapSize;
                    int nextR = i;
                    if (nextC == 0) {
                        nextR += 1;
                    }

                    if (map[i][j] == 2) {
                        //바이러스를 현재 위치에 투하
                        virusPutIdxs.add(i);
                        virusPutIdxs.add(j);

                        combinationDFS(left-1, nextR, nextC, virusPutIdxs);
                        //바이러스를 현재 위치에 투하하지 않는다.
                        virusPutIdxs.remove(virusPutIdxs.size() - 1);
                        virusPutIdxs.remove(virusPutIdxs.size() - 1);
                        //다음 루프로
                    }
                }
            }
        }

    }
```
- 다음은 Spread Counting (by BFS)
```java 
    public static int countSpreadTime(int[][] caseMap) {

        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[mapSize][mapSize];
        int time = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (caseMap[i][j] == 2) {
                    q.add(i);
                    q.add(j);
                }
            }
        }

        while (!q.isEmpty()) {
            int len = q.size() / 2;
            boolean spread = false;
            for (int i = 0; i < len; i++) {
                Integer curR = q.poll();
                Integer curC = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nextR = curR + moveR[j];
                    int nextC = curC + moveC[j];
                    //인덱스 유효 검사
                    if (!(nextR >= 0 && nextR < mapSize && nextC >= 0 && nextC < mapSize)) {
                        continue;
                    }
                    if (caseMap[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        spread = true;
                        caseMap[nextR][nextC] = 2;
                        q.add(nextR);
                        q.add(nextC);
                        visited[nextR][nextC] = true;
                    }
                }
            }
            if (spread) {
                time++;
            }
        }
        // 모든 빈 칸을 바이러스로 채웠는지 체크
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (caseMap[i][j] == 0) {
                    return -1;
                }
            }
        }
        return time;

    }
```

### - 17090
#### 미로의 격자에 적힌대로 이동해야 할 때 사이클에 빠지지 않고 탈출할 수 있는 시작점은 몇개인지 구하라
#### DFS가 핵심인데 DFS가 왜 쓰이는지 근본적인 이해를 요구한다. 
- Q17090.java 첫번째 풀이 
- 모든 출발점에 대해서 탈출 가능한지 불가능한지를 따진다. 사이클에 빠지면 무한으로 돌기에 사이클 체크를 visited로 확인했다. 
- 제출 결과는 시간 초과, 시간초과를 해결하기 위해서 dfs내에 shortCut을 추가했다.
- 방문한 곳이 이미 방문한 곳이면 사이클에 빠졌음을 감지하고 지금까지 밟아왔던 모든 인덱스는 한 번 밟으면 사이클에 빠지게 되는 것으로 구별했다.
- 정보를 저장하고 처음에 출발할 때 사이클지점인지 확인하여 모든 경우의 수에서 dfs를 하지 않게 하는 것에는 성공  
- 실제로 hit되는 경우가 많았고 압축에 나름 성공한 줄 알았으나 여전히 시간초과 .. 
- 아래는 실패한 코드 
```java        
//정해진 대로만 이동해야 함. 만약 이동했는데 왔던 곳으로 왔으면 루프에 빠져 탈출할 수 없는 상태임을 알리는 것
    public static void driveMaze(Node1 node) {

        int startRow = node.getRow();
        int startCol = node.getCol();

        char cur = map[startRow][startCol];
        int nextRow = 0, nextCol = 0;

        //현재 밟고 있는 곳에 적힌대로 이동
        switch (cur) {
            case 'U':
                nextRow = startRow - 1;
                nextCol = startCol;
                break;
            case 'D':
                nextRow = startRow + 1;
                nextCol = startCol;
                break;
            case 'L':
                nextRow = startRow;
                nextCol = startCol - 1;
                break;
            case 'R':
                nextRow = startRow;
                nextCol = startCol + 1;
                break;

        }

        //탈출 성공 확정
        if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) {

            //현 위치는 탈출 가능한 위치임을 설정
            isEscapableStartPoint[startRow][startCol] = true;
            Node1 prevNode;
            int rowIdx = startRow;
            int colIdx = startCol;
            //지금 까지 밟아왔던 것들 중 하나라도 밟게 되면 탈출 성공
            while((prevNode = prev[rowIdx][colIdx]) != null) {
                isEscapableStartPoint[prevNode.getRow()][prevNode.getCol()] = true;
                rowIdx = prevNode.getRow();
                colIdx = prevNode.getCol();

            }
            return;
        }

        //가려는 곳에 방문한 적이 있다면 탈출 실패 확정
        if (prev[nextRow][nextCol] != null) {

            isEscapableStartPoint[startRow][startCol] = false;
            Node1 prevNode;
            int rowIdx = startRow;
            int colIdx = startCol;
            //지금 까지 밟아왔던 것들 중 하나라도 밟게 되면 탈출 불가
            while((prevNode = prev[rowIdx][colIdx]) != null) {
                isEscapableStartPoint[prevNode.getRow()][prevNode.getCol()] = false;
                rowIdx = prevNode.getRow();
                colIdx = prevNode.getCol();

            }
            return;
        }

        //다음으로 가고자 하는 곳이 이미 결과가 나온 곳인지 체크
        if (isEscapableStartPoint[nextRow][nextCol] != null) {
            //현 위치부터 지금까지 밟아온 곳은 다음 밟는 곳의 결과를 따른다.
            isEscapableStartPoint[startRow][startCol] = isEscapableStartPoint[nextRow][nextCol];
            Node1 prevNode;
            int rowIdx = startRow;
            int colIdx = startCol;
            while((prevNode = prev[rowIdx][colIdx]) != null) {
                isEscapableStartPoint[prevNode.getRow()][prevNode.getCol()] = isEscapableStartPoint[nextRow][nextCol];
                rowIdx = prevNode.getRow();
                colIdx = prevNode.getCol();

            }
            return;
        }
        //다음으로 가기전 어디에서 오는 것인지 기입
        prev[nextRow][nextCol] = node;
        //다음으로 이동
        Node1 nextNode = new Node1(nextRow, nextCol);
        driveMaze(nextNode);
    }
```
- Q17090RS.java: Right solution
- 사실 dfs에 관해서 지금까지 너무 획일화된 문제만 풀어와서 그럴까 이게 dfs의 근본을 묻는 문제라는 것을 꽤나 늦게 알아차림
- dfs의 본질은 파고들다가 막히면 back tracking 한다는 것 
- 즉 어디에서 왔는지 prev배열을 두어 저장할 필요 없이 back tracking을 통해서 이전 위치에 값을 알릴 수 있는것
- 이렇게 하면 prev를 처리하는 n~n제곱만큼의 시간복잡도를 줄일 수 있다
- 애초에 잘못된 풀이에서 필요 없는 것을 덕지덕지 붙여놓고 경로 압축이라고 주장한 셈.. 
- dfs의 back tracking을 이용하여 결과를 퍼뜨리는 코드를 한번 살펴보자 
```java 
    //정해진 대로만 이동해야 함. 만약 이동했는데 왔던 곳으로 왔으면 루프에 빠져 탈출할 수 없는 상태임을 알리는 것
    public static int dfs(int sr, int sc) {

        //현재 탈출했다면 return 1
        if (sr < 0 || sc < 0 || sr >= n || sc >= m) {
//            dp[sr][sc] = 1;
            return 1;
        }
        //현재 위치에 방문한 적이 있다면
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        dp[sr][sc] = -1;
        char cur = map[sr][sc];
        int nr = 0, nc = 0;

        //현재 밟고 있는 곳에 적힌대로 이동
        switch (cur) {
            case 'U':
                nr = sr - 1;
                nc = sc;
                break;
            case 'D':
                nr = sr + 1;
                nc = sc;
                break;
            case 'L':
                nr = sr;
                nc = sc - 1;
                break;
            case 'R':
                nr = sr;
                nc = sc + 1;
                break;

        }


        //다음 위치에 방문한 적이 없다면
        dp[sr][sc] = dfs(nr, nc);

        return dp[sr][sc];
    }
   
```
- dfs가 return한다. 사실 요것이 나한테 조금 어색했던 부분 
- dfs(row, col)은 해당 위치가 탈출 할 수 있는 지 없는지를 int로 알린다. 
- 방문한 곳이 탈출 가능한지 안한지는 돌려서 사이클을 만나던지 탈출 하던지 그 때가 되서야 알 수 있다. 
- 따라서 가다가 결론이 나면 propagate하는 부분이 바로 이부분이다. dp[sr][sc] = dfs(nr, nc);
- prev 없이 propagate이 가능한 것을 볼 수 있음 


</div>
</details>