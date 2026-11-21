import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) throws Exception {

        var account = new BankAccount();
        account.setMoney(100);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Que quieres hacer:");
        System.out.println("1: Ver tu saldo en el banco");
        System.out.println("2: Añadir dinero a tu cuenta bancaría");
        System.out.println("3: Retirar dinero de tu cuenta bancaría");
        System.out.println("4: Salir");
        System.out.print("Introduce el numero de lo que quieres hacer: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Tu saldo en la cuenta es de: " + account.getAccount());
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;

            case 2:
                System.out.print("Cuanto dinero quieres añadir: ");
                double add = scanner.nextDouble();

                if (add < 0) {
                    System.out.println("No puedes añadir esa cantidad");
                } else {
                    account.addMoney(add);
                }

                System.out.println("Tu saldo en la cuenta despues de añadir dinero es de : " + account.getAccount());
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;

            case 3:
                System.out.print("Cuanto dinero quieres retirar: ");
                double withdraw = scanner.nextDouble();

                if (account.getAccount() < withdraw) {
                    System.out.println("No tienes suficiente saldo");
                } else {
                    account.withdrawMoney(withdraw);
                }

                System.out.println("Tu saldo en la cuenta despues de retirar dinero es de: " + account.getAccount());
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;

            case 4:
                System.out.println("Saliendo...");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
        }


    }
}
