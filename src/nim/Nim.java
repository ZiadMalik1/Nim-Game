/*
Ziad Malik
Section U01
Nim.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package nim ;

import javax.swing.JOptionPane ;

/**
 * The Nim Class is in charge of Conducting the Nim Game itself. It plays the
 * game and also obtains the PileSize from the Pile Class. Also Allows the
 * Players to take turns one by one removing marbles until a winner is declared
 * within the Play Method.
 *
 * @author Ziad Malik
 */
public class Nim {

    private String winner ;//String of the Player Name who wins the current game
    private Pile newPile ;// The Pile Object used within this Nim Game

    /**
     * The Nim Constructor of the Nim Class is used to create an Object of the
     * Nim Class. In this case, the Constructor simply assigns a new Pile to the
     * new Nim Object. Since every Nim Game Should have its own unique Pile).
     */
    public Nim() {

        /*
        Instance Variable newPile Initialized to new Pile
         */
        newPile = new Pile() ;

    }

    /**
     * The Play Method is where the most crucial aspect of the program takes
     * place. The Method First Prints the amount of Marbles are within the new
     * pile that will be used within this Nim Game. Then, It runs a for Loop
     * that traverses the Players Array that was passed to it. It will First let
     * the First Element of the Array Take its turn (Since it was added first it
     * is the first Player). However, before the Player Object can take its turn
     * it will first check to see if the Element that the loop is currently on
     * is an instance of the Human Class. If so, it will notify the Human Player
     * that is playing and running the program that it is their turn. (Since
     * Humans aren't perfect). It will then call the Abstract method of the
     * Player Interface, getMarbles() for the Current Playing Object within the
     * Player array and will remove from the pile newPile, the amount of marbles
     * that player removed based on the method within their respective classes.
     * (See getMarbles() method within Respective Classes to see how the amount
     * of marbles to be removed is chosen). It then prints who just removed
     * marbles from the pile and how many they removed. It also prints how many
     * marbles are left. (The Computer Players do not need this, however, it is
     * for the Human Player so they are well-informed and have a chance of
     * winning by thinking about how many to remove based on the information).
     * If the PileSize is equal to 1 after a Player has played their turn, that
     * player Wins! Why? Well because the next player will have to remove that
     * marble and the player to remove the last marble loses! Once the if
     * statement is executed for when the pileSize is equal to 1, the loop is
     * exited and the instance variable winner is initialized to the Player that
     * won and a little Congratulations message which is later printed after the
     * loop is exited. What I explained about what the method does is exactly
     * what happens again for the second player after the first player has
     * completed their turn.
     *
     * @param players The Array Of 2 Player Objects that will Compete to win.
     */
    public void play(Players[] players) {
        /*
        removedMarbles is a holder for the amount of Marbles the Current
        Playing Player removes. It is reset to 0 after the end of each players
        turn. 
         */
        int removedMarbles ;
        System.out.println("Starting Pile Size: " + newPile.getPileSize()
                + " Marble(s)") ;
        /*
        The for loop does as was explained within the Methods Description, 
        however 1 key point that was not mentioned is that the loop will not
        exit on its own unless the pile size is equal to 0. We know that before
        that can happen, we will already have exited the loop and have announced
        the winner and ended the game.
         */
        for (int i = 0 ; newPile.getPileSize() != 0 ; i++) {

            removedMarbles = 0 ;

            if (players[0] instanceof Human) {
                JOptionPane.showMessageDialog(null, players[0].getName()
                        + " You're Up!",
                        "New Turn", JOptionPane.PLAIN_MESSAGE) ;
            }

            removedMarbles = players[0].getMarbles(newPile.getPileSize()) ;

            newPile.removeMarbles(removedMarbles) ;

            System.out.println(players[0].getName() + " Removed: "
                    + removedMarbles
                    + " Marbles\n" + newPile.getPileSize()
                    + " Marble(s) Left") ;

            if (newPile.getPileSize() == 1) {

                winner = "\nCongrats "
                        + players[0].getName() + "! You Win!" ;
                break ;
            }

            //Now Lets the Second Player Have Their Turn
            removedMarbles = 0 ;

            if (players[1] instanceof Human) {
                JOptionPane.showMessageDialog(null, players[1].getName()
                        + " You're Up!",
                        "New Turn", JOptionPane.PLAIN_MESSAGE) ;
            }

            removedMarbles = players[1].getMarbles(newPile.getPileSize()) ;

            newPile.removeMarbles(removedMarbles) ;

            System.out.println(players[1].getName() + " Removed: "
                    + removedMarbles
                    + " Marbles\n" + newPile.getPileSize()
                    + " Marble(s) Left") ;

            if (newPile.getPileSize() == 1) {

                winner = "\nCongrats "
                        + players[1].getName() + "! You Win!" ;
                break ;
            }

        }

        System.out.println(winner) ;

    }
    /**
     * This Method is used to print a more User friendly String that shows 
     * the user how many Marbles are left. Instead of just calling the
     * getPileSize() method and throwing some random number at the user, which
     * will confuse them, This method is called that tells the Used that 
     * the newPile Size Marbles are Left. Also created to avoid Code 
     * Repetition. 
     */
    public void printPileSize() {

        System.out.println(newPile.getPileSize() + " Marbles") ;

    }

}
