package lista1.exercicio04;

// Lista 1 - Exercício 4: Reta y = ax + b
public class Reta {

    private static final double TOLERANCIA = 1e-9;

    private double a; // coeficiente angular
    private double b; // coeficiente linear

    // i) A partir dos coeficientes angular e linear
    public Reta(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // ii) A partir de dois pontos
    public Reta(Ponto2D p1, Ponto2D p2) {
        if (p1.getX() == p2.getX()) {
            throw new IllegalArgumentException("Reta vertical não pode ser escrita como y = ax + b");
        }
        this.a = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        this.b = p1.getY() - a * p1.getX();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    // c) Verifica se o ponto pertence à reta
    public boolean pertence(Ponto2D p) {
        return Math.abs(p.getY() - (a * p.getX() + b)) < TOLERANCIA;
    }

    // d) Representação "ax + b"
    @Override
    public String toString() {
        if (b < 0) {
            return a + "x - " + (-b);
        }
        return a + "x + " + b;
    }

    // e) Ponto de interseção, ou null se forem paralelas
    public Ponto2D intersecao(Reta outra) {
        if (Math.abs(a - outra.a) < TOLERANCIA) {
            return null;
        }
        double x = (outra.b - b) / (a - outra.a);
        double y = a * x + b;
        return new Ponto2D(x, y);
    }
}
