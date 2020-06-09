/*
 * This class and constructor for do homework 
 * object oriented styles
 * @author Ahsen Amil
 * 
 * @Since March 17, 2019
 */
public class Circle {

	private double x;
	private double y;
	private double radius;

	Circle (double x , double y , double radius) {                       //create constructor
		this.x = x;
		this.y = y;
		this.radius = radius;

	}
	public double getX() {

		return  x;
    }

	public void setX(int x) {

		this.x = x;
    }
	public double getY() {

		return y;
    }
 
	public void setY(int y) {

		this.y = y;
    }
	
	public void draw() {                             //for draw the circle
		StdDraw.circle(x, y, radius);
	}
	
	public double distance(Circle inputCircle) {     //find max distance and return
		return (Math.sqrt((x - inputCircle.x)*(x - inputCircle.x) + (y-inputCircle.y)*(y-inputCircle.y)));			
	}
}


