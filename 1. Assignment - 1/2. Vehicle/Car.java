public class Car extends Vehicle{
  private int numberOfDoors;
  private String color;

  public Car(String make, String model, int year, int numberOfDoors, String color) {
    super(make, model, year);
    this.numberOfDoors = numberOfDoors;
    this.color = color;
  }

  // Getter
  public int getNumberOfDoors() {
    return numberOfDoors;
  }

  public String getColor() {
    return color;
  }
  // Setter
  public void setNumberOfDoors(int numberOfDoors) {
    this.numberOfDoors = numberOfDoors;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return super.toString() + ", \nNumber of Doors: " + numberOfDoors + "\nColor: " + color;
  }

  // Display method to print all details
  public void display() {
    System.out.println("Car Details:- " + "\n"+this.toString()+ "\n");
  }
}
