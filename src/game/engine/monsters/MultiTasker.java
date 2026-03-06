package game.engine.monsters;

import game.engine.Role;

public class MultiTasker extends Monster{
    private int normalSpeedTurns;

    public MultiTasker(String name, String description, Role role, int energy){
        super(name, description, role, energy);
        this.normalSpeedTurns = 0;
    }
}
