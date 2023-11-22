import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Empresa{
    
    private List<Empregado> empregados;

    Empresa(){
        empregados = new ArrayList<>();
    }

    public void adicionaEmpregado(Empregado e){
        this.empregados.add(e);
    }

    public void mostraEmpregado(){
        System.out.println("Empresa: ");
         for (Empregado e : empregados) {
            System.out.println(e.toString());
         }
    }

    public double calculaFolha(){
        double totalFolha = 0.0;
        for (Empregado e : empregados) {
            totalFolha += e.pagamento();
        }
        return totalFolha;

        

    }



}