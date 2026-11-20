package lista1.exercicio09;

public class Main {
    public static void main(String[] args) {
        Pessoa avo = new Pessoa("Carlos");
        Pessoa avoMaterna = new Pessoa("Lucia");
        Pessoa pai = new Pessoa("José", avo, avoMaterna);
        Pessoa mae = new Pessoa("Maria");
        Pessoa ana = new Pessoa("Ana", pai, mae);
        Pessoa bia = new Pessoa("Bia", pai, mae);
        Pessoa leo = new Pessoa("Leo");

        System.out.println("Ana e Bia são irmãs? " + ana.saoIrmas(bia)); // true
        System.out.println("Ana e Leo são irmãos? " + ana.saoIrmas(leo)); // false
        System.out.println("Carlos é antecessor de Ana? " + ana.ehAntecessora(avo)); // true
        System.out.println("Leo é antecessor de Ana? " + ana.ehAntecessora(leo)); // false
        System.out.println("Ana equals Bia? " + ana.equals(bia)); // false
    }
}
