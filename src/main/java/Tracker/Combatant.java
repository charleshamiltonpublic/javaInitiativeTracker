package Tracker;

/*
 * class: Combatant version: 2.3
 * date modified: 12/16/19
 * The purpose of this program is to provide an object that acts as a player
 * or monster with character stats implemented
 * Initiative Tracker.
 * created by: Charles Hamilton
 */
import java.util.Random;
public class Combatant implements Comparable {
    Random rando = new Random();
    int dex = 1;
    int dexMod = 1;
    int init = 1;
    int position = 1;
    String name = "";
    String type = "";
    @Override
     public boolean equals(Object o){
         if(o instanceof Combatant){
              Combatant p = (Combatant) o;
              return this.name.equals(p.getName());
         } else
              return false;
     }
    
    public Combatant (int newDex, String newName, String newType, int newInit) {
        dex = newDex;
        dexMod = (newDex-10)/2;
        name = newName;
        type = newType;
        init = newInit;
    }
    public Combatant (int newDex, String newName, String newType) {
        dex = newDex;
        dexMod = (newDex-10)/2;
        name = newName;
        type = newType;
        
    }
    @Override
    public int compareTo(Object comparestu) {
        int compareInit=((Combatant)comparestu).getInit();
        /* For Ascending order*/
        //return this.init-compareInit;

        /* For Descending order do like this */
        return compareInit-this.init;
    }
    public int roll() {
        dexMod = (dex - 10)/2;
        init = 1 + rando.nextInt(20) + dexMod;
        return init;
    }
    public boolean match(int newDex, String newName, String newType, int newInit) {
        if (newName.equals(name) &&
            newType.equals(type) &&
            newDex == dex &&
            newInit == init)
            return true;
        else
            return false;
    }
    public boolean match(int newDex, String newName, String newType) {
        if (newName.equals(name) &&
            newType.equals(type) &&
            newDex == dex)
            return true;
        else
            return false;
    }
    
    public int getInit() {
        return init;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setDex(int newDex) {
        dex = newDex;
        dexMod = (newDex - 10)/2;
    }
    
    public void setInit(int newInit) {
        init = newInit;
    }
    
    public int getDex() {
        return dex;
    }
    
    public int getPos() {
        return position;
    }
    
    public void setPos(int newPos) {
        position = newPos;
    }    
}
