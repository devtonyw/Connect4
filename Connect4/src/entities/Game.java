package entities;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    //Atributos
    private Board brd;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    //Construtor
    public Game() {
        this.brd = new Board();
        scanner = new Scanner(System.in);
        this.brd.startBoard();
    }

    //Métodos
    public void start(){
        System.out.println("\n-----SEJA BEM-VINDO AO CONNECT4-----");
        System.out.println("---Jogador 1---");
        this.player1 = createPlayer();
        System.out.println("---Jogador 2---");
        this.player2 = createPlayer();
        this.brd.showBoard();
        currentPlayer = player1;
        int position;
        boolean validPlay;

        while(true){

            do{
                position = currentPlayer.play();
                validPlay = this.brd.markPosition(position, currentPlayer.getSymbol());
            }while (!validPlay);

            this.brd.showBoard();

            if(checkWin(currentPlayer.getSymbol())){
                System.out.printf("\nJogador %s venceu!\n",currentPlayer.getName());
                break;
            }

            if(checkDraw()){
                System.out.println("\nEmpate!");
                break;
            }
            changePlayer();
        }
    }

    //Cria Jogador
    private Player createPlayer(){
        System.out.print("Digite nome do Jogador: ");
        String name = scanner.nextLine();
        System.out.print("Digite o símbolo: ");
        char symbol = scanner.next().charAt(0);
        scanner.nextLine();

        return new Player(name, symbol);
    }

    //Verifica Vitória de um dos jogadores
    private boolean checkWin(char symbol){
        boolean winLine = this.brd.checkLines(symbol);
        boolean winColumn = this.brd.checkColumns(symbol);
        boolean winDiagonalAscending = this.brd.checkDiagonalAscending(symbol);
        boolean winDiagonalDescending = this.brd.checkDiagonalDescending(symbol);

        if(winLine || winColumn || winDiagonalAscending || winDiagonalDescending){
            return true;
        }else{
            return false;
        }

    }

    //Verificar Empate
    private boolean checkDraw(){
        boolean hasVoidPosition = this.brd.checkVoidPositions();
        return !hasVoidPosition;
    }

    //Trocar Jogador
    private void changePlayer(){
        if(currentPlayer.equals(player1)) {
            currentPlayer = player2;
        }else {
            currentPlayer = player1;
        }
    }

}
