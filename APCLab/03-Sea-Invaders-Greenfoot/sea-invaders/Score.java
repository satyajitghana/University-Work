import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor {
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Integer score = 0;
    Integer fishEaten = 0;
    
    public Score() {
        score = 0;
        fishEaten = 0;
        Enemy.speed = 1.0f;
    }
    
    public void act() {
        setImage(new GreenfootImage("Score : " + score+" Fishes Eaten : "+fishEaten+" Difficulty : " + String.format("%.2f", Enemy.speed) + "X", 30, Color.WHITE, null));
    }
    
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public void updateDifficulty() {
        if (fishEaten % 5 == 0)
            Enemy.speed *= 1.2f;
    }
    
    public void incrementFishEaten() {
        fishEaten++;
    }
    
    public Integer getFishEaten() {
        return fishEaten;
    }
}
