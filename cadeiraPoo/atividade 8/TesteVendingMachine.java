import java.util.Locale;
import java.util.Scanner;

class TesteVendingMachine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        VendingMachine vm = new VendingMachine(0);
        while (true) {
            String line = sc.nextLine();
            System.out.println("$" + line);
            String[] param = line.split(" ");

            if (param[0].equals("end")) {
                break;
            }
            float cash;

            switch (param[0]) {
                case "init" : {
                    int capacity = Integer.parseInt(param[1]);
                    vm = new VendingMachine(capacity);
                    break;
                }
                case "show" : System.out.println(vm); break;
                case "set" : {
                    try {
                        int index = Integer.parseInt(param[1]);
                        String name = param[2];
                        int quantity = Integer.parseInt(param[3]);
                        float price = Float.parseFloat(param[4]);
                        vm.setSlot(index, new Slot(name, quantity, price));
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("fail: indice nao existe");
                        break;
                    }
                }
                case "limpar" : {
                    try {
                        int index = Integer.parseInt(param[1]);
                        vm.clearSlot(index);
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("fail: indice nao existe");
                        break;
                    }
                }
                case "dinheiro" : {
                    cash = Float.parseFloat(param[1]);
                    vm.insertCash(cash);
                    break;
                }
                case "troco" : {
                    cash = vm.withdrawCash();
                    System.out.printf("voce recebeu %.2f RS\n", cash);
                    break;
                }
                case "comprar" : {
                    try {
                        int index = Integer.parseInt(param[1]);
                        vm.buyItem(index);
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("fail: indice nao existe");
                        break;
                    }
                }
            }
        }
            sc.close();
    }
}