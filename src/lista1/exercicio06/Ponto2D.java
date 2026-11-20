package lista1.exercicio06;

// Lista 1 - Exercício 2: Classe Ponto2D
public class Ponto2D {

    private double x;
    private double y;

    // a) Construtores sobrecarregados
    public Ponto2D() {
        this(0, 0);
    }

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Ponto2D(Ponto2D outro) {
        this(outro.x, outro.y);
    }

    // b) Getters e setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // c) Métodos de movimentação sobrecarregados
    public void mover() {
        mover(0, 0);
    }

    public void mover(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void mover(Ponto2D destino) {
        mover(destino.x, destino.y);
    }

    // d) Comparação semântica
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ponto2D)) return false;
        Ponto2D outro = (Ponto2D) obj;
        return Double.compare(x, outro.x) == 0 && Double.compare(y, outro.y) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(x) + Double.hashCode(y);
    }

    // e) Representação como String
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Distância até outro ponto
    public double distancia(Ponto2D outro) {
        double dx = outro.x - x;
        double dy = outro.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // f) Clone: novo ponto no mesmo local
    @Override
    public Ponto2D clone() {
        return new Ponto2D(this);
    }
}
