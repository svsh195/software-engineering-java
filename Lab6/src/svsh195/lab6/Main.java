package svsh195.lab6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {1, 2, -3, 14, 5, 6, -17, 8, 9, 0};
        System.out.print("Все четные элементы: ");
        for (int n: numbers) {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
        System.out.print("Все нечетные элементы: ");
        for (int n: numbers) {
            if (n % 2 != 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();

        System.out.print("Все положительные элементы: ");
        for (int n: numbers) {
            if (n >= 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
        System.out.print("Все отрицательные элементы: ");
        for (int n: numbers) {
            if (n < 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();

        System.out.print("Все однозначные элементы: ");
        for (int n: numbers) {
            if (n / 10 < 1 && n / 10 > -1) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
        System.out.print("Все двузначные элементы: ");
        for (int n: numbers) {
            if ((n / 10 >= 1 || n / 10 <= -1) && !(n / 10 >= 10 || n / 10 <= -10)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();


        int max = Arrays.stream(numbers).max().getAsInt(); // если не использовать getAsInt(), то возвращает OptionalInt
        int min = Arrays.stream(numbers).min().getAsInt();
        double avgMaxMin = (max + min) / 2;
        int avgMaxMinCount = 0;
        for (int n: numbers) {
            if (n > avgMaxMin) {
                avgMaxMinCount++;
            }
        }
        System.out.println("Количество элементов, больших ср.арифм. массива: " + avgMaxMinCount);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > avgMaxMin) {
                System.out.println("Индекс " + i);
            }
        }


        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                numbers[i] += 1;
            } else if (numbers[i] < 0) {
                numbers[i] -= 1;
            } else {
                numbers[i] = (Arrays.stream(numbers).max().getAsInt() + Arrays.stream(numbers).min().getAsInt()) / numbers.length;
            }
        }


        int[][] numbers2 = new int[][] {
                {8, 3, 8, -4},
                {4, 2, 0, 7},
                {-4, 5, 0, 2},
                {0, -5, -7, 0}
        };
        int maxNumber2 = numbers2[0][0];
        int minNumber2 = numbers2[0][0];
        int maxI = 0;
        int maxJ = 0;
        int minI = 0;
        int minJ = 0;
        int maxCount = 0;
        int minCount = 0;
        // тупой поиск минимума
        for (int i = 0; i < numbers2.length; i++) {
            for (int j = 0; j < numbers2[i].length; j++) {
                if (numbers2[i][j] < minNumber2) {
                    minNumber2 = numbers2[i][j];
                }
            }
        }
        // тупой поиск максимума
        for (int i = 0; i < numbers2.length; i++) {
            for (int j = 0; j < numbers2[i].length; j++) {
                if (numbers2[i][j] > maxNumber2) {
                    maxNumber2 = numbers2[i][j];
                }
            }
        }
        maxI = -1;
        maxJ = -1;
        for (int i = 0; i <= numbers2.length; i++) {
            for (int j = 0; j < numbers2[i].length; j++) {
                if (numbers2[i][j] == maxNumber2) {
                    maxI = i;
                    maxJ = j;
                    break;
                }
            }
            if (maxI > -1 & maxJ > -1) break;
        }
        System.out.println("Max=" + maxNumber2 + " в координатах " + maxI + " " + maxJ);
        minI = -1;
        minJ = -1;
        for (int i = numbers2.length - 1; i >= 0; i--) {
            for (int j = numbers2[i].length - 1; j >= 0; j--) {
                if (numbers2[i][j] == minNumber2) {
                    minI = i;
                    minJ = j;
                    break;
                }
                if (minJ > -1 & minJ > -1) break;
            }
        }
        System.out.println("Min=" + minNumber2 + " в координатах " + minI + " " + minJ);
        /*
        for (int i = 0; i < numbers2.length; i++) {
            for (int j = 0; j < numbers2[i].length; j++) {
                if (numbers2[i][j] == maxNumber2) {
                    maxI = i;
                    maxJ = j;
                    maxCount++;
                }
                if (numbers2[i][j] == minNumber2) {
                    minI = i;
                    minJ = j;
                    minCount++;
                }
            }
        }
        if (maxCount == 1) {
            System.out.println("Max=" + maxNumber2 + " в координатах " + maxI + " " + maxJ);
        } else {
            int upMaxI = -1;
            int upMaxJ = -1;
            int leftMaxI = -1;
            int leftMaxJ = -1;
            for (int i = 0; i < numbers2.length; i++) {
                for (int j = 0; j < numbers2[i].length; j++) {
                    if (maxNumber2 == numbers2[i][j] && upMaxI == -1 && upMaxJ == -1) {
                        maxNumber2 = numbers2[i][j];
                        upMaxI = i;
                        upMaxJ = j;
                    }
                    if (maxNumber2 == numbers2[j][i] && leftMaxI == -1 && leftMaxJ == -1) {
                        maxNumber2 = numbers2[j][i];
                        leftMaxI = j;
                        leftMaxJ = i;
                    }
                }
            }
            System.out.println("Max=" + maxNumber2 + "\nКоординаты верхнего max " + upMaxI + " " + upMaxJ +
                    "\nКоординаты левого max " + leftMaxI + " " + leftMaxJ);
        }
        if (minCount == 1) {
            System.out.println("Min=" + minNumber2 + " в координатах " + minI + " " + minJ);
        } else {
            int bottomMinI = -1;
            int bottomMinJ = -1;
            int rightMinI = -1;
            int rightMinJ = -1;
            // тупой поиск правого минимума
            for (int j = numbers2[0].length - 1; j >= 0; j--) {
                for (int i = 0; i < numbers2.length; i++) {
                    if (numbers2[i][j] == minNumber2) {
                        rightMinI = i;
                        rightMinJ = j;
                        break;
                    }
                }
                if (rightMinI != -1) {
                    break;
                }
            }
            // тупой поиск нижнего минимума
            for (int i = numbers2.length - 1; i >= 0; i--) {
                for (int j = 0; j < numbers2[i].length; j++) {
                    if (numbers2[i][j] == minNumber2) {
                        bottomMinI = i;
                        bottomMinJ = j;
                        break;
                    }
                }
                if (bottomMinI != -1) {
                    break;
                }
            }
            System.out.println("Min=" + minNumber2 + "\nКоординаты нижнего min " + bottomMinI + " " + bottomMinJ +
                    "\nКоординаты правого min " + rightMinI + " " + rightMinJ);
        }*/


        int[][] numbers3 = new int[][] {
                {2, 7, 6},
                {9, 5, 1},
                {4, 3, 0}
        };
        int standartSum = Arrays.stream(numbers3[0]).sum();
        boolean isMagiq = true;
        for (int i = 0; i < numbers3.length; i++) {
            int jSum = 0;
            int mainDiagSum = 0;
            int notMainDiagSum = 0;
            for (int j = 0; j < numbers3.length; j++) {
                // проверка строк
                if (Arrays.stream(numbers3[i]).sum() != standartSum) {
                    isMagiq = false;
                    break;
                }

                // проверка столбцов
                jSum += numbers3[j][i];

                // проверка диагоналей
                mainDiagSum += numbers3[j][j];
                notMainDiagSum += numbers3[j][numbers3.length - 1 - j];
            }
            if ((jSum != standartSum) | (mainDiagSum != standartSum) | (notMainDiagSum != standartSum)) {
                isMagiq = false;
                break;
            }
            if (isMagiq == false) {
                break;
            }
        }
        if (isMagiq) {
            System.out.println("Квадрат магический");
        } else {
            System.out.println("Квадрат не магический");
        }
    }
}
