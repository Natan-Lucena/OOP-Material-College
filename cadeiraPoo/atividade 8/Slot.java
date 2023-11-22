public class Slot{
    String name;
    int quantity;
    float price;


    public Slot() {
        this.name = "empty";
        this.price = 0;
        this.quantity = 0;
    }


    public Slot(String name, int quantity, float price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public float getPrice() {
        return price;
    }


    public void setPrice(float price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while (name.length() + i < 8){
            sb.append(" ");
            i++;
        }
        sb.append(name).append(" : ").append(quantity).append(" U : ").append(String.format("%.2f", price));
        sb.append(" RS]");
        return sb.toString();
    }

}