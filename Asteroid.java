import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bouncing around until you shoot them or they reach the bottom of the screen.
 * shooting them gives you points!
 * 
 * @author Will Threlkeld 
 * @version 6/1/2020
 */
public class Asteroid extends Obstacles
{
    int dx = Greenfoot.getRandomNumber(10) -5;
    int dy = 2;
    public void act() 
    {        
        bounce();
        if (getY() == 490)
        {
            getWorld().removeObject(this);
        }
    } 
    public void bounce()
    {
          setLocation(getX() + dx, getY() + dy);
          if(isAtEdge())
          {
               dx *= -1;
          }
    }
}
