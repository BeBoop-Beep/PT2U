import java.io.IOException;
import java.util.Scanner;


/*
Public PT2U class is the main class of the program.
Static variables declared as private class wide variables for PT2U.
*/
public class PT2U {
    private static Exercises list;
    private static String pain;
    private static Scanner scn;
    private static int flag;
    private static Integer painLvl;
    private static int painLocation;
    private static boolean redo;


    /*
    main initializes the PT2U and prompts user for input of type String for pain level.
    main takes pain level and makes sure that the response is an int value of type String by the try/ catch functions.
    If successful, then main transfers function to painReceiver method. Else tells user invalid response and closes program.
    When program has finished main will print out a final response for user.
    */
    public static void main(String [] args) throws IOException, NullPointerException {
        scn = new Scanner(System.in);
            System.out.println("Please choose a number for your pain from 0-10 (0 being none and 10 being the most extreme): ");

        try {

            painLvl = Integer.valueOf(scn.nextInt());
        }
        catch(NumberFormatException n){
            System.out.println("INVALID ENTRY: Please try again!");

        }
        redo = true;
        painReceiver(painLvl);

            if (painLvl != 10 ) {
                System.out.println("You are finished, Please continue to do your exercises 1 time a day.");
                System.out.println("If your condition worsens, stop doing the exercises and see medical provider.");
                System.out.println("Thank you for using PT2U and we hope you feel better soon!");
            }
        }

    /*
    painReceiver checks to make sure painLvl received from users response to the 1st prompt in main is a correct int value of type String.
    If correct, painReceiver gives that value of painLvl a pain String with the String of "high," "medium," or "low" depending on painLvl's value.
    After giving the number pain a generic pain String, painLocation method is called.
    If painLvl value of type String is not within desired parameters then and Invalid response message is given to user to attempt value again
    by calling painReceiver again.
    */
    public static void painReceiver(Integer location) throws IOException{
    if(redo == false){
        painLvl = Integer.valueOf(location);
    }
        if (painLvl <= 10 && painLvl >= 0) {
            if (painLvl == 10) {
                System.out.println("These exercises may not be suitable for your current condition at this time. Please contact your medical provider or urgent care ASAP.");
            } else if (painLvl > 6 && painLvl < 10) {
                pain = "high";
                painLocation();
            } else if (painLvl > 3 && painLvl <= 6) {
                pain = "medium";
                painLocation();
            } else {
                pain = "low";
                painLocation();
            }
        } else {
            System.out.println("INVALID ENTRY: Please choose a number for your pain from 0-10 (0 being none and 10 being the most extreme): ");
            redo = false;
            painReceiver(painLocation);
        }

    }

    /*
    painLocation creates a scanner to take in some value from user and creates an object of list type Exercises.
    flag is used to re-prompt user on pain location if they entered an invalid value.
    painLocation is used to take in a int value of Type String from user based on their corresponding pain Location.
    try and catch functions are utilized in case user types in any non-int value.
    If a non-int value comes in from user then an Invalid Entry will prompt them and painLocation method will be recalled.
    flag is incremented before recalling to make sure they are prompt on the question again and then flag reset to 0.
    If user uses correct response, then method exerciseFile of Exercises is called with parameters String painLocation and String pain.
   */
    public static void painLocation() throws IOException {
        scn = new Scanner(System.in);
        list = new Exercises();


        if (flag == 0) {
            System.out.println("Where is your current pain located? ");
            flag =0;
        }
        System.out.println("Please select from the following corresponding numbers: ");
        System.out.println("1 Lower Back");
        System.out.println("2 Shoulder");
        System.out.println("3 Knee");
        try {
            painLocation = Integer.parseInt(scn.next());
        } catch(NumberFormatException n){
        System.out.println("INVALID ENTRY: Please try again!");
        System.out.println("");
            flag++;
        painLocation();

    }

        if (painLocation <=3 && painLocation>=0){

                    list.exerciseFile(painLocation, pain);

        }
        else{
            System.out.println("Invalid entry:  ");
            flag ++;
            painLocation();
        }
    }
    
}
