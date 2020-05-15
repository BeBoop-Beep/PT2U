import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
Exercises class both extends abstract class ExerciseList and implements Interface ExerciseGeneric.
Exercises class creates 3 class wide objects: lets_Exercise, search, and sort (used later).
*/
public class Exercises extends ExerciseList implements ExerciseGeneric{
    ExerciseQueue lets_Exercise = new ExerciseQueue();
    ExerciseSearch search = new ExerciseSearch();
    SortExercises sort = new SortExercises();


    /*
   exerciseFile is called from main class method painLocation giving parameters String painLocation and String pain.
   Both Strings are received as Objects painLoc and Object pain (respectively).
   exerciseFile is an Overridden method from the Interface ExerciseGeneric.
   A try and catch is used in this method due to creating a File object exerciseFile from "Exercise.txt".
   While loop will read one String line at a time and give each String to String exercises(created in the abstract method).
   Once complete, ptExercises ArrayList is converted into an Array ptArr. Then ptArr is sent to SortExercises class method
   selectionSortExercise by object sort.
   Once sorted, painLocation and pain are sent to separateExercises method within Exercises.
   If file was not read correctly, IOException is caught.
   */
    @Override
    public void exerciseFile(Object painLoc, Object pain) {
        Integer painLocation = (Integer)painLoc;
        try {
            File exerciseFile = new File("Exercises.txt");
            Scanner scn = new Scanner(exerciseFile);

            while (scn.hasNextLine()) {
                int i = 0;
                exercises = scn.nextLine();
                ptExercises.add(exercises);
            }
            ptArr = new String[ptExercises.size()];
            int index = 0;
            for (Object value : ptExercises) {
                ptArr[index] = (String) value;
                index++;
            }
            sort.selectionSortExercises(ptArr);
            separateExercises(painLocation, pain);
        }
        catch (IOException e) {
            System.out.println("ERROR: File cannot be found");
        }
    }


    /*
      separateExercises locates the correct array of lines of exercises for the users pain and location (9 possible outcomes).
      All outcomes perform the same sequence of functions.
      After locating correct array, exerciseSearch method from ExerciseSearch Class is called from Object search to
      perform a binary search.
      Once returned, printExercises method is called.
      After printExercises, queue method of ExerciseQueue class is called.
    */
    public void separateExercises(Integer painLocation, Object pain) {
        if (painLocation == 1) {
            if (pain == "high") {
                int[] count = {31, 32, 33, 34, 35};
                for (int i = 0; i < count.length; i++) {
                    key = count[i];
                    last = ptArr.length - 1;
                    int result = search.exerciseSearch(ptArr, first, last, key);

                    if (result == -1) {
                        System.out.println("Element is not found");
                    } else {
                        highArr.add(ptArr[result]);
                    }
                }
                String [] copyList = new String[highArr.size()];
                int index = 0;
                for (Object value : highArr) {
                    copyList[index] = (String) value;
                    index++;
                }
                printExercises(copyList);
                lets_Exercise.queue(copyList);
            }
            else if (pain == "medium") {
                int[] count = {36, 37, 38, 39, 40};
                for (int i = 0; i < count.length; i++) {
                    key = count[i];
                    last = ptArr.length - 1;
                    int result = search.exerciseSearch(ptArr, first, last, key);

                    if (result == -1) {
                        System.out.println("Element is not found");
                    } else {
                        mediumArr.add(ptArr[result]);
                    }
                }
                String [] copyList = new String[mediumArr.size()];
                int index = 0;
                for (Object value : mediumArr) {
                    copyList[index] = (String) value;
                    index++;
                }
                printExercises(copyList);
                lets_Exercise.queue(copyList);
            }
            else if (pain == "low") {
                int[] count = {41, 42, 43, 44, 45};
                for (int i = 0; i < count.length; i++) {
                    key = count[i];
                    last = ptArr.length - 1;
                    int result = search.exerciseSearch(ptArr, first, last, key);

                    if (result == -1) {
                        System.out.println("Element is not found");
                    } else {
                        lowArr.add(ptArr[result]);

                    }
                }
                String [] copyList = new String[lowArr.size()];
                int index = 0;
                for (Object value : lowArr) {
                    copyList[index] = (String) value;
                    index++;
                }
                printExercises(copyList);
                lets_Exercise.queue(copyList);
            }
        }
         else if (painLocation == 2) {
             if (pain == "high") {
                 int[] count = {16, 17, 18, 19, 20};
                 for (int i = 0; i < count.length; i++) {
                     key = count[i];
                     last = ptArr.length - 1;
                     int result = search.exerciseSearch(ptArr, first, last, key);

                     if (result == -1) {
                            System.out.println("Element is not found");
                     } else {
                            highArr.add(ptArr[result]);

                     }
                 }
                 String [] copyList = new String[highArr.size()];
                 int index = 0;
                 for (Object value : highArr) {
                     copyList[index] = (String) value;
                     index++;
                 }
                 printExercises(copyList);
                 lets_Exercise.queue(copyList);
             }
             else if (pain == "medium") {
                 int [] count = {21, 22, 23, 24, 25};
                 for(int i = 0; i < count.length; i++) {
                     key = count[i];
                     last = ptArr.length - 1;
                     int result = search.exerciseSearch(ptArr, first, last, key);

                     if (result == -1) {
                         System.out.println("Element is not found");
                     } else {
                         mediumArr.add(ptArr[result]);

                     }
                 }
                 String [] copyList = new String[mediumArr.size()];
                 int index = 0;
                 for (Object value : mediumArr) {
                     copyList[index] = (String) value;
                     index++;
                 }
                 printExercises(copyList);;
                 lets_Exercise.queue(copyList);
             }
             else if (pain == "low") {
                 int[] count = {26, 27, 28, 29, 30};
                 for (int i = 0; i < count.length; i++) {
                     key = count[i];
                     last = ptArr.length - 1;
                     int result = search.exerciseSearch(ptArr, first, last, key);

                     if (result == -1) {
                         System.out.println("Element is not found");
                     } else {
                         lowArr.add(ptArr[result]);

                     }
                 }
                 String [] copyList = new String[lowArr.size()];
                 int index = 0;
                 for (Object value : lowArr) {
                     copyList[index] = (String) value;
                     index++;
                 }
                 printExercises(copyList);
                 lets_Exercise.queue(copyList);
             }
        }
         else if (painLocation == 3) {
             if (pain == "high") {
                 int [] count = {1, 2, 3, 4, 5};
                 for(int i = 0; i < count.length; i++) {
                     key = count[i];
                     last = ptArr.length - 1;
                     int result = search.exerciseSearch(ptArr, first, last, key);

                     if (result == -1) {
                         System.out.println("Element is not found");
                     } else {
                         highArr.add(ptArr[result]);
                     }
                 }
                 String [] copyList = new String[highArr.size()];
                 int index = 0;
                 for (Object value : highArr) {
                     copyList[index] = (String) value;
                     index++;
                 }
                 printExercises(copyList);
                 lets_Exercise.queue(copyList);
             }
             else if (pain == "medium") {
                 int [] count = {6, 7, 8, 9, 10};
                 for(int i = 0; i < count.length; i++) {
                     key = count[i];
                     last = ptArr.length - 1;
                     int result = search.exerciseSearch(ptArr, first, last, key);

                     if (result == -1) {
                         System.out.println("Element is not found");
                     } else {
                         mediumArr.add(ptArr[result]);

                     }
                 }
                 String [] copyList = new String[mediumArr.size()];
                 int index = 0;
                 for (Object value : mediumArr) {
                     copyList[index] = (String) value;
                     index++;
                 }
                 printExercises(copyList);
                 lets_Exercise.queue(copyList);
             }
             else if (pain == "low") {
                 int [] count = {11, 12, 13, 14, 15};
                 for(int i = 0; i < count.length; i++) {
                     key = count[i];
                     last = ptArr.length - 1;
                     int result = search.exerciseSearch(ptArr, first, last, key);

                     if (result == -1) {
                         System.out.println("Element is not found");
                     } else {
                         lowArr.add(ptArr[result]);

                     }
                 }
                 String [] copyList = new String[lowArr.size()];
                 int index = 0;
                 for (Object value : lowArr) {
                     copyList[index] = (String) value;
                     index++;
                 }
                 printExercises(copyList);
                 lets_Exercise.queue(copyList);
             }
         }
    }


    /*
    printExercises is an overridden abstract method from the abstract class ExerciseList.
    printExercises is prompted by separateExercises, to print out the exact exercises for the user based on their
    pain and painLocation.
    printExercises prints out a subString to take out the numbers given to exercises in "Exercises.txt" as they are not necessary
    for user to see.
    */
    @Override
    public void printExercises(String [] exerciseList) {
        String [] printing = new String[exerciseList.length];
        for(int i = 0; i< exerciseList.length; i++){
            printing[i] = exerciseList[i].substring(5);
        }
        System.out.println("Here are some recommended exercises for you and your current pain level:");
        System.out.println("");
        for(Object printExercise : printing){
            System.out.println(printExercise);

        }

    }
}


