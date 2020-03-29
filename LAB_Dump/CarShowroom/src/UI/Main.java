package UI;

import Entity.CarData;
import Entity.ExceptionCar;


public class Main
{
    public static void main(String[] args) throws ExceptionCar
    {
        CarData[] carData = {
                new CarData(
                        new String[]{"White", "Yellow", "Orange"},
                        new int[]{5500, 3000, 4500},
                        new String[]{"Friday", "Sunday", "Monday"}),
                new CarData(
                        new String[]{"Green", "Blue", "Purple"},
                        new int[]{5000, 6000, 8500},
                        new String[]{"TueDay", "Saturday", "Wednesday"}),
                new CarData(
                        new String[]{"Pink", "Red", "Brown"},
                        new int[]{2500, 3000, 3500},
                        new String[]{"Monday", "Sunday", "Thursday"})
        };


        while (true)
        {
            System.out.println("Input information of car");

            System.out.print("Name: ");
            String carName = InputChecker.checkInputString();

            System.out.print("Color: ");
            String colorName = InputChecker.checkInputString();

            System.out.print("Price: ");
            int price = InputChecker.checkPrice();

            System.out.print("Today: ");
            String today = InputChecker.checkInputString();


            Car carManufacture = Car.getCar(carName);
            CarData carDatum = carData[carManufacture.ordinal()];

            boolean check = carDatum != null;
            
            if (carDatum != null)
            {
                if (InputChecker.checkCar(carDatum, colorName, price, today))
                {
                    System.out.println("Sold!");
                    System.out.print("Do you want find more?(Y/N): ");
                    if (InputChecker.wannaContinue())
                        continue;
                }
                else
                    System.out.println("Car break");
                break;
            }
            if (!check)
                throw new ExceptionCar("Can't find car.");
            else
                break;
        }
    }


    enum Car
    {
        AUDI, MERCEDES, BMW;

        static Car getCar(String car)
        {
            car = car.trim().toUpperCase();
            switch (car)
            {
                case "AUDI":
                    return AUDI;
                case "MERCEDES":
                    return MERCEDES;
                case "BMW":
                    return BMW;
            }
            return null;
        }
    }

    enum Day
    {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

        static Day getDay(String day)
        {
            day = day.trim().toUpperCase();
            switch (day)
            {
                case "SUNDAY":
                    return SUNDAY;
                case "MONDAY":
                    return MONDAY;
                case "TUESDAY":
                    return TUESDAY;
                case "WEDNESDAY":
                    return WEDNESDAY;
                case "THURSDAY":
                    return THURSDAY;
                case "FRIDAY":
                    return FRIDAY;
                case "SATURDAY":
                    return SATURDAY;
                default:
                    return null;
            }
        }
    }

    enum Color
    {
        WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NO_COLOR;

        static Color getColor(String color)
        {
            color = color.trim().toUpperCase();
            switch (color)
            {
                case "WHITE":
                    return WHITE;
                case "YELLOW":
                    return YELLOW;
                case "ORANGE":
                    return ORANGE;
                case "GREEN":
                    return GREEN;
                case "BLUE":
                    return BLUE;
                case "PURPLE":
                    return PURPLE;
                case "PINK":
                    return PINK;
                case "RED":
                    return RED;
                case "BROWN":
                    return BROWN;
                case "NO COLOR":
                    return NO_COLOR;
                default:
                    return null;
            }
        }
    }

}
