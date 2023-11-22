

import java.text.DecimalFormat;

public class Circulo extends Shape{
	public Ponto2D center;
	public double radius;
	
	public Circulo(Ponto2D center, double radius) {
		super("Circ");
		this.center = center;
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return (Math.PI * Math.pow(radius, 2));
	}

	@Override
	public double getPerimeter() {
		return (Math.PI * radius * 2);
	}
	
	@Override
	public String toString() {
    DecimalFormat d = new DecimalFormat("0.0");
    return "Círculo com centro em (" + d.format(center.x) + "," + d.format(center.y) + ") e raio " + d.format(radius);
}

}