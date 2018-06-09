package Misc;

import java.math.BigDecimal;
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
                new Point(3, 4),
                new Point(3, 4),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6),
                new Point(6, 6)
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

        Point[] points8 = {
                new Point(0, 0),
                new Point(0, 0),
                new Point(1, 1)
        };


        System.out.println(maxPoints(points1));
        System.out.println(maxPoints(points2));
        System.out.println(maxPoints(points3));
        System.out.println(maxPoints(points4));
        System.out.println(maxPoints(points5));
        System.out.println(maxPoints(points6));
        System.out.println(maxPoints(points7));
        System.out.println(maxPoints(points8));

    }

    public static int maxPoints(Point[] points) {
        System.out.println(points.length);
        if (points.length <= 2) {
            return points.length;
        }

        Map<BigDecimal, List<List<Point>>> slopeMap = new HashMap<>();
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

                if (!isEqual(point1, point2)) {
                    BigDecimal slope = slope(point1, point2);

                    if (slopeMap.containsKey(slope)) {
                        boolean newLineFlag = true;
                        List<List<Point>> lines = slopeMap.get(slope);

                        for (List<Point> line : lines) {
                            if (!hasPoint(line, point2) && slope(line.get(0), point2).equals(slope)) {
                                line.add(point2);
                                newLineFlag = false;

                                if (line.size() > max) {
                                    max = line.size();
                                    maxLine = line;
                                }
                            } else if (!hasPoint(line, point1) && !hasPoint(line, point2)) {
                                newLineFlag = true;
                            }
                        }

                        if (newLineFlag) {
                            List<Point> newLine = new ArrayList<>();
                            newLine.add(point1);
                            newLine.add(point2);

                            lines.add(newLine);
                        }

                    } else {
                        List<Point> firstLine = new ArrayList<>();
                        firstLine.add(point1);
                        firstLine.add(point2);

                        List<List<Point>> lines = new ArrayList<>();
                        lines.add(firstLine);
                        slopeMap.put(slope, lines);

                        if (max == Integer.MIN_VALUE) {
                            max = 2;
                            maxLine = firstLine;
                        }
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

    private static BigDecimal slope(Point point1, Point point2) {
        double slope = (point2.y - point1.y) / (double) (point2.x - point1.x);

        if (Double.isInfinite(slope)) {
            return BigDecimal.valueOf(Double.MAX_VALUE);
        }

        return ((slope == -0.0) || (slope == 0.0)) ? BigDecimal.ZERO : BigDecimal.valueOf(slope);
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
