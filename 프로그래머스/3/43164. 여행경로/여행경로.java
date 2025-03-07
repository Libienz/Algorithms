import java.util.*;

class Solution {
    private static int ticketCount;
    private static List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {

        ticketCount = tickets.length;
        List<Ticket> ticketList = new ArrayList<>();
        for (String[] ticket : tickets) {
            ticketList.add(new Ticket(ticket));
        }

        Collections.sort(ticketList);
        List<String> footPrint = new ArrayList<>();
        footPrint.add("ICN");
        dfs("ICN", ticketList, footPrint);
        
        String[] a = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            a[i] = answer.get(i);
        }
        return a;
    }
    
    public void dfs(String cur, List<Ticket> ticketList, List<String> footPrint) {
        if (!answer.isEmpty()) {
            return;
        }
        if (footPrint.size() == ticketCount + 1) {
            answer = List.copyOf(footPrint);
            return;
        }
        
        for (int i = 0; i < ticketList.size(); i++) {
            Ticket next = ticketList.get(i);
            if (next.start.equals(cur)) {
                ticketList.remove(i);
                footPrint.add(next.destination);
                dfs(next.destination, ticketList, footPrint);
                footPrint.remove(footPrint.size()-1);
                ticketList.add(next);
                Collections.sort(ticketList);
            }
        }
        
        
    }
    private static class Ticket implements Comparable<Ticket> {
        private final String start;
        private final String destination;
        
        public Ticket(String[] ticket) {
            this.start = ticket[0];
            this.destination = ticket[1];
        }
        
        @Override
        public int compareTo(Ticket other) {
            if (this.start.equals(other.start)) {
                return this.destination.compareTo(other.destination);
            }
            return this.start.compareTo(other.start);
        }
    }
}