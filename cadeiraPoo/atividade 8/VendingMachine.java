public class VendingMachine {
    Slot[] slots;
    float profit;
    float cash;
    int capacity;

    VendingMachine(int capacity) {
        this.profit = 0;
        this.cash = 0;
        this.capacity = capacity;
        slots = new Slot[capacity];
        for (int i = 0; i < capacity; i++) {
            slots[i] = new Slot();
        }
    }

    Slot getSlot(int index) {
        return slots[index];
    }

    void setSlot(int index, Slot s) {
        slots[index] = s;
    }

    void clearSlot(int index) {
        slots[index] = new Slot();
    }

    void insertCash(float cash) {
        this.cash += cash;
    }

    float withdrawCash() {
        float temp = cash;
        cash = 0;
        return temp;
    }

    float getCash() {
        return cash;
    }

    float getProfit() {
        return profit;
    }

    void buyItem(int index) {
        if(slots[index].getQuantity() == 0){
            System.out.println("fail: espiral sem produtos");
        }
        else if(slots[index].getPrice() > getCash()){
            System.out.println("fail: saldo insuficiente");
        }
        else {
            System.out.println("voce comprou um "+slots[index].getName());
            slots[index].setQuantity(slots[index].getQuantity()-1);
            cash -= slots[index].getPrice();
            profit += slots[index].getPrice();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("saldo: ");
        sb.append(String.format("%.2f", getCash())).append('\n');
        for(int i = 0; i < capacity; i++){
            sb.append(i).append(" ").append(slots[i]).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}