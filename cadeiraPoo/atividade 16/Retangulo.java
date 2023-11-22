

import java.text.DecimalFormat;

public class Retangulo extends Shape{
	public Ponto2D p1;
	public Ponto2D p2;
	
	public Retangulo(Ponto2D p1, Ponto2D p2) {
		super("Rect");
		this.p1 = p1;
		this.p2 = p2;
	}
	

	@Override
	public double getArea() {
		double altura = Math.abs(p1.x - p2.x);
		double largura = Math.abs(p1.y - p2.y);
		
		return (largura * altura);
	}

	@Override
	public double getPerimeter() {
		double altura = Math.abs(p1.x - p2.x);
		double largura = Math.abs(p1.y - p2.y);
		
		return 2 * (altura + largura);
	}
	
	public String toString() {
    DecimalFormat d = new DecimalFormat("0.0");
    return "Retângulo com cantos (" + d.format(p1.x) + "," + d.format(p1.y) + ") e (" + d.format(p2.x) + "," + d.format(p2.y) + ")";
}

}