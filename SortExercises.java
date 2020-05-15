/*
SortExercises class created to use a selection sort for "Exercise.txt" file.
*/
public class SortExercises {

    /*
    selectionSortExercises performs the selection sort of the substring(0,3) of ptArr from method exerciseFile Class Exercises.
    This exact subString is used because each line in file is numbered and those numbers are compared to put the file in
    an order that will have the same exercises next to one another.
    */
    public static void selectionSortExercises (String [] exercises) {
        String [] numberVal = new String[exercises.length];
        for(int i = 0; i < exercises.length; i++ ){
            numberVal[i] = exercises[i].substring(0,3);
        }

        for (int i = 1; i < numberVal.length; i++) {
            int current = Integer.parseInt(numberVal[i]);
            String replace = exercises[i];
            int j = i - 1;
            while (j >= 0 && current < Integer.parseInt(numberVal[j])) {
                exercises[j + 1] = exercises[j];
                numberVal[j + 1] = numberVal[j];
                j--;
            }
            numberVal[j + 1] = String.valueOf(current);
            exercises[j + 1] = replace;
        }



    }
}

