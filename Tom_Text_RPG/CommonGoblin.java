import java.lang.Math;
import java.util.*;

public class CommonGoblin implements Entity
{
    private int hitpoint;
    private int attack;
    private int defense;
    private Player play;
    private int playTotHp;
    
    public CommonGoblin(int hp, int a, int d, Player p, int pthp)
    {
        hitpoint = hp;
        attack = a;
        defense = d;
        play = p;
        playTotHp = pthp;
    }
    
    private int getHp()
    {
        return hitpoint;
    }
    
    private void newHp(int dam)
    {
        hitpoint = hitpoint - dam;
    }
    
    private int damage(int oDef)
    {
        int dam;
        int randMult = (int)(Math.random() * 4) + 1;
        int hitCount = 1;
        dam = (attack / oDef) * randMult + 1;
        
        for (int i = 0; i < 5; i++)
        {
            int randHit = (int)(Math.random() * 10);
            
            if (randHit <= 3)
            {
                randMult = (int)(Math.random() * 4) + 1;
                dam = dam + (attack / oDef) * randMult + 1;
                hitCount++;
            }
        }
        
        System.out.println("Enemy hit " + hitCount + " times!");
        return dam;
    }
    
    private int getDef()
    {
        return defense;
    }
    
    private void addDef()
    {
        defense = defense + 3;
    }
    
    public boolean fight()
    {
        Scanner kb = new Scanner(System.in);
        
        int damage;
        
        while (play.getHp() > 0 || getHp() > 0)
        {
            System.out.println("Player HP: " + play.getHp() + " / " + playTotHp);
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
            
            if (chanceDecide <= 2)
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
                damage = play.damage(getDef());
                newHp(damage);
                System.out.println("Player attacked and did " + damage + " damage.");
                
                if (getHp() <= 0)
                {
                    System.out.println("Player defeated enemy!");
                    return true;
                }
            }
            
            if (chanceDecide > 2)
            {
                damage = damage(play.getDef());
                play.newHp(damage);
                System.out.println("Enemy attacked and did " + damage + " damage.");
                
                if (play.getHp() <= 0)
                {
                    System.out.println("Player HP: " + "0 / " + playTotHp);
                    System.out.println("Enemy defeated player!");
                    return false;
                }
            }
        }
    }
}
