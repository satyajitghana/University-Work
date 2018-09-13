import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeaActors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SeaActors extends Actor{  
    public void checkBounds() {
        if (getX()+getImage().getHeight()/2 >= getWorld().getWidth())
            setLocation(getImage().getHeight()/2, getY());
        else if (getX() <= 0)
            setLocation(getWorld().getWidth() - getImage().getHeight()/2, getY());
        
        if (getY()+getImage().getWidth()/2 >= getWorld().getHeight())
            setLocation(getX(), getImage().getWidth()/2); 
        else if (getY() <= 0)
            setLocation(getX(), getWorld().getHeight() - getImage().getWidth()/2);
    }
}
