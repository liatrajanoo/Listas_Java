package lista1.exercicio08;

// Lista 1 - Exercício 7: Classe Pais
public class Pais {

    private static final int MAX_FRONTEIRAS = 40;

    private String codigoIso;
    private String nome;
    private long populacao;
    private double dimensao; // em km²
    private Pais[] vizinhos = new Pais[MAX_FRONTEIRAS];
    private int qtdVizinhos = 0;

    // a) Construtor com código ISO, nome e dimensão
    public Pais(String codigoIso, String nome, double dimensao) {
        this.codigoIso = codigoIso;
        this.nome = nome;
        this.dimensao = dimensao;
    }

    // b) Getters e setters
    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    // Adiciona um país vizinho (se ainda não existir e houver espaço)
    public boolean adicionarVizinho(Pais outro) {
        if (outro == null || this.equals(outro) || ehLimitrofe(outro) || qtdVizinhos >= MAX_FRONTEIRAS) {
            return false;
        }
        vizinhos[qtdVizinhos++] = outro;
        return true;
    }

    // c) Igualdade semântica: mesmo código ISO
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pais)) return false;
        Pais outro = (Pais) obj;
        return codigoIso != null && codigoIso.equals(outro.codigoIso);
    }

    @Override
    public int hashCode() {
        return codigoIso == null ? 0 : codigoIso.hashCode();
    }

    // d) Outro país é limítrofe?
    public boolean ehLimitrofe(Pais outro) {
        for (int i = 0; i < qtdVizinhos; i++) {
            if (vizinhos[i].equals(outro)) {
                return true;
            }
        }
        return false;
    }

    // e) Densidade populacional (hab/km²)
    public double densidadePopulacional() {
        return populacao / dimensao;
    }

    // f) Vizinhos comuns aos dois países
    public Pais[] vizinhosComuns(Pais outro) {
        Pais[] temp = new Pais[MAX_FRONTEIRAS];
        int qtd = 0;
        for (int i = 0; i < qtdVizinhos; i++) {
            if (outro.ehLimitrofe(vizinhos[i])) {
                temp[qtd++] = vizinhos[i];
            }
        }
        Pais[] resultado = new Pais[qtd];
        for (int i = 0; i < qtd; i++) {
            resultado[i] = temp[i];
        }
        return resultado;
    }

    @Override
    public String toString() {
        return nome + " (" + codigoIso + ")";
    }
}
