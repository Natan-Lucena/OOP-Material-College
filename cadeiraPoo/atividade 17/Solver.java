import java.util.Scanner;
import java.util.Locale;


class Jogo{
    
    private int numJogadores;
    private int [] armadilha;
    private int [] posicao;
    private boolean [] podeJogar;
    private int numArmadilha = 0;
    private int numCasas;
    private int prox;
    private boolean fimDoJogo = false;
    
    public Jogo(int numJogadores, int numCasas){
        this.armadilha = new int[numCasas];
        this.posicao = new int[numJogadores];
        this.podeJogar = new boolean[numJogadores];
        
        this.numJogadores = numJogadores;
        this.numCasas =  numCasas;
        for(int i = 0; i < numJogadores; i++){
            this.posicao[i] = 0;
            this.podeJogar[i] = true;
        }
        
        this.prox = 0;
    }
    
    public void proximo(){
        if(this.prox == this.numJogadores - 1){
            this.prox = 0;
            return;
        }
        else{
            this.prox += 1;
        }
    }
    
    public void addArmadilha(int t){
        this.armadilha[this.numArmadilha] = t;
        this.numArmadilha += 1;
    }
    
    public void addMove(int d1, int d2){
        if(this.fimDoJogo == false){
            if(this.podeJogar[this.prox] == false){
                this.podeJogar[this.prox] = true;
                System.out.println("O jogador " + (this.prox + 1) + " passa a vez");
                proximo();
            }
            int casas = d1 + d2;
            this.posicao[this.prox] += casas;
            System.out.println("O jogador " + (this.prox + 1) + " vai para a casa " + this.posicao[this.prox]);
            if(this.posicao[this.prox] > numCasas){
                System.out.println("O jogador " + (this.prox + 1) + " venceu o jogo");
                this.fimDoJogo = true;
            }
            for(int i = 0; i < this.numArmadilha; i ++){
                if(this.posicao[this.prox] == this.armadilha[i]){
                    this.podeJogar[this.prox] = false;
                    System.out.println("O jogador " + (this.prox + 1) + " caiu em um armadilha");
                    proximo();
                    return;
                }
            }
            proximo();
        }
        else{
            System.out.println("O jogo acabou");
        }
    }
    public String toString(){
        String valor = "";
        for(int i = 0; i < this.numJogadores; i++){
            valor = valor + "PosJogador[" + (i + 1) + "] = " + this.posicao[i] + "\n";
        }
        return valor;
    }
    
}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault ( Locale.US ) ;
        Jogo jogo = new Jogo(0,0);

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("init")) {
                jogo = new Jogo( Integer.parseInt( ui[1]),  Integer.parseInt( ui[2]) );
            } else if(ui[0].equals("end")) {
                break; 
            } else if(ui[0].equals("addArmadilha")) {
                jogo.addArmadilha( Integer.parseInt( ui[1]) ); 
            } else if(ui[0].equals("addMove")) {
                int d1 = Integer.parseInt( ui[1]);
                int d2 = Integer.parseInt( ui[2]);
                jogo.addMove(d1, d2);
            } else if(ui[0].equals("show")) {
                System.out.println(jogo);
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}