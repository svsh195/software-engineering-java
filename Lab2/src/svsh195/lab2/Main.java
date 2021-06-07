package svsh195.lab2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Пользователь, введите число: ");
        if (in.hasNextInt()) {
            int number = in.nextInt();
            System.out.println("Вы ввели число: " + number);
            System.out.println(number + " - вот какое число Вы ввели");
        } else if (in.hasNextDouble()) {
            double number = in.nextDouble();
            System.out.println("Вы ввели число: " + number);
            System.out.println(number + " - вот какое число Вы ввели");
        } else {
            System.out.println("Что-то пошло не так. Ожидались значения типа int или double");
        }

        System.out.println(1 + " " + 13 + " " + 49);
        System.out.println("50\n10");

        System.out.println("Введите значение x и y, разделив их через Enter: ");
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println("а) 7 см\n" +
                "б) " + x + " 25\n" +
                "в) " + x + " " + y);

        in.close();
    }
}
