package live.leer.spring.demo4;

public class CarInfo {
	private String name;
	
	public String getName() {
		return "摩托车";
	}
	
	public Double calculatorPrice(){
		return Math.random() * 3000;
	}
	
}
