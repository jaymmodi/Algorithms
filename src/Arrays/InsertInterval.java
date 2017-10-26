package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(3, 5);
        Interval interval3 = new Interval(6, 7);
        Interval interval4 = new Interval(8, 10);
        Interval interval5 = new Interval(12, 16);

        List<Interval> insert = insert(Arrays.asList(interval1, interval2, interval3, interval4, interval5), new Interval(4, 9));
    }


    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            return Arrays.asList(newInterval);
        }

        List<Interval> result = new ArrayList<>();
        result.add(newInterval);

        for (Interval currentInterval : intervals) {
            Interval lastInterval = result.get(result.size() - 1);
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
        if ((newInterval.start >= currentInterval.start && newInterval.start <= currentInterval.end) ||
                (newInterval.end >= currentInterval.start && newInterval.end <= currentInterval.end) ||
                (newInterval.start <= currentInterval.start && newInterval.end >= currentInterval.end) ||
                (newInterval.start >= currentInterval.start && newInterval.end <= currentInterval.end)) {
            return true;
        }

        return false;
    }
}

