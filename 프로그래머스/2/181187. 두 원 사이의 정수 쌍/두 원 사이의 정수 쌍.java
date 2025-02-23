class Solution {
    public long solution(int r1, int r2) {
        Circle smaller = Circle.createCenterCircle(r1);
        Circle bigger = Circle.createCenterCircle(r2);
        
        long answer = 0;
        for (int x = 1; x <= r2; x++) {
            int by = (int) Math.floor(bigger.getY(x));
            int sy = (int) Math.ceil(smaller.getY(x));
            answer += (by - sy + 1);
        }
        return answer * 4;
    }
    
    
    private static class Circle {
        int x;
        int y;
        int r;
        
        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
        
        public static Circle createCenterCircle(int r) {
            return new Circle(0, 0, r);
        }
        
        public boolean contains(int tx, int ty) {
            int xd = x - tx;
            int yd = y - ty;
            
            return Math.pow(r,2) > Math.pow(xd, 2) + Math.pow(yd, 2);
        }
        
        public boolean isPointOnBoarderLine(int tx, int ty) {
            int xd = x - tx;
            int yd = y - ty;
            
            return Math.pow(r,2) == Math.pow(xd, 2) + Math.pow(yd, 2);
        }
        
        public double getY(int tx) {
            return Math.sqrt(Math.pow(r,2) - Math.pow(tx - x, 2));
        }
    }
}