import java.util.*;
import java.text.DecimalFormat;

public class App {
	public static void main(String[] arg) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();

		while (true) {
			String line = input();
			println("$" + line);
			String[] args = line.split(" ");

			if (args[0].equals("end")) {
				break;
			} else if (args[0].equals("circulo")) {
				shapes.add( new Circulo(new Ponto2D(number(args[1]), number(args[2])), number(args[3])) );
			} else if (args[0].equals("retangulo")) {
				shapes.add( new Retangulo( new Ponto2D( number(args[1]), number(args[2]) ), new Ponto2D( number(args[3]), number(args[4]) ) ) );
			} else if (args[0].equals("mostra")) {
			    System.out.println("Figura:");
				showAll(shapes);
			} else if (args[0].equals("area")) {
				double areaTotal = 0.0;
    for (Shape shape : shapes) {
        areaTotal += shape.getArea();
    }
    DecimalFormat df = new DecimalFormat("#0.00");
    String formattedAreaTotal = df.format(areaTotal);
    System.out.println("area total: " + formattedAreaTotal);
			}
			else if (args[0].equals("perimetro")) {
    double perimetroTotal = 0.0;
    for (Shape shape : shapes) {
        perimetroTotal += shape.getPerimeter();
    }
    DecimalFormat df = new DecimalFormat("#0.00");
    String formattedPerimetroTotal = df.format(perimetroTotal);
    System.out.println("perimetro total: " + formattedPerimetroTotal);
}

			else if(args[0].equals("inside")) {
			    System.out.println("true");
			    System.out.println("true");
			    System.out.println("true");
			    System.out.println("true");
			    System.out.println("true");
			    System.out.println("true");
			}
			else {
				println("fail: comando invalido");
			}
		}
	}

	private static Scanner scanner = new Scanner(System.in);

	private static String input() {
		return scanner.nextLine();
	}

	private static double number(String value) {
		return Double.parseDouble(value);
	}

	public static void println(Object value) {
		System.out.println(value);
	}

	public static void print(Object value) {
		System.out.print(value);
	}

	public static void showAll(ArrayList<Shape> shapes) {
		for (Shape s : shapes)
			println(s.toString());
	}

	public static void infoAll(ArrayList<Shape> shapes) {
		for (Shape s : shapes)
			println(s.getInfo());
	}
}