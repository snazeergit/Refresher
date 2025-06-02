package myprep.dp.builder.solution2;


/*
 * let’s enhance this with mandatory parameters in the Builder’s constructor, and optional ones with setters. 
 * This makes sure some important fields are always provided when building the object.
 */

public class Car {
	private String brand;
	private String model;
	private String color;
	private double price;

	// Private constructor
	private Car(Builder builder) {
		this.brand = builder.brand;
		this.model = builder.model;
		this.color = builder.color;
		this.price = builder.price;
	}

	// Static nested Builder class
	public static class Builder {
		// Mandatory fields
		private final String brand;
		private final String model;

		// Optional fields
		private String color;
		private double price;

		// Constructor with mandatory fields
		public Builder(String brand, String model) {
			this.brand = brand;
			this.model = model;
		}

		public Builder setColor(String color) {
			this.color = color;
			return this;
		}

		public Builder setPrice(double price) {
			this.price = price;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

	// Method to display car details
	public void displayDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Color: " + color);
		System.out.println("Price: $" + price);
	}
}
