package myprep.dp.builder.solution1;

import myprep.dp.builder.solution1.House.HouseBuilder;

public class HouseMain {
	public static void main(String[] args) {
		House house1 = new HouseBuilder("KRHOME", "NELLORE").setArea(2400).setCost(100000.0).build();
		house1.printHouseDetails();

		House house2 = new HouseBuilder("KRHOME", "NELLORE").setArea(2400).build();
		house2.printHouseDetails();

	}
}
