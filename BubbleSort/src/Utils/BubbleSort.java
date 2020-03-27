package Utils;

public class BubbleSort
{
    public static void sort(int[] list, boolean isAsc)
    {
        boolean swapped;
        while (true)
        {
            swapped = false;
            for (int i = 0, k = list.length - 1; i < k; ++i)
                if (isAsc)
                {
                    if (list[i] > list[i + 1])
                    {
                        int temp = list[i];
                        list[i] = list[i + 1];
                        list[i + 1] = temp;
                        swapped = true;
                    }
                }
                else
                {
                    if (list[i] < list[i + 1])
                    {
                        int temp = list[i];
                        list[i] = list[i + 1];
                        list[i + 1] = temp;
                        swapped = true;
                    }
                }
            if (!swapped) break;
        }
    }
}
