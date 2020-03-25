import Utils.BubbleSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main
{

    public static void main(String[] args)
    {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of array:");
        //loop until user input correct
        int quan;
        while (true)
        {
            try
            {
                quan = Integer.parseInt(input.nextLine().trim());
                break;
            } catch (NumberFormatException e)
            {
                System.out.print("Enter again: ");
            }
        }
        int[] a = IntStream.generate(() -> new Random().nextInt(1000)).limit(quan).toArray();
        System.out.println(Arrays.toString(a));
        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));

    }
}
