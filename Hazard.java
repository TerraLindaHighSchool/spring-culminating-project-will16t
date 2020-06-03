import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hazard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hazard extends Obstacles
{
    int dx = Greenfoot.getRandomNumber(4) -2;
    int dy = 1;
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
