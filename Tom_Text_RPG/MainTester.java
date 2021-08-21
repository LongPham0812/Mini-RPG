import java.util.*;

// add player info in monster classes and return player info after fight
// to tester classes?

public class MainTester
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        boolean stillPlay = true;
        
        Player player = new Player (100, 30, 20);
        int totalHp = player.getHp();
        int contHp = player.getHp();

        while (stillPlay)
        {
            int randMon = (int)(Math.random() * 3);

            if (randMon == 0)
            {
                CommonGoblin enemyG = new CommonGoblin (90, 20, 15);
                System.out.println("Player encountered Common Goblin!");
                enemyG.fight();
            }
            else if (randMon == 1)
            {
                Angel enemyA = new Angel (80, 15, 15, contHp);
                System.out.println("Player encountered Angel!");
                enemyA.fight();
                contHp = enemyA.getPlayerHP();
            }
            else
            {
                RockWall enemyR = new RockWall (100, 15, 25);
                System.out.println("Player encountered RockWall!");
                enemyR.fight();
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