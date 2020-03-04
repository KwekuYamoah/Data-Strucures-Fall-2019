
public interface WordFinder {
    public boolean readFile(String fileName);
    
    public void doPreProcessing();
    
    public boolean findWord(String wordToFind);
}