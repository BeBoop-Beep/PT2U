import java.util.Scanner;

/*
ExerciseQueue class extends abstract class ExerciseList.
ExerciseQueue is used to create a queue for the user to interact with during their exercises.
Exercise Queue declares multiple variables and String Arrays for class wide use.
*/
public class ExerciseQueue extends ExerciseList {
    Scanner scn;
    String[] queue;
    String [] copyQueue;
    int size;
    int front;
    int rear;
    int counter;

    /*
    queue is called on from Exercises class, method exerciseFile.
    queue is used as the central hub for the queuing process.
    queue prompts the user to exercise, if yes, then queue will enqueue every String within the lets_Exercise Array.
    once cued, queue will call printExercises.
    if no, queue tells user some prompts and then terminates.

    */
    public void queue(String[] lets_Exercise) {
        scn = new Scanner(System.in);
        queue = new String[lets_Exercise.length];
        for (int i = 0; i < lets_Exercise.length; i++) {
            queue[i] = lets_Exercise[i].substring(5);
        }
        System.out.println("");
        System.out.println("Shall we try these exercises together?");
        System.out.println("yes or no?");
        String response = scn.next();

        if (response.equalsIgnoreCase("yes")) {
            for (int i = 0; i < lets_Exercise.length; ++i) {
                enqueue(queue[i]);
            }

            for (int i = 0; i < lets_Exercise.length; i++) {
                printExercises(queue);
            }
        } else if (response.equalsIgnoreCase("no")) {
            System.out.println("");
            System.out.println("Please make sure to do all these exercises 1 time a day.");
            System.out.println("If your condition worsens, stop doing the exercises and see medical provider.");
            System.out.println("Thank you for using PT2U and we hope you feel better soon!");
            System.exit(0);
        } else {
            System.out.println("Invalid Response: ");
            queue(lets_Exercise);
        }
    }


    /*
    enqueue method used to create a queue of Strings for the Array lets_Exercise.
    will print Queue is full if the for loop in queue surpasses the length of let_Exercise array length.
    */
    public void enqueue(String qString) {
        size = queue.length;
        if (size == rear) {
            System.out.println("Queue is full");
        } else {
            queue[rear] = qString;
            rear++;
        }
    }

    /*
    dequeue method is called on from printExercises.
    Is used to create a new array called copyQueue which is always one less then queue.
    This will take away one String at a time from lets_Exercise ( queue) Array until there are no more String available.
    */
    public String[] dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
        } else {
            copyQueue = new String[queue.length-1];
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
                copyQueue[i] = queue[i];
            }

            if (rear < size)
                queue[rear] = "";
                rear--;
        }
        return copyQueue;
    }


    /*
    printExercises is an abstract method inherited by ExerciseList abstract class.
    This method serves a few purposes other than just printing.
    It prompts user to either continue or to terminate code (Exercising);
    If user continues it will dequeue one line then print and prompt user to keep going again or to terminate.
    If user continues through to queue.length times then the method will end and will return to main in Class PT2U.
    If user decides to terminate early then user is given some prompts and code is terminated.
    and if user gives and wrong response, then an Invalid Response message is given and printExercises is recalled.
    */
    @Override
    protected void printExercises(String[] exerciseList) {
        System.out.println("");
        System.out.println("Did you complete the top exercise?");
        System.out.println("yes or no?");
        String response1 = scn.next();

        if(response1.equalsIgnoreCase("yes")){
                System.out.println("Great Job!");
                System.out.println("");
                dequeue();
                counter = 0;
                    System.out.println("Your remaining exercises are as followed: ");
                    System.out.println("");
                for(int i = 0 ; i < copyQueue.length; i++) {
                    if(copyQueue[i] == null){
                        System.out.print("");
                    }
                    else {
                        System.out.println(copyQueue[i]);
                    }
            }
        }

        else if(response1.equalsIgnoreCase("no")){
            System.out.println("Shall we get started?");
            System.out.println("yes or no?");
            String response2= scn.next();
                if (response2.equalsIgnoreCase("yes") ){
                    printExercises(exerciseList);
                }
                else{
                    System.out.println("Please make sure to do all these exercises 1 time a day.");
                    System.out.println("If your condition worsens, stop doing the exercises and see medical provider.");
                    System.out.println("Thank you for using PT2U and we hope you feel better soon!");
                    System.exit(0);
                }
            }
        else{
            System.out.println("Invalid Response: ");
            printExercises(exerciseList);
        }
        }

    }
