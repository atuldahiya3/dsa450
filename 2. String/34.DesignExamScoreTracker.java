
import java.util.TreeMap;

class ExamTracker {
    TreeMap<Object, Object><Integer,Integer> map;
    public ExamTracker() {
        map= new TreeMap<>();
    }
    
    public void record(int time, int score) {
        map.put(time, map.getOrDefault(time, 0)+score);
    }
    
    public long totalScore(int startTime, int endTime) {
        long total=0;
        for(int val: map.subMap(startTime, true, endTime, true).values()){
            total+=val;
        }
        return total;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */