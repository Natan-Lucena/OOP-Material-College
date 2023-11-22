class Equipe {
    private String nome;
    private int totalPontos;
    private int totalVitorias;
    private int saldoGols;
    private int golsPro;
    
    public Equipe(String nome, int totalPontos, int totalVitorias,int saldoGols, int golsPro){
        this.nome = nome;
        this.totalPontos = totalPontos;
        this.totalVitorias = totalVitorias;
        this.saldoGols = saldoGols;
        this.golsPro = golsPro;
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
