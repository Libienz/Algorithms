import java.util.*;

class Solution {
    private static final int ROW_SIZE = 100;
    private static final int COL_SIZE = 100;

    public int solution(int[][] points, int[][] routes) {
        List<List<Position>> robots = new ArrayList<>();

        for (int robotId = 0; robotId < routes.length; robotId++) {
            List<Position> robotPath = getRobotPath(routes[robotId], points);
            robots.add(robotPath);
        }

        int collisionCount = 0;
        int maxLengthOfRobotPath = Integer.MIN_VALUE;

        for (List<Position> robotPath : robots) {
            maxLengthOfRobotPath = Math.max(maxLengthOfRobotPath, robotPath.size());
        }

        for (int i = 0; i < maxLengthOfRobotPath; i++) {
            Map<Position, Integer> positionCount = new HashMap<>();
            for (List<Position> robotPath : robots) {
                if (i < robotPath.size()) {
                    Position visitedPosition = robotPath.get(i);
                    positionCount.put(visitedPosition, positionCount.getOrDefault(visitedPosition, 0) + 1);
                }
            }
            for (int count : positionCount.values()) {
                if (count > 1) {
                    collisionCount++;
                }
            }
        }
        return collisionCount;
    }

    public List<Position> getRobotPath(int[] robotPath, int[][] points) {
        List<Position> path = new ArrayList<>();
        int prev = robotPath[0];
        int sr = points[prev - 1][0] - 1;
        int sc = points[prev - 1][1] - 1;

        path.add(new Position(sr, sc));
        for (int i = 1; i < robotPath.length; i++) {
            int dest = robotPath[i];
            int dr = points[dest - 1][0] - 1;
            int dc = points[dest - 1][1] - 1;

            int cr = sr;
            int cc = sc;

            int rowMoveDirection = cr < dr ? 1 : -1;
            while (cr != dr) {
                cr += rowMoveDirection;
                path.add(new Position(cr, cc));
            }

            int colMoveDirection = cc < dc ? 1 : -1;
            while (cc != dc) {
                cc += colMoveDirection;
                path.add(new Position(cr, cc));
            }

            sr = dr;
            sc = dc;
        }
        return path;
    }

    private static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            Position other = (Position) o;
            return this.r == other.r && this.c == other.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.r, this.c);
        }

        @Override
        public String toString() {
            return "(" + this.r + ", " + this.c + ")";
        }
    }
}