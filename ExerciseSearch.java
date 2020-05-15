/*
ExerciseSearch is used to binarySearch through ptArr Array given from exerciseFile method from Exercises class.
*/
public class ExerciseSearch{

    /*
    exerciseSearch method performs the binary search prompted by exerciseFile method from Exercises Class.
    Just like sortExercise, exerciseSearch uses the substring(0,3) of ptExercises (ptArr Array given from exerciseFile)
    in order to compare the exercises.
    During this binarySearch, recursion is used to cycle through until key is found.
    Once the base case is found (which is the key value) then all four variables are returned to Exercises class to
    exerciseFile method.
    */
    public static int exerciseSearch(String[] ptExercises, int first, int last, int key) {
        String [] numberVal = new String[ptExercises.length];

        for(int i = 0; i < ptExercises.length; i++ ){
            numberVal[i] = ptExercises[i].substring(0,3);
        }

        int [] exercises = new int[numberVal.length];
        for(int i = 0; i < numberVal.length; i++){
            exercises[i] = Integer.valueOf(numberVal[i]);
        }

       if(last >= first){
           int mid = first + (last - first)/2;
           if(exercises[mid] == key){
               return mid;
           }
           if (exercises[mid] > key){
               return exerciseSearch(ptExercises ,first, mid-1, key);
           }
           else{
               return exerciseSearch(ptExercises, mid+1, last, key);
           }
        }
       return -1;

    }
    }

