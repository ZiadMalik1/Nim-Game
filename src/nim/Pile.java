/*
Ziad Malik
Section U01
Pile.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package nim ;

import java.util.Random ;

/**
 * The Pile Class is in Charge of keeping track of the Current Games Pile. it
 * also is where the Pile itself is created which is used throughout the game
 *
 * @author Ziad Malik
 */
public class Pile {

    /*
    The Only Instance Variable within the class is the pileSize Integer which
    is initialized within the Constructor where the Size becomes some random
    number between 20 and 95. This variable is used to track the Pile's Size 
     */
    private int pileSize = 0 ;

    /**
     * The Pile Class Constructor Initializes the pileSize of the new Pile to
     * some random Integer between 20 and 95.
     */
    public Pile() {
        /*
        New Random Number Generator Used to acquire a random Integer to set the
        new Pile's Size to. 
         */
        Random gen = new Random() ;
        pileSize = gen.nextInt(76) + 20 ;

    }

    /**
     * The getPileSize Method simply is an accessor for all classes not the Pile
     * Class to the pileSize of some Pile Object that has been Created.
     *
     * @return Returns the Size of the Pile Object.
     */
    public int getPileSize() {

        return pileSize ;

    }

    /**
     * The Method removeMarbles is used to remove Marbles from the Pile when a
     * Player wishes to remove Marbles from the Pile in order to try to win. The
     * Method takes the Amount of marbles the caller wishes to remove and sets
     * the pileSize to that amount of marbles subtracted from the current
     * pileSize.
     *
     * @param howMany Is the amount of Marbles the caller/player wishes to
     * remove from the pile.
     */
    public void removeMarbles(int howMany) {

        pileSize = pileSize - howMany ;

    }

}
