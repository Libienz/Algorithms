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



</div>
</details>