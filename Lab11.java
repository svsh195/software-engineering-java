import java.io.File;

//////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                              //
//  **Инструкция**                                                                              //
//                                                                                              //
//  Перед запуском лабы создайте папку (рекомендуется на рабочем столе) и заполните её файлами  //
//  с разными расширениями (пример: .txt, .jpeg, .docx и т.д.)                                  //
//  Папки с названиями txt, jpeg и т.д. СОЗДАВАТЬ НЕ НУЖНО!                                     //
//  Программа самостоятельно создаст нужные папки                                               //
//                                                                                              //
//////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        File dir = new File("C://Users/svsh195/Desktop/Lab11java"); // указываем путь к директории, где находятся файлы для сортировки
        sort(dir); // вызываем метод для сортировки файлов в директории
        File dir2 = new File("C://Users/svsh195/Desktop"); // указываем путь к корневой директории, дерево которой нам нужно показать
        tree(dir2, 1); // вызываем метод для вывода дерева каталогов tree(путь к каталогу, уровень вложенности)
                       // уровень вложенности - положительное число. Если указать 0 или отрицательное число, то будет показано только содержимое указанного каталога
    }

    public static void sort(File dir) { // метод для сортировки файлов в директории
        if (dir.isDirectory()) { // если по указанному пути действительно находится директория
            for (File item : dir.listFiles()) { // получаем список содержимого директории и просматриваем его поэлементно
                if (item.isFile()) { // если выбранный элемент является файлом, не директорией
                    String newdir = dir + "/" + getExtension(item.getName()); // генерируем путь нового расположения для файла (* см метод для получения расширения файла)
                    File extdir = new File(newdir); 
                    extdir.mkdir(); // создаем директори по новому пути
                    item.renameTo(new File(newdir + '/' + item.getName())); // перемещаем элемент в новую директорию
                }
            }
        }
    }

    public static String getExtension(String s) { // метод для получения расширения файла
        int index = -1; // сначала считаем, что в файле нет символа .
        for (int i = s.length() - 1; i >= 0; i--) { // посимвольно читаем строку с конца
            if (s.charAt(i) == '.') { // если мы наткнулсь на точку
                index = i; // сохраняем её положение
                break; // прерываем цикл
            }
        }
        if (index == -1) return ""; // если мы так и не нашли точку, то возвращаем пустую строку
        else return s.substring(index + 1, s.length()); // если точка есть, то с с позиции точки + 1 и до конца строки делаем срез и возвращаем его
    }

    public static void tree(File dir, int number) { // метод для вывода дерева каталогов
        if (dir.isDirectory()) { // если по указанному пути действительно находится директория
            for (File item : dir.listFiles()) { // получаем список содержимого директории и просматриваем его поэлементно
                if (item.isDirectory()) { // т.к. нам файлы не нужны, то проверяем, является ли элемент директорией и если да
                    System.out.println(item.getPath()); // выводим путь к директории
                    if (number >= 1) // если мы не привысили уровень вложенности
                        tree(new File(item.getPath()), number - 1); // вызываем метод с путем к новой директории и уменьшенным на 1 уровнем вложенности
                }
            }
        }
    }
}