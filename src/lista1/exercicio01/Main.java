package lista1.exercicio01;

public class Main {
    public static void main(String[] args) {
        Contador c = new Contador();
        c.incrementar();
        c.incrementar();
        c.incrementar();
        System.out.println("Valor: " + c.getValor()); // 3
        c.zerar();
        System.out.println("Depois de zerar: " + c.getValor()); // 0
    }
}
