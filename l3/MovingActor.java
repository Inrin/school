import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Abstrakte Klasse MovingActor stellt Basisfunktionalität zur Verfügung, die jedem bewegbaren Actor zu Grunde liegt.
 * 
 * @author (Thomas Karp) 
 * @version (1.0)
 */
public abstract class MovingActor extends Actor
{
    /**
     * Richtungskonstanten: Norden: 0, Osten: 1; Süden: 2, Westen: 3
     */
    // public wäre eigentlich besser, aber ich möchte nicht, dass wir am Anfang
    // beim Lesen der Dokumentation mit static final in Berührung kommen.
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;        
    private static final int WEST = 3;
    
    // Instanzvariablen
    private int direction;
    private GreenfootImage imageRight;
    private GreenfootImage imageLeft;

    /**
     * Konstruktor für Anfangswerte.
     * Startrichtung ist Osten
     */
    public MovingActor()
    {
        // Bilder für rechts-links festlegen
        imageRight = getImage();
        imageLeft = new GreenfootImage(getImage());
        imageLeft.mirrorHorizontally();
        // Startwert für die Richtung
        setDirection(EAST);
    } 
    
    /**
     * Gehe einen Schritt nach vorne.
     * Falls dies nicht möglich ist, bleibe stehen.
     */
    public void move()
    {
        if (!canMove()) {
            return;
        }
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }    
    
    /**
     * Prüft, ob das MovingActor-Objekt in der aktuellen Richtung gehen kann.
     * Überprüft dabei nur, ob es am Ende der Welt angekommen ist.
     * @return true, wenn das Objekt gehen kann, sonst false
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // test for outside border
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        return true;
    }
    
    /**
     * Nach links drehen.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }
    
    /**
     * Nach rechts drehen.
     */
    public void turnRight()
    {
        switch(direction) {
            case SOUTH :
                setDirection(WEST);
                break;
            case EAST :
                setDirection(SOUTH);
                break;
            case NORTH :
                setDirection(EAST);
                break;
            case WEST :
                setDirection(NORTH);
                break;
        }
    }    

    /**
     * Legt die Richtung fest.
     * 0: Norden, 1: Osten, 2: Süden, 3: Westen
     */
    public void setDirection(int direction)
    {
        this.direction = direction;
        switch(direction) {
            case SOUTH :
                setRotation(90);
                setImage(imageRight);                
                break;
            case EAST :
                setRotation(0);
                setImage(imageRight);
                break;
            case NORTH :
                setRotation(90);
                setImage(imageLeft);                
                break;
            case WEST :
                setRotation(0);
                setImage(imageLeft);                
                break;
            default :
                break;
        }
    } 
}
