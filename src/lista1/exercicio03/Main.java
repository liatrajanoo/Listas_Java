package lista1.exercicio03;

public class Main {
    public static void main(String[] args) {
        NumeroComplexo z1 = new NumeroComplexo(3, 4);
        NumeroComplexo z2 = new NumeroComplexo(1, -2);

        System.out.println("z1 = " + z1);
        System.out.println("z2 = " + z2);
        System.out.println("soma = " + z1.somar(z2));
        System.out.println("subtração = " + z1.subtrair(z2));
        System.out.println("multiplicação = " + z1.multiplicar(z2));
        System.out.println("divisão = " + z1.dividir(z2));
        System.out.println("|z1| = " + z1.modulo()); // 5.0
        System.out.println("|6 - 8i| = " + new NumeroComplexo(6, -8).modulo()); // 10.0
    }
}
