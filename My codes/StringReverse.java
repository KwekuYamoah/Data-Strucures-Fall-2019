public class StringReverse {
  public static String reverse(String input){
    String[] data = input.split("");
    return  reverseString( data, 0, input.length() -1);
  }
  public static String reverseString(String[] data, int first,int last){
    if ( first == last){
      return String.join("",data);
    }
    else{
      String current = data[first];
      data[first] = data[last];
      data[last] = current;
      return String.join("",reverseString(data, first+1,last-1));
    }
  }
  
  public static boolean Palindrome(String input){
    String text = reverse(input);
    return text.equals(input);
  }
  
  public static String wordBuild(String[] input){
    String joinedInput = String.join("",input);
    if(joinedInput.length() == 0){
      return "";
    }
    
    else{
      return joinedInput.charAt(0) + wordBuild(joinedInput.substring(1).split(""));
    }
  }
  
  public static void main(String[] args){
    System.out.println(reverse("kweku"));
    System.out.println(Palindrome("ama"));
    String a[] = {"k","w","e","k","u"};
    System.out.print(a.substring(1));
    System.out.println(wordBuild(a));
  }
}