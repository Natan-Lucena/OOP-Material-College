import java.util.Arrays;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trem trem = new Trem(0);

        label:
        while (true) {
            String line = sc.nextLine();
            System.out.println("$" + line);

            String[] input = line.split(" ");
            String cmd = input[0];
            String[] param = Arrays.copyOfRange(input, 1, input.length);
            switch (cmd) {
                case "init":
                    int maxVagoes = Integer.parseInt(param[0]);
                    trem = new Trem(maxVagoes);
                    break;
                case "nwvag":
                    int capacidade = Integer.parseInt(param[0]);
                    trem.add(new Vagao(capacidade));
                    break;
                case "la":
                    System.out.println(trem);
                    break;
                case "entrar":
                    trem.embarcar(new Passageiro(param[0]));
                    break;
                case "sair":
                    trem.desembarcar(param[0]);
                    break;
                case "cadastro":
                    trem.registro.getPassageiros().forEach(passageiro -> System.out.println(passageiro.getId()));
                    break;
                case "movimentacao":
                    trem.registro.getMovimentos().forEach(movimento -> System.out.println(movimento.toString()));
                    break;
                case "end":
                    break label;
            }
        }
            sc.close();
    }
}