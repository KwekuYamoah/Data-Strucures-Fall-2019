public class Midsem{
  public static void main(String args[]){
    int[][] nums = new int[5][7];
    System.out.println(nums.length);
    for(int i= 0; i < nums.length ; i ++){
      //System.out.print(nums[i]);
      for(int j= 0; j < nums[i].length ; j ++){
        System.out.print(nums[i][j] + " ");
      }
      System.out.print(", ");
    }
    
    String[] names = {"Ama", "Kobena", "Yolanda"};
    for (int i=0; i<names.length; i++){
      System.out.print(names[i] + ": " + names[i].length() + ". ");
    }
    
    int[][] twoD = new int[3][2]; 
 
    int num = 1;
    for (int i=0; i<twoD.length; i++){
      for (int j=0; j<twoD[i].length; j++) {
        twoD[i][j] = num;
        num++;
      }
    }
    int[] oneD = {2, 4, 6, 8, 10};
    twoD[1] = oneD;

    for (int i=0; i<twoD.length; i++){
      for (int j=0; j<twoD[i].length; j++){
        System.out.print(twoD[i][j] + " ");
      }
      System.out.println(", ");
    }
    
    int nRows = 3, nCols = 3;
    char[][] symbols = new char[nRows][];

    for (int i=0; i<nRows; i++) {
      symbols[i] = new char[nCols];
    }

    for (int i=0; i<nRows; i++) {
      for (int j=0; j<nCols; j++) {
        symbols[i][j] = '0';
      }
    }
    for(int i=0; i<symbols.length; i++){
      for (int j=0; j<symbols[i].length; j++){
        System.out.print(symbols[i][j] + " ");
      }
      System.out.println(" ");
      
    }
    //System.out.println(2 % 5);
  }

}