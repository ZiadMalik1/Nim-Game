/*
Ziad Malik
Section U01
Players.java
I affirm that this program is entirely my own work 
and none of it is the work of any other person.
 */
package nim ;

import javax.swing.JOptionPane ;
import java.util.Random ;

/**
 *
 * The Players Interface is where the abstract Methods for All Player Type
 * Objects are Defined. Within Our Interface, we Have two methods. The First one
 * being getMarbles(int remainingMarbles) which takes into account the amount of
 * marbles left and returns the amount the Player type takes. The second being
 * the String getName() Method that returns the name of the Player Object.
 *
 * @author Ziad Malik
 */
public interface Players {

    /*
    Method to Find how many Marbles the Player takes
     */
    int getMarbles(int remainingMarbles) ;

    String getName() ;// Method that returns the Name of the Player Object

}

/**
 * The Human Class is the Class that Implements the "Human" Player of the Game.
 * It is also in charge of Creating the Human Player Objects and keeping track
 * of things such as the amount of marbles the Human Player Takes and also the
 * name of the Human Player.
 *
 * @author Ziad Malik
 */
class Human implements Players {

    /*
    The Name of the Human Player, Initialized Interactively and 
    returned by getName()
     */
    private String name ;

    /**
     * Constructor for the Human Class asks the User Interactively what the name
     * of the new Human Player Object will be. That is the only Instance
     * Variable assigned to every Human Player Object.
     */
    public Human() {

        name = JOptionPane.showInputDialog("Enter The Name Of The Human: ") ;
    }

    /**
     * The getMarbles() Method for the Human works as follows. The Method will
     * first ask the User how many Marbles they would like to remove. This is
     * because the Human Object is an Object that represents the Human running
     * the Game. Therefore, the Human Object will remove only what the Human
     * Desires. However, Following the rules is mandatory. And according to the
     * Rules, You must take at least 1 Marbles and no more than half. So, Once
     * the User enters the amount of Marbles they want to remove, the Method
     * throws an error message until the User enters an acceptable amount. That
     * way, if they enter an unacceptable amount twice, they cannot get away
     * with it. Once an acceptable amount is entered, it is returned to the
     * caller of the Method.
     *
     * @param remainingMarbles
     * @return Returns the Acceptable Number of Marbles that the User Entered to
     * Remove.
     */
    public int getMarbles(int remainingMarbles) {

        /*
        int value1 is a local variable of the method getMarbles() that serves
        only as a holder for the value the User enters to indicate how many
        marbles they would like to remove from the pile. It is used to compare
        to the pile size and see if the entered number is acceptable.
         */
        int value1 = Integer.parseInt(JOptionPane.showInputDialog("Enter The "
                + "Amount of Marbles You Would Like to Remove: ")) ;

        while (value1 > (remainingMarbles / 2) || value1 == 0) {

            JOptionPane.showMessageDialog(null, "Sorry, You must "
                    + "remove between 1 and " + remainingMarbles / 2
                    + " Marbles", "Don't Cheat!",
                    JOptionPane.PLAIN_MESSAGE) ;
            value1 = Integer.parseInt(JOptionPane.showInputDialog("Enter The "
                    + "Amount of Marbles You Would Like to Remove: ")) ;

        }
        return value1 ;
    }

    /**
     * The String method getName() Simply Returns the Initialized Instance
     * Variable name of the Human Object. AKA Returns the name of the Human
     * Player Object
     *
     * @return Returns the name of the Human Player Object which is a String.
     */
    public String getName() {

        return name ;
    }

}

/**
 * The BelowAverageComputer Class is the Class that Implements the "Stupid"
 * Player of the Game. It is also in charge of Creating the BelowAverageComputer
 * Player Objects and keeping track of things such as the amount of marbles the
 * BelowAverageComputer Player Takes and also the name of the
 * BelowAverageComputer Player.
 *
 * @author Ziad Malik
 */
class BelowAverageComputer implements Players {

    /*
    The Name of the BelowAverageComputer Player, Initialized Interactively and 
    returned by abstract method getName()
     */
    private String name ;

    /**
     * Below is the Constructor for the BelowAverageComputer Class. Like the
     * Human Class all it does is Interactively initialize the instance Variable
     * name to whatever the User decides to name the Player. That is all.
     */
    public BelowAverageComputer() {

        name = JOptionPane.showInputDialog("Enter The Name Of The Below "
                + "Average Computer: ") ;
    }

    /**
     * The getMarbles Method for the BelowAverageComputer serves as the
     * Algorithm for removing marbles for the BelowAverageComputer Object.
     * Within this method, since it is a BelowAverageComputer, it picks a random
     * generated Integer between 1 and Half the size of the Pile (Inclusive) and
     * uses that number to indicate how many marbles the BelowAverageComputer
     * Object will remove from the pile.
     *
     * @param remainingMarbles
     * @return Returns the Random int the Method Computes and returns it as the
     * number of Marbles the BelowAverageComputer Will Remove.
     */
    public int getMarbles(int remainingMarbles) {

        Random gen = new Random();//New Random Generator, Used to get Random Int
        return ((gen.nextInt(remainingMarbles / 2)) + 1) ;

    }

    /**
     * The getName() Method for the BelowAverageComputer works the Same as the
     * one in the Human Class. It simply returns the Instance Variable name of
     * the Object that was initialized within the Constructor of the class by
     * the User Interactively when the Object was made.
     *
     * @return Returns the Name of the BelowAverageComputer in the form of a
     * String
     */
    public String getName() {

        return name ;
    }

}

/**
 * The SmartComputer Class is the Most Complex of all By Far. This Class
 * implements and keeps track of the SmartComputer Player Objects that are used
 * within the Game. Within it we have the two abstract methods that Override the
 * methods of the Interface, and through this we have a class that can act as a
 * "Player". Keeps track of name and also contains algorithm for how Smart
 * Computer Player Objects Remove Marbles in order to win.
 *
 * @author Ziad Malik
 */
class SmartComputer implements Players {

    /*
    Instance Variable for Name which is Initialized Interactively 
    through the Constructor.
     */
    private String name ;
    /*
    Random Generator Object which is used only if the SmartComputer cannot
    carry out its Set Algorithm for removing Marbles. Which like professor said
    is if the remaining Pile Size is a power of 2 - 1 and Removing Marbles to 
    get to the next Power of 2 -1 is more than half. Example: 31 Marbles Left,
    Cannot Remove 16 to get to 15, there remove random number of marbles within
    the restriction instead. 
     */
    Random gen = new Random() ;

    /**
     * The Constructor of the SmartComputer Class acts the same as the
     * Constructors of the Human Class and the BelowAverageComputer Class. It
     * Simply Initializes the only Instance Variable of the Class "name" to
     * whatever the User wishes to name that Player Object. Interactively. That
     * is all.
     */
    public SmartComputer() {

        name = JOptionPane.showInputDialog("Enter The Name Of The Smart "
                + "Computer: ") ;
    }

    /**
     * The Method getName Within the SmartComputer Class Simply Returns the
     * Instance Variable "name" of the Object. This Method is the same for the
     * other two types of Players as it is just an accessor for the Objects Name
     *
     * @return Returns the name of the SmartComputer Object
     */
    public String getName() {

        return name ;
    }

    /*
    This Method is used to Help the getMarbles method within the SmartComputer
    Class. What it is Responsible for is checking to see if the value passed to
    it is a Power of 2. How does it do this. We use the Math Class and take 
    the Log of the Number Passed and Divide it by the Log of 2. If you remember
    some pre-calculus, you would remember that Log Base 2 of a number is the 
    same as Log of that number divided by Log of 10. (Default Base is 10). If
    and only if the retured double does not contain any decimals or
    the Double Divided by 1 contains no remainer.(It is an exact power of 2) 
    will the Boolean that is returned by the method be True.
     */
    private boolean isFound(int remaingingMarbles) {

        return (Math.log(remaingingMarbles) / Math.log(2)) % 1 == 0 ;

    }

    /**
     * The getMarbles Method of the SmartComputer is the Most Complex Part Of
     * the Game. The Smart Computer must remove marbles until a power of 2 - 1
     * is left over. However, it cannot remove more than half or less than 1. So
     * This getMarbles() method takes into account all these steps and
     * restrictions.
     *
     * @param remainingMarbles //Takes into Account how many marbles are
     * currently within the Pile.
     * @return Returns The Amount of Marbles the Smart Computer Object ended up
     * Removing.
     */
    public int getMarbles(int remainingMarbles) {

        /*
        Counter Used to keep track of how many marbles the SmartComputer has
        removed within his turn.
         */
        int Counter = 0 ;

        /*
        Local Variable "holder" Serves as a holder for the Intial Pile Size.
        This is used to check if the SmartComputer has removed half the amount
        of this current size. If so, It is also used to create a random number
        between 1 and this holders value which is the current pile size entered
        into the method.
         */
        int holder = remainingMarbles ;
        /*
        This While Loop Within the getMarbles() Method is the Algorithm for
        how the SmartComputer ensures it leaves a Pilesize of a power of 2 - 1.
        First, it checks to see if the Current Remaining Pile Size is a power of
        2, if so the While Loop Breaks and Counter is initialized and returned.
        (1 Marble Removed to Leave Power of 2 - 1). However, if the Current 
        Pile Size is not a power of 2, it will remove 1 marble and check to see
        if it has removed half the amount of marbles within the current pile. 
        If it has, then it Stops and instead of removing that amount it instead 
        ends up removing a random number between 1 and half the current pile 
        size.This is because, the method has to remove one more marble in the 
        end, which would be more than half which is not allowed. However, if it 
        has not removed more than half it will keep removing and checking if the
        left over amount is a power of 2. When it obtains a power of 2 within 
        the pile, it will remove exactly 1 more to leave a Power of 2 - 1 to 
        ensure victory.
         */
        while (!isFound(remainingMarbles)) {
            remainingMarbles-- ;//Removes a marble if not power of 2 yet.
            Counter++ ;//Counter for how many marbles have been removed.
            /*
            You Might be thinking, How come the Smart Computer cannot remove 
            half the amount of the pile? Well Because the Smart computer will
            never want to stop at half, it will want to continue as there is
            no power of 2 - 1 that can be reached by subtracting half of another 
            power of 2 - 1. Example, 31: The SmartComputer Will want to get to
            15, However that entails removing 16, Which is more than half, 
            Therefore once the Counter reaches 15 it stops for it knows it will
            try to remove one more, therefore it returns a random int between
            1 and the Initial Entered Pile Size instead. 
             */
            if (Counter == ((holder) / 2)) {
                return ((gen.nextInt(holder / 2)) + 1) ;
            }
        }
        return ++Counter ; //Returns one more than the number of moves down to 
        //get the pile to a power of 2 in order to leave a power of 2 - 1.
    }

}
