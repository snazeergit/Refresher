package myprep.dp.builder.solution1;

public class CarMain {
	public static void main(String[] args) {
		Car car = new Car.Builder().setBrand("Tesla").setModel("Model S").setColor("Red").setPrice(79999.99).build();

		car.displayDetails();
	}
}

/* Why Builder Design Pattern
 * 	•	No overloaded constructors needed.
	•	You can selectively set the fields you want.
 */