/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2){
               return i1.start - i2.start;
           }
        });
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.offer(intervals[0].end);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start>=q.peek()){
              q.poll();
            }
            q.offer(intervals[i].end);
        }
        return q.size();
    }
}
