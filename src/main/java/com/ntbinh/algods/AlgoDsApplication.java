package com.ntbinh.algods;

import com.ntbinh.algods.algorithms.array.RotateArray;
import com.ntbinh.algods.algorithms.divideconquer.ClosestPairOfPoints;
import com.ntbinh.algods.utils.Utilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

@SpringBootApplication
public class AlgoDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgoDsApplication.class, args);
		// RotateArray.execute();
		// System.setProperty("java.awt.headless", "false"); //Disables headless
		// Point2D[] points = Utilities.generateRandomPoints(9);
		// // for (int i = 0; i < points.length; i++) {
		// // 	System.out.println(String.format("x = %f : y = %f", points[i].x(), points[i].y()));
		// // }
		// StdDraw.setCanvasSize(1000, 1000);
    	// StdDraw.setXscale(-5, 10);
    	// StdDraw.setYscale(-5, 10);
    	// StdDraw.setPenRadius(0.002);
        // StdDraw.setPenColor(StdDraw.BLUE);
		// StdDraw.line(-5, 0, 10, 0);
		// StdDraw.line(0, -5, 0, 10);
		// // StdDraw.setPenRadius(0.05);
        // // StdDraw.point(0.5, 0.5);
		// // StdDraw.setPenColor(StdDraw.MAGENTA);
        // // StdDraw.point(3.5, 1.7);
		// for (int i = 0; i < points.length; i++) {
		// 	StdDraw.setPenRadius(0.02);
        //    	StdDraw.setPenColor(StdDraw.BLUE);
		// 	StdDraw.point(points[i].x(), points[i].y());
		// }
		// System.out.println(String.format("The closest distance between 2 points is %f", ClosestPairOfPoints.execute(points)));
	}

}
