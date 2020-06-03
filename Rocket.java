import greenfoot.*;

/***
 * A simple rocket than can move left with the left arrow key, right
 * with the right arrow key, and can shoot bullets with spacebar
 * 
 * @author Will Threlkeld
 * @version 6/1/2020
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5;             
    private int reloadDelayCount;                  
    private GreenfootImage rocket = new GreenfootImage("rocket.png");     
    /**
     * Initialise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        reloadDelayCount++;
        move();
        setRotation(-90);
    }
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w")) 
        {
            fire();
        }
        if (Greenfoot.isKeyDown("Left") || Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-5, getY());
        }
        if (Greenfoot.isKeyDown("Right") || Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+5, getY());
        }
        
    }
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getVelocity(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = -15;
        }
    }
}