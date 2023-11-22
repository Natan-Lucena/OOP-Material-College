public class Client {
    private int balance;
    private String codename;
    private int limite;
    
    public Client(String name, int limite){
        this.codename = name;
        this.limite = limite;
        this.balance = 0;
    }
    
    String getName(){
        return this.codename;
    }
    
    void spendBalance(int valor){
        this.balance += valor;
    }
    
    int getLimite(){
        return this.limite;
    }
    int getBalance(){
        return this.balance;
    }
    
    @Override
    public String toString(){
        return "- " + this.codename + ":" + this.balance + "/" + this.limite;
    }
}