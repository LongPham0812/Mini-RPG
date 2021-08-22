import java.lang.Math;
import java.util.*;

public class RockWall implements Entity
{
    private int hitpoint;
    private int attack;
    private int defense;
    private Player play;
    
    public RockWall(int hp, int a, int d, Player p)
    {
        hitpoint = hp;
        attack = a;
        defense = d;
        play = p;
    }
    
    public int getHp()
    {
        return hitpoint;
    }
    
    public void newHp(int dam)
    {
        hitpoint = hitpoint - dam;
    }
    
    public int damage(int oDef)
    {
        int critChance = (int)(Math.random() * 100);
        double randMult = Math.random() + 4;
        
        if (critChance <= 2)
        {
            System.out.println("Critical Hit!");
            return (int)((((2 * attack / oDef) * randMult) + 1) * 1.5);
        }
        
        return (int)((2 * attack / oDef) * randMult) + 1;
    }
    
    public int getDef()
    {
        return defense;
    }
    
    public void addDef()
    {
        defense = defense + 5;
    }
    
    public void fight()
    {
        Scanner kb = new Scanner(System.in);
        
        int totalHp = play.getHp();
        int damage;
        System.out.println("Player HP: " + play.getHp() + " / " + totalHp);
        
        while (play.getHp() > 0 || getHp() > 0)
        {
            System.out.print("Attack or Defend (Press A or D)? ");
            String input = kb.nextLine();
            boolean strIn = true;
            
            while (strIn)
            {
                switch (input)
                {
                    case "A":
                    case "a":
                    case "D":
                    case "d":
                        strIn = false;
                        break;
                    default:
                        System.out.print("Please press either A or D. ");
                        input = kb.nextLine();
                }
            }
            
            int chanceDecide = (int)(Math.random() * 10);
            
            if (chanceDecide <= 3)
            {
                addDef();
                System.out.println("Enemy defended.");
            }
            
            if (input.equalsIgnoreCase("D"))
            {
                play.addDef();
                System.out.println("Player defended.");
            }
            else
            {
                damage = player.damage(getDef());
                newHp(damage);
                System.out.println("Player attacked and did " + damage + " damage.");
                
                if (getHp() <= 0)
                {
                    System.out.println("Player defeated enemy!");
                    break;
                }
            }
            
            if (chanceDecide > 3)
            {
                damage = damage(play.getDef());
                play.newHp(damage);
                System.out.println("Enemy attacked and did " + damage + " damage.");
                
                if (play.getHp() < 0)
                {
                    System.out.println("Player HP: " + "0 / " + totalHp);
                }
                else
                {
                    System.out.println("Player HP: " + play.getHp() + " / " + totalHp);
                }
                
                if (play.getHp() <= 0)
                {
                    System.out.println("Enemy defeated player!");
                    break;
                }
            }
        }
    }
}
