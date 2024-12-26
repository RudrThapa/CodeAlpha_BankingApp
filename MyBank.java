import java.util.Scanner;

public class MyBank {
    private static double balance = 0.0;   //Global Balance Variable, the balance is what the user has in their Bank Account
    private static Scanner sc = new Scanner(System.in);   //Global Scanner Object

    public static void main(String[] args) {
        System.out.println("Welcome to My Bank!");

        while (true) {

            //Shows the options to the User
            showMenu();

            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exitProgram();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
            }
        }
    }

    //Shows the Menu to the user
    private static void showMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

//Reads and validates the user's menu choice
    private static int getUserChoice() {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            System.out.println("Invalid input, Please enter a valid number.");
            sc.next();
            return -1;
        }
    }

    //Handles deposits from the user
    private static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double depositAmount = getValidAmount();
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("Successfully deposited Rs " + depositAmount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    //Handles withdrawals from the user's account
    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double withdrawAmount = getValidAmount();
        if (withdrawAmount > 0) {

            //If user has enough balance to withdraw
            if (withdrawAmount <= balance) {
                balance -= withdrawAmount;
                System.out.println("Successfully withdrew Rs " + withdrawAmount);
            } else {
                System.out.println("Insufficient balance, Your current balance is Rs " + balance);
            }
        } else {
            System.out.println("Withdrawal amount has to be positive.");
        }
    }

    //Displays the current Balance
    private static void checkBalance() {
        System.out.println("Your current balance is Rs " + balance);
    }

//Validates the entered amount to ensure it is a valid numeric value
    private static double getValidAmount() {
        while (true) {
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Invalid input.\nPlease enter a number: ");
                sc.next();
            }
        }
    }

    //Closes the Program
    private static void exitProgram() {
        System.out.println("Thank you for using the MyBank Application! Goodbye!");
        sc.close();
    }
}

