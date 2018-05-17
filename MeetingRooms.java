/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        
        if (intervals.length == 0)
            return 0;
        if (intervals.length == 1)
            return 1;
        Arrays.sort(intervals, new Comparator<Interval>()
                   {
                       public int compare(Interval i1, Interval i2)
                       {
                           return i1.start - i2.start;
                       }
                   });
        
        int count = 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>()
                                                                    {
                                                                        public int compare(Integer i1, Integer i2)
                                                                        {
                                                                            return i1 - i2;
                                                                        }
                                                                    });
        
        minHeap.offer(intervals[0].end);    
        for (int i=1; i<intervals.length; i++)
        {
            if (intervals[i].start < minHeap.peek())
                count++;
            else
                minHeap.poll();
            minHeap.offer(intervals[i].end);
        }  
            
            
            
        return count;
    }
}