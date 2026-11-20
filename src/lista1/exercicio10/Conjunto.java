package lista1.exercicio10;

// Lista 1 - Exercício 10: Conjunto de Strings (array que cresce por demanda)
public class Conjunto {

    private String[] elementos = new String[4];
    private int tamanho = 0;

    public int getTamanho() {
        return tamanho;
    }

    // a) Adicionar (não pode repetir)
    public boolean adicionar(String elemento) {
        if (elemento == null || contem(elemento)) {
            return false;
        }
        if (tamanho == elementos.length) {
            crescer();
        }
        elementos[tamanho++] = elemento;
        return true;
    }

    // Dobra a capacidade do array quando está cheio
    private void crescer() {
        String[] novo = new String[elementos.length * 2];
        for (int i = 0; i < tamanho; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    // b) Pertence ao conjunto?
    public boolean contem(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    // c) União
    public Conjunto uniao(Conjunto outro) {
        Conjunto resultado = new Conjunto();
        for (int i = 0; i < tamanho; i++) {
            resultado.adicionar(elementos[i]);
        }
        for (int i = 0; i < outro.tamanho; i++) {
            resultado.adicionar(outro.elementos[i]);
        }
        return resultado;
    }

    // d) Interseção
    public Conjunto inter(Conjunto outro) {
        Conjunto resultado = new Conjunto();
        for (int i = 0; i < tamanho; i++) {
            if (outro.contem(elementos[i])) {
                resultado.adicionar(elementos[i]);
            }
        }
        return resultado;
    }

    // e) Subtração (elementos daqui que não estão no outro)
    public Conjunto menos(Conjunto outro) {
        Conjunto resultado = new Conjunto();
        for (int i = 0; i < tamanho; i++) {
            if (!outro.contem(elementos[i])) {
                resultado.adicionar(elementos[i]);
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < tamanho; i++) {
            if (i > 0) sb.append(", ");
            sb.append(elementos[i]);
        }
        return sb.append("}").toString();
    }
}
