package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPoints {

    public static void main(String[] args) {

        Point[] points1 = {
                new Point(1, 1),
                new Point(3, 2),
                new Point(5, 3),
                new Point(4, 1),
                new Point(2, 3),
                new Point(1, 4)
        };

        Point[] points2 = {
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4),
                new Point(2, 3),
                new Point(3, 4)
        };

        Point[] points3 = {
                new Point(0, 0),
                new Point(0, 0),
                new Point(1, 1)
        };


        Point[] points4 = {
                new Point(4, 0),
                new Point(4, -1),
                new Point(4, 5),
                new Point(4, 5)
        };

        Point[] points5 = {
                new Point(1, 1),
                new Point(1, 1),
                new Point(1, 1)
        };

        Point[] points6 = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(0, 0)
        };

        Point[] points7 = {
                new Point(1, 1),
                new Point(0, 0),
                new Point(0, 0)
        };


        System.out.println(maxPoints(points1));
        System.out.println(maxPoints(points2));
        System.out.println(maxPoints(points3));
        System.out.println(maxPoints(points4));
        System.out.println(maxPoints(points5));
        System.out.println(maxPoints(points6));
        System.out.println(maxPoints(points7));

    }


    public static int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }

        Map<Double, List<List<Point>>> slopeMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> pointsCount = new HashMap<>();
        List<Point> maxLine = null;
        int max = Integer.MIN_VALUE;

        for (Point point : points) {
            if (pointsCount.containsKey(point.x)) {
                Map<Integer, Integer> yCordinateMap = pointsCount.get(point.x);

                if (yCordinateMap.containsKey(point.y)) {
                    Integer yCount = yCordinateMap.get(point.y);

                    yCordinateMap.put(point.y, ++yCount);
                } else {
                    yCordinateMap.put(point.y, 1);
                }

            } else {
                Map<Integer, Integer> yCordinateMap = new HashMap<>();
                yCordinateMap.put(point.y, 1);

                pointsCount.put(point.x, yCordinateMap);
            }
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point point1 = points[i];
                Point point2 = points[j];

                double slope = slope(point1, point2);
                if (slopeMap.containsKey(slope) && !isEqual(point1, point2)) {
                    boolean newLineFlag = true;
                    List<List<Point>> lines = slopeMap.get(slope);

                    for (List<Point> line : lines) {
                        if (slope(line.get(0), point2) == slope && !line.contains(point2) && !hasPoint(line,point2)) {
                            line.add(point2);
                            newLineFlag = false;

                            if (line.size() > max) {
                                max = line.size();
                                maxLine = line;
                            }
                        }
                    }

                    if (newLineFlag) {
                        List<Point> newLine = new ArrayList<>();
                        newLine.add(point1);
                        newLine.add(point2);

                        lines.add(newLine);
                    }

                } else if (!isEqual(point1, point2)) {

                    List<Point> newLine = new ArrayList<>();
                    newLine.add(point1);
                    newLine.add(point2);

                    List<List<Point>> line = new ArrayList<>();
                    line.add(newLine);
                    slopeMap.put(slope, line);

                    if (max == Integer.MIN_VALUE) {
                        max = 2;
                        maxLine = newLine;
                    }
                }

            }
        }

        if (maxLine != null) {
            for (Point point : maxLine) {
                int count = pointsCount.get(point.x).get(point.y);

                if (count > 1) {
                    max = max + count - 1;
                }
            }
        } else {
            max = pointsCount.get(points[0].x).get(points[0].y);
        }
        return max;
    }

    private static boolean isEqual(Point point1, Point point2) {
        return point1.x == point2.x && point1.y == point2.y;
    }

    private static double slope(Point point1, Point point2) {
        double slope = (point2.y - point1.y) / (double) (point2.x - point1.x);

        if (Double.isInfinite(slope)) {
            return Double.POSITIVE_INFINITY;
        }

        return slope == -0.0 ? 0.0 : slope;
    }

    private static boolean hasPoint(List<Point> points, Point point) {
        for (Point point1 : points) {
            if (isEqual(point1, point)) {
                return true;
            }
        }
        return false;
    }
}
