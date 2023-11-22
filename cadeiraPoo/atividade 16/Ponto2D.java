

public class Ponto2D {
	public double x;
	public double y;
	
	public Ponto2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(Ponto2D p) {
		return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
	}
	
	@ Override
	public String toString() {
		return "";
	}
}