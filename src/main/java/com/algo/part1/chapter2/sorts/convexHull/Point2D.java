package com.algo.part1.chapter2.sorts.convexHull;

import com.algo.libraries.StdDraw;
import com.algo.libraries.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cov-127 on 27/12/16.
 */

public class Point2D{
    public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
    private final double x, y;
    public Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    private class PolarOrder implements Comparator<Point2D> {
        public int compare(Point2D q1, Point2D q2) {
            double dy1 = q1.y - y;
            double dy2 = q2.y - y;
            if (dy1 == 0 && dy2 == 0) { return 0;}   // p, q1, q2 horizontal
            else if (dy1 >= 0 && dy2 < 0) return -1; // q1 above p; q2 below p
            else if (dy2 >= 0 && dy1 < 0) return +1; // q1 below p; q2 above p
            else return -ccw(Point2D.this, q1, q2);  // both above or below p
        }
    }
    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = ((b.x - a.x) * (c.y-a.y)) - ((b.y - a.y) * (c.x - a.x));
        if (area2 < 0) return -1; // clockwise
        else if (area2 > 0) return +1; // counter-clockwise
        else return 0; // collinear
    }
}