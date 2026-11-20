package lista4.exercicio21;

import java.util.Scanner;

// Lista 4 - Exercício 21: Jogo da velha usando uma matriz 3x3
public class Exercicio21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] jogo = new char[3][3];

        // Inicializa o tabuleiro com posições vazias.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jogo[i][j] = '-';
            }
        }

        char jogador = 'X';
        boolean terminou = false;

        System.out.println("=== JOGO DA VELHA ===");
        System.out.println("Jogador 1: X | Jogador 2: O");
        System.out.println("Escolha linha e coluna de 1 a 3.");

        while (!terminou) {
            mostrarTabuleiro(jogo);
            System.out.println("Vez do jogador " + jogador);

            int linha = lerPosicao(sc, "Linha: ");
            int coluna = lerPosicao(sc, "Coluna: ");

            if (jogo[linha][coluna] != '-') {
                System.out.println("Essa posição já está ocupada. Escolha outra.");
                continue;
            }

            jogo[linha][coluna] = jogador;

            if (verificarVitoria(jogo, jogador)) {
                mostrarTabuleiro(jogo);
                System.out.println("Jogador " + jogador + " venceu!");
                terminou = true;
            } else if (tabuleiroCheio(jogo)) {
                mostrarTabuleiro(jogo);
                System.out.println("Empate! O tabuleiro está cheio.");
                terminou = true;
            } else {
                if (jogador == 'X') {
                    jogador = 'O';
                } else {
                    jogador = 'X';
                }
            }
        }

        sc.close();
    }

    // Lê uma posição válida e transforma de 1-3 para 0-2.
    public static int lerPosicao(Scanner sc, String mensagem) {
        int valor;

        while (true) {
            System.out.print(mensagem);

            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= 1 && valor <= 3) {
                    return valor - 1;
                }
            } else {
                sc.next();
            }

            System.out.println("Digite um número de 1 a 3.");
        }
    }

    // Mostra a matriz 3x3 na tela.
    public static void mostrarTabuleiro(char[][] jogo) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(jogo[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    // Verifica linhas, colunas e diagonais.
    public static boolean verificarVitoria(char[][] jogo, char jogador) {
        for (int i = 0; i < 3; i++) {
            if (jogo[i][0] == jogador && jogo[i][1] == jogador && jogo[i][2] == jogador) {
                return true;
            }

            if (jogo[0][i] == jogador && jogo[1][i] == jogador && jogo[2][i] == jogador) {
                return true;
            }
        }

        if (jogo[0][0] == jogador && jogo[1][1] == jogador && jogo[2][2] == jogador) {
            return true;
        }

        if (jogo[0][2] == jogador && jogo[1][1] == jogador && jogo[2][0] == jogador) {
            return true;
        }

        return false;
    }

    // Verifica se não restam posições vazias.
    public static boolean tabuleiroCheio(char[][] jogo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (jogo[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
