package svsh195.lab5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberOfDays = 10;
        double kmInFirstDay = 10;
        double kmInAllDays = kmInFirstDay;
        for (int i = 2; i <= numberOfDays; i++) {
            kmInFirstDay += kmInFirstDay * 0.1;
            kmInAllDays += kmInFirstDay;
            System.out.println("Пробег за " + i + " день " + String.format("%.2f", kmInFirstDay));
        }
        System.out.println("Пробег за " + numberOfDays + " дней " + String.format("%.2f", kmInAllDays));

        Scanner in = new Scanner(System.in);
        
        System.out.print("Пользователь, введите число, чтобы рассчитать ср.арифм. от 1 до числа: ");
        int n = in.nextInt();
        double avg1000 = 0;
        for (int i = 1; i <= 1000; i++) {
            avg1000 += i;
        }
        System.out.println("Среднее арифметическое чисел от 1 до 1000 = " + avg1000 / 1000);
        double avgn = 0;
        if (n >= 1) {
            for (int i = 1; i <= n; i++) {
                avgn += i;
            }
            System.out.println("Среднее арифметическое чисел от 1 до " + n + " = " + avgn / n);
        } else {
            int iCount = 0;
            for (int i = n; i <= 1; i++) {
                avgn += i;
                iCount++;
            }
            System.out.println("Среднее арифметическое чисел от " + n + " до 1 = " + avgn / iCount);
        }




        System.out.print("Пользователь, введите натуральное число, чтобы узнать, является ли оно совершенным: ");
        int number = in.nextInt();
        if (isNatural(number)) {
            System.out.println("Число " + number + (isPerfect(number) ? " является " : " не является ") + "совершенным");
        } else {
            System.out.println("Введенное число " + number + " не является натуральным");
        }


        System.out.println("Поиск 10 чисел больших 100, оканчивающихся на 7 и кратных 9");
        number = 100;
        byte count = 0;
        while (count < 10)
        {
            number++;
            if ((number % 10 == 7) & (number % 9 == 0))
            {
                count++;
                System.out.println("Число " + number + " соответствует условиям");
            }
        }

        System.out.println("Пользователь, введите число, чтобы найти ближайший натуральный квадрат: ");
        number = in.nextInt();
        if (number < 1) {
            System.out.println(1);
        } else {
            var t = Math.round(Math.sqrt(number));
            if (Math.pow(t, 2) <= number) {
                t++;
            }
            System.out.println((int)(Math.pow(t, 2)));
        }
    }

    static boolean isPerfect(int someNumber) {
        int _sum = 0;
        for (int i = 1; i < someNumber; i++)
        {
            if (someNumber % i == 0)
            {
                _sum += i;
            }
        }
        return _sum == someNumber;
    }

    static boolean isNatural(int someNumber) {
        if (someNumber > 0) {
            return true;
        } else {
            return false;
        }
    }
}
