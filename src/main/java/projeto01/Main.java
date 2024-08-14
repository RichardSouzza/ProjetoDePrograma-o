package projeto01;

import java.util.Scanner;
import projeto01.Account;
import projeto01.User;
import projeto01.Transaction;

public class Main {
    public static void checkBalance(Account account) {
        System.out.printf("Saldo: R$ %,.2f%n", account.getBalance());
    }

    public static void deposit(Account account, double value) {
        Transaction transaction = new Transaction("Depósito", "deposit", value);
        account.transactions.add(transaction);
        System.out.printf("%nDeposito de R$ %,.2f realizado.%n", value);
    }

    public static void withdraw(Account account, double value) {
        Transaction transaction = new Transaction("Saque", "withdraw", value * -1);
        account.transactions.add(transaction);
        System.out.printf("%nSaque de R$ %,.2f realizado.%n", value);
    }

    public static void exit() {
        System.exit(0);
    }

    private static void handleInput(User user, int operation) {
        Scanner scanner = new Scanner(System.in);
        if (operation == 1) {
            checkBalance(user.account);
        } else if (operation == 2) {
            System.out.print("Qual o valor do depósito? ");
            double value = scanner.nextDouble();
            deposit(user.account, value);
        } else if (operation == 3) {
            System.out.print("Qual o valor do saque? ");
            double value = scanner.nextDouble();
            if (value < 0) {
                System.out.println("O valor de saque não pode ser negativo.");
            } else if (value > user.account.getBalance()) {
                System.out.println("Saldo insuficiente.");
            } else {
                withdraw(user.account, value);
            }
        } else if (operation == 4) {
            exit();
        } else {
            System.out.println("Insira uma opção válida.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("corrente");
        User user = new User("Richard", account);

        System.out.printf("""
            ***********************
            Nome:
            Tipo conta: %s
            Saldo inicial: R$ %,.2f
            ***********************

            Operações:
            1- Consultar saldo
            2- Depositar
            3- Sacar
            4- Sair%n""", user.account.type, user.account.getBalance());

        while (true) {
            System.out.printf("%nDigite a opção desejada: ");
            int operation = scanner.nextInt();
            handleInput(user, operation);
        }
    }
}