import java.util.ArrayList;

/*
  abstract class ExerciseList declares multiply global ArrayLists of type String, a global String, a gobal String array,
  and global ints for its inherited classes to use.
*/
public abstract class ExerciseList {
    ArrayList<String> ptExercises;
    String exercises;
    ArrayList<String> highArr;
    ArrayList<String> mediumArr;
    ArrayList<String> lowArr;
    String [] ptArr;
    int first;
    int last;
    int key;

    /*
    Constructor used to initialize all the globals declared under the abstract class.
    */
    public ExerciseList(){
        ptExercises = new ArrayList<>();
        exercises = "";
        highArr = new ArrayList<>();
        mediumArr = new ArrayList<>();
        lowArr = new ArrayList<>();
        first = 0;
        last = 0;
        key = 0;
    }


    /*
    Constructor used to initialize all the globals declared under the abstract class (only if a String value was used
    when referring ExerciseList).
    */
    public ExerciseList(String exercises){
        ptExercises = new ArrayList<>();
        this.exercises = exercises;
    }


    // abstract method created for inherited classes to use.
    protected abstract void printExercises(String[] exerciseList);
}
