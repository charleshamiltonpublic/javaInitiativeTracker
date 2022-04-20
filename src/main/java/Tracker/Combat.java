package Tracker;

/*
 * class: Combat version: 2.3
 * date modified: 12/16/19
 * The purpose of this program is to run most of the logic required to sort the
 * various combatants by initiative.
 * created by: Charles Hamilton
 */
import java.util.*;
import java.io.*;
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
// An AWT program inherits from the top-level container java.awt.Frame
public class Combat {
    static String filePath = "";
    static String charFile = "";
    static String monFile = "";
    static String comFile = "";
    
    static String charFileStore = "";
    static String monFileStore = "";
    static String comFileStore = "";
    static String outputLine = "";

    static int total = 0;
    static int monTotal = 0;
    static int charTotal = 0;
    String fighterName = "";
    String fighterType = "";
    String fighterDex = "";
    String fighterInit = "";
    public Combat (String newFilePath) {
        filePath = newFilePath;
    }
    public void setFilePath( String filer ) {
        filePath = filer;
    }
//    public ArrayList<Combatant> myCombatant()    {
//        return(dice2);
//    }
//    public ArrayList<Combatant> myMonster()    {
//        return(monDice2);
//    }
//    public ArrayList<Combatant> myCharacter()    {
//        return(charDice2);
//    }
    public int getTotal() {
        return(total);
    }
    public int countTotal (String comFile, String charFile, String monFile) {
        //Count the line numbers in the file
        int total = 0;
        int monTotal = 0;
        int charTotal = 0;
        try {
        FileInputStream stream = new FileInputStream(comFile);
        byte[] buffer = new byte[8192];
        int count = 0;
        int n;
        while ((n = stream.read(buffer)) > 0) {
            for (int i = 0; i < n; i++) {
                if (buffer[i] == '\n') count++;
         }
        }
        if (count % 4 == 0 && count > 0)
            total = count/4;
        stream.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
//Count the line numbers in the monster file
        try {
        FileInputStream stream = new FileInputStream(monFile);
        byte[] buffer = new byte[8192];
        int count = 0;
        int n;
        while ((n = stream.read(buffer)) > 0) {
            for (int i = 0; i < n; i++) {
                if (buffer[i] == '\n') count++;
         }
        }
        if (count % 4 == 0 && count > 0)
            monTotal = count/4;
        stream.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
//Count the line numbers in the character file
    try {
        FileInputStream stream = new FileInputStream(charFile);
        byte[] buffer = new byte[8192];
        int count = 0;
        int n;
        while ((n = stream.read(buffer)) > 0) {
            for (int i = 0; i < n; i++) {
                if (buffer[i] == '\n') count++;
         }
        }
        if (count % 4 == 0 && count > 0)
            charTotal = count/4;
        stream.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    return total;
    }
    public int newCharacter(String newDex, String newName, String newType, String newRoll) {
            
//new Character Checker and Writer
        try {
            comFile = filePath + "/Combatants.txt";
            monFile = filePath + "/Monster.txt";
            charFile = filePath + "/Characters.txt";
            comFileStore = filePath + "/CombatantsTemp.txt";
            charFileStore = filePath + "/MonsterTemp.txt";
            monFileStore = filePath + "/CharactersTemp.txt"; 
            total = 0;
            monTotal = 0;
            charTotal = 0;
            BufferedWriter p = new BufferedWriter(new FileWriter(comFile, true));
            BufferedWriter c = new BufferedWriter(new FileWriter(charFile, true));
            BufferedWriter m = new BufferedWriter(new FileWriter(monFile, true));
            BufferedWriter pt = new BufferedWriter(new FileWriter(comFileStore, true));
            BufferedWriter ct = new BufferedWriter(new FileWriter(charFileStore, true));
            BufferedWriter mt = new BufferedWriter(new FileWriter(monFileStore, true));
//                    phName = newName;
//                    fighterName = phName;
                    fighterName = newName;
                    
//                    phDexString = newDex;
//                    fighterDex = phDexString;
                    fighterDex = newDex;
                    
//                    phType = newType;
//                    fighterType = phType;
                    fighterType = newType;
                    
                    if (fighterType.equals("character") && ! newRoll.equals("")) {
//                        phInitString = newRoll;
//                        fighterInit = phInitString;
                        fighterInit = newRoll;
                    }
                    else {
                        Combatant ph = new Combatant(Integer.parseInt(newDex), newName, newType);
                        fighterInit = Integer.toString(ph.roll());
                        }
                    if (fighterType.equals("character")) {
                        c.write(fighterDex);
                        c.newLine();
                        c.write(fighterName);
                        c.newLine();
                        c.write(fighterType);
                        c.newLine();
                        c.write(fighterInit);
                        c.newLine();
                        
                        ct.write(fighterDex);
                        ct.newLine();
                        ct.write(fighterName);
                        ct.newLine();
                        ct.write(fighterType);
                        ct.newLine();
                        ct.write(fighterInit);
                        ct.newLine();
                        
                        charTotal++;
                    }
                    else if (fighterType.equals("monster")) {
                        m.write(fighterDex);
                        m.newLine();
                        m.write(fighterName);
                        m.newLine();
                        m.write(fighterType);
                        m.newLine();
                        
                        mt.write(fighterDex);
                        mt.newLine();
                        mt.write(fighterName);
                        mt.newLine();
                        mt.write(fighterType);
                        mt.newLine();
                        mt.write(fighterInit);
                        mt.newLine();
                        monTotal++;
                    }
                    p.write(fighterDex);
                    p.newLine();
                    p.write(fighterName);
                    p.newLine();
                    p.write(fighterType);
                    p.newLine();
                    
                    pt.write(fighterDex);
                    pt.newLine();
                    pt.write(fighterName);
                    pt.newLine();
                    pt.write(fighterType);
                    pt.newLine();
                    pt.write(fighterInit);
                    pt.newLine();
                    
                    total++;
                    p.close();
                    c.close();
                    m.close();
                    pt.close();
                    ct.close();
                    mt.close();
            
        } catch (IOException e) {
            System.out.print("Exception");
        }
        return Integer.parseInt(fighterInit);
    }
    
    //public static void main (String args[]) {
    public ArrayList<Combatant> myCombatant(int initialized) {
            //throws ClassNotFoundException {
        //Class.forName("Combatant");
        ArrayList<Combatant> stored = new ArrayList<Combatant>();
        //ArrayList for storing all entered combatants with dex, name, and type
        ArrayList<Combatant> dice1 = new ArrayList<Combatant>();
        //ArrayList for storing all entered combatants with randomly generated init
        ArrayList<Combatant> dice2 = new ArrayList<Combatant>();
        //ArrayList for storing all entered monsters with dex, name, and type
        ArrayList<Combatant> monDice1 = new ArrayList<Combatant>();
        //ArrayList for storing all entered monsters with randomly generated init
        ArrayList<Combatant> monDice2 = new ArrayList<Combatant>();
        //ArrayList for storing all entered characters with dex, name, init, and type
        ArrayList<Combatant> charDice1 = new ArrayList<Combatant>();
        //ArrayList for storing all sorted entered characters
        ArrayList<Combatant> charDice2 = new ArrayList<Combatant>();

        int phDex = 1;
        int phInit = 1;
        String phDexString = "";
        String phInitString = "";
        String phName = "";
        String phType = "";
        //Scanner input = new Scanner(System.in);
        
//        System.out.println("Welcome to Iniative Tracker 1.0! if at any point you are prompted for initiative ");
//        System.out.println("and wish to automate your roll, please enter 'roll'");
//        System.out.println("Please enter the filepath of the folder you which to use starting with C:");
//        System.out.println("Example: C:/users/Public/PublicDocuments");
//        filePath = input.next();
//        filePath = "C:/java";
        comFile = filePath + "/Combatants.txt";
        monFile = filePath + "/Monster.txt";
        charFile = filePath + "/Characters.txt";
        comFileStore = filePath + "/CombatantsTemp.txt";
        monFileStore = filePath + "/MonsterTemp.txt";
        charFileStore = filePath + "/CharactersTemp.txt"; 
        if (initialized == 0) {
//Count the line numbers in the file
        try {
        FileInputStream stream = new FileInputStream(comFile);
        byte[] buffer = new byte[8192];
        int count = 0;
        int n;
        while ((n = stream.read(buffer)) > 0) {
            for (int i = 0; i < n; i++) {
                if (buffer[i] == '\n') count++;
         }
        }
        if (count % 3 == 0 && count > 0)
            total = count/3;
        stream.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
//Count the line numbers in the monster file
        try {
        FileInputStream stream = new FileInputStream(monFile);
        byte[] buffer = new byte[8192];
        int count = 0;
        int n;
        while ((n = stream.read(buffer)) > 0) {
            for (int i = 0; i < n; i++) {
                if (buffer[i] == '\n') count++;
         }
        }
        if (count % 3 == 0 && count > 0)
            monTotal = count/3;
        stream.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
//Count the line numbers in the character file
    try {
        FileInputStream stream = new FileInputStream(charFile);
        byte[] buffer = new byte[8192];
        int count = 0;
        int n;
        while ((n = stream.read(buffer)) > 0) {
            for (int i = 0; i < n; i++) {
                if (buffer[i] == '\n') count++;
         }
        }
        if (count % 4 == 0 && count > 0)
            charTotal = count/4;
        stream.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
//        System.out.print("How many players do you have for this encounter?");
//        total = input.nextInt();
//        System.out.print("How many total monsters for this encounter?");
//        total = total + input.nextInt();
        
        try {
            int i = 0;

//File Reader
//            Object[][] combatant = new Object[total][3];
//            Object[][] character = new Object[charTotal][4];
//            Object[][] monster = new Object[monTotal][3];
//            combatant[0][0] = "me";
//            combatant[0][1] = 1;
//            combatant[0][2] = "me";
//            
//            character[0][0] = "me";
//            character[0][1] = 1;
//            character[0][2] = "me";
//            character[0][3] = 1;
//            
//            monster[0][0] = "me";
//            monster[0][1] = 1;
//            monster[0][2] = "me";
            
            BufferedReader r = new BufferedReader(new FileReader(comFile));
            BufferedReader ch = new BufferedReader(new FileReader(charFile));
            BufferedReader mo = new BufferedReader(new FileReader(monFile));
                        
            int j = 0;
            int k = 0;
            for (i = 0; i < total; i++) {
                phDexString = r.readLine();
                phDex = Integer.parseInt(phDexString);
                phName = r.readLine();                 
                phType = r.readLine();
                dice1.add(new Combatant(phDex, phName, phType));
                
                if (phType.equals("character")) {
                    phDexString = ch.readLine();
                    phDex = Integer.parseInt(phDexString);
                    phName = ch.readLine();
                    phType = ch.readLine();
                    phInitString = ch.readLine();
                    if (phInitString.equals("roll")) {
                        Combatant roller = new Combatant(phDex, phName, phType);
                        phInit = roller.roll();
                        phInitString = Integer.toString(phInit);
                    }
                    else
                        phInit = Integer.parseInt(phInitString);
                    charDice1.add(new Combatant(phDex, phName, phType, phInit));
                    j++;
                }
                else if (phType.equals("monster")) {
                    phDexString = mo.readLine();
                    phDex = Integer.parseInt(phDexString);
                    phName = mo.readLine();                    
                    phType = mo.readLine();
                    monDice1.add(new Combatant(phDex, phName, phType));
                    k++;
                }
            }
            r.close();
            ch.close();
            mo.close();
            
//Dice Roller
            j = 0;
            k = 0;
            int n = 0;
            for (i = 0; i < total; i++) {
                if (dice1.get(i).getType().equals("character")) {
                    dice2.add(new Combatant(dice1.get(i).getDex(), dice1.get(i).getName(), dice1.get(i).getType(), charDice1.get(j).getInit()));
                    n++;
                    charDice2.add(new Combatant(dice1.get(i).getDex(), dice1.get(i).getName(), dice1.get(i).getType(), charDice1.get(j).getInit()));
                    j++;
                }
                else {
                    dice2.add(new Combatant(dice1.get(i).getDex(), dice1.get(i).getName(), dice1.get(i).getType(), dice1.get(i).roll()));
                    n++;
                }
                if (dice1.get(i).getType().equals("monster")) {
                    monDice1.get(k).setInit(dice2.get(n-1).getInit());
                    monDice2.add(new Combatant(dice1.get(i).getDex(), dice1.get(i).getName(), dice1.get(i).getType(), monDice1.get(k).getInit()));
                    k++;
                }
            }
//Initiative sort
            Collections.sort(dice2);
            Collections.sort(monDice2);
            Collections.sort(charDice2);
//Store the rolls to a seperate file
            comFileStore = filePath + "/CombatantsTemp.txt";
            monFileStore = filePath + "/MonsterTemp.txt";
            charFileStore = filePath + "/CharactersTemp.txt";
            BufferedWriter b = new BufferedWriter(new FileWriter(comFileStore));
            BufferedWriter h = new BufferedWriter(new FileWriter(charFileStore));
            BufferedWriter o = new BufferedWriter(new FileWriter(monFileStore));
            for (i = 0; i < total; i++) {
                if (dice2.get(i).getType().equals("character")) {
                    h.write(Integer.toString(dice2.get(i).getDex()));
                    h.newLine();
                    h.write(dice2.get(i).getName());
                    h.newLine();
                    h.write(dice2.get(i).getType());
                    h.newLine();
                    h.write(Integer.toString(dice2.get(i).getInit()));
                    h.newLine();
                }
                else if (dice2.get(i).getType().equals("monster")) {
                    o.write(Integer.toString(dice2.get(i).getDex()));
                    o.newLine();
                    o.write(dice2.get(i).getName());
                    o.newLine();
                    o.write(dice2.get(i).getType());
                    o.newLine();
                    o.write(Integer.toString(dice2.get(i).getInit()));
                    o.newLine();
                }
                b.write(Integer.toString(dice2.get(i).getDex()));
                b.newLine();
                b.write(dice2.get(i).getName());
                b.newLine();
                b.write(dice2.get(i).getType());
                b.newLine();
                b.write(Integer.toString(dice2.get(i).getInit()));
                b.newLine();
            }
            
            stored = dice2;
            b.close();
            h.close();
            o.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
        }
        else {
            //count the line numbers in the file
            total = countTotal(comFileStore, charFileStore, monFileStore);
            try {
                int i = 0;
                //File Reader
                BufferedReader r = new BufferedReader(new FileReader(comFileStore));
                BufferedReader ch = new BufferedReader(new FileReader(charFileStore));
                BufferedReader mo = new BufferedReader(new FileReader(monFileStore));
                for (i = 0; i < total; i++) {
                    phDexString = r.readLine();
                    phDex = Integer.parseInt(phDexString);
                    phName = r.readLine();
                    phType = r.readLine();
                    phInitString = r.readLine();
                    if (phInitString.equals("")) {
                        Combatant roller = new Combatant(phDex, phName, phType);
                        phInit = roller.roll();
                    }
                    else
                        phInit = Integer.parseInt(phInitString);
                    dice2.add(new Combatant(phDex, phName, phType, phInit));
                }
                r.close();
                ch.close();
                mo.close();
                Collections.sort(dice2);
                stored = dice2;
                } catch (IOException e) {
                    System.out.print("Exception");
                }
        }
        return stored;
        
        
    }
    public ArrayList<Combatant> myCombatantStored(int totaled, ArrayList<Integer> inits, ArrayList<String> names) {
        ArrayList<Combatant> stored = new ArrayList<Combatant>();
        int phDex = 1;
        int phInit = 1;
        String phDexString = "";
        String phInitString = "";
        String phName = "";
        String phType = "";
        try {
            BufferedReader com = new BufferedReader(new FileReader(filePath + "/CombatantsTemp.txt"));
            BufferedReader chara = new BufferedReader(new FileReader(filePath + "/CharactersTemp.txt"));
            BufferedReader mon = new BufferedReader(new FileReader(filePath + "/MonsterTemp.txt"));
            int i = 0;
            int j = 0;
            for (i = 0; i < totaled; i++) {
                phDexString = com.readLine();
                phDex = Integer.parseInt(phDexString);
                phName = com.readLine();
                phType = com.readLine();
                phInitString = com.readLine();
                phInit = Integer.parseInt(phInitString);
                if (names.contains(phName) && phType.equals("character")) {
                    phInit = inits.get(j);
                    j++;
                }
                stored.add(new Combatant(phDex, phName, phType, phInit));
            }
            Collections.sort(stored);
            com.close();
            chara.close();
            mon.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
        return stored;
        
    }
}
