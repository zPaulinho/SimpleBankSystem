import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) throws Exception {

        boolean trabajando = false;
        String trabajo;
        boolean deuda1 = false;
        boolean deuda2 = false;
        boolean deuda3 = false;

        var account = new BankAccount();
        account.setMoney(100);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Que quieres hacer:");
            System.out.println("1: Ver tu saldo en el banco");
            System.out.println("2: Añadir dinero a tu cuenta bancaría");
            System.out.println("3: Entrar a un trabajo");
            System.out.println("4: Retirar dinero de tu cuenta bancaría");
            System.out.println("5: Pedir un préstamo");
            System.out.println("6: Pagar un préstamo");
            System.out.println("7: Salir");
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
                    System.out.println("Tienes 3 prestamos para escoger:");
                    System.out.println("Prestamo 1: 4500€, a pagar en 8 semanas + 3% de interés");
                    System.out.println("Prestamo 2: 10000€, a pagar en 15 semanas + 5% de interés");
                    System.out.println("Prestamo 3: 25000€, a pagar en 24 semanas + 8% de interés");
                    int loannumber = scanner.nextInt();
                    scanner.nextLine();

                    if (loannumber == 1) {
                        account.loan1();
                    } else if (loannumber == 2) {
                        account.loan2();
                    } else if (loannumber == 3) {
                        account.loan3();
                    } else {
                        System.out.println("Opción no valida");
                        break;
                    }
                    break;

                case 6:
                    System.out.println("Tienes 3 prestamos para escoger:");
                    System.out.println("Prestamo 1: Debes pagar 4500€");
                    System.out.println("Prestamo 2: Debes pagar 10000€");
                    System.out.println("Prestamo 3: Debes pagar 25000€");
                    int payloan = scanner.nextInt();
                    scanner.nextLine();

                    if (payloan == 1 && deuda1) {
                        account.payloan1();
                    } else if (payloan == 2 && deuda2) {
                        account.payloan2();
                    } else if (payloan == 3 && deuda3) {
                        account.payloan3();
                    } else {
                        System.out.println("No tienes ese préstamo o la opción no es válida");
                        break;
                    }
                    break;
                case 7:
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