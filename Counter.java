import greenfoot.*;

/**
 * Keeps track of your score.
 * 
 * 
 * @author Will Threlkeld 
 * @version 6/1/2020
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    private int target;
    private String prefix;  
    public Counter()
    {
        this(new String());
    }
    public Counter(String prefix)
    {
        background = getImage();
        value = 1000;
        target = 0;
        this.prefix = prefix;
        updateImage();
    }
    public void act() 
    {
        if (value > target) 
        {
            value--;
            updateImage();
        }
        gameOver();
    }
    public void gameOver()
    {
        if(value == target)
        {
            ((Space)getWorld()).endGame();      
        }
    }
    public void add(int score)
    {
        value += score;
    }
    public int getValue()
    {
        return target;
    }
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
