/* Source of Stack code: Dr Korsah
 * Postfix function built using a stack 
 * Author: Kweku Andoh Yamoah
 */

import java.util.Scanner;

public class Postfix{
  private String data;
  private String[] token;
 
  public Postfix(){};
  
  public int getCalc(){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your post fix expresssion, eg: 13   4   +   6   10   +   *   2   -:");
    data = input.nextLine();
    token = data.split(" ");
    Stack<Integer> post_stack = new Stack(); //Creating a new Stack
    
    for(int i = 0; i < token.length; i++){
        if(token[i].equals("+")){
          int x= post_stack.pop();
          int y= post_stack.pop();
          int z= x+y;
          post_stack.push(z);
        }
        else if (token[i].equals("-")){
             int x= post_stack.pop();
             int y= post_stack.pop();
             int z= y-x;
             post_stack.push(z);
        }
        else if (token[i].equals("/")){
             int x= post_stack.pop();
             int y= post_stack.pop();
             int z= y/x;
             post_stack.push(z);
        }
        else if (token[i].equals("*")){
             int x= post_stack.pop();
             int y= post_stack.pop();
             int z= y*x;
             post_stack.push(z);
        }
           
        else if ((token[i].equals("%"))|(token[i].equals("//"))){
             int x= post_stack.pop();
             int y= post_stack.pop();
             int z= y % x;
             post_stack.push(z);
        }
        else if ((token[i].equals("**")) |(token[i].equals("^"))){
             int x= post_stack.pop();
             int y= post_stack.pop();
             int z= y ^ x;
             post_stack.push(z);
        }
        else{
           int num = Integer.parseInt(token[i]);
           post_stack.push(num);
        }
           
    
   }
   return post_stack.top();
  }
  //Testing the method
  public static void main(String[]args){
        Postfix p = new Postfix();
        System.out.println(p.getCalc());
  }
}