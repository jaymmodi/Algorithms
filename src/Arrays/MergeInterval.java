package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        Interval interval1 = new Interval(2, 3);
        Interval interval2 = new Interval(4, 5);
        Interval interval4 = new Interval(6, 7);
        Interval interval5 = new Interval(8, 9);
        Interval interval6 = new Interval(1, 10);

        List<Interval> insert = insert(Arrays.asList(interval1, interval2, interval4, interval5,interval6));
//        List<Interval> insert = insert(new ArrayList<>());
        System.out.println("Jay");
    }


    public static List<Interval> insert(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> result = new ArrayList<>();
        intervals.sort((o1, o2) -> {
            if (o1.start < o2.start) {
                return -1;
            } else if (o1.start > o2.start) {
                return 1;
            } else {
                return 0;
            }
        });

        result.add(intervals.get(0));

        for (int i = 1; i <= intervals.size() - 1; i++) {
            Interval lastInterval = result.get(result.size() - 1);
            Interval currentInterval = intervals.get(i);
            if (isOverlapping(currentInterval, lastInterval)) {
                int min = getIntervalMin(currentInterval.start, lastInterval.start);
                int max = getIntervalMax(currentInterval.end, lastInterval.end);

                lastInterval.start = min;
                lastInterval.end = max;
            } else {
                if (currentInterval.start < lastInterval.start) {
                    result.remove(result.size() - 1);
                    result.add(currentInterval);
                    result.add(lastInterval);
                } else {
                    result.add(currentInterval);
                }
            }
        }
        return result;
    }

    private static int getIntervalMin(int currentStart, int lastStart) {
        if (currentStart > lastStart) {
            return lastStart;
        } else {
            return currentStart;
        }
    }

    private static int getIntervalMax(int currentEnd, int lastEnd) {
        if (currentEnd > lastEnd) {
            return currentEnd;
        } else {
            return lastEnd;
        }
    }

    private static boolean isOverlapping(Interval currentInterval, Interval newInterval) {
        return (newInterval.start >= currentInterval.start && newInterval.start <= currentInterval.end) ||
                (newInterval.end >= currentInterval.start && newInterval.end <= currentInterval.end) ||
                (newInterval.start <= currentInterval.start && newInterval.end >= currentInterval.end) ||
                (newInterval.start >= currentInterval.start && newInterval.end <= currentInterval.end);

    }
}

