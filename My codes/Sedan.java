public class Sedan extends Vehicle{
  public static final int DEFAULT_FRONT_AGE = 10;
  
  private final boolean cargo = true;
  
  public Sedan(String lincese_plate, String make,String model, int manu_year){
    super(lincese_plate,make,model,manu_year,2,4,4); //Calling the Vehicle Constructor
  }
  
  public boolean getCargo(){ return cargo;}
  
  public boolean setFrontSeat(Person new_person){
    if(new_person.getAge() >= DEFAULT_FRONT_AGE && isFull() == false){
      for(int i = c_pass; i > 0; i--){            
        passengers[i+1] = passengers[i];                                  
                                              
      }
      passengers[0] = new_person;                                   
      c_pass++;
      return true;
    }
    return false;
  
  }
  
    
  public static void main(String[] args){
    Sedan salon = new Sedan("GN 4547-18","Sedan","Salon", 2005);
    
     // Printing the values held by the default constructor.
    
    System.out.println("Lincese plate: " + salon.getLinplate());
    System.out.println("Vehicle make:" + salon.getVmake());
    System.out.println("Vehicle model: " + salon.getVmodel());
    System.out.println("Manufacture year: " + salon.getVmanu());
    System.out.println("Number of doors: " + salon.getVdoors());
    System.out.println("Number of wheels:" + salon.getVwheels());
    System.out.println("Driver:" + salon.getDriver());
    System.out.println("Current capacity:" + salon.getC_pass());
    System.out.println("Does the sedan has cargo? : " + salon.getCargo());
    System.out.println("Has passenger sat in the front seat?: " + salon.setFrontSeat(new Person("John Ayomah",20, Person.Gender.Male)));
    System.out.println();
    System.out.println();
  }
  
 
}