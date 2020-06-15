/*..
Code to remove duplicate elements from an array (arraylist) efficiently
..*/

import java.util.*;

public class ArrayListRemoveDuplicate {
 /*   public static boolean intOrNot(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }*/
    public static void main(String[] args) {
        List<Integer> withDuplicates=new ArrayList<>();
        System.out.println("Enter list with duplicate integers. Enter a non-integer value to escape");
        Scanner scanner=new Scanner(System.in);
       /* while (intOrNot(scanner.nextLine()))
        {
            withDuplicates.add(Integer.parseInt(scanner.nextLine()));
        }*/

       while (scanner.hasNextInt())
       {
           withDuplicates.add(scanner.nextInt());
       }

        System.out.println("With Duplicates: "+ withDuplicates);


        Set<Integer> withoutDuplicates=new LinkedHashSet<>(withDuplicates);
        withDuplicates.clear();
        withDuplicates.addAll(withoutDuplicates);

        System.out.println("Without Duplicates: "+withoutDuplicates);

    }
}
