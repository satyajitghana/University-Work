import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StingRay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StingRay extends Enemy
{
    /**
     * Act - do whatever the StingRay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StingRay() {
        getImage().rotate(90);
    }
    
    public void act() {
        _move();
        checkBounds();
        kill();
    }

}
