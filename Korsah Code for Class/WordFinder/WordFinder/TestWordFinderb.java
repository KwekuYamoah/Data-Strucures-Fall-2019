
public class TestWordFinderb {
   public static void main(String[] args) {
    
    String wordsFileName = "text_files/austen-emma.txt";
    //String wordsFileName = "text_files/bible.txt";
    //String wordsFileName = "text_files/galsworthy.txt";
    
    WordFinder[] wordFinders = new WordFinder[3];
    
    WordFinderV1b wordFinder1 = new WordFinderV1b();
    // read the words in the file
    wordFinder1.readFile(wordsFileName);
    
    WordFinderV2b wordFinder2 = new WordFinderV2b(wordFinder1.getWords());
    WordFinderV3b wordFinder3 = new WordFinderV3b(wordFinder1.getWords());
    
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