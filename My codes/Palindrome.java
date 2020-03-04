/*
 * Palindrome code written using recursion 
 * Author: Kweku Andoh Yamoah
 */
public class Palindrome{
  
  public static boolean Palindrome(String input){
    String text = reverse(input); //Calling on the reverse method
    return text.equals(input);
  }
  //Defining a recursive reverse method which calls on reverseString
  public static String reverse(String input){
    String[] data = input.split("");
    return  reverseString( data, 0, input.length() -1);
  }
  //Defining recursive reverseString method
  public static String reverseString(String[] input, int first,int last){
    if ( input.length == 2){
      return input[last] + input[first];
    }
    else{
      if ( first == last){
        return String.join("",input);} //base case
      else{
      String current = input[first];
      input[first] = input[last];
      input[last] = current;
      return String.join("",reverseString(input, first+1,last-1));
    }
  }
  }
  //Testing the method
  public static void main(String[] args){
    System.out.println("Testing Palindrome for true");
    System.out.println("Is ama a Palindrome:" + Palindrome("ama"));
    System.out.println("Testing Palindrome for false");
    System.out.println("Is kweku a Palindrome:" + Palindrome("kweku"));
    System.out.println("Testing Palindrome for true again");
    System.out.println("Is redivider a Palindrome:" + Palindrome("redivider"));
    System.out.println(reverse("four"));
  }  
}

