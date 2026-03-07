package game.engine;
import game.engine.cards.Card;
import game.engine.monsters.Monster;
import game.engine.dataloader.DataLoader;
import game.engine.Role; // Assuming Role enum is in game.engine based on Section 3.1
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.util.Random;


public class Game {
    public static final Board board;
    public static final ArrayList<Monster> allMonsters;
    public static final Monster player;
    public static final Monster opponent;
    public static Monster current;

    public Game(Role playerRole) throws IOException{
        board =new Board(DataLoader.readCards());
        allMonsters=DataLoader.readMonsters();
        Role opponentRole=(player.Role==SCARER)?Role.LAUGHER:Role.SCARER;
        this.opponent=selectRandomMonsterByRole(opponentRole);
        this.current=this.player;
        
        
    }


    private Monster selectRandomMonsterByRole(Role role){
        int size=allMonsters.size();
        ArrayList<Monster> selectedMonsters
        for(int i=0;i<size;i++){
            Monster currentMonster=allMonsters.get(i);
            if(currentMonster.Role==role){
                selectedMonsters.add(currentMonster);
            }
        }
        Random rand=new Random();
        return selectedMonsters.get(rand.nextInt(size));
    }

    public static getBoard (){
        return board;
    }

    public static void getAllMonsters(){
        return allMonsters;
    }

    public static void getPlayer(){
        return player;
    }

    public static void getOpponent(){
        return opponent;
    }

    public static void getCurrent(){
        return current;
    }

    public static Monster setCurrent(Monster current){
        this.current=current;
    }
        
}
