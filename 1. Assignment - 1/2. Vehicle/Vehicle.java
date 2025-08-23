/* 
Create a class "Vehicle" that models a vehicle.
a. Implement methods to set and get the vehicle's make, model, and year.

b. Define classes "Car" and "Motorcycle" that inherit from the Vehicle class, with additional properties specific to each type.

c. Write a display method to print all details.

d. Write a main method to create instances of both Car and Motorcycle, set their
properties, and display the information 
*/

public class Vehicle {
  private String vehicleMake;
  private String vehicleModel;
  private int vehicleYear;

  public Vehicle(String make, String model, int year) {
    this.vehicleMake = make;
    this.vehicleModel = model;
    this.vehicleYear = year;
  }

  // Getters
  public String getMake() {
    return vehicleMake;
  }
  public String getModel() {
    return vehicleModel;
  }
  public int getYear() {
    return vehicleYear;
  }

  // Setters
  public void setMake(String make) {
    this.vehicleMake = make;
  }
  public void setModel(String model) {
    this.vehicleModel = model;
  }
  public void setYear(int year) {
    this.vehicleYear = year;
  }

  public String toString() {
    return "Make: " + vehicleMake + "\nModel: " + vehicleModel + "\nYear: " + vehicleYear;
  }
}
