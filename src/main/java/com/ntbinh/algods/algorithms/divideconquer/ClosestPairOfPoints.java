package com.ntbinh.algods.algorithms.divideconquer;

import java.util.Arrays;

import com.ntbinh.algods.utils.Utilities;

import edu.princeton.cs.algs4.Point2D;

public final class ClosestPairOfPoints {

    private static double bruteForce(Point2D[] points) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i].distanceTo(points[j]) < min) {
                    min = points[i].distanceTo(points[j]);
                }
            }
        }
        return min;
    }

    private static double stripClosestDist(Point2D[] stripPoints, int n, double minDist) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && Math.abs(stripPoints[i].y() - stripPoints[j].y()) < minDist; j++) {
                if (stripPoints[i].distanceTo(stripPoints[j]) < minDist) {
                    minDist = stripPoints[i].distanceTo(stripPoints[j]);
                }
            }
        }
        return minDist;
    }

    private static double closestDist(Point2D[] pointsX, Point2D[] pointsY) {
        int n = pointsX.length;                         
        if (n <= 3) return bruteForce(pointsX);
        int mid = n / 2;
        Point2D midPoint = pointsX[mid];
        
        Point2D[] leftPointsY = new Point2D[mid];
        Point2D[] rightPointsY = new Point2D[n - mid];

        int leftIndex = 0, rightIndex = 0;
        for (int i = 0; i < n; i++) {
            if (leftIndex < mid && (pointsY[i].x() < midPoint.x() || (pointsY[i].x() == midPoint.x() && pointsY[i].y() < midPoint.y()))) {
                leftPointsY[leftIndex++] = pointsY[i];
            } else {
                rightPointsY[rightIndex++] = pointsY[i];
            }
        }
        // System.out.println(String.format(" leftIndex = %d, rightIndex = %d", leftIndex, rightIndex));
        double leftMinDist = closestDist(Arrays.copyOfRange(pointsX, 0, mid), leftPointsY);
        double rightMinDist = closestDist(Arrays.copyOfRange(pointsX, mid, n), rightPointsY);
        // System.out.println(String.format("left min = %f, right min = %f", leftMinDist, rightMinDist));

        Point2D[] stripPoints = new Point2D[pointsX.length];
        int stripIndex = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(pointsX[i].x() - midPoint.x()) < Math.min(leftMinDist, rightMinDist)) {
                stripPoints[stripIndex++] = pointsY[i];
            }
        }    
        return stripClosestDist(stripPoints, stripIndex, Math.min(leftMinDist, rightMinDist));
    }

    /**
     * 
     * @param points    array of Point2D
     * @param m         enumerator value of Method
     * @return          the minimum distance between two points among the points
     */
    public static double execute(Point2D[] points) {

        Point2D[] pointsX = new Point2D[points.length];
        Point2D[] pointsY = new Point2D[points.length];

        for (int i = 0; i < points.length; i++) {
            pointsX[i] = points[i];
            pointsY[i] = points[i];
        }

        System.out.println("x-sorted points");
        Arrays.sort(pointsX, Point2D.X_ORDER);
        Utilities.showPoints(pointsX);
        Arrays.sort(pointsY, Point2D.Y_ORDER);
        return closestDist(pointsX, pointsY);
    }
}
