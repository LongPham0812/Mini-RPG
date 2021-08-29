import java.lang.Math;
import java.util.*;

public class Angel implements Entity
{
    private int hitpoint;
    private int maxHp;
    private int attack;
    private int defense;
    private Player play;
    private int playTotHp;
    
    public Angel(int hp, int a, int d, Player p, int pthp)
    {
        hitpoint = hp;
        maxHp = hp;
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
    
    private void heal()
    {
        int randHeal = (int)(Math.random() * 6) + 10;
        
        if (randHeal > maxHp - hitpoint)
        {
            randHeal = maxHp - hitpoint;
        }
        
        hitpoint = hitpoint + randHeal;
        System.out.println("Enemy healed " + randHeal + " HP!");
    }
    
    private int damage(int oDef)
    {
        int critChance = (int)(Math.random() * 100);
        double randMult = Math.random() + 4;
        
        if (critChance <= 2)
        {
            return (int)(((2 * attack / oDef) * randMult) + 1) * 2;
        }
        
        return (int)((2 * attack / oDef) * randMult) + 1;
    }
    
    private int getDef()
    {
        return defense;
    }
    
    private void addDef()
    {
        defense = defense + 2;
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
            
            if (2 < chanceDecide && chanceDecide <= 4)
            {
                heal();
            }
            else
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
