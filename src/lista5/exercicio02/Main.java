package lista5.exercicio02;

// Lista 5 - Exercício 2: Separando cálculo

public class Main {

    public static int somar(int a, int b) {
        return a + b;
    }

    public static void mostrarResultado(int resultado) {
        System.out.println("Resultado: " + resultado);
    }

    public static void main(String[] args) {
        int resultado = somar(10, 20);
        mostrarResultado(resultado);
    }
}
