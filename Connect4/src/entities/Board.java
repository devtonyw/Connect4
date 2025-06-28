package entities;

import java.sql.SQLOutput;

public class Board {
    //Atributos
    private char[][] board;

    //Construtor
    public Board() {
        this.board = new char[6][7];
    }

    //Métodos
    //Inicia o Tabuleiro
    public void startBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                this.board[i][j] = ' '; //Preenche o Tabuleiro com espaços vazios
            }
        }
    }

    //Mostra o Tabuleiro
    public void showBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("| " + this.board[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    //Verifica Linhas para saber se o jogador atual venceu
    public boolean checkLines(char symbol) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == symbol) {
                    count++; //Inicia contador com o símbolo iniciado
                    if (count == 4) { //Caso ele identificar o símbolo 4 vezes ele verifica a vitória
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    //Verifica Colunas
    public boolean checkColumns(char symbol) {
        int count = 0;
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 6; i++) {
                if (board[i][j] == symbol) {
                    count++; //Inicia contador com o símbolo iniciado
                    if (count == 4) { //Caso ele identificar o símbolo 4 vezes ele verifica a vitória
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    //Verifica Diagonais Descendo
    public boolean checkDiagonalDescending(char symbol) {
        for (int i = 0; i <= 2; i++) {       // linhas até 2
            for (int j = 0; j <= 3; j++) {   // colunas até 3
                if (board[i][j] == symbol &&
                        board[i+1][j+1] == symbol &&
                        board[i+2][j+2] == symbol &&
                        board[i+3][j+3] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    //Verifica Diagonais Subindo
    public boolean checkDiagonalAscending(char symbol) {
        for (int i = 3; i < 6; i++) {            // linhas de 3 a 5
            for (int j = 0; j <= 3; j++) {   // colunas até 3
                if (board[i][j] == symbol &&
                        board[i-1][j+1] == symbol &&
                        board[i-2][j+2] == symbol &&
                        board[i-3][j+3] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    //Verifica posições vazias(empate)
    public boolean checkVoidPositions() {
        for (int j = 0; j < 7; j++) {
            if (board[0][j] == ' ') { //Se tiver lugares vazios ainda
                return true;
            }
        }
        return false;//Se não tiver lugares vazios
    }

    //Marcar Posição
    public boolean markPosition(int column, char symbol) {
        if (column < 0 || column >= 7){
            return false;
        }
        for(int i = 5; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = symbol;
                return true;
            }
        }
        return false;
    }

}
