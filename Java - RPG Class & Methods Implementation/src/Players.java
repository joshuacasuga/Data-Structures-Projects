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

public class Players
{
    private String name = "";
    private int experience = 0;
    private static int count = 0;
    private Stats playerStats; //aggregate of Stats
    private Status playerStatus; //aggregate of Status
    Status tempStatus;
    Stats tempStats;
    public Players(String name, int experience, Stats stats, Status status) //constructor
    {
        this.name = name;
        this.experience = experience;
        this.playerStats = new Stats(stats);
        this.playerStatus = new Status(status);
        count++;
        int id=count;
    }
    public Players(Players object2) //copy constructor
    {
        name = object2.name;
        experience = object2.experience;
        playerStats = object2.playerStats;
        playerStatus = object2.playerStatus;
        if(name == null || playerStats == null || playerStatus == null)
        {
            throw new IllegalArgumentException("Null value passed.");
        }
        if(getClass() != object2.getClass())
        {
            throw new IllegalArgumentException("Object not of Player type.");
        }
    }

    public String getName() {return this.name;}
    public int getExperience()
    {
        return this.experience;
    }
    public Stats getPlayerStats()
    {
        tempStats = (this.playerStats);
        return tempStats;
    }
    public Status getPlayerStatus()
    {
        tempStatus = (this.playerStatus);
        return tempStatus;
    }

    public void addExperience(int exp) //adds to experience
    {
        if((experience+exp>1000))
        {
            experience = 1000;
        }
        if(experience>=0 && experience<1000)
        {
            experience+=exp;
        }
    }
    public static int playerCount()
    {
        return count;
    }

    @Override
    public String toString() //toString method
    {
        return ("Name: " + getName() + " Experience: " + getExperience() + " Stats: " + getPlayerStats() + " Status: " + getPlayerStatus());
    }
    @Override
    public boolean equals(Object other) //equals method
    {
        if(other == null || getClass() != other.getClass())
        {
            throw new IllegalArgumentException("ERROR: Objects are not of same type!");
        }
        else
        {
            Players otherStats = (Players) other;
            if(otherStats.getName() == name && otherStats.getExperience() == experience
                    && otherStats.getPlayerStats() == this.playerStats
                    && otherStats.getPlayerStatus() == this.playerStatus)
            {
                return true;
            }
        }
        throw new IllegalArgumentException("ERROR: Objects are not of same type!");
    }

}
