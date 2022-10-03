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

public class Stats
{
    private int strength, intelligence, stamina;

    public Stats(int strength, int intelligence, int stamina)
    {
        //constructor
        this.strength = strength;
        this.intelligence = intelligence;
        this.stamina = stamina;
        if(strength>12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
        if(intelligence>12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
        if(stamina>12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
        if((strength+intelligence+stamina)>20)
        {
            throw new IllegalArgumentException("ERROR: Stat total is greater than 20!");
        }
    }
    public Stats(Stats stats)
    {
        //copy constructor
        this.strength = stats.strength;
        this.intelligence = stats.intelligence;
        this.stamina = stats.stamina;
    }
    public int getStrength()
    {
        return this.strength;
    }
    public int getIntelligence()
    {
        return this.intelligence;
    }
    public int getStamina()
    {
        return this.stamina;
    }
    public void moveStrengthToIntelligence(int amount)
    {
        if(amount>0 && amount<=12) //positive int moves strength to intelligence
        {
            this.strength -= amount;
            this.intelligence += amount;
        }
        if(amount<0 && amount>=-12) //negative int moves intelligence to strength
        {
            this.strength += Math.abs(amount);
            this.intelligence -= Math.abs(amount);
        }
        if(strength>12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
        if(intelligence >12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
    }
    public void moveStrengthToStamina(int amount)
    {
        if(amount>0 && amount <=12) //positive int moves strength to stamina
        {
            this.strength -= amount;
            this.stamina += amount;
        }
        if(amount<0 && amount>=-12) //negative int moves stamina to strength
        {
            this.strength += Math.abs(amount);
            this.stamina -= Math.abs(amount);
        }
        if(stamina>12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
        if(strength>12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
    }
    public void moveIntelligenceToStamina(int amount)
    {
        if((amount>0 && amount <=12)) //positive int moves intelligence to stamina
        {
            this.intelligence -= amount;
            this.stamina += amount;
        }
        if((amount<0 && amount >=-12)) //negative int moves stamina to intelligence
        {
            this.intelligence += Math.abs(amount);
            this.stamina -= Math.abs(amount);
        }
        if(stamina>12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
        if(intelligence >12)
        {
            throw new IllegalArgumentException("ERROR: A stat value is greater than 12!");
        }
    }

    @Override
    public String toString()
    {
        return ("Strength: " + getStrength() + " Intelligence: " + getIntelligence() + " Stamina: " + getStamina());
    }
    @Override
    public boolean equals(Object other)
    {
        if(other == null || getClass() != other.getClass())
        {
            return false;
        }
        else
        {
            Stats otherStats = (Stats) other;
            if(otherStats.getStrength() == strength && otherStats.getIntelligence() == intelligence
                    && otherStats.getStamina() == stamina)
            {
                return true;
            }
        }
        return false;
    }
}
