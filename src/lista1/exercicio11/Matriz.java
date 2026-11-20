package lista1.exercicio11;

// Lista 1 - Exercício 11: Classe Matriz
public class Matriz {

    private int linhas;
    private int colunas;
    private double[][] dados;

    // Construtor com as dimensões (começa com zeros)
    public Matriz(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("Dimensões devem ser positivas");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = new double[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    // Acesso a cada elemento (leitura/escrita)
    public double get(int i, int j) {
        return dados[i][j];
    }

    public void set(int i, int j, double valor) {
        dados[i][j] = valor;
    }

    private boolean ehQuadrada() {
        return linhas == colunas;
    }

    // a) Comparação semântica
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Matriz)) return false;
        Matriz o = (Matriz) obj;
        if (linhas != o.linhas || colunas != o.colunas) return false;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (Double.compare(dados[i][j], o.dados[i][j]) != 0) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(dados);
    }

    // b) Transposta
    public Matriz transposta() {
        Matriz t = new Matriz(colunas, linhas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                t.dados[j][i] = dados[i][j];
            }
        }
        return t;
    }

    // c) Oposta (sinais trocados)
    public Matriz oposta() {
        Matriz o = new Matriz(linhas, colunas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                o.dados[i][j] = -dados[i][j];
            }
        }
        return o;
    }

    // d) Matriz nula (mesmas dimensões, tudo zero)
    public Matriz nula() {
        return new Matriz(linhas, colunas);
    }

    // e) Identidade
    public boolean ehIdentidade() {
        if (!ehQuadrada()) return false;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                double esperado = (i == j) ? 1 : 0;
                if (dados[i][j] != esperado) return false;
            }
        }
        return true;
    }

    // f) Diagonal
    public boolean ehDiagonal() {
        if (!ehQuadrada()) return false;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i != j && dados[i][j] != 0) return false;
            }
        }
        return true;
    }

    // g) "Singular" (como definido na lista): diagonal com todos os elementos da diagonal iguais
    public boolean ehSingular() {
        if (!ehDiagonal()) return false;
        for (int i = 1; i < linhas; i++) {
            if (dados[i][i] != dados[0][0]) return false;
        }
        return true;
    }

    // h) Simétrica: igual à sua transposta
    public boolean ehSimetrica() {
        return ehQuadrada() && this.equals(transposta());
    }

    // i) Anti-simétrica: oposta igual à transposta
    public boolean ehAntiSimetrica() {
        return ehQuadrada() && oposta().equals(transposta());
    }

    // j) Adicionar (altera esta matriz)
    public void somar(Matriz outra) {
        verificarMesmaDimensao(outra);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] += outra.dados[i][j];
            }
        }
    }

    // k) Subtrair (altera esta matriz)
    public void subtrair(Matriz outra) {
        verificarMesmaDimensao(outra);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] -= outra.dados[i][j];
            }
        }
    }

    // l) Multiplicar (altera esta matriz; as dimensões passam a ser linhas x outra.colunas)
    public void multiplicar(Matriz outra) {
        if (colunas != outra.linhas) {
            throw new IllegalArgumentException("Colunas desta matriz devem ser iguais às linhas da outra");
        }
        double[][] resultado = new double[linhas][outra.colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < outra.colunas; j++) {
                for (int k = 0; k < colunas; k++) {
                    resultado[i][j] += dados[i][k] * outra.dados[k][j];
                }
            }
        }
        this.dados = resultado;
        this.colunas = outra.colunas;
    }

    // m) Cópia
    public Matriz copia() {
        Matriz c = new Matriz(linhas, colunas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                c.dados[i][j] = dados[i][j];
            }
        }
        return c;
    }

    private void verificarMesmaDimensao(Matriz outra) {
        if (linhas != outra.linhas || colunas != outra.colunas) {
            throw new IllegalArgumentException("As matrizes devem ter as mesmas dimensões");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                sb.append(dados[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
