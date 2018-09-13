import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SeaActors {
    
    public void _move() {
        if (Greenfoot.isKeyDown("right")) turn(5);
        
        if (Greenfoot.isKeyDown("left")) turn(-5);
        
        if (Greenfoot.isKeyDown("up")) {
            turn(-90);
            move(5);
            turn(90);
        }
        
        if (Greenfoot.isKeyDown("down")) {
            turn(90);
            move(5);
            turn(-90);
        }
    }
}
