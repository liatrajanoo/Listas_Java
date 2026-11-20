package lista1.exercicio08;

// Lista 1 - Exercício 8: Classe Continente
public class Continente {

    private static final int MAX_PAISES = 48;

    private String nome;
    private Pais[] paises = new Pais[MAX_PAISES];
    private int qtdPaises = 0;

    // a) Construtor
    public Continente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // b) Adicionar país
    public boolean adicionarPais(Pais pais) {
        if (pais == null || qtdPaises >= MAX_PAISES) {
            return false;
        }
        for (int i = 0; i < qtdPaises; i++) {
            if (paises[i].equals(pais)) {
                return false;
            }
        }
        paises[qtdPaises++] = pais;
        return true;
    }

    // c) Dimensão total
    public double dimensaoTotal() {
        double total = 0;
        for (int i = 0; i < qtdPaises; i++) {
            total += paises[i].getDimensao();
        }
        return total;
    }

    // d) População total
    public long populacaoTotal() {
        long total = 0;
        for (int i = 0; i < qtdPaises; i++) {
            total += paises[i].getPopulacao();
        }
        return total;
    }

    // e) Densidade populacional
    public double densidadePopulacional() {
        return populacaoTotal() / dimensaoTotal();
    }

    // f) País com maior população
    public Pais maiorPopulacao() {
        Pais maior = null;
        for (int i = 0; i < qtdPaises; i++) {
            if (maior == null || paises[i].getPopulacao() > maior.getPopulacao()) {
                maior = paises[i];
            }
        }
        return maior;
    }

    // g) País com menor população
    public Pais menorPopulacao() {
        Pais menor = null;
        for (int i = 0; i < qtdPaises; i++) {
            if (menor == null || paises[i].getPopulacao() < menor.getPopulacao()) {
                menor = paises[i];
            }
        }
        return menor;
    }

    // h) País de maior dimensão
    public Pais maiorDimensao() {
        Pais maior = null;
        for (int i = 0; i < qtdPaises; i++) {
            if (maior == null || paises[i].getDimensao() > maior.getDimensao()) {
                maior = paises[i];
            }
        }
        return maior;
    }

    // i) País de menor dimensão
    public Pais menorDimensao() {
        Pais menor = null;
        for (int i = 0; i < qtdPaises; i++) {
            if (menor == null || paises[i].getDimensao() < menor.getDimensao()) {
                menor = paises[i];
            }
        }
        return menor;
    }

    // j) Razão territorial: maior país / menor país
    public double razaoTerritorial() {
        return maiorDimensao().getDimensao() / menorDimensao().getDimensao();
    }
}
