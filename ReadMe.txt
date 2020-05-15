Donald L Stivison Jr, Red ID 823412467, 5/14/20

Program PT2U is a program that will take in a users pain level and pain location. 
It will then give them exercises based on those two variabes.
After which it will have the user complete the exercises until finished.

Exercises.txt:
Is a file of currently 45 exercises not arranaged but are numbered to be arranged (at a later time).

PT2U.java:
Is the main file that initializes the code and prompts user to give pain level and pain location. 

ExerciseGeneric.java:
Is an Interface which implements generics for it's inherited class(es) to use.

ExerciseList.java:
Is an abstract class that creates a multiple of varibles and String object arrays & arrayLists for it's inherited classes to use.
It also creates an abstract method for it's inherited classes to implement as well. 

Exercises.java:
Is used to access the Exercises.txt file and begin the process of creating the exact exercises needed for the specified pain level and location.

SortExercises.java:
Used to sort the Exercise.txt file by an int value given to each String line from the file. Uses SelectionSort.

ExerciseSearch.java:
Uses binary search to look for the specified exercises in order to add it to an array of specific exercise for user to use for their specified pain and location.

ExerciseQueue.java:
Is used to create a queue of exercises and when the user performs the exercises, they are then removed from the queue one by one util all exercises are completed. 