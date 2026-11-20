package lista1.exercicio04;

public class Main {
    public static void main(String[] args) {
        Reta r = new Reta(2, 1); // y = 2x + 1
        Reta s = new Reta(new Ponto2D(0, 5), new Ponto2D(1, 4)); // y = -1x + 5

        System.out.println("r: " + r);
        System.out.println("s: " + s);
        System.out.println("(1,3) pertence a r? " + r.pertence(new Ponto2D(1, 3))); // true
        System.out.println("(0,0) pertence a r? " + r.pertence(new Ponto2D(0, 0))); // false
        System.out.println("Interseção r e s: " + r.intersecao(s));
        System.out.println("Interseção r e paralela: " + r.intersecao(new Reta(2, 7))); // null
    }
}
