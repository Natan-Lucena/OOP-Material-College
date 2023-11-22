import java.util.*;

class Person{
	private int age;
	private String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}
}

class Motorcycle{
	private Person person;
	private int power;
	private int time;
	
	public Motorcycle(int power) {
		this.person = null;
		this.power = power;
		this.time = 0;
	}
	
	// Getters e Setters
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	// Methods
	public void insertPerson(int age, String nome){
		if(person == null) person = new Person(age, nome);
		else System.out.println("fail: busy motorcycle");
	}
	
	public void removePerson() {
		if(person != null) person = null;
		else System.out.println("fail: empty motorcycle");
	}
	
	public void buyTime(int time) {
		setTime(getTime() + time);
	}
	
	public void drive(int time) {
		if(getTime() > 0) {		// Se tiver tempo
			if(person != null) {	// Se tiver uma pessoa
				if(person.getAge() <= 10 ) {	// Se a pessoa for menor de 10 anos
					if(getTime() - time >= 0) {		// Se o tempo for suficiente
						setTime(getTime() - time);
					} else {
						System.out.println("fail: time finished after " + (time - getTime()) + " minutes");
						setTime(0);
					}
				} else {
					System.out.println("fail: too old to drive");
				}
			} else {
				System.out.println("fail: empty motorcycle");
			}
		} else {
			System.out.println("fail: buy time first");
		}
	}
	
	public void honk() {
		System.out.print("P");
		for(int i = 0; i < power; i++) {
			System.out.print("e");
		}
		System.out.println("m");
	}

	@Override
	public String toString() {
		if(person != null) {
			return "power:" + power
					+ ", time:" + time
					+ ", person:(" + person + ")";
		} else {
			return "power:" + power
					+ ", time:" + time
					+ ", person:(empty)";
		}
	}
	
	
}


public class Solver {
	static Motorcycle motoca = new Motorcycle(1);

	public static void main(String[] args) {
		while (true) {
			String line = input();
			args = line.split(" ");
			write('$' + line);

			if (args[0].equals("show")) {
				System.out.println(motoca);
			} else if (args[0].equals("init")) {
				motoca = new Motorcycle(number(args[1]));
			} else if (args[0].equals("buy")) {
				motoca.buyTime(number(args[1]));
			} else if (args[0].equals("drive")) {
				motoca.drive(number(args[1]));
			} else if (args[0].equals("enter")) {
				motoca.insertPerson(number(args[2]), args[1]);
			} else if (args[0].equals("honk")) {
				motoca.honk();
			} else if (args[0].equals("leave")) {
				if (motoca.getPerson() != null) {
					System.out.println(motoca.getPerson());
				}
				motoca.removePerson();
			} else if (args[0].equals("end")) {
				break;
			} else
				System.out.println("fail: comando invalido");
		}
	}

	static Scanner scanner = new Scanner(System.in);

	public static String input() {
		return scanner.nextLine();
	}

	public static void write(String value) {
		System.out.println(value);
	}

	public static int number(String str) {
		return Integer.parseInt(str);
	}
}