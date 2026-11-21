public class BankAccount {

    private double money;
    private String Panadero;
    private String Repartidor;

    // Setter para añadirte dinero
    public void setMoney(double money){
        if (money >= 0) {
            this.money = money;
        } else {
            System.out.println("No se puede cantidad negativa");
        }
    }

    // Getter para saber el dinero
    public double getAccount(){
        return money;
    }

    public void addMoney(double cantidad){
        this.money = cantidad + money;
    }

    public void withdrawMoney(double cantidad){
        this.money = money - cantidad;
    }

}
