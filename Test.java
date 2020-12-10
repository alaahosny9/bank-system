import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account a[] = new Account[2];
        Account obj = new Account();
        double arrBalance[] = new double[10];
        double amount;
        double monthlyRate = 0.0;
        int id; 
        int accountId;
        String answer2;
        boolean check, answer;
        double balance, annualInterestRate;
        int choice;
        System.out.println("Enter the data ");
        for (int i = 0; i < a.length; i++) {
            System.out.println("Enter the id between 1 and 10 of your account ");
            id = input.nextInt();
            System.out.println("Enter the balance between 1000$ and 20000$ of your account ");
            balance = input.nextDouble();
            a[i] = new Account(id, balance);
            a[i].setId(id);
            a[i].setBalance(balance);
            a[i].setAnnualInterestRate(4.5);
            a[i].getId();
            a[i].getBalance();
            a[i].getAnnualInterestRate();
            monthlyRate = a[i].getMonthlyInterestRate();
            a[i].getMonthlyInterest(monthlyRate);
        }
        do {

            System.out.println("1. Show the data ");
            System.out.println("2. withdraw ");
            System.out.println("3. deposit ");
            Account obj2 = null;

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    obj.showData(a, monthlyRate);
                    System.out.println("YOU WANT ANYTHING ELSE? ");
                    answer2 = input.next();
                    String s1 = new String(answer2);
                    check = s1.equalsIgnoreCase("yes");
                    if (check) {
                        answer = true;
                        break;
                    } else {
                        answer = false;
                        System.out.println("THANK YOU! ");
                        break;
                    }

                case 2:
                    obj2 = obj.search(a);
                    System.out.println("Enter the amount you want to withdraw ");
                    amount = input.nextDouble();
                    obj2.withdraw(amount);
                    System.out.println("Your data after withdraw ");
                    obj2.showData(a, monthlyRate);
                    System.out.println("YOU WANT ANYTHING ELSE? ");
                    answer2 = input.next();
                    String s2 = new String(answer2);
                    check = s2.equalsIgnoreCase("yes");
                    if (check) {
                        answer = true;
                        break;
                    } else {
                        answer = false;
                        System.out.println("THANK YOU! ");
                        break;
                    }

                case 3:
                    obj2 = obj.search(a);
                    System.out.println("Enter the amount you want to deposit ");
                    amount = input.nextDouble();
                    obj2.deposit(amount);
                    System.out.println("Your data after deposit ");
                    obj2.showData(a, monthlyRate);
                    System.out.println("YOU WANT ANYTHING ELSE? ");
                    answer2 = input.next();
                    String s3 = new String(answer2);
                    check = s3.equalsIgnoreCase("yes");
                    if (check) {
                        answer = true;
                        break;
                    } else {
                        answer = false;
                        System.out.println("THANK YOU! ");
                        break;
                    }

                default:
                    System.out.println("Invalid");
                    System.out.println("YOU WANT ANYTHING ELSE? ");
                    answer2 = input.next();
                    String s4 = new String(answer2);
                    check = s4.equalsIgnoreCase("yes");
                    if (check) {
                        answer = true;
                        break;
                    } else {
                        answer = false;
                        System.out.println("THANK YOU! ");
                        break;
                    }
            }


        }while (answer);
    }
}

class Account{
    private int id;
    private double balance;
    private static double annualInterestRate;

    Account(){
    }

    Account(int id , double balance){
        this.id = id;
        this.balance = balance;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public double getMonthlyInterestRate(){
        double rate = annualInterestRate / 100;
        double monthlyInterestRate = rate / 12;
        return monthlyInterestRate;
    }

    public double getMonthlyInterest(double monthlyRate){
        double monthlyInterest = balance * monthlyRate;
        return monthlyInterest;
    }
    public double withdraw(double amount){
        if (amount > balance){
            System.out.println("SORRY YOUR BALANCE IS INSUFFICIENT ");
        }else{
            balance = balance - amount;
        }
        return balance;
    }
    public double deposit(double amount){
        balance = balance + amount;
        return balance;
    }

    public void showData(Account arr [] , double monthlyRate){
        System.out.println("The Account data ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("================= Account " + (i+1) + " =================");
            System.out.println("ID : " + arr[i].getId());
            System.out.println("Balance : " + arr[i].getBalance());
            System.out.println("The Monthly Interest : " + arr[i].getMonthlyInterest(monthlyRate));
        }
    }


    public Account search(Account arr[]){
        int choice;
        Account a1 = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the account ");
        choice = input.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getId() == choice){
                a1 = arr[i];
                break;
            }
        }
        return a1;

    }


}
