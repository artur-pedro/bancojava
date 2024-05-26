package application;

import java.util.Scanner;

public class leituraJava {
    public static Scanner input = new Scanner(System.in);
    
    public static int lerInteiro() {
        while (!input.hasNextInt()) {
            System.err.println("Valor inválido: " + input.next());
            System.out.println("Informe um inteiro:");
        }
        return input.nextInt();
    }

    public static float lerFloat() {
        while (!input.hasNextFloat()) {
            System.err.println("Valor inválido: " + input.next());
            System.out.println("Informe um número real:");
        }
        return input.nextFloat();
    }

    public static long lerLong() {
        while (!input.hasNextLong()) {
            System.err.println("Valor inválido: " + input.next());
            System.out.println("Informe um número longo:");
        }
        return input.nextLong();
    }

    public static String lerString() {
        return input.nextLine();
    }
}
