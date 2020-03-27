import Business.BaseConversion;

public class Main
{
    public enum Base
    {
        BIN(1), DEC(2), HEX(3);
        private int value;

        private Base(int value)
        {
            this.value = value;
        }
    };

    public static void main(String[] args)
    {

        Base from, to;
        // write your code here
        System.out.println("Base?\n" +
                "1. Bin\n" +
                "2. Dec\n" +
                "3. Hex");
        int indicator = InputChecker.checkInputIntLimit(1, 3);
        if (indicator == 1)
            from = Base.BIN;
        else if (indicator == 2)
            from = Base.DEC;
        else
            from = Base.HEX;
        String num = InputChecker.checkInputString();
        System.out.println("Base?\n" +
                "1. Bin\n" +
                "2. Dec\n" +
                "3. Hex");
        indicator = InputChecker.checkInputIntLimit(1, 3);
        if (indicator == 1)
            to = Base.BIN;
        else if (indicator == 2)
            to = Base.DEC;
        else
            to = Base.HEX;
        if (from == to)
            System.out.println(num);
        else
        {
            int temp = -1;
            if (indicator != 2)
            {
                temp = BaseConversion.convertToDec(num, from.value);
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
            String res = BaseConversion.convertFromDec(temp, to.value);
            System.out.println(res);
        }
    }
}
