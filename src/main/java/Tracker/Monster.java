package Tracker;

/*
 * class: Monster version: 2.3
 * date modified: 12/16/19
 * The purpose of this program is to provide a extended version of Combatant
 * for the specific Monster type of a Combatant (meaning this is an enemy 
 * controlled by the DM and its dice rolls are all automated unless otherwise
 * determined).
 * It is currently not in use.
 * created by: Charles Hamilton
 */
//import java.util.Random;
public class Monster {
//    Random rando = new Random();
    int dex = 1;
    int dexMod = 1;
    int init = 1;
    int position = 1;
    public String name = "";
    public String type = "";
    public Monster (int newDex, String newName, String newType) {
        dex = newDex;
        name = newName;
        type = newType;
    }
    public void setName(String newName) {
        name = newName;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public int getDex() {
        return dex;
    }
    
    
}
