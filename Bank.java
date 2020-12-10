import java.util.Scanner;

public class Bank {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        bankAccount a1 = new bankAccount();
        System.out.println("     WELCOME TO OUR BANK SYSTEM!     ");
        System.out.println("PLEASE ENTER YOUR FIRST DEPOSIT BALANCE " + "\n");
        double first = input.nextDouble();
        a1.setAccountBalance(first);
        a1.getAccountBalance(a1.balance);
        int choice;
        String answer2;
        boolean answer = false;
        boolean check;

        do {

            System.out.println("Please choose the service you want ");
            System.out.println("1. WITHDRAW ");
            System.out.println("2. DEPOSIT ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("ENTER THE AMOUNT YOU WANT TO WITHDRAW ");
                    double amount = input.nextDouble();
                    a1.withdraw(amount);
                    System.out.println("YOU WANT ANYTHING ELSE? ");
                    answer2 = input.nextLine();
                    answer2 = input.nextLine();
                    String s1 = new String(answer2);
                    check = s1.equalsIgnoreCase("yes");
                    if(check){
                        answer = true;
                        break;
                    } else{
                        answer =false;
                        System.out.println("THANK YOU! ");
                        break;
                    }

                case 2:
                    System.out.println("ENTER THE AMOUNT YOU WANT TO DEPOSIT ");
                    amount = input.nextDouble();
                    a1.deposit(amount);
                    System.out.println("YOU WANT ANYTHING ELSE? ");
                    answer2 = input.nextLine();
                    answer2 = input.nextLine();
                    String s2 = new String(answer2);
                    check = s2.equalsIgnoreCase("yes");
                    if(check){
                        answer = true;
                        break;
                    } else{
                        answer =false;
                        System.out.println("THANK YOU! ");
                        break;
                    }
                default:
                    System.out.println("INVALID! ");
                    System.out.println("YOU WANT ANYTHING ELSE? ");
                    answer2 = input.nextLine();
                    answer2 = input.nextLine();
                    String s3 = new String(answer2);
                    check = s3.equalsIgnoreCase("yes");
                    if(check){
                        answer = true;
                        break;
                    } else{
                        answer =false;
                        System.out.println("THANK YOU! ");
                        break;
                    }
            }

        } while (answer);
    }
}

class bankAccount {
    private int accountNumber;
    private double accountBalance;
    double balance;
    private static double annualInterestRate;

    bankAccount() {
    }
        public void setAccountBalance ( double accountBalance){

        balance = accountBalance;
    }
        public void getAccountBalance ( double balance){
        System.out.println("Your Account Balance is " + balance + "\n");
    }
        public void withdraw (double amount){
        if (amount > balance){
            System.out.println("SORRY YOUR BALANCE IS INSUFFICIENT ");
        }
        else {
            balance = balance - amount;
            System.out.println("YOUR BALANCE AFTER WITHDRAW IS " + balance);
        }

    }
        public void deposit (double amount){
        balance = balance + amount;
        System.out.println("YOUR BALANCE AFTER DEPOSIT IS " + balance);
    }

}


