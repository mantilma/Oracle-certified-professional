package ocp.chapter3.generic.genericClass;

public class Cat implements Animal{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "sono un gatto";
	}
	
	public void getVersoGatto() {
		System.out.println("MIAO");
	}

}
