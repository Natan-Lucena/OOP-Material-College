import java.lang.Comparable;

class Equipe implements Comparable<Equipe> {
    private String nome;
    private int totalPontos;
    private int totalVitorias;
    private int saldoGols;
    private int golsPro;
    
    @Override
    public int compareTo(Equipe T){
        int comparaPontos = Integer.compare(T.getTotalPontos(), this.totalPontos);
        if(comparaPontos != 0){
            return comparaPontos;
        }
        int comparaVitorias = Integer.compare(T.getTotalVitorias(), this.totalVitorias);
        if(comparaVitorias != 0){
            return comparaVitorias;
        }
        int comparaSaldoGols = Integer.compare(T.getSaldoGols(), this.saldoGols);
        if(comparaSaldoGols != 0){
            return comparaSaldoGols;
        }
        int comparaGolsPro = Integer.compare(T.getGolsPro(), this.golsPro);
        if(comparaGolsPro != 0) {
            return comparaGolsPro;
        }else{
            return 0;
        }
    }
    public Equipe(String nome, int totalPontos, int totalVitorias,int saldoGols, int golsPro){
        this.nome = nome;
        this.totalPontos = totalPontos;
        this.totalVitorias = totalVitorias;
        this.saldoGols =  saldoGols;
        this.golsPro =  golsPro;
    }
    String getNome(){
        return this.nome;
    }
    int getTotalPontos(){
        return this.totalPontos;
    }
    int getTotalVitorias(){
        return this.totalVitorias;
    }
    int getSaldoGols(){
        return this.saldoGols;
    }
    int getGolsPro(){
        return this.golsPro;
    }
    public String toString(){
        String ts = "Equipe [nome="+getNome()+", totalPontos="+getTotalPontos()+", totalVitorias=" + getTotalVitorias()+", saldoGols="+getSaldoGols()+", golsPro="+getGolsPro()+"]";
        return ts;
    }
}
