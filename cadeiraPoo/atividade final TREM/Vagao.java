import java.util.Objects;

public class Vagao {
    Passageiro[] cadeiras;
    int maxPassageiros;

    public Vagao(int capacidade) {
        this.maxPassageiros = capacidade;
        this.cadeiras = new Passageiro[capacidade];
        for(int i = 0; i < maxPassageiros; i++){
            cadeiras[i] = new Passageiro(null);
        }
    }

    void embarcar(Passageiro pass){
        for (int i = 0; i < cadeiras.length; i++) {
            Passageiro p = cadeiras[i];
            if (p.getId() == null) {
                cadeiras[i] = pass;
                return;
            }
        }
    }

    void desembarcar(String idPass){
        for(int i = 0; i < maxPassageiros; i++){
            if(Objects.equals(cadeiras[i].getId(), idPass)){
                cadeiras[i] = new Passageiro(null);
            }
        }
    }

    boolean exists(String idPass){
        for(Passageiro passageiro : cadeiras){
            if(Objects.equals(passageiro.getId(), idPass)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for(Passageiro p: cadeiras){
            if(p.getId() == null) sb.append("- ");
            else sb.append(p).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

}