package entities;

import java.util.Objects;
import java.util.Scanner;

public class Player {
    //Atributos
    private String name;
    private char symbol;
    Scanner scanner;

    //Construtor
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        scanner = new Scanner(System.in);
    }

    //Métodos
    //Jogador faz jogada
    public int play(){
        int column;

        //Solicita Jogada
        while (true) {
            System.out.printf("\n%s, informa a coluna (1-7) para jogar: ", this.name);
            column = scanner.nextInt()-1;

            if(column < 7 && column >= 0){
                break;
            }else{
                System.out.println("\nColuna inválida, digite novamente.");
            }
        }

        return column;
    }

    //Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    //Métodos Hash(Gera um número que representa um objeto) e Equals(Compara objeto)
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return symbol == player.symbol && Objects.equals(name, player.name) && Objects.equals(scanner, player.scanner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol, scanner);
    }
}
