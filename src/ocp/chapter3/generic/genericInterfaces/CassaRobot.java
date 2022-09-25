package ocp.chapter3.generic.genericInterfaces;

public class CassaRobot implements Shippable<Robot>{

	@Override
	public void ship(Robot t) {
		System.out.println("CASSA SPEDIBILE");
	}
		
}
