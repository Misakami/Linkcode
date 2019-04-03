import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * 扫描线算法？？没差？？？
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null)
            return intervals;
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        while (i<intervals.size()){
            res.add(intervals.get(i++));
        }
        return res;
    }
}
