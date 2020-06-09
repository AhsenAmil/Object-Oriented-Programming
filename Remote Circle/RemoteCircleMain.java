import java.awt.Color;
import java.util.Random;

public class RemoteCircleMain {

	final static int MAX_RADIUS = 50;      //set an estimated maximum radius so the hoops don't come out of the canvas      
/*Object Oriented Lecture, Assignment 2 : Remote Circle 
 * First, we determine the length and width of canvas. 
 * Random circles are drawn, but the hoops should not come out of the canvass. 
 * We are adding various controls for this. After circles are drawn, 
 * we find the two of them and draw lines between them. 
 * We find the distance by calculating the distance from the center of 
 * the two circles to the center. We assign that to the loop and 
 * compare each circle with the other.
 * @author Ahsen Amil
 * 
 * @Since March 17, 2019
 * 
 */
	public static void main(String[] args) {

		int canvas_width = 1000;                                  //set canvas width
		int canvas_height = 1000;                                 //set canvas height
		double circle_border_thickness = 0.005;                   //determine circle border thickness
		StdDraw.clear(StdDraw.WHITE);                             //command to clear the previous step
		StdDraw.setPenColor(StdDraw.BLACK); 
		StdDraw.setPenRadius(circle_border_thickness);            //circle color
		StdDraw.setCanvasSize(canvas_width, canvas_height);       //draw canvas

		StdDraw.setXscale(0, 1000);                               //set x coordinates
		StdDraw.setYscale(0, 1000);                               //set y coordinates


		Circle [] circles = new Circle[100];                      //keep all our circles in an array

		for ( int i = 0 ; i<circles.length; i++) {                //control structure for the hoops coming out of the canvas

			Random r = new Random ();                             //draws random circles of array length

			int circle_radius   = r.nextInt(MAX_RADIUS);          //draws circles with a radius of up to 50
			double circle_center_x = (double)r.nextInt(canvas_width - (2*circle_radius))+circle_radius;  //the centers are written in a certain size so that the hoops are not left half way
			double circle_center_y = (double)r.nextInt(canvas_height - (2*circle_radius))+circle_radius;

			Circle inputCircle = new Circle(circle_center_x, circle_center_y, circle_radius);          //draw circle according to all our commands
			circles[i] = inputCircle;
			inputCircle.draw();
		}

		Circle circle1 = circles[0];                            //find two farthest circle so control to start first index of an array
		Circle circle2 = circles[0];
		double maxDistance = 0;                                 //assign max distance of two circle
		for (int i = 0; i < circles.length; i++)                //each loop to compare with the other to find the most farthest circles
		{
			for (int j = 0; j < circles.length; j++)
			{
				double distance = circles[i].distance(circles[j]);  //distance of each circle to another
				if (distance > maxDistance)                         //if each process finds more distant circles
				{
					maxDistance = distance;                         //new distance 
					circle1 = circles[i];                           //the first of the farthest circles
					circle2 = circles[j];                           //the second of the farthest circles
				}

			}
		}
		
		
		Color line_color = StdDraw.RED;                             //line color is red           
		StdDraw.setPenColor(line_color);                            //draws line between two distant circles
		StdDraw.line(circle1.getX(), circle1.getY(), circle2.getX(), circle2.getY());	//coordinates of line

	}

}


