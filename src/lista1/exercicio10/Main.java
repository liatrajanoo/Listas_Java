package lista1.exercicio10;

public class Main {
    public static void main(String[] args) {
        Conjunto a = new Conjunto();
        Conjunto b = new Conjunto();
        for (String s : new String[] {"a", "b", "c", "d", "e", "a"}) {
            a.adicionar(s);
        }
        for (String s : new String[] {"d", "e", "f", "g"}) {
            b.adicionar(s);
        }

        System.out.println("A = " + a + " (tamanho " + a.getTamanho() + ")");
        System.out.println("B = " + b);
        System.out.println("A contém 'c'? " + a.contem("c"));
        System.out.println("União: " + a.uniao(b));
        System.out.println("Interseção: " + a.inter(b));
        System.out.println("A menos B: " + a.menos(b));
    }
}
