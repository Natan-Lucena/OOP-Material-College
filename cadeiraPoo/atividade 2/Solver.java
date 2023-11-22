import java.util.Scanner;
import java.text.*;

class Car{
    public int pass; // Passageiros
    public int passMax; // limite de Passageiros
    public int gas; // tanque
    public int gasMax; // limite do tanque
    public int km; // quantidade de quilometragem
    
    public Car(){
        this.pass = 0;
        this.km = 0;
        this.gas = 0;
        this.gasMax = 100;
        this.passMax = 2;
    }
    public String toString(){
        String valor = "pass: " + this.pass + ", gas: " + this.gas + ", km: " + this.km;
        return valor;
    }
    public void enter(){
        if(this.pass == 2){
            System.out.println("fail: limite de pessoas atingido");
        }
        else{
            this.pass += 1;
        }
    }
    public void leave(){
        if(this.pass == 0){
            System.out.println("fail: nao ha ninguem no carro");
        }
        else{
            this.pass -= 1;
        }
    }
    public void fuel(int gas){
        if(this.gas + gas > 100){
            this.gas = 100;
        }else{
            this.gas += gas;
        }
    }
    public void drive (int km){
    if(this.pass == 0){
      System.out.println("fail: nao ha ninguem no carro");
      return;
    } 
    else if(this.gas == 0) {
      System.out.println("fail: tanque vazio");
      return;
    }
    else if(this.gas < km){
      System.out.println("fail: tanque vazio apos andar " + this.gas + " km");
      this.km += this.gas;
      this.gas = 0;
    }
    else {
      this.gas -= km;
      this.km += km;
    }
  }
};

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("enter")) {
                car.enter();
            } else if(ui[0].equals("leave")) {
                car.leave();
            } else if(ui[0].equals("show")) {
                System.out.println(car.toString());
            } else if (ui[0].equals("drive")) {//km
                car.drive(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("fuel")) {//gas
                car.fuel(Integer.parseInt(ui[1]));
            } else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}