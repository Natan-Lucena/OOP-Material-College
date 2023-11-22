import java.util.Comparator;

class ComparaEquipe implements Comparator<Equipe> {
    public int compare(Equipe t1, Equipe t2) {
        int comparaPontos = Integer.compare(t1.getTotalPontos(), t2.getTotalPontos());
        if(comparaPontos != 0){
            return comparaPontos;
        }
        int comparaVitorias = Integer.compare(t1.getTotalVitorias(), t2.getTotalVitorias());
        if(comparaVitorias != 0){
            return comparaVitorias;
        }
        int comparaSaldoGols = Integer.compare(t1.getSaldoGols(), t2.getSaldoGols());
        if(comparaSaldoGols != 0){
            return comparaSaldoGols;
        }
        int comparaGolsPro = Integer.compare(t1.getGolsPro(), t2.getGolsPro());
        if(comparaGolsPro != 0) {
            return comparaGolsPro;
        }else{
            return 0;
        }
    }
}
