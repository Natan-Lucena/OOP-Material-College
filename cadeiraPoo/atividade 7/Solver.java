import java.util.Scanner;
public class Solver {
    public static void main(String[] args){
        Agiota agiota =  new Agiota(0);
        Scanner sc = new Scanner( System.in );
        while(true){
            String line = sc.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("init")){
            agiota = new Agiota(Integer.parseInt(ui[1]));
            }
            else if(ui[0].equals("end")){
                break;
            }
            else if(ui[0].equals("addCli")){
                Client cliente =  new Client(ui[1], Integer.parseInt(ui[2]));
                agiota.addClient(cliente);
            }
            else if(ui[0].equals("lend")){
                agiota.emprestarDinheiro(ui[1],Integer.parseInt(ui[2]));
            }
            else if(ui[0].equals("show")){
                agiota.relatorio();
            }
            else if(ui[0].equals("receive")){
                agiota.receive(ui[1],Integer.parseInt(ui[2]));
            }
            else if(ui[0].equals("kill")){
                agiota.matar(ui[1]);
         }
       }
    }
}
