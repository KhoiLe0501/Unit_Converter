
public class Unit {
	private String name;
	private String type;
	private double factor;
	
	public Unit(String name, String type, double factor) {
		this.name = name;
		this.type = type;
		this.factor = factor;
	}

	String getName() {return this.name;}
	String getType() {return this.type;}
	double getFactor() {return this.factor;}
	
	public String toString() {
		return "" + this.factor;}
	

// void convert() {}

}