import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;

/** 
 * Reads in a file with words
 */
public class WordFinderV3b implements WordFinder {
 
  public static final int MAX_WORDS = 1000000;
  public static final double MILLION = 1000000;
  public static final int REPEAT = 10000;
  private HashSet<String> words;
  private int numWords;
  
  public WordFinderV3b(){
    words = new HashSet<String>();
    numWords = 0;
  }
  
  public WordFinderV3b(String[] inputWords) {
    words = new HashSet<String>();
    for (int i=0; i<inputWords.length; i++){
      words.add(inputWords[i]);
    }
  }
  
  public HashSet<String> getWords(){
    return words;
  }

  public boolean readFile(String fileName){
    long startTime, endTime;
    double duration;
    
    startTime = System.nanoTime();
    
    File file = new File(fileName);
    Scanner fileInput = null;
    try {
      fileInput = new Scanner(file);
    }
    catch (FileNotFoundException e) {
      System.out.println("Error opening the file: " + fileName);
      return false;
    }
    
    // read the contents of the file
    String word;
    while (fileInput.hasNext() && numWords < MAX_WORDS){
      words.add(fileInput.next());
      numWords++;
    }
    
    endTime = System.nanoTime();
    duration = (endTime - startTime)/MILLION;
    
    System.out.print("FYI: Read " + numWords + " words.");
    if (fileInput.hasNext())
      System.out.print("..and there are still more!");
    System.out.println();
    
    System.out.println("Reading '" + fileName + "' took " + duration + " ms.");
    return true;
  }

  public void doPreProcessing(){
    long startTime, endTime;
    double duration;
    
    startTime = System.nanoTime();
        
    endTime = System.nanoTime();
    duration = (endTime - startTime)/MILLION;
    
    System.out.println("Pre-processing took " + duration + "ms.");
  }
  
  public boolean findWord(String wordToFind){
    boolean found = false;
    long startTime, endTime;
    double duration;
    
    startTime = System.nanoTime();
    for (int i=0; i<REPEAT; i++)
      found = words.contains(wordToFind);
    endTime = System.nanoTime();
    duration = (endTime - startTime)/MILLION;
    
    System.out.print("Searching for '" + wordToFind + "' " + REPEAT +
                     " times took " + duration + " ms.");

    if (found)
      System.out.println(" ... found it.");
    else
      System.out.println(" ... did not find it.");
    
    return found;
  }
}