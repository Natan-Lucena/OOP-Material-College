public class Transaction {
    private String codename;
    private int id;
    private int value;
    
    public Transaction(int id, int value, String name){
        this.id = id;
        this.value = value;
        this.codename = name;
    }
    int getId(){
        return this.id;
    }
    
    int getValue(){
        return this.value;
    }
    String getCodeName(){
        return this.codename;
    }
    
    @Override
    public String toString(){
        return "- id:" + this.id + " " + this.codename + ":" + this.value;
    }
}
