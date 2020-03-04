import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

/** 
 * Reads in a file with words
 */
public class WordFinderV2 implements WordFinder {
 
  public static final int MAX_WORDS = 1000000;
  public static final double MILLION = 1000000;
  private String[] words;
  private int numWords;
  
  public WordFinderV2(){
    words = new String[MAX_WORDS];
    numWords = 0;
  }
  
  public WordFinderV2(String[] inputWords) {
    words = new String[inputWords.length];
    for (int i=0, j=0; i<words.length; i++, j++){
      if (inputWords[i] != null){
        words[j] = inputWords[i];
        numWords++;
      }
    }
  }
  
  public String[] getWords(){
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
      words[numWords] = fileInput.next();
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
    Arrays.sort(words,0,numWords-1);    
    endTime = System.nanoTime();
    duration = (endTime - startTime)/MILLION;
    
    System.out.println("Pre-processing took " + duration + "ms.");
  }
  
  public boolean findWord(String wordToFind){
    int foundIndex;
    long startTime, endTime;
    double duration;
    
    startTime = System.nanoTime();
    foundIndex = StringArraySearch.binarySearch(wordToFind, words, numWords);
    endTime = System.nanoTime();
    duration = (endTime - startTime)/MILLION;
    
    System.out.print("Searching for '" + wordToFind + "' took " +
                       duration + " ms.");
    if (foundIndex != -1)
      System.out.println(" ... found it.");
    else
      System.out.println(" ... did not find it.");
    
    return (foundIndex != -1);
  }
}