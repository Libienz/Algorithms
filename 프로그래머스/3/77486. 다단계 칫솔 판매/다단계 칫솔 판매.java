import java.util.*;

class Solution {
    private static final int PRICE = 100;
    private static final int RATE = 10;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        List<Seller> sellers = new ArrayList<>();
        Map<String, Seller> nameIdx = new HashMap();
        
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            Seller cur = new Seller(i, name);
            nameIdx.put(name, cur);
            sellers.add(cur);
        }
        
        for (int i = 0; i < enroll.length; i++) {
            Seller cur = sellers.get(i);
            String parentName = referral[i];
            Seller parent = nameIdx.get(parentName);
            cur.setParent(parent);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String curSellerName = seller[i];
            Seller curSeller = nameIdx.get(curSellerName);
            curSeller.applyProfit(amount[i] * PRICE);
        }
        
        int[] answer = new int[sellers.size()];
        for (int i = 0; i < sellers.size(); i++) {
            answer[i] = sellers.get(i).profit;
        }
        return answer;
    }

    
    private static class Seller {
        private final int id;
        private Seller parent;
        private final String name;
        private int profit = 0;
        
        public Seller(int id, Seller parent, String name) {
            this.id = id;
            this.parent = parent;
            this.name = name;
        }
        
        public Seller(int id, String name) {
            this(id, null, name);
        }
        
        public void setParent(Seller parent) {
            this.parent = parent;
        }
        
        public void applyProfit(int totalPrice) {
            if (this.parent != null) {
                this.profit += totalPrice - (totalPrice / RATE);
                this.parent.applyProfit(totalPrice / RATE);
            } else {
                this.profit += totalPrice - (totalPrice / RATE);
            }
        }
        
        public String toString() {
            if (parent == null) { 
                return "name: " + name + ", parent: -";    
            }
            return "name: " + name + ", parent: " + parent.name;
        }
    }
}