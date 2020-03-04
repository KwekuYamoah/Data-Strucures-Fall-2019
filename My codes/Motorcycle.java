
public class Motorcycle extends Vehicle{
  
  public Motorcycle(String lincese_plate, String make,String model, int manu_year
                ){
    super(lincese_plate,make,model,manu_year,0,2,1); //Calling the Vehicle Constructor
  }
  
  public static void main(String[] args){
    Motorcycle aboboyaa = new Motorcycle("GR 14-18", "Yamaha","Racing Bike",2016);
    
    // Printing the values held by the default constructor.
    
    System.out.println("Lincese plate: " + aboboyaa.getLinplate());
    System.out.println("Vehicle make:" + aboboyaa.getVmake());
    System.out.println("Vehicle model: " + aboboyaa.getVmodel());
    System.out.println("Manufacture year: " + aboboyaa.getVmanu());
    System.out.println("Number of doors: " +aboboyaa.getVdoors());
    System.out.println("Number of wheels:" + aboboyaa.getVwheels());
    System.out.println("Driver:" + aboboyaa.getDriver());
    System.out.println("Current capacity:" +aboboyaa.getC_pass());
    System.out.println();
    System.out.println();
  }
  
}






