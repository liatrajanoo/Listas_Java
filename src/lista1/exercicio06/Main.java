package lista1.exercicio06;

public class Main {
    public static void main(String[] args) {
        Circulo c = new Circulo(2);
        System.out.println(c);
        System.out.println("Área: " + c.area());
        c.inflar();
        c.inflar(2.5);
        System.out.println("Depois de inflar: " + c);
        c.desinflar(1);
        c.mover(5, 7);
        System.out.println("Depois de desinflar e mover: " + c);
        c.mover();
        System.out.println("De volta à origem: " + c);
    }
}
