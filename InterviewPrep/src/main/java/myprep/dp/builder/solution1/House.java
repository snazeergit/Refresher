package myprep.dp.builder.solution1;

public class House {

	private Integer area;
	private String name;
	private Double cost;
	private String address;

	private House(HouseBuilder houseBuilder) {
		this.area = houseBuilder.area;
		this.name = houseBuilder.name;
		this.address = houseBuilder.address;
		this.cost = houseBuilder.cost;
	}

	public static class HouseBuilder {
		//Optional params while building obj
		private Integer area;
		private Double cost;
		//Mandatory param marked as final
		private final String name;
		private final String address;

		public HouseBuilder setArea(Integer area) {
			this.area = area;
			return this;
		}

		public HouseBuilder setCost(Double cost) {
			this.cost = cost;
			return this;
		}
		
		//Parameterized constructor for mandatory/final fields
		public HouseBuilder(String name, String address) {
			this.name = name;
			this.address = address;
		}

		public House build() {
			return new House(this);
		}
	}

	public void printHouseDetails() {
		System.out.println("Name: " + name);
		System.out.println("Area: " + area);
		System.out.println("Cost: " + cost);
		System.out.println("Address: " + address);
	}
}
