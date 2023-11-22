import java.util.ArrayList;

public class Mercantil {
    
    private ArrayList<Pessoa> caixas = new ArrayList<>();
    private ArrayList<Pessoa> espera = new ArrayList<>();
   
    Mercantil(int qtdCaixas){
        for(int i = 0; i < qtdCaixas; i++) {
            this.caixas.add(null);
        }
    }

    public void chegar(Pessoa p){
       this.espera.add(p);
    }

    public boolean chamarNoCaixa(int indice){
        if(this.espera.size() >= indice && this.espera.size() != 0) {
           this.caixas.set(indice, this.espera.get(0));
            this.espera.remove(0);
            return true; 
        } else {
            System.out.println("fail: fila vazia");
            return false;
        }
        
    }

    public void finalizarAtendimento(int indice){
        this.caixas.set(indice, null);
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < this.caixas.size(); i++){
            if(i == 0) {
                result += "|0:";
                if(this.caixas.get(i) ==  null) {
                    result += "-----|";
                } else {
                    result += this.caixas.get(i).getNome() + "|";
                }
            } 
            
            if(i != 0 && i != this.caixas.size() - 1) {
                result += i + ":";
                if(this.caixas.get(i) ==  null) {
                    result += "-----|";
                } else {
                    result += this.caixas.get(i).getNome() + "|";
                }
            }
            
            if (i == this.caixas.size() - 1) {
                result += i + ":";
                if(this.caixas.get(i) ==  null) {
                    result += "-----|\n";
                } else {
                    result += this.caixas.get(i).getNome() + "|\n";
                }
            }
        }
        result += "Espera: [";
        for(int i = 0; i < this.espera.size(); i++) {
            if(i == this.espera.size() - 1) {
                result += this.espera.get(i).getNome();
            } else {
                result += this.espera.get(i).getNome() + ", ";
            }
        }
        result += "]";
        return result;
    }

}