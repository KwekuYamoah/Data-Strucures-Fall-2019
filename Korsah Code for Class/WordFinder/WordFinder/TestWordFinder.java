
public class TestWordFinder {
   public static void main(String[] args) {
    
    String wordsFileName = "text_files/galsworthy.txt";
    WordFinder[] wordFinders = new WordFinder[3];
    
    WordFinderV1 wordFinder1 = new WordFinderV1();
    // read the words in the file
    wordFinder1.readFile(wordsFileName);
    WordFinderV2 wordFinder2 = new WordFinderV2(wordFinder1.getWords());
    WordFinderV3 wordFinder3 = new WordFinderV3(wordFinder1.getWords());
    
    wordFinders[0] = wordFinder1;
    wordFinders[1] = wordFinder2;
    wordFinders[2] = wordFinder3;
    
    for (int i=0; i<wordFinders.length; i++){
      System.out.println();
      System.out.println("USING METHOD " + (i+1) + ":");
    
      // process the data
      wordFinders[i].doPreProcessing();
     
      // Find a word
      wordFinders[i].findWord("and");
      wordFinders[i].findWord("quick");
      wordFinders[i].findWord("Ghana");
    }
  } 
}