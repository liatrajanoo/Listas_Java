package lista1.exercicio09;

// Lista 1 - Exercício 9: Pessoa em uma árvore genealógica
public class Pessoa {

    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    // a) i) Nome, pai e mãe
    public Pessoa(String nome, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }

    // a) ii) Só o nome (antecessores null)
    public Pessoa(String nome) {
        this(nome, null, null);
    }

    public String getNome() {
        return nome;
    }

    public Pessoa getPai() {
        return pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    // b) Iguais se tiverem o mesmo nome e a mesma mãe
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pessoa)) return false;
        Pessoa outra = (Pessoa) obj;
        boolean mesmoNome = nome == null ? outra.nome == null : nome.equals(outra.nome);
        boolean mesmaMae = mae == null ? outra.mae == null : mae.equals(outra.mae);
        return mesmoNome && mesmaMae;
    }

    @Override
    public int hashCode() {
        return nome == null ? 0 : nome.hashCode();
    }

    // c) Irmãs: pessoas diferentes com o mesmo pai e a mesma mãe (ambos conhecidos)
    public boolean saoIrmas(Pessoa outra) {
        if (outra == null || this.equals(outra)) {
            return false;
        }
        return pai != null && mae != null && pai.equals(outra.pai) && mae.equals(outra.mae);
    }

    // d) A pessoa recebida é antecessora de quem recebeu a mensagem?
    public boolean ehAntecessora(Pessoa possivelAntecessora) {
        if (possivelAntecessora == null) {
            return false;
        }
        if (pai != null && (pai.equals(possivelAntecessora) || pai.ehAntecessora(possivelAntecessora))) {
            return true;
        }
        return mae != null && (mae.equals(possivelAntecessora) || mae.ehAntecessora(possivelAntecessora));
    }

    @Override
    public String toString() {
        return nome;
    }
}
