package game.engine;
import game.engine.monsters.Monster;
import game.engine.dataloader.DataLoader;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;


public class Game {
    private final Board board;
    private final ArrayList<Monster> allMonsters;
    private final Monster player;
    private final Monster opponent;
    private Monster current;

    public Game(Role playerRole) throws IOException{
        board = new Board(DataLoader.readCards());
        allMonsters = DataLoader.readMonsters();
        Role opponentRole = (playerRole==Role.SCARER)?Role.LAUGHER:Role.SCARER;
        this.opponent = selectRandomMonsterByRole(opponentRole);
        this.player = selectRandomMonsterByRole(playerRole);
        this.current = this.player;
        
        
    }


    private Monster selectRandomMonsterByRole(Role role){
        int size=allMonsters.size();
        ArrayList<Monster> selectedMonsters = new ArrayList<>();
        for(int i=0;i<size;i++){
            Monster currentMonster=allMonsters.get(i);
            if(currentMonster.getRole()==role){
                selectedMonsters.add(currentMonster);
            }
        }
        Random rand=new Random();
        return selectedMonsters.get(rand.nextInt(size));
    }

    public Board getBoard (){
        return board;
    }

    public ArrayList<Monster> getAllMonsters(){
        return allMonsters;
    }

    public Monster getPlayer(){
        return player;
    }

    public Monster getOpponent(){
        return opponent;
    }

    public Monster getCurrent(){
        return current;
    }

    public void setCurrent(Monster current){
        this.current=current;
    }
        
}
