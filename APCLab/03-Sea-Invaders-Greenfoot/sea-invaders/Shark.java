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
            // Increase the score
            currWorldScore.setScore(currWorldScore.getScore()+((Food)toEat).getFoodPoints());
            currWorldScore.incrementFishEaten();
            Food toAdd = null;
            if (toEat instanceof ClownFish)
                toAdd = new ClownFish();
            if (toEat instanceof PufferFish)
                toAdd = new PufferFish();
            
            getWorld().addObject(toAdd,Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
            
            currWorldScore.updateDifficulty();
        }
    }
}
