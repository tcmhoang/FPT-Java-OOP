import Business.BaseConversion;

public class Main
{

    public static void main(String[] args)
    {
        // write your code here
        System.out.println("Base?\n" +
                "1. Bin\n" +
                "2. Dec\n" +
                "3. Hex");
        int indicatorFrom = InputChecker.checkInputIntLimit(1, 3);
        String num = InputChecker.checkInputString();
        System.out.println("Base?\n" +
                "1. Bin\n" +
                "2. Dec\n" +
                "3. Hex");
        int indicatorTo = InputChecker.checkInputIntLimit(1, 3);
        if (indicatorFrom == indicatorTo)
            System.out.println(num);
        else
        {
            int temp = -1;
            if (indicatorFrom != 2)
            {
                temp = BaseConversion.convertToDec(num, indicatorFrom);
                if (temp == -1)
                {
                    System.err.println("INVALID NUMBER");
                    return;
                }

            }
            else
            {
                if (num.matches("-?\\d+"))
                    temp = Integer.parseInt(num);
                else
                {
                    System.err.println("INVALID NUMBER");
                    return;
                }
            }
            String res = BaseConversion.convertFromDec(temp, indicatorTo);
            System.out.println(res);
        }
    }
}
