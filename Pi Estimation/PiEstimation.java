import java.awt.Color;
import java.util.Random;
/*
 * Sample Code for OOP
 * The aim of the project is to draw different points in and out of the 
 * canvas after drawing a large circle. "pi number" is obtained when the 
 * sum of the points outside is divided by the sum of points inside. 
 * The colors of the points outside and inside are different.
 * 
 */

public class PiEstimation {

	public static void main(String[] args) {
		int canvas_width = 500;

		int canvas_height = 500;

		StdDraw.clear(StdDraw.WHITE);

		StdDraw.setCanvasSize(canvas_width, canvas_height);

		StdDraw.setXscale(0, 1); // set x coordinates

		StdDraw.setYscale(0, 1); // set y coordinates

		double circle_center_x = 0.5; 

		double circle_center_y = 0.5;

		double circle_radius   = 0.5; 

		double circle_border_thickness = 0.005; 

		Color circle_color = StdDraw.PRINCETON_ORANGE;  

		StdDraw.setPenColor(circle_color); 

		StdDraw.setPenRadius(circle_border_thickness); 

		StdDraw.circle(circle_center_x, circle_center_y, circle_radius);
		

		int counter = 0;

		int counter2 = 0;

		for ( int i = 0 ; i<50000; i++) {

			Random r = new Random ();

			double ball_center_x = r.nextDouble();

			double ball_center_y =r.nextDouble();

			double ball_radius   = 0.004;

			double ball_border_thickness = 0.004;

			double distance = Math.sqrt((0.5 - ball_center_x)*(0.5-ball_center_x) + (0.5-ball_center_y)*(0.5-ball_center_y));

			if(distance > 0.5) {
				Color ball_color = StdDraw.BLACK;
				StdDraw.setPenColor(ball_color);
				StdDraw.point(ball_center_x, ball_center_y);
				counter ++;
			}
			else {
				Color ball_color = StdDraw.BOOK_RED;
				StdDraw.setPenColor(ball_color);
				StdDraw.point(ball_center_x, ball_center_y);
				counter2 ++;

			}
			double result = counter + counter2;
			System.out.println((4*(counter2))/(result));

		}
	}
}
