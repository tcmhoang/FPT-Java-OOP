package Business;

public class BaseConversion
{
    private static int getBase(int indicator)
    {
        switch (indicator)
        {
            case 1:
                return 2;
            case 2:
                return 10;
            case 3:
                return 16;
        }
        return -1;
    }

    private static int val(char c)
    {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    private static char reVal(int num)
    {
        if (num >= 0 && num <= 9)
            return (char) (num + 48);
        else
            return (char) (num - 10 + 65);
    }

    public static int convertToDec(String str,
                                   int indicator)
    {
        int base = getBase(indicator);
        int len = str.length();
        int power = 1;
        int num = 0;

        for (int i = len - 1; i >= 0; i--)
        {
            if (val(str.charAt(i)) >= base)
                return -1;

            num += val(str.charAt(i)) * power;
            power = power * base;
        }

        return num;
    }

    public static String convertFromDec(int inputNum, int indicator)
    {

        int base = getBase(indicator);

        StringBuilder s = new StringBuilder();

        while (inputNum > 0)
        {
            s.append(reVal(inputNum % base));
            inputNum /= base;
        }
        
        return s.reverse().toString();
    }
}
