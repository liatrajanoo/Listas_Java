package lista1.exercicio11;

public class Main {
    public static void main(String[] args) {
        Matriz a = new Matriz(2, 2);
        a.set(0, 0, 1); a.set(0, 1, 2);
        a.set(1, 0, 3); a.set(1, 1, 4);

        Matriz id = new Matriz(2, 2);
        id.set(0, 0, 1);
        id.set(1, 1, 1);

        System.out.println("A:\n" + a);
        System.out.println("Transposta:\n" + a.transposta());
        System.out.println("Oposta:\n" + a.oposta());
        System.out.println("Identidade é identidade? " + id.ehIdentidade()); // true
        System.out.println("A é simétrica? " + a.ehSimetrica()); // false

        Matriz copia = a.copia();
        copia.somar(a);
        System.out.println("Cópia + A:\n" + copia);
        copia.multiplicar(id);
        System.out.println("(Cópia + A) x Identidade:\n" + copia);
    }
}
