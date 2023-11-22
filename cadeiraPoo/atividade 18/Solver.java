import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
import java.text.DecimalFormat;


class MediaNotas{

    private ArrayList<Double> notas = new ArrayList<Double>();
    private DecimalFormat df = new DecimalFormat("#.00");

    public void addNota(double nota){
        this.notas.add(nota);
    }

    public void removeNota(int index){
        this.notas.remove(index);
    }

    public void mudaNota(int index, double valor){
        this.notas.set(index,valor);
    }

    public double maiorNota(){
        double maior = this.notas.get(0);
        for(int i = 0; i < this.notas.size(); i++){
            if(maior < this.notas.get(i)){
                maior = this.notas.get(i);
            }
        }
        return maior;
    }

    public double menorNota(){
        double menor = this.notas.get(0);
        for(int i = 0; i < this.notas.size(); i++){
            if(menor > this.notas.get(i)){
                menor = this.notas.get(i);
            }
        }
        return menor;
    }

    double media(){
        double media = 0;
        for(int i = 0; i < this.notas.size(); i++){
            media += this.notas.get(i);
        }
        media = media / this.notas.size();
        return media;
    }

    void parametriza(){
        double parametro = maiorNota();
        for(int i = 0; i < this.notas.size(); i++){
            this.notas.set(i ,(this.notas.get(i) / parametro) * 10 );
        }
    }

    public String toString(){
        String mensagem = "[";
        for(int i = 0; i < this.notas.size(); i++ ){
            String nota = this.df.format(this.notas.get(i));
            mensagem = mensagem + nota;
            if(i != this.notas.size() - 1){
                mensagem = mensagem + ",";
                mensagem = mensagem + " ";
            }
        }
        mensagem = mensagem + "]";
        return mensagem;
    }

    
    
    
}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaNotas m = new MediaNotas();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break; 
            } else if(ui[0].equals("addNota")) {
                m.addNota( Double.parseDouble( ui[1]) );
            } else if(ui[0].equals("removeNota")) {
                m.removeNota( Integer.parseInt( ui[1]) ); 
            } else if(ui[0].equals("maiorNota")) {
                System.out.println( m.maiorNota() );
            } else if(ui[0].equals("menorNota")) {
                System.out.println( m.menorNota() );
            } else if(ui[0].equals("media")) {
                System.out.printf( Locale.US, "%.2f\n",  m.media() );
            }else if(ui[0].equals("parametriza")) {
                m.parametriza(); 
            }else if(ui[0].equals("show")) {
                System.out.println( m );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
