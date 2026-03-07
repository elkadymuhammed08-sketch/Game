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

}
