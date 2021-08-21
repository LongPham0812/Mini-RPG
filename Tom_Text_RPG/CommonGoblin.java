import java.lang.Math;
import java.util.*;

public class CommonGoblin implements Entity
{
    private int hitpoint;
    private int attack;
    private int defense;
    
    public CommonGoblin(int hp, int a, int d)
    {
        hitpoint = hp;
        attack = a;
        defense = d;
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
    
    public int getDef()
    {
        return defense;
    }
    
    public void addDef()
    {
        defense = defense + 3;
    }
    
    public void fight()
    {
        Scanner kb = new Scanner(System.in);
        
        Player player = new Player (100, 30, 20);
        int randMon = (int)(Math.random() * 3);
        int totalHp = player.getHp();
        int damage;
        System.out.println("Player HP: " + player.getHp() + " / " + totalHp);
        
        while (player.getHp() > 0 || getHp() > 0)
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
            
            if (chanceDecide <= 2)
            {
                addDef();
                System.out.println("Enemy defended.");
            }
            
            if (input.equalsIgnoreCase("D"))
            {
                player.addDef();
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
            
            if (chanceDecide > 2)
            {
                damage = damage(player.getDef());
                player.newHp(damage);
                System.out.println("Enemy attacked and did " + damage + " damage.");
                
                if (player.getHp() < 0)
                {
                    System.out.println("Player HP: " + "0 / " + totalHp);
                }
                else
                {
                    System.out.println("Player HP: " + player.getHp() + " / " + totalHp);
                }
                
                if (player.getHp() <= 0)
                {
                    System.out.println("Enemy defeated player!");
                    break;
                }
            }
        }
    }
}
