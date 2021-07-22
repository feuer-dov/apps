package myapps.javastuff;

public class TestStuff {
    public static void main(String[] args) {

        int count = 0;
        do {
            int balance = 1000;
            int initBalance = balance;
            int amount = 100;

            String command = "Withdraw";

            switch (command) {
                case "Withdraw":
                    balance = balance - amount;
                    break;
                case "Deposit":
                    balance = balance + amount;
                    break;
            }

            System.out.println("Your balance used to be " + initBalance + " now it is " + balance);
            count++;
        } while (count < 5);
    }
}