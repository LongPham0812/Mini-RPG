import java.lang.Math;

public class Player implements Entity
{
    private int hitpoint;
    private int attack;
    private int defense;
    
    public Player(int hp, int a, int d)
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
    
    public void heal()
    {
        hitpoint = hitpoint + 5;
    }
    
    public int damage(int oDef)
    {
        int critChance = (int)(Math.random() * 100);
        double randMult = Math.random() + 4;
        
        if (critChance <= 9)
        {
            System.out.println("Critical Hit!");
            return (int)(((2 * attack / oDef) * randMult) + 1) * 2;
        }
        
        return (int)((2 * attack / oDef) * randMult) + 1;
    }
    
    public int getDef()
    {
        return defense;
    }
    
    public void addDef()
    {
        defense = defense + 3;
    }
}