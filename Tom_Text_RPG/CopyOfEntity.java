import java.lang.Math;

abstract class CopyOfEntity
{
    public int hitpoint;
    public int attack;
    public int defense;
    
    public abstract int getHp();
    
    public abstract void newHp(int dam);
    
    public abstract int damage(int oDef);
    
    public abstract int getDef();
    
    public abstract void addDef();
}
