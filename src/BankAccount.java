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

    public void loan1(){
        addMoney(4500);
        System.out.println("Se te ha añadido 4500€ a la cuenta, tienes que pagar este préstamo en 8 semanas, con un 3% de intereses");
    }

    public void loan2(){
        addMoney(10000);
        System.out.println("Se te ha añadido 10000€ a la cuenta, tienes que pagar este préstamo en 15 semanas, con un 5% de intereses");
    }

    public void loan3(){
        addMoney(25000);
        System.out.println("Se te ha añadido 25000€ a la cuenta, tienes que pagar este préstamo en 24 semanas, con un 8% de intereses");
    }

    public void payloan1(){
        withdrawMoney(4500);
        System.out.println("Has pagado los 4500 del préstamo 3, ahora te queda: \" + getAccount()");
    }

    public void payloan2(){
        withdrawMoney(10000);
        System.out.println("Has pagado los 10000 del préstamo 3, ahora te queda: " + getAccount());
    }

    public void payloan3(){
        withdrawMoney(25000);
        System.out.println("Has pagado los 25000€ del préstamo 3, ahora te queda: " + getAccount());
    }

}
