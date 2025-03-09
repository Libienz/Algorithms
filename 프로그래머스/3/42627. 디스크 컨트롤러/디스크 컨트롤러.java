import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Queue<Job> jobQueue = new PriorityQueue<>();
        Map<Integer, List<Job>> jobTable = new HashMap<>();
        for (int i = 0; i < jobs.length; i++) {
            Job curJob = new Job(i, jobs[i][0], jobs[i][1]);
            List<Job> emptyJobs = new ArrayList<>();
            List<Job> timeJobs = jobTable.getOrDefault(curJob.requestedAt, emptyJobs);
            timeJobs.add(curJob);
            jobTable.put(curJob.requestedAt, timeJobs);
        }
        
        int jobEndAt = 0;
        int turnAroundTimes = 0;
        int curTime = 0;
        int processed = 0;
        Job currentProcessing = null;
        
        while (processed < jobs.length) {
            if (jobTable.get(curTime) != null) {
                jobQueue.addAll(jobTable.get(curTime));
            }
            if (currentProcessing != null && jobEndAt == curTime) {
                processed++;
                currentProcessing = null;
            }
            if (currentProcessing == null && !jobQueue.isEmpty()) {
                currentProcessing = jobQueue.poll();
                jobEndAt = curTime + currentProcessing.costTime;
                turnAroundTimes += jobEndAt - currentProcessing.requestedAt;
            }
            curTime++;
        }
        
        int answer = turnAroundTimes / jobs.length;
        return answer;
    }
    
    private static class Job implements Comparable<Job> {
        private final int id;
        private final int requestedAt;
        private final int costTime;
        
        public Job(int id, int requestedAt, int costTime) {
            this.id = id;
            this.requestedAt = requestedAt;
            this.costTime = costTime;
        }
        
        @Override
        public int compareTo(Job other) {
            if (this.costTime == other.costTime && this.requestedAt == other.requestedAt) {
                return this.id - other.id;
            }
            if (this.costTime == other.costTime) {
                return this.requestedAt - other.requestedAt;
            }
            return this.costTime - other.costTime;
        }
        
        @Override
        public boolean equals(Object other) {
            return this.id == ((Job) other).id;
        }
        
        @Override 
        public int hashCode() {
            return Objects.hashCode(this.id);
        }
    }
}