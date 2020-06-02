import greenfoot.*;

/**
 * Space. Where asteroids and hazards roam.
 * 
 * @author Will Threlkeld
 * @version 6/1/2020
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    private Star[] stars = new Star[100];
    Color color1 = new Color(246,250,190);
    Color color2 = new Color(255,255,255);
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        Rocket rocket = new Rocket();
        addObject(rocket, 300, 480);
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);
        star();
        prepare();      
    }
    private void star()
    {
        for(int i = 0; i < 50; i++){
            Star star;
            int deltaSpeed = Greenfoot.getRandomNumber(2);
            if(i < 17)
            {
                star = new Star(-1 - deltaSpeed, color1, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }
            if(i >= 17 && i < 35)
            {
                star = new Star(-3 - deltaSpeed, color2, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }
        }
    }
    public void act()
    {
        for(int i = 0; i < 50; i++)
        {
            if(stars[i] != null)
            {
                stars[i].move();
            }          
            if (Greenfoot.getRandomNumber(6000) < 2)
            {
                addObject(new Asteroid(), Greenfoot.getRandomNumber(600), 20);
            }            
            if (Greenfoot.getRandomNumber(25000) < 2)
            {
                addObject(new Hazard(), Greenfoot.getRandomNumber(600), 20);
            }
        }
    }
    public void updateScore(int addToScore)
    {
        scoreCounter.add(addToScore);
    }
    public void endGame()
    {
        Greenfoot.stop();
    }
    private void prepare()
    {
        
    }
}