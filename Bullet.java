import greenfoot.*;

/**
 * A bullet that can hit asteroids and (hopefully not) hazards. 
 * @author Will Threlkeld
 * @version 6/1/2020
 */
public class Bullet extends SmoothMover
{
    private int life = 30;
    
    private static final int pointsToAdd = 100;
    private static final int pointsToSubtract = -300;
    /**
     * Default constructor for testing.
     */
    public Bullet()
    {
        
    }  
    /**
     * Create a bullet with given speed and direction of movement.
     */
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));        
    }    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkAsteroidHit();
            checkHazardHit();            
        }
    }    
    /**
     * Check whether we have hit an asteroid.
     */
    private void checkAsteroidHit()
    {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if (isTouching(Asteroid.class))
        {
            ((Space)getWorld()).updateScore(pointsToAdd);
            Greenfoot.playSound("Boop.wav");
            removeTouching(Asteroid.class);
            life = 0;
        }
    } 
    private void checkHazardHit()
    {
        Hazard hazard = (Hazard) getOneIntersectingObject(Hazard.class);
        if (isTouching(Hazard.class))
        {
            ((Space)getWorld()).updateScore(pointsToSubtract);
            Greenfoot.playSound("Error.wav");
            removeTouching(Hazard.class);
            life = 0;
        }
    } 
}