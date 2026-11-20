package lista3.exercicio04;

// Lista 3 - Exercício 4: Soma de 1 até 100

public class Exercicio04 {
    public static void main(String[] args) {
        int soma = 0;

        for (int i = 1; i <= 100; i++) {
            soma += i;
        }

        System.out.println("Soma: " + soma);
    }
}
