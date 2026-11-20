package lista1.exercicio08;

public class Main {
    public static void main(String[] args) {
        Pais brasil = new Pais("BRA", "Brasil", 8515767.049);
        brasil.setPopulacao(193946886L);
        Pais argentina = new Pais("ARG", "Argentina", 2780400);
        argentina.setPopulacao(45000000L);
        Pais uruguai = new Pais("URY", "Uruguai", 176215);
        uruguai.setPopulacao(3400000L);

        Continente america = new Continente("América do Sul");
        america.adicionarPais(brasil);
        america.adicionarPais(argentina);
        america.adicionarPais(uruguai);

        System.out.println("Dimensão total: " + america.dimensaoTotal());
        System.out.println("População total: " + america.populacaoTotal());
        System.out.println("Densidade: " + america.densidadePopulacional());
        System.out.println("Maior população: " + america.maiorPopulacao());
        System.out.println("Menor população: " + america.menorPopulacao());
        System.out.println("Maior dimensão: " + america.maiorDimensao());
        System.out.println("Menor dimensão: " + america.menorDimensao());
        System.out.println("Razão territorial: " + america.razaoTerritorial());
    }
}
