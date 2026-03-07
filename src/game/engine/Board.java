package game.engine;

import java.util.ArrayList;

import game.engine.cards.Card;
import game.engine.cells.Cell;
import game.engine.monsters.Monster;

public class Board {
    private final Cell[][] boardCells;
    private static ArrayList<Monster> stationedMonsters;
    private static final ArrayList<Card> originalCards = new ArrayList<>();
    private static ArrayList<Card> cards;

    public Board(ArrayList<Card> readCards){
        boardCells = new Cell[Constants.BOARD_ROWS][Constants.BOARD_COLS];
        stationedMonsters = new ArrayList<>();
        cards = new ArrayList<>();
        for(int i = 0; i<readCards.size(); i++){
            originalCards.add(i, readCards.get(i));
        }
    }

    public static cell[][] getBoardCells(){
        return boardcells;
    }

    public static ArrayList<Monster> getStationedMonsters(){
        return stationedMonsters;
    }

    public static ArrayList<Card> getOriginalCards(){
        return originalCards;
    }

    public static ArrayList<Card> getCards(){
        return cards;
    }

    public static void setStationedMonsters(ArrayList<Monster> newStationedMonsters){
        Board.stationedMonsters=newStationedMonsters;
    }

    public static void setCards(ArrayList<Card> newCards){
        Board.cards=newCards;
    }

}
