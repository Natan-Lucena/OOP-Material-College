import java.util.*;

class Lead {
	private float espessura;
	private String dureza;
	private int tamanho;
	
	public Lead(float espessura, String dureza, int tamanho) {
		super();
		this.espessura = espessura;
		this.dureza = dureza;
		this.tamanho = tamanho;
	}

	public float getEspessura() {
		return espessura;
	}

	public void setEspessura(float espessura) {
		this.espessura = espessura;
	}

	public String getDureza() {
		return dureza;
	}

	public void setDureza(String dureza) {
		this.dureza = dureza;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int usagePerSheet() {
		if("HB".equals(getDureza())) {
			return 1; 
		} else if("2B".equals(getDureza())) {
			return 2; 
		} else if("4B".equals(getDureza())) {
			return 4; 
		} else if("6B".equals(getDureza())) {
			return 6; 
		} else {
			return 0;	
		}
	}
	
	@Override
	public String toString() {
		return "[" 
				+ String.format("%.1f", espessura) 
				+ ":" + dureza 
				+ ":" + tamanho
				+ "]";
	}
}

class Pencil{
	private float espessura;
	private Lead tipo;
	
	public Pencil(float espessura) {
		super();
		this.espessura = espessura;
		this.tipo = null;
	}
	
	public float getEspessura() {
		return espessura;
	}

	public void setEspessura(float espessura) {
		this.espessura = espessura;
	}

	public Lead getTipo() {
		return tipo;
	}

	public void setTipo(Lead tipo) {
		this.tipo = tipo;
	}

	public boolean hasGrafite(){
		if(tipo != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void insert(Lead lead) {
		if(!hasGrafite()) {
			if(lead.getEspessura() == this.getEspessura()) {
				tipo = lead;
			} else {
				System.out.println("fail: calibre incompatível");
			}
		} else {
			System.out.println("fail: ja existe grafite");
		}
	}
	
	public void remove() {
		if(hasGrafite()) {
			setTipo(null);
		}
	}
	
	public void writePage() {
		if(hasGrafite()) {
			if(tipo.getTamanho() > 10) {
				if((tipo.getTamanho() -  tipo.usagePerSheet()) >= 10) {
					tipo.setTamanho(tipo.getTamanho() - tipo.usagePerSheet());
				} else {
				    tipo.setTamanho(10);
					System.out.println("fail: folha incompleta");
				}
			} else {
				System.out.println("warning: grafite com tamanho insuficiente para escrever");
			}
		} else {
			System.out.println("fail: nao existe grafite");
		}
		
	}

	@Override
	public String toString() {
		return "calibre: " + espessura
				+ ", grafite: " + tipo;
	}
}

public class Solver {
	public static void main(String[] args) {
		Pencil lap = new Pencil(0.5f);

		while (true) {
			String line = input();
			String[] argsL = line.split(" ");
			write('$' + line);

			if ("end".equals(argsL[0])) {
				break;
			} else if ("init".equals(argsL[0])) {
				lap = new Pencil(number(argsL[1]));
			} else if ("insert".equals(argsL[0])) {
				lap.insert(new Lead(number(argsL[1]), argsL[2], (int) number(argsL[3])));
			} else if ("remove".equals(argsL[0])) {
				lap.remove();
			} else if ("write".equals(argsL[0])) {
				lap.writePage();
			} else if ("show".equals(argsL[0])) {
				write(lap.toString());
			}
		}
	}

	static Scanner scanner = new Scanner(System.in);

	public static String input() {
		return scanner.nextLine();
	}

	public static void write(String value) {
		System.out.println(value);
	}

	public static float number(String str) {
		return Float.parseFloat(str);
	}
}