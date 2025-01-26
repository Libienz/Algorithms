import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        Circle c1 = Circle.createOriginCircle(r1);
        Circle c2 = Circle.createOriginCircle(r2);
        
        long answer = 0;
        for (int y = 1; y <= c2.radius; y++) {
            int x1 = (int) Math.ceil(c1.getX(y));
            int x2 = (int) Math.floor(c2.getX(y));
            answer += x2 - x1 + 1;
        }
        
        return answer * 4;
    }
    
    private static class Circle {
        int xPoint;
        int yPoint;
        int radius;
        
        public Circle(int xPoint, int yPoint, int radius) {
            this.xPoint = xPoint;
            this.yPoint = yPoint;
            this.radius = radius;
        }
        
        public double getX(int y) {
            return Math.sqrt(Math.pow(radius,2) - Math.pow(y,2));
        }
        
        public static Circle createOriginCircle(int radius) {
            return new Circle(0,0,radius);
        }
        
        public boolean contains(int x, int y) {
            double distanceSquare = Math.pow(x - xPoint, 2) + Math.pow(y - yPoint, 2);
            double radiusSquare = Math.pow(radius, 2);
            
            if (distanceSquare > radiusSquare) {
                return false;
            }
            if (distanceSquare < radiusSquare) {
                return true;
            }
            return false;
        }
        
        public boolean isPointOnBoarderLine(int x, int y) {
            double distanceSquare = Math.pow(xPoint - x, 2) + Math.pow(yPoint - y, 2);
            double radiusSquare = Math.pow(radius, 2);
            
            if (distanceSquare == radiusSquare) {
                return true;
            }
            return false;
        }
    }
}