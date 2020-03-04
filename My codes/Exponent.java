import java.lang.Math;

public class Exponent{
  public static int Exponent(int a, int n){
    if (n == 0){ return 1;}
    
    else if (n >= 1){
      return a * (Exponent(a,n-1));
    }
    else{
      return 1/ Exponent(a,Math.abs(n));
    }
  }
}