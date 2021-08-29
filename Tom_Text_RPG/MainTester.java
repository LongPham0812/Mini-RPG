import java.util.*;

public class MainTester
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        boolean stillPlay = true;
        boolean LorW = false;
        
        ini_def = 20;
        Player player = new Player (100, 30, ini_def);
        int totalHp = player.getHp();

        while (stillPlay)
        {
            int randMon = (int)(Math.random() * 3);

            if (randMon == 0)
            {
                CommonGoblin enemyG = new CommonGoblin (90, 20, 15, player, totalHp);
                System.out.println("Player encountered Common Goblin!");
                LorW = enemyG.fight();
            }
            else if (randMon == 1)
            {
                Angel enemyA = new Angel (80, 15, 15, player, totalHp);
                System.out.println("Player encountered Angel!");
                LorW = enemyA.fight();
            }
            else
            {
                RockWall enemyR = new RockWall (100, 15, 25, player);
                System.out.println("Player encountered RockWall!");
                enemyR.fight();
            }
            
            if (LorW)
            {
                System.out.print("Want to continue playing (Press Y or N; Pressing Y will reset your stats)? ");
                String YorN = kb.nextLine();
                boolean checkIn = true;
                
                while (checkIn)
                {
                    switch (YorN)
                    {
                        case "Y":
                        case "y":
                            System.out.println("Resetting stats...");
                            player.setDef(ini_def);
                            break;
                        case "N":
                        case "n":
                            stillPlay = false;
                            break;
                        default:
                            System.out.print("Please press either Y or N. ");
                            YorN = kb.nextLine();
                            continue;
                    }
                    
                    checkIn = false;
                }
            }
            else
            {
                stillPlay = false;
            }
        }
        
        System.out.println("Thanks for playing. :)");
        System.out.println("Everything in this game was made by me.");
    }
}
