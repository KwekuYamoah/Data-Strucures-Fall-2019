//Testing my SimpleArrayList which is generic.

public class SimpleArrayListDemo{
  
  public static void main(String [] args){
    //Creating an array of type string.
    SimpleArrayList<String> my_array = new SimpleArrayList<>();
    
    //Testing the accessor methods
    
    System.out.println("======Testing the accessor methods======");
    System.out.print("My array contains:");
    my_array.print();
    System.out.println();
    System.out.println("The number of items in my array is: " + my_array.size());
    System.out.println();
   
    
    //Testing the mutator methods data type String
    System.out.println("=====Testing the add method for Strings=====");
    my_array.add("abraham");
    my_array.add("aziz");
    System.out.print("My array contains:");
    System.out.println();
    my_array.print();
    
    
    
    System.out.println("======Testing the mutator methods for Strings======");
    
    
    my_array.set(0,"lion");
    System.out.print("My array now contains: ");
    System.out.println();
    my_array.print();
    
    
    
    
    System.out.println("======Testing addAll for Strings ======");
    my_array.addAll(new String[] {"kweku","percy","john","kweku","percy","kweku"});
    System.out.print("My array now contains:");
    System.out.println();
    my_array.print();
    
    System.out.println("======Testing Insert for Strings======");
    my_array.Insert(4,"abeiku");
    System.out.print("My array now contains:");
    System.out.println();
    my_array.print();
    
    System.out.println("======Testing Find for Strings======");
    System.out.print("Found Kweku at: " + my_array.find("kweku"));
    System.out.println();
    my_array.print();
    
    System.out.println("======Testing Remove for Strings======");
    my_array.remove("abeiku");
    System.out.print("My array now contains:");
    System.out.println();
    my_array.print();
   
    
    System.out.println("======Testing insertAll for Strings======");
    my_array.insertAll(1, new String[] {"kwame","eileen","kwesi"});
    System.out.print("My array now contains:");
    System.out.println();
    my_array.print();
    
    
    System.out.println("======Testing removeAll for Strings======");
    my_array.removeAll("kweku");
    System.out.print("My array now contains:");
    System.out.println();
    my_array.print();
    System.out.println();
    my_array.addAll(new String[] {"kweku","percy","john","kweku","percy","kweku"});
    System.out.println();
    my_array.print();
    
    System.out.println("======Testing findLast for Strings======");
    System.out.println();
    System.out.println("The last occurence of john was at index: " + my_array.findLast("john"));
    System.out.println();
    
    System.out.println("=====Testing the findAll method for Strings=====");
    int[] list = my_array.findAll("kweku");
    System.out.println("The positions of kweku are: ");
    for (int i=0; i<list.length; i++)
      System.out.print(list[i] + " ");
    System.out.println();
    
    System.out.println("Item at index 5: " + my_array.get(5));
    
    
    
    
    //Creating an array of type Integer.
    SimpleArrayList<Integer> my_num = new SimpleArrayList<>();
    
    //Testing the accessor methods data type of Integers
    
    System.out.println("======Testing the accessor methods for Integers======");
    System.out.print("My array contains:");
    my_num.print();
    System.out.println();
    System.out.println("The number of items in my array is: " + my_num.size());
    System.out.println();
   
    
    //Testing the mutator methods
    System.out.println("=====Testing the add method for Integers=====");
    my_num.add(8);
    my_num.add(10);
    System.out.print("My array contains:");
    System.out.println();
    my_num.print();
    
    
    System.out.println("======Testing the mutator methods for Integers======");
    my_num.set(0,3);
    System.out.print("My array now contains: ");
    System.out.println();
    my_num.print();
    
    
    System.out.println("======Testing addAll for Integers======");
    my_num.addAll(new Integer[] {49,41,23,49,41,49});
    System.out.print("My array now contains:");
    System.out.println();
    my_num.print();
    
    System.out.println("======Testing Insert for Integers======");
    my_num.Insert(4,100);
    System.out.print("My array now contains:");
    System.out.println();
    my_num.print();
    
    System.out.println("======Testing Find for Integers======");
    System.out.print("Found 41 at: " + my_num.find(41));
    System.out.println();
    my_num.print();
    
    System.out.println("======Testing Remove for Integers======");
    my_num.remove(100);
    System.out.print("My array now contains:");
    System.out.println();
    my_num.print();
   
   
    
    System.out.println("======Testing insertAll======");
    my_num.insertAll(1, new Integer[] {58,51,35});
    System.out.print("My array now contains:");
    System.out.println();
    my_num.print();
    
    
    System.out.println("======Testing removeAll for Integers======");
    my_num.removeAll(49);
    System.out.print("My array now contains:");
    System.out.println();
    my_num.print();
    System.out.println();
    my_num.addAll(new Integer[] {49,41,23,49,41,49});
    System.out.println();
    my_num.print();
    
    System.out.println("======Testing findLast for Integers======");
    System.out.println();
    System.out.println("The last occurence of 23 was at index: " + my_num.findLast(23));
    System.out.println();
    
    System.out.println("=====Testing the findAll method for Integers=====");
    int[] lis = my_num.findAll(41);
    System.out.println("The positions of 49 are: ");
    for (int i=0; i<lis.length; i++)
      System.out.print(lis[i] + " ");
    System.out.println();
                       
    System.out.println("Item at index 5: " + my_num.get(5));
    
    
  }
  
}