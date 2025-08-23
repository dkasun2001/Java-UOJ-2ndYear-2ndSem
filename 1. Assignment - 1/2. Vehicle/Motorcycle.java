public class Motorcycle extends Vehicle{
  private String type; // Cruiser, Sport, Touring
  private String color;
  
  public Motorcycle(String make, String model, int year, String type, String color) {
    super(make, model, year);
    this.type = type;
    this.color = color;
  }

  // Getter methods
  public String getType() {
    return type;
  }

  public String getColor() {
    return color;
  }

  // Setter methods
  public void setType(String type) {
    this.type = type;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return super.toString() + ", \nType: " + type + "\nColor: " + color;
  }

  // Display method to print all details
  public void display() {
    System.out.println("Motorcycle Details:- " + "\n"+this.toString()+ "\n");
  }
}
