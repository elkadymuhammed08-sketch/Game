package game.engine.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import game.engine.Role;
import game.engine.cards.Card;
import game.engine.cards.ConfusionCard;
import game.engine.cards.EnergyStealCard;
import game.engine.cards.ShieldCard;
import game.engine.cards.StartOverCard;
import game.engine.cards.SwapperCard;
import game.engine.cells.Cell;
import game.engine.cells.ContaminationSock;
import game.engine.cells.ConveyorBelt;
import game.engine.cells.DoorCell;
import game.engine.monsters.Dasher;
import game.engine.monsters.Dynamo;
import game.engine.monsters.Monster;
import game.engine.monsters.MultiTasker;
import game.engine.monsters.Schemer;

public class DataLoader {
    private static final String CARDS_FILE_NAME = "cards.csv";
    private static final String CELLS_FILE_NAME = "cells.csv";
    private static final String MONSTERS_FILE_NAME = "monsters.csv";

    public static ArrayList<Card> readCards() throws IOException{
        ArrayList<Card> cards = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(CARDS_FILE_NAME));
        String line = "";
        while ((line = bufferedReader.readLine())!=null) { //readLine only returns one line per call
            String[] data = line.split(","); //no array length needed
            if(data[0].equals("SWAPPER")){
                Card swapperCard = new SwapperCard(data[1], data[2], Integer.parseInt(data[3]));
                cards.add(swapperCard);
            }
            if(data[0].equals("SHIELD")){
                Card shieldCard = new ShieldCard(data[1], data[2], Integer.parseInt(data[3]));
                cards.add(shieldCard);
            }
            if(data[0].equals("ENERGYSTEAL")){
                Card energyStealCard = new EnergyStealCard(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                cards.add(energyStealCard);
            }
            if(data[0].equals("STARTOVER")){
                Card startOverCard = new StartOverCard(data[1], data[2], Integer.parseInt(data[3]), Boolean.parseBoolean(data[4]));
                cards.add(startOverCard);
            }
            if(data[0].equals("CONFUSION")){
                Card confusionCard = new ConfusionCard(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                cards.add(confusionCard);
            }
        }
        bufferedReader.close();
        return cards;
    }
    public static ArrayList<Cell> readCells() throws IOException{
        ArrayList<Cell> cells = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(CELLS_FILE_NAME));
        String line = "";
        while((line = bufferedReader.readLine())!=null){
            String[] data = line.split(",");
            if(data.length==3){
                Cell doorCell = new DoorCell(data[0], Role.valueOf(data[1]), Integer.parseInt(data[2]));
                cells.add(doorCell);
            }
            else{
                if(Integer.parseInt(data[1])>0){
                    Cell conveyorBelt = new ConveyorBelt(data[0], Integer.parseInt(data[1]));
                    cells.add(conveyorBelt);
                }
                if(Integer.parseInt(data[1])<0){
                    Cell contaminationSock = new ContaminationSock(data[0], Integer.parseInt(data[1]));
                    cells.add(contaminationSock);
                }
            }
        }
        bufferedReader.close();
        return cells;
    }
    public static ArrayList<Monster> readMonsters() throws IOException{
        ArrayList<Monster> monsters = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(MONSTERS_FILE_NAME));
        String line = "";
        while((line = bufferedReader.readLine())!=null){
            String[] data = line.split(",");
            if(data[0].equals("DASHER")){
                Monster dasher = new Dasher(data[1], data[2], Role.valueOf(data[3]), Integer.parseInt(data[4]));
                monsters.add(dasher);
            }
            if(data[0].equals("DYNAMO")){
                Monster dynamo = new Dynamo(data[1], data[2], Role.valueOf(data[3]), Integer.parseInt(data[4]));
                monsters.add(dynamo);
            }
            if(data[0].equals("SCHEMER")){
                Monster schemer = new Schemer(data[1], data[2], Role.valueOf(data[3]), Integer.parseInt(data[4]));
                monsters.add(schemer);
            }
            if(data[0].equals("MULTITASKER")){
                Monster multiTasker = new MultiTasker(data[1], data[2], Role.valueOf(data[3]), Integer.parseInt(data[4]));
                monsters.add(multiTasker);
            }
        }
        bufferedReader.close();
        return monsters;
    }
}
