/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * N*log(N) + N*log(N) -> O(N*log(N))
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



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * N*log(N) + N*log(N) + N -> O(N*log(N))
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int x=0;
        int y=0;
        int rooms = 0;
        int maxRooms = 0;
        while(x<intervals.length && y <intervals.length){
            if(starts[x] < ends[y]){
                rooms++;
                maxRooms = Math.max(rooms, maxRooms);
                x++;
            }
            else{
                y++;
                rooms--;
            }
        }
        return maxRooms;
    }
}
