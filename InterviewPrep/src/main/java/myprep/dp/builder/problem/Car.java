package myprep.dp.builder.problem;

import java.util.Objects;

/*
 * 📌 What is Builder Design Pattern?

The Builder Pattern is a creational design pattern that lets you construct complex objects step by step. 
It allows you to build different representations of an object using the same building process.

Use it when:
	•	You have a complex object with many optional parameters.
	•	You want to make your object creation readable and maintainable.
 * 
 * 
 * If we have a scenario where we wanted to pass only few properties to create an object then we are forced to write 
 * overloaded constructors as below and we have no choice, it makes the code mode complex and messy to avoid this we 
 * go for builder design pattern where we have capability to pass the properties only required to construct an object.
 * Lets say I need an obj only with brand and model properties, may be i need another obj only with price, like wise.
 * This was discussed in myprep.dp.builder.solution1 package.
 * We can make specific properties mandatory for every obj that is discussed in myprep.dp.builder.solution2 package
 * */

public class Car {

	private String brand;
	private String model;
	private String color;
	private Double price;

	// No-arg constructor
	public Car() {
	}

	// Constructor with all fields
	public Car(String brand, String model, String color, Double price) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.price = price;
	}

	// Constructor with brand and model
	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	// Constructor with brand, model, and color
	public Car(String brand, String model, String color) {
		this.brand = brand;
		this.model = model;
		this.color = color;
	}

	// Constructor with brand, model, and price
	public Car(String brand, String model, Double price) {
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	// Constructor with brand only
	public Car(String brand) {
		this.brand = brand;
	}

	/* Here constructor with String as a argument which takes model as an input is not allowed as 
	 * we already have the 1-string param Constructor which takes brand as an input
	 * so we can no have 1-string param constuctor in class and we can not use the existing 1-param string 
	 * constructor to read the model input as its already configured to read only brand.
	 * 
		// Constructor with model only
		public Car(String model) {
			this.model = model;
		}
	*/

	// Constructor with price only
	public Car(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", color=" + color + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, color, model, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(color, other.color)
				&& Objects.equals(model, other.model) && Objects.equals(price, other.price);
	}

}
