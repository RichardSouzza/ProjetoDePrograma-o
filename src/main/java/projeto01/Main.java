package projeto01;

import java.util.Scanner;

public class Main {
    public static void consultarSaldo() {
        System.out.println("Saldo: ");
    }

    public static void depositar() {
        System.out.println("Depositando...");
    }

    public static void sacar() {
        System.out.println("Sacando...");
    }

    public static void sair() {
        System.out.println("Saindo...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
            ***********************
            Nome:
            Tipo conta: Corrente
            Saldo inicial: R$ 2500,00
            ***********************

            Operações:
            1- Consultar saldo
            2- Depositar
            3- Sacar
            4- Sair

            Digite a opção desejada:""");
        while (1 == 1) {
            int operation = scanner.nextInt();
            if (operation == 1) {
                consultarSaldo();
            } else if (operation == 2) {
                depositar();
            } else if (operation == 3) {
                sacar();
            } else if (operation == 4) {
                sair();
            } else {
                System.out.println("Insira uma opção válida");
            }
        }
    }
}