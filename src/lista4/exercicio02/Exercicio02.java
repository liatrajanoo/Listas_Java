package lista4.exercicio02;

// Lista 4 - Exercício 2: Soma dos elementos

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += sc.nextInt();
        }

        System.out.println(soma);
        sc.close();
    }
}
