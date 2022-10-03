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

public class Status
{
    private int hitPoints = 0, hunger = 0, sleepiness = 0;

    public Status(int hitPoints, int hunger, int sleepiness) //constructor
    {
        this.hitPoints = hitPoints;
        this.hunger = hunger;
        this.sleepiness = sleepiness;
    }
    public Status(Status status) //copy constructor
    {
        this.hitPoints = status.hitPoints;
        this.hunger = status.hunger;
        this.sleepiness = status.sleepiness;

    }
    public int getHitPoints()
    {
        return hitPoints;
    }
    public int getHunger()
    {
        return hunger;
    }
    public int getSleepiness()
    {
        return sleepiness;
    }
    public void setHitPoints(int points)
    {
        hitPoints = points;
    }
    public void setHunger(int hun)
    {
        hunger = hun;
    }
    public void setSleepiness(int sleep)
    {
        sleepiness = sleep;
    }

    @Override
    public String toString() //toString method
    {
        return ("Hit Points: " + getHitPoints() + "  Hunger: " + getHunger() + " Sleepiness: " + getSleepiness());
    }
    @Override
    public boolean equals(Object other) //equals method
    {
        if(other == null || getClass() != other.getClass())
        {
            return false;
        }
        else
        {
            Status otherStats = (Status) other;
            if(otherStats.getHitPoints() == hitPoints && otherStats.getHunger() == hunger
                    && otherStats.getSleepiness() == sleepiness)
            {
                return true;
            }
        }
        return false;
    }

    public void addHitPoints(int delta) //hitPoints cannot be less than 0 or greater than 25
    {
        if(delta>0 && !(delta+hitPoints>25)) //adds hitPoints if sum of delta and hitPoints <= 25
        {
            this.hitPoints += delta;
        }
        else if(delta<0 && !(delta+hitPoints<=0)) //subtracts hitPoints if sum of delta and hitPoints >= 0
        {
            this.hitPoints -= Math.abs(delta);
        }
        else //throws exception if sum of delta value and hitPoints is <0 or >25
        {
            throw new IllegalArgumentException("ERROR: Int given will exceed either 0 or 25 HitPoints");
        }
    }
    public void addHunger(int delta) //hunger cannot be less than 0 or greater than 15
    {
        if((delta>0)&&(delta<=15-hunger)) //adds hunger if sum of delta and current hunger <= 15
        {
            this.hunger += delta;
        }
        else if((delta<0)&&(Math.abs(delta)<=hunger-1)) //subtracts hunger if sum of delta and current hunger >= 0
        {
            this.hunger -= Math.abs(delta);
        }
        else //throws exception if sum of delta and hunger <0 or >15
        {
            throw new IllegalArgumentException("ERROR: Int given will exceed either 0 or 15 Hunger");
        }
    }
    public void addSleepiness(int delta) //sleepiness cannot be less than 0 or greater than 15
    {
        if((delta>0)&&(delta<=15-sleepiness)) //adds sleepiness if sum of delta and sleepiness <=15
        {
            this.sleepiness += delta;
        }
        else if((delta<0)&&(Math.abs(delta)<=sleepiness-1)) //subtracts sleepiness if sum of delta and sleepiness >=0
        {
            this.sleepiness -= Math.abs(delta);
        }
        else //throws exception if sum of delta and hunger <0 or >15
        {
            throw new IllegalArgumentException("ERROR: Int given will exceed either 0 or 15 Sleepiness");
        }
    }
}
