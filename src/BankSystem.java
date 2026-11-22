import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) throws Exception {

        boolean trabajando = false;
        String trabajo;
        boolean loan1;
        boolean loan2;
        boolean loan3;

        var account = new BankAccount();
        account.setMoney(100);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Que quieres hacer:");
            System.out.println("1: Ver tu saldo en el banco");
            System.out.println("2: Añadir dinero a tu cuenta bancaría");
            System.out.println("3: Entrar a un trabajo");
            System.out.println("4: Retirar dinero de tu cuenta bancaría");
            System.out.println("5: Retirar dinero de tu cuenta bancaría");
            System.out.println("6: Salir");
            System.out.print("Introduce el numero de lo que quieres hacer: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Tu saldo en la cuenta es de: " + account.getAccount());
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 2:
                    System.out.print("Cuanto dinero quieres añadir: ");
                    double add = scanner.nextDouble();
                    scanner.nextLine();

                    if (add <= 0) {
                        System.out.println("No puedes añadir esa cantidad");
                    } else {
                        account.addMoney(add);
                    }

                    System.out.println("Tu saldo en la cuenta despues de añadir dinero es de : " + account.getAccount());
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 3:
                    System.out.println("Estos son los trabajos disponibles: ");
                    System.out.println("1: Panadero, 1350 al mes, 8h  ");
                    System.out.println("2: Repartidor de globo: 1000€ al mes y media jornada 12h ");
                    System.out.println("Elije el trabajo que mas te guste: ");

                    int job = scanner.nextInt();
                    scanner.nextLine();

                    if (trabajando) {
                        System.out.println("Ya tienes un trabajo");
                        break;
                    }

                    if (job == 1) {
                        account.addMoney(1300);
                        System.out.println("Tu trabajo ahora es Panadero ahora cobraras 1300€ al mes");
                        System.out.println("Se te ha dado un adelanto de tu primer mes");
                        System.out.println(account.getAccount());
                        trabajando = true;
                        trabajo = "panadero";
                        break;
                    } if (job == 2) {
                        account.addMoney(1000);
                        System.out.println("Tu trabajo ahora es Repartidor de glob ahora cobraras 1000€ al mes");
                        System.out.println("Se te ha dado un adelanto de tu primer mes");
                        System.out.println(account.getAccount());
                        trabajando = true;
                        trabajo = "repartidor";
                        break;
                    } else {
                        System.out.println("Trabajo no válido");
                        break;
                    }


                case 4:
                    System.out.print("Cuanto dinero quieres retirar: ");
                    double withdraw = scanner.nextDouble();
                    scanner.nextLine();

                    if (account.getAccount() < withdraw) {
                        System.out.println("No tienes suficiente saldo");
                    } else {
                        account.withdrawMoney(withdraw);
                    }

                    System.out.println("Tu saldo en la cuenta despues de retirar dinero es de: " + account.getAccount());
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 5:
                    System.out.println("Tienes 3 prestamos,");

                    break;
                case 6:
                    System.out.println("Saliendo...");
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
            // Esperar a Enter
            System.out.println("\n¿Quieres hacer otra operación? (S/N)");
            String sn = scanner.nextLine();
            if (sn.equalsIgnoreCase("s")){
                scanner.nextLine();
            } else{
                return;
            }

            // Clear después de cada pregunta
            System.out.print("\033[H\033[2J");
            System.out.flush();

        }
    }
}