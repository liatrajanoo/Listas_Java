package lista1.exercicio06;

// Lista 1 - Exercício 6: Círculo no plano cartesiano
public class Circulo {

    private double raio;
    private Ponto2D centro;

    // a) Raio e centro
    public Circulo(double raio, Ponto2D centro) {
        this.raio = raio;
        this.centro = new Ponto2D(centro);
    }

    // b) Só o raio: centro na origem
    public Circulo(double raio) {
        this(raio, new Ponto2D());
    }

    // c) Acesso ao raio
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Ponto2D getCentro() {
        return centro.clone();
    }

    // d) inflar/desinflar com valor
    public void inflar(double valor) {
        raio += valor;
    }

    public void desinflar(double valor) {
        raio = Math.max(0, raio - valor);
    }

    // e) inflar/desinflar uma unidade
    public void inflar() {
        inflar(1);
    }

    public void desinflar() {
        desinflar(1);
    }

    // h) mover (sobrecarregado)
    public void mover() {
        centro.mover();
    }

    public void mover(double x, double y) {
        centro.mover(x, y);
    }

    public void mover(Ponto2D destino) {
        centro.mover(destino);
    }

    // f) Área = π · r²
    public double area() {
        return Math.PI * raio * raio;
    }

    @Override
    public String toString() {
        return "Círculo[raio=" + raio + ", centro=" + centro + "]";
    }
}
