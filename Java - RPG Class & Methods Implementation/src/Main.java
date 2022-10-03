/** A RPG Program that creates players with individual status and stats.
 * Practices class implementation and method implementation
 *
 * - Player experience cannot exceed 10,000.
 *
 * - An individual stat (strength, intelligence, stamina) cannot exceed 12.
 * - The values of all stats combined (strength + intelligence + stamina) cannot exceed 20.
 * - Stat points can be moved to other stats
 *
 * - An individual status (hitPoints, hunger, sleepiness) cannot exceed 25, 15, or 15 respectively
 *
 */

import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        try
        {
            //test 1
            System.out.println("TEST 1");


            Stats player1stats = new Stats(10,5,5); //creates stats for player 1
            Status player1status = new Status(15,10,10); //creates status for player 1
            Players player1 = new Players("Joshua", 0, player1stats, player1status); //creates a player 1


            System.out.println("The name of player 1 is: " + player1.getName()); //tests getName()
            player1.addExperience(950);//adds 950 experience
            System.out.println(player1.getName() + " now has: " + player1.getExperience() + " experience."); //tests getExperience()
            player1.addExperience(51);//tests boundaries for experience making it sure it does not exceed 1000
            System.out.println(player1.getName() + " now has: " + player1.getExperience() + " experience."); //tests getExperience()


            System.out.println("This tests the equals method: " + player1.getPlayerStats().equals(player1stats)); //tests Stats equals()
            System.out.println("This tests the equals method: " + player1.getPlayerStatus().equals(player1status));//tests Status equals()

            //test 2
            System.out.println("\nTEST 2");
            Scanner keyboard = new Scanner(System.in);


            Stats player2stats = new Stats(10,5,5); //creates stats for player 2
            Status player2status = new Status(20,15,15); //creates status for player 2
            Players player2 = new Players("Casuga", 150, player2stats, player2status); //creates player 2


            System.out.println("Player 2 has " + player2.getPlayerStats().toString()); //tests Stats toString()
            System.out.println("This tests functionality of moving stats. Type a positive int to move intelligence to stamina." +
                    " Type a negative int to move stamina to intelligence");
            player2.getPlayerStats().moveIntelligenceToStamina(keyboard.nextInt()); //tests moving stats
            System.out.println("Player 2 has " + player2.getPlayerStats().toString());


            System.out.println("\n" + "Player 2 has " + player2.getPlayerStatus().toString()); //tests toString() for Status class
            System.out.println("This tests functionality of moving Status values. Type a positive int to add hit points." +
                    " Type a negative int to remove hit points.");
            player2.getPlayerStatus().addHitPoints(keyboard.nextInt()); //tests moving status values
            System.out.println("Player 2 has " + player2.getPlayerStatus().toString());
        }
        catch (Exception e)
        {
            System.out.println("ERROR DETECTED.");
        }

        try
        {
            //test 3
            System.out.println("\nTEST 3");
            Scanner keyboard = new Scanner(System.in);


            Stats player3stats = new Stats(8,7,5);
            Status player3status = new Status (25,10,10);
            Players player3 = new Players("Danzel", 812, player3stats, player3status);


            System.out.println("Player 3 has " + player3.getPlayerStatus().toString());
            System.out.println("A player can have no more than 25 hit points. When prompted, try adding hit points.");
            System.out.println("Enter a positive int to try adding hit points.");
            player3.getPlayerStatus().addHitPoints(keyboard.nextInt());
            System.out.println("Player 3 has " + player3.getPlayerStatus().toString());
        }
        catch (Exception e)
        {
            System.out.println("ERROR DETECTED.");
        }

        try
        {
            //test 4
            System.out.println("\nTEST 4");
            Scanner keyboard = new Scanner(System.in);


            Stats player4stats = new Stats(12, 5, 3);
            Status player4status = new Status(5,5,5);
            Players player4 = new Players("Yap", 914, player4stats, player4status);


            System.out.println("Player 4 has " + player4.getPlayerStats().toString());
            System.out.println("Here, we will try moving values between stats. A stat can be no more than 12.");
            System.out.println("Enter a negative int to try moving intelligence to strength.");
            player4.getPlayerStats().moveStrengthToIntelligence(keyboard.nextInt());
            System.out.println("Player 4 has " + player4.getPlayerStats().toString());
        }
        catch (Exception e)
        {
            System.out.println("ERROR DETECTED.");
        }

        try
        {
            //test 5
            System.out.println("\nTEST 5");


            Stats player5stats = new Stats(5,5,5);
            Status player5status = new Status(10,10,10);
            Players player5 = new Players("Matthew", 408, player5stats, player5status);


            System.out.println("This test will check if the equals method in Players works.");
            System.out.println("An object of type Stats will be run through the equals method for Players. This should throw an exception.");
            System.out.println("This tests the equals method: " + player5.equals(player5stats));
        }
        catch (Exception e)
        {
            System.out.println("ERROR DETECTED.");
        }

        /** tests unused methods
         *
        try
        {
            Scanner keyboard = new Scanner(System.in);

            Stats testPlayerStats = new Stats(5, 5, 5);
            Status testPlayerStatus = new Status(10, 10, 10);
            Players player5 = new Players("Test", 0, testPlayerStats, testPlayerStatus);

            System.out.println("\n" + "Test has " + player5.getPlayerStats().toString());
            System.out.println("move strength to stamina");
            player5.getPlayerStats().moveStrengthToStamina(keyboard.nextInt());
            System.out.println("Test has " + player5.getPlayerStats().toString());

            System.out.println("\n" + "Test has " + player5.getPlayerStatus().toString());
            System.out.println("add hunger");
            player5.getPlayerStatus().addHunger(keyboard.nextInt());
            System.out.println("Test has " + player5.getPlayerStatus().toString());
            System.out.println("add sleepiness");
            player5.getPlayerStatus().addSleepiness(keyboard.nextInt());
            System.out.println("Test has " + player5.getPlayerStatus().toString());
        }
        catch (Exception e)
        {
            System.out.println("ERROR DETECTED.");
        }
        */
    }
}
