import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Player {
    /**
     * Act - do whatever the Shark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Shark() {
        getImage().rotate(-90);
        getImage().scale(80, 80);
    }
    
    public void act() {
        _move();
        checkBounds();
        eat();
    }

    
    private void eat() {
        Actor toEat = getOneIntersectingObject(Food.class);
        if (toEat != null) {
            getWorld().removeObject(toEat);
            Score currWorldScore = ((SeaWorld)getWorld()).getWorldScore();
            currWorldScore.setScore(currWorldScore.getScore()+((Food)toEat).getFoodPoints());
            getWorld().addObject(new ClownFish(),Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
            
            if (currWorldScore.getScore()%100 == 0) {
                currWorldScore.updateDifficulty();
            }
        }
    }
}
