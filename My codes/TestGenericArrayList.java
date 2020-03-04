
public class TestGenericArrayList {

    public static void main(String[] args) {
    
        // Note that on the right hand side, it is permissible to
        // leave the triangle braces empty.  The value of the type
        // parameter is inferred from the type parameter specified on
        // the left hand side.
        GenericArrayList<String> names = new GenericArrayList<>();
        GenericArrayList<Integer> ages = new GenericArrayList<>();
       
        // As an alternative to the two lines above, we can use the
        // following two lines:
        //GenericArrayList<String> names = new GenericArrayList<String>();
        //GenericArrayList<Integer> ages = new GenericArrayList<Integer>();
        
        // Add items to the names array list
        names.add("Sena");
        names.add("Esther");
        names.add("James");
        names.add("Daniel");
        names.add("Adorkor");
        names.add("Ayorkor");
        names.add("Korsah");
        names.add("Juliet");
        names.add("Gloria");
        
        // Add items to the ages array list.  Note that we really
        // should be adding Integer objects instead of ints, but autoboxing
        // comes to our rescue by automatically converting the int to Integer, 
        // because Integer is expected.
        ages.add(20);
        ages.add(17);
        ages.add(48);
        
        // print the two lists
        System.out.println("\nThe names list is: ");
        names.print();
        System.out.println("\nThe ages list is: ");
        ages.print();
        
        // Retrieve the first item from each list.
        // Note that casting is NOT needed when we retrive items from 
        // the list.  The items are returned with the appropriate type
        // due to the type parameter specified when instantiating the class
        String firstName = names.first();
        Integer firstAge = ages.first();
        
        System.out.println("\nThe first name is " + firstName +
                            " with length " + firstName.length() + 
                            " and the first age is " + firstAge + ".\n");
    }
}