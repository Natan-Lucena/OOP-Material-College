

import java.text.DecimalFormat;

public abstract class Shape {
	public String name;
	
	public Shape(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean inside(Ponto2D point) {
		return false;
	}
	public abstract double getArea();
	public abstract double getPerimeter();
	
	public String getInfo() {
		DecimalFormat d = new DecimalFormat("#.##");
		// Circ: A=78.54 P=31.42
		// Rect: A=4.00 P=8.00
		return this.name + " A=" + d.format(getArea()) + " P=" + d.format(getPerimeter());
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}