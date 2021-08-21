import java.util.*;

// add player info in monster classes and return player info after fight
// to tester classes?

public class MainTester
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        boolean stillPlay = true;
        
        int totalPlayHp = 100;
        int contPlayHp = totalPlayHp;
        int ini_playAtt = 30;
        int ini_playDef = 20;

        while (stillPlay)
        {
            int randMon = (int)Math.random();

            if (randMon == 0)
            {
                CommonGoblin enemyG = new CommonGoblin (90, 20, 15, contPlayHp, totalPlayHp, ini_playAtt, ini_playDef);
                System.out.println("Player encountered Common Goblin!");
                enemyG.fight();
            }
            
            System.out.print("Want to continue playing (Press Y or N; Pressing Y will reset your stats and HP)? ");
            String YorN = kb.nextLine();
            boolean checkIn = true;
            
            while (checkIn)
            {
                switch (YorN)
                {
                    case "Y":
                    case "y":
                        checkIn = false;
                        System.out.println("Resetting stats and HP...");
                        break;
                    case "N":
                    case "n":
                        checkIn = false;
                        stillPlay = false;
                        break;
                    default:
                        System.out.print("Please press either Y or N. ");
                        YorN = kb.nextLine();
                }
            }
        }
        
        System.out.println("Thanks for playing. :)");
        System.out.println("Everything in this game was made by me.");
    }
}
