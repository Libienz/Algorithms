import java.util.*;

class Node1 {
    private int row, col;


    public Node1(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

public class Q17090 {

    private static int n, m;
    private static char[][] map;
    private static Node1[][] prev;
    private static Boolean[][] isEscapableStartPoint;
    private static int escapeCount = 0;


    public static void main(String[] args) {

        //요소들 초기화
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // map row size
        m = sc.nextInt(); // map col size
        map = new char[n][m];
        isEscapableStartPoint = new Boolean[n][m];
        prev = new Node1[n][m];

        //미로 초기화
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
                isEscapableStartPoint[i][j] = null;
            }
        }

        //i,j에서 시작하여 미로에 적힌대로 움직일 때 탈출 할 수 있는지 확인한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resetPrev();
                //이전에 결과를 밝힌 위치인지 check
                if (isEscapableStartPoint[i][j] == null) {
                    //i, j에서 미로 출발
                    Node1 node = new Node1(i, j);
                    driveMaze(node);
                }
            }
        }

        //탈출 가능한 시작점 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //이전에 결과를 밝힌 위치인지 check
                if (isEscapableStartPoint[i][j]) {
                    escapeCount++;
                }
            }
        }
        System.out.println(escapeCount);

    }

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


    public static void resetPrev() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prev[i][j] = null;
            }
        }
    }
}
