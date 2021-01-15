/*
Ziad Malik
Section U01
NimTest.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package nim ;

import javax.swing.JOptionPane ;

/**
 * The NimTest Class is where the Player Types and Names are acquired from the
 * User/Player and using this information, the game is Played. Along with this,
 * following every game the NimTest Class will ask the User/Player if they would
 * like to run another game. If so it will run the Main Method again. If not the
 * Program is exited.
 *
 * @author Ziad Malik
 */
public class NimTest {

    /**
     * The Main Method of the NimTest Class is in charge of Gathering
     * Information Necessary to Run a game. First an array of Player Objects is
     * created which is meant to store the two different players that will play.
     * It will then Ask the User Which type of player will play first allowing
     * them to select from integers 1-3 where each integer correlates to a
     * player type. This is done using the Switch Statement. For Example, if the
     * User wants a Human to play first, they will enter 3 and from there the
     * Switch will run the case with the number of the entered integer. In this
     * case, Case 3 would run and a new Human Object would be created and would
     * be added to the Player Object Array. It will then do the same but for
     * whoever is playing second. Will then proceed to play the game by creating
     * a new Nim Object and calling the Play Method of that object and passing
     * the Players Array to the method. Finally, after the game has ran and a
     * winner has been announced, it will ask the user if they would like to run
     * the game again.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Players[] players = new Players[2] ;
        /*
        Local Variable valueOfPlayerType which is an integer is a holder for the
        integer the User enters according to which Player they would like to 
        play first. Is used within the Switch Statement to see which Type of 
        Player will be added to the Players Array first.
         */
        int valueOfPlayerType = Integer.parseInt(JOptionPane.showInputDialog(""
                + "Who is Playing "
                + "First?:\n"
                + "1. Smart Computer\n"
                + "2. Below Average Computer\n"
                + "3. Human\n"
                + "Enter Number Next to Type To Choose that Type: ")) ;

        switch (valueOfPlayerType) {
            case 1:
                players[0] = new SmartComputer() ;
                break ;
            case 2:
                players[0] = new BelowAverageComputer() ;
                break ;
            case 3:
                players[0] = new Human() ;

                break ;
        }
        /*
        Local Variable valueOfPlayerType2 which is an integer is a holder for 
        the integer the User enters according to which Player they would like to 
        play second. Is used within the Switch Statement to see which Type of 
        Player will be added to the Players Array second.
         */
        int valueOfPlayerType2 = Integer.parseInt(JOptionPane.showInputDialog(""
                + "Who is Playing "
                + "Second?:\n"
                + "1. Smart Computer\n"
                + "2. Below Average Computer\n"
                + "3. Human\n"
                + "Enter Number Next to Type To Choose that Type: ")) ;

        switch (valueOfPlayerType2) {
            case 1:
                players[1] = new SmartComputer() ;
                break ;
            case 2:
                players[1] = new BelowAverageComputer() ;
                break ;
            case 3:
                players[1] = new Human() ;
                break ;
        }
        /*
        newGame is the New Nim Object and basically where the game is played.
        Nim is Defined within the Nim Class. 
         */
        Nim newGame = new Nim() ;
        newGame.play(players) ;
        /*
        playAgain is a Local String variable which holds the value of what is
        entered by the User is regards to if they would like to play again 
        or not. If nothing is entered the Game is ended. If any number is
        entered, like it is asked, the if statement will check to see if
        that int is equal to 1. If so, the main method is run again. If not, 
        the game ends. This is because we said that any other number except
        1 means you would like to quit.
         */
        String playAgain = JOptionPane.showInputDialog("Play Again?: \n"
                + "Enter 1 For Yes or Any other Number to Quit") ;
        if (playAgain.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Thank You! Have a Good Day!",
                    "Game Over", JOptionPane.PLAIN_MESSAGE) ;

        } else {
            /*
            valueOfPlayAgain is simply the Integer version of the String the
            Player entered IF there was a number entered to begin with. If 
            nothing is entered there is no need to convert to integer as is seen
            above.
             */
            int valueOfPlayAgain = Integer.parseInt(playAgain) ;
            if (valueOfPlayAgain == 1) {
                main(null) ;
            } else {

                JOptionPane.showMessageDialog(null, "Thank You! Have a Good "
                        + "Day!",
                        "Game Over", JOptionPane.PLAIN_MESSAGE) ;

            }
        }
    }
}
