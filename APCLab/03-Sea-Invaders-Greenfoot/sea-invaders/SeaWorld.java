import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;  // ArrayList

/**
 * Write a description of class SeaWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeaWorld extends World
{

    /**
     * Constructor for objects of class SeaWorld.
     * 
     */
    
    private Score score = new Score();
    
    public SeaWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        
        addObject(score, getWidth()/2, 30);
        
        // Player
        Shark player = new Shark();
        addObject(player, getWidth()/2, getHeight()/2);
        // Enemy
        StingRay enemy1 = new StingRay();
        addObject(enemy1, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Crab enemy2 = new Crab();
        addObject(enemy2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        
        ArrayList<Food> foods = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            foods.add(new ClownFish());
            if (i%2==0) foods.add(new PufferFish());
        }
        
        
        foods.forEach(food -> addObject(food, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())));
            
        getBackground().drawImage(new GreenfootImage("coral.png"), 1100, 595);
    }
    
    public Score getWorldScore() {
        return score;
    }
    
    public void gameOver() {
        getBackground().drawImage(new GreenfootImage("GAME OVER Your Score: " + score.getScore(), 50, Color.WHITE, null), getWidth()/2-300, getHeight()/2);
        Greenfoot.stop();
    }
}
