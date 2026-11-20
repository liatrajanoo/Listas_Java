package lista1.exercicio01;

// Lista 1 - Exercício 1: Classe Contador
public class Contador {

    private int valor;

    public Contador() {
        this.valor = 0;
    }

    public void zerar() {
        valor = 0;
    }

    public void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}
