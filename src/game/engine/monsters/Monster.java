package game.engine.monsters;

import game.engine.Role;

public abstract class Monster implements Comparable<Monster>{
    private final String name;
    private final String description;
    private Role role;
    private final Role originalRole;
    private int energy;
    private int position;
    private boolean frozen;
    private boolean shielded;
    private int confusionTurns;

    public Monster(String name, String description, Role originalRole, int energy){
        this.name = name;
        this.description = description;
        this.role = originalRole;
        this.originalRole = originalRole;
        this.energy = energy;
        this.position = 0;
        this.confusionTurns = 0;
        this.frozen = false;
        this.shielded = false;
    }
    public int compareTo(Monster o){
        return this.position - o.position;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public Role getRole(){
        return this.role;
    }
    public void setRole(Role role){
        this.role = role;
    }
    public Role getOriginalRole(){
        return this.originalRole;
    }
    public int getEnergy(){
        return this.energy;
    }
    public void setEnergy(int energy){
        if(energy<0){
            this.energy = 0;
        }
        else{
            this.energy = energy;
        }
    }
    public int getPosition(){
        return this.position;
    }
    public void setPosition(int position){
        if(position>99){
            this.position = 0;
            return;
        }
        if(position<0){
            this.position = 0;
            return;
        }
        else{
            this.position = position;
        }
    }
    public boolean isFrozen(){
        return this.frozen;
    }
    public boolean isShielded(){
        return this.shielded;
    }
    public int getConfusionTurns(){
        return this.confusionTurns;
    }
    public void setConfusionTurns(int confusionTurns){
        this.confusionTurns = confusionTurns;
    }

}
