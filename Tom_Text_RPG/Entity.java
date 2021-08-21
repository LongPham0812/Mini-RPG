import java.lang.Math;

public interface Entity
{
    public int getHp();
    
    public void newHp(int dam);
    
    public int damage(int oDef);
    
    public int getDef();
    
    public void addDef();
}