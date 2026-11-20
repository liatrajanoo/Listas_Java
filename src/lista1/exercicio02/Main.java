package lista1.exercicio02;

public class Main {
    public static void main(String[] args) {
        Ponto2D origem = new Ponto2D();
        Ponto2D a = new Ponto2D(3, 4);
        Ponto2D b = a.clone();

        System.out.println("Origem: " + origem);
        System.out.println("A: " + a);
        System.out.println("Distância origem-A: " + origem.distancia(a)); // 5.0
        System.out.println("A equals B? " + a.equals(b)); // true
        b.mover(10, 10);
        System.out.println("B depois de mover: " + b);
        System.out.println("A equals B? " + a.equals(b)); // false
    }
}
