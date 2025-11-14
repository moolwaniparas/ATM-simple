import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pin = 1234;
        double balance = 5000;
        int attempts = 0;

        while (attempts < 3) {
            try {
                System.out.print("Enter PIN: ");
                int entered = Integer.parseInt(sc.nextLine());

                if (entered != pin) {
                    System.out.println("Wrong PIN");
                    attempts++;
                    continue;
                }

                boolean run = true;
                while (run) {
                    System.out.println("\n1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");
                    System.out.print("Choose: ");

                    int choice = Integer.parseInt(sc.nextLine());

                    try {
                        switch (choice) {
                            case 1:
                                System.out.println("Balance: " + balance);
                                break;

                            case 2:
                                System.out.print("Enter amount: ");
                                double d = Double.parseDouble(sc.nextLine());
                                if (d <= 0) throw new Exception("Invalid amount");
                                balance += d;
                                System.out.println("Deposited: " + d);
                                break;

                            case 3:
                                System.out.print("Enter amount: ");
                                double w = Double.parseDouble(sc.nextLine());
                                if (w <= 0) throw new Exception("Invalid amount");
                                if (w > balance) throw new Exception("Insufficient balance");
                                balance -= w;
                                System.out.println("Withdrawn: " + w);
                                break;

                            case 4:
                                run = false;
                                break;

                            default:
                                System.out.println("Invalid option");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                return;

            } catch (NumberFormatException e) {
                System.out.println("Enter numbers only.");
            }
        }

        System.out.println("Card Blocked.");
    }
}
