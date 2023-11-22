import java.util.ArrayList;
import java.util.Objects;

class Movimento {
    Passageiro passageiro;
    Direcao dir;

    public Movimento(Passageiro passageiro, Direcao dir) {
        this.passageiro = passageiro;
        this.dir = dir;
    }

    public String toString() {
        return passageiro.id + " " + dir.value;
    }

}

class Registro {
    ArrayList<Passageiro> passageiros;
    ArrayList<Movimento> movimentos;

    public Registro() {
        this.passageiros = new ArrayList<>();
        this.movimentos = new ArrayList<>();
    }

    public void cadastrar(Passageiro p) {
        for(Passageiro passageiro : passageiros){
            if(Objects.equals(passageiro.id,p.id)){
                return;
            }
        }
        passageiros.add(p);
    }

    public void movimentar(String passId, Direcao dir) {
        if(!movimentos.contains(new Movimento(new Passageiro(passId),dir))){
            movimentos.add(new Movimento(new Passageiro(passId),dir));
        }
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    public ArrayList<Movimento> getMovimentos() {
        return movimentos;
    }

}

public class Trem {
    int maxVagoes;
    Vagao[] vagoes;
    int totalVagoes;

    Registro registro = new Registro();

    public Trem(int maxVagoes) {
        this.maxVagoes = maxVagoes;
        this.totalVagoes = 0;
        this.vagoes = new Vagao[maxVagoes];
    }

    public void add(Vagao vagao) {
        if(totalVagoes < maxVagoes){
            vagoes[totalVagoes] = vagao;
            totalVagoes++;
        }
        else{
            System.out.println("fail: limite de vagões atingido");
        }
    }

    public void embarcar(Passageiro pass) {
        registro.cadastrar(pass);
        if(this.exists(pass.getId())){
            System.out.println("fail: "+pass.getId()+" já está no trem");
            return;
        }
        for(Vagao vagao : vagoes){
            for(Passageiro p : vagao.cadeiras) {
                if(p.getId() == null){
                    vagao.embarcar(pass);
                    registro.movimentar(pass.getId(), Direcao.IN);
                    return;
                }
            }
        }
        System.out.println("fail: trem lotado");
    }

    public boolean exists(String idPass) {
        for(Vagao vagao : vagoes){
            if(vagao.exists(idPass)){
                return true;
            }
        }
        return false;
    }

    public void desembarcar(String idPass) {
        if(!this.exists(idPass)){
            System.out.println("fail: "+idPass+" nao esta no trem");
        }
        for(Vagao vagao : vagoes){
            if(vagao.exists(idPass)){
                vagao.desembarcar(idPass);
                registro.movimentar(idPass, Direcao.OUT);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Trem ");
        for(Vagao vagao : vagoes){
            if(vagao != null){
                sb.append(vagao);
            }
        }
        return sb.toString();
    }

}