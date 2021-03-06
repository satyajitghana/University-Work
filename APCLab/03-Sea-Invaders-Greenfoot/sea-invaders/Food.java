import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

class Food extends SeaActors {
    Float lifeTime;
    Integer points;
    
    public Food(Integer points) {
        lifeTime = 155.0f + Greenfoot.getRandomNumber(100);
        this.points = points;
    }
    
    public void liveLife() {
        lifeTime -= 0.2f;
    }
    
    public boolean isDead() {
        if (lifeTime < 0) return true;
        return false;
    }
    
    public Integer getFoodPoints() {
        return this.points;
    }
}
