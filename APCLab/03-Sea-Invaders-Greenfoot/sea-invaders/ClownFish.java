import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClownFish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClownFish extends Food
{
    /**
     * Act - do whatever the ClownFish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static Integer points = 10;
    
    public ClownFish() {
        super(points);
        getImage().scale(40, 40);
    }
    
    public void act() {
       liveLife();
       checkBounds();
       _move();
       if (isDead()) {
           getWorld().addObject(new ClownFish(), Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
           getWorld().removeObject(this);
        }
       
    }
    
    private void _move() {
        move(2);
        if (Greenfoot.getRandomNumber(100) < 5) turn(8);
        else if (Greenfoot.getRandomNumber(100) < 5) turn(-8);
    }
    
    @Override
    public Integer getFoodPoints() {
        return this.points;
    }
}
