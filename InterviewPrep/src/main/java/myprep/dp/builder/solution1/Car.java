package myprep.dp.builder.solution1;



public class Car {
	private String brand;
	private String model;
	private String color;
	private double price;

	// Private constructor to force the use of Builder
	private Car(Builder builder) {
		this.brand = builder.brand;
		this.model = builder.model;
		this.color = builder.color;
		this.price = builder.price;
	}

	// Static nested Builder class
	public static class Builder {
		private String brand;
		private String model;
		private String color;
		private double price;

		public Builder setBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public Builder setModel(String model) {
			this.model = model;
			return this;
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