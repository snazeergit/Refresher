package myprep.dp.builder.solution2;

public class CarMain {
	public static void main(String[] args) {
		Car car = new Car.Builder("Tesla", "Model 3").setColor("Blue").setPrice(55999.99).build();

		car.displayDetails();
	}
}

/*
 * brand and model must be provided when creating the builder:
 * new Car.Builder("Tesla", "Model 3");
 * 
 * Other properties like color and price are optional and can be set via setter methods.
 * Cleaner and safer — you avoid creating incomplete objects without essential details.
 */