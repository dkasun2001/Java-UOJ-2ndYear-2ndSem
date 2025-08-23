/*
 Write a program to create a 'Rectangle' class with a constructor having length and width as its parameters. Calculate the perimeter and area of a rectangle with length 6 units and width 4 units using the class
*/

class Rectangle{
	private double length;
	private double width	;
	
	public Rectangle(float length, float width){
		this.length = length;
		this.width = width;
	}
	
	// setters
	public void setLength(float length){
		this.length = length; 
	}
	
	public void setWidth(float width){
		this.width = width; 
	}
	
	// getters
	public double getLength(){
		return this.length;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	
	// Perimeter
	public double calPerimeter(){
		return 2*(this.length + this.width);
	}
	
	// Area
	public double calArea(){
		return this.length * this.width;
	}	
	
	// toString
	public String toString(){
		return ("Perimeter is "+this.calPerimeter()+", Area is "+this.calArea());
	}
}