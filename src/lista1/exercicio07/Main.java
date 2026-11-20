package lista1.exercicio07;

public class Main {
    public static void main(String[] args) {
        Pais brasil = new Pais("BRA", "Brasil", 8515767.049);
        brasil.setPopulacao(193946886L);
        Pais argentina = new Pais("ARG", "Argentina", 2780400);
        Pais paraguai = new Pais("PRY", "Paraguai", 406752);
        Pais uruguai = new Pais("URY", "Uruguai", 176215);
        Pais bolivia = new Pais("BOL", "Bolívia", 1098581);

        brasil.adicionarVizinho(argentina);
        brasil.adicionarVizinho(paraguai);
        brasil.adicionarVizinho(uruguai);
        argentina.adicionarVizinho(paraguai);
        argentina.adicionarVizinho(uruguai);
        argentina.adicionarVizinho(bolivia);

        System.out.println("Densidade do Brasil: " + brasil.densidadePopulacional());
        System.out.println("Brasil faz fronteira com Argentina? " + brasil.ehLimitrofe(argentina));
        System.out.println("Brasil faz fronteira com Bolívia? " + brasil.ehLimitrofe(bolivia));
        System.out.println("Vizinhos comuns Brasil/Argentina:");
        for (Pais p : brasil.vizinhosComuns(argentina)) {
            System.out.println(" - " + p);
        }
    }
}
