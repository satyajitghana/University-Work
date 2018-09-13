import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SeaActors
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static Float speed = 2.0f;
      
    public void _move() {
        move(speed.intValue());
        if (Greenfoot.getRandomNumber(100) < 10) turn(8);
        else if (Greenfoot.getRandomNumber(100) < 10) turn(-8);
    }
    
    public void kill() {
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            getWorld().removeObject(player);
            ((SeaWorld)getWorld()).gameOver();
        }
    }
    
    public void setSpeed(Float newSpeed) {
        this.speed = newSpeed;
    }
}
