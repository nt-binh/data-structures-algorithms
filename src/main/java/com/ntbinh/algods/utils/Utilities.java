package com.ntbinh.algods.utils;


import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("rawtypes")
public class Utilities {
    
    public static void display(Object str) {
        System.out.println(str.toString());
    }

    public static void display(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static <T> void display(Node<T> head) {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.value.toString() + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static Point2D[] generateRandomPoints(int size) {
        Point2D[] points = new Point2D[size];
        for (int i = 0; i < size; i++) {
            double x = StdRandom.uniform() * 10;
            double y = StdRandom.uniform() * 10;
            points[i] = new Point2D(x, y);
        }
        return points;
    }

    public static void showPoints(Point2D[] points) {
        for (int i = 0; i < points.length; i++) {
            System.out.println(String.format("x = %f : y = %f", points[i].x(), points[i].y()));
        }
    }
}
