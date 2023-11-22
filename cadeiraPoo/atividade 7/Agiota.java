import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;



public class Agiota {
    private int balance;
    private int nextTrid;
    Map<String,Client> repCli;
    Map<Integer, Transaction> repTr; 
    
    public Agiota(int balance){
        this.balance = balance;
        this.repCli = new HashMap<>();
        this.repTr = new HashMap<>();
        this.nextTrid = 0;
    }
    
    boolean clientExists(String name){
        Client clientAlreadyExists = this.repCli.get(name);
        if(clientAlreadyExists != null){
            return true;
    }
        return false;
    }
    
    void addClient(Client cliente){
        boolean clientAlreadyExists = clientExists(cliente.getName());
        if(!clientAlreadyExists){
            this.repCli.put(cliente.getName(),cliente);
            return;
        }
        System.out.println("fail: cliente ja existe");
    }
    
    Client getCliente(String nome){
        Client cliente = this.repCli.get(nome);
        return cliente;
    }
    
    void overrideClient(Client cliente, int valor){
        cliente.spendBalance(valor);
        this.repCli.put(cliente.getName(),cliente);
    }
    
    void emprestarDinheiro(String nome, int valor){
        boolean clientAlreadyExists = clientExists(nome);
        if(!clientAlreadyExists){
            System.out.println("fail: cliente nao existe");
            return;
        }
        Client cliente = getCliente(nome);
        if(cliente.getBalance() + valor > cliente.getLimite()){
            System.out.println("fail: limite excedido");
            return;
        }
        if(this.balance < valor){
            System.out.println("fail: fundos insuficientes");
            return;
        }
        overrideClient(cliente,valor);
        Transaction transacao = new Transaction(this.nextTrid,valor,nome);
        this.repTr.put(this.nextTrid,transacao);
        this.nextTrid += 1;
        this.balance -= valor;
    }
    
    void relatorio(){
        String retorno = "";
        retorno += "clients:\n";
        int contador = 0;
        for(Client cliente : repCli.values()){
            if(contador == 0){
                retorno += cliente.toString();
                contador = 1;
            }else{
                retorno += "\n" + cliente.toString();
            }
        }
        contador = 0;
        retorno += "\ntransactions:\n";
        for(Transaction transacao : repTr.values()){
            if(contador == 0){
                retorno += transacao.toString();
                contador = 1;
            }
            else {retorno += "\n" + transacao.toString();}
        }
        retorno += "\n" + "balance: " + this.balance;
        System.out.println(retorno);
    }
    
    void receive(String nome, int valor){
        Client cliente = getCliente(nome);
        if(cliente.getBalance() < valor){
            System.out.println("fail: valor maior que a divida");
            return;
        }
        overrideClient(cliente, valor *(-1));
        Transaction transacao = new Transaction(this.nextTrid,(-1) * valor,nome);
        this.repTr.put(this.nextTrid,transacao);
        this.nextTrid += 1;
        this.balance += valor;
    }
    
    
    void matar(String nome) {
    List<Client> clientsToRemove = new ArrayList<>();
    List<Transaction> transactionsToRemove = new ArrayList<>();

    
    for (Client cliente : repCli.values()) {
        if (cliente.getName().equals(nome)) {
            clientsToRemove.add(cliente);
        }
    }

    for (Transaction transacao : repTr.values()) {
        if (transacao.getCodeName().equals(nome)) {
            transactionsToRemove.add(transacao);
        }
    }

    
    for (Client cliente : clientsToRemove) {
        repCli.remove(cliente.getName());
    }

    for (Transaction transacao : transactionsToRemove) {
        repTr.remove(transacao.getId());
    }
}

    
    
}
