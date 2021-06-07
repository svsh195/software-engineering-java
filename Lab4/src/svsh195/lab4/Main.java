package svsh195.lab4;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        int number1 = 17;
        int number2 = 22;
        int number3 = 43;
        Math.max(number1, Math.max(number2, number3));
        Math.min(number1, Math.min(number2, number3));

        var today = LocalDate.now();
        var birthday = LocalDate.of(1997, 05, 19);

        if (today.getYear() - birthday.getYear() < 0) {
            System.out.println("Введенная дата ещё не наступила");
        }
        else {
            if (today.getMonthValue() < birthday.getMonthValue()){
                System.out.println("Полных лет " + (today.getYear() - birthday.getYear() - 1));
            } else {
                System.out.println("Полных лет " + (today.getYear() - birthday.getYear()));
            }
        }

        int k = 225;
        int dayofweek = k % 7;
        switch (dayofweek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Будний день");
                break;
            case 6:
            case 0:
                System.out.println("Выходной день");
                break;
            default:
                System.out.println("Что-то пошло не так");
                break;
        }

        int points = 3;
        switch (points) {
            case 0:
                System.out.println("Проигрыш");
                break;
            case 1:
                System.out.println("Ничья");
                break;
            case 3:
                System.out.println("Выигрыш");
                break;
            default:
                System.out.println("Это точно футбол?");
                break;
        }

        int month = 6;
        var date = LocalDate.of(2018, month, 1);
        switch (month)
        {
            case 1:
            case 2:
            case 12:
                System.out.println(date.getMonth() + ", зима, " + date.lengthOfMonth()); // название месяца выводит на английском
                break;
            case 3:
            case 4:
            case 5:
                System.out.println(date.getMonth() + ", весна, " + date.lengthOfMonth());
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(date.getMonth() + ", лето, " + date.lengthOfMonth());
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(date.getMonth() + ", осень, " + date.lengthOfMonth());
                break;
        }
    }
}
