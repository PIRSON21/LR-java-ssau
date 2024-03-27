import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Int[] array;

    public static void main(String[] s) {
        Scanner scan = new Scanner(System.in);
        System.out.println("====ЛАБОРАТОРНАЯ РАБОТА №3====");
        while (array == null) {
            try {
                System.out.println("====СОЗДАНИЕ МАССИВА====");
                System.out.print("Введите размерность массива: ");
                int count = Integer.parseInt(scan.nextLine());
                array = new Int[count];
            } catch (NumberFormatException e) {
                System.out.println("====ОШИБКА====");
                System.out.println("Неверный формат ввода!\n");
            } catch (NegativeArraySizeException e) {
                System.out.println("====ОШИБКА====");
                System.out.println("Размерность не может быть отрицательной\n");
            }
        }
        for (int i = 0; i < array.length;) {
            System.out.println("1. Серия сочинений");
            System.out.println("2. Серия статей");
            System.out.printf("Выберите тип %d-го элемента: ", i);
            String name  = scan.nextLine();
            System.out.println();
            switch (name) {
                case "1":
                    try {
                    System.out.print("Введите название серии: ");
                    name = scan.nextLine();
                    System.out.print("Введите количество сочинений в серии: ");
                    int count = Integer.parseInt(scan.nextLine());
                    System.out.print("Введите, сколько вступительных страниц в серии: ");
                    int introduce = Integer.parseInt(scan.nextLine());

                        array[i] = new Essays(count, name, introduce);
                        i++;
                        System.out.println("====УСПЕШНО====\n");
                    }  catch (NumberFormatException e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println("Неверный формат ввода!\n");
                    }  catch (RuntimeException e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case "2":
                    try {
                    System.out.print("Введите название серии: ");
                    name = scan.nextLine();
                    System.out.print("Введите количество сочинений в серии: ");
                    int count = Integer.parseInt(scan.nextLine());
                    System.out.print("Введите, сколько вступительных страниц в серии: ");
                    int introduce = Integer.parseInt(scan.nextLine());

                        array[i] = new Articles(count, name, introduce);
                        i++;
                        System.out.println("====УСПЕШНО====\n");
                    } catch (NumberFormatException e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println("Неверный формат ввода!\n");
                    } catch (RuntimeException  e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                default:
                    System.out.println("====ОШИБКА====");
                    System.out.println("Введено не правильное значение!\n");
                    break;
            }
        }

        boolean end = false;
        while (!end) {
            System.out.println("=========================МЕНЮ=========================");
            System.out.println("1. Вывести полную информацию обо всех объектах массива");
            System.out.println("2. Найти в массиве объекты, бизнес-метод которых возвращают одинаковый результат");
            System.out.println("3. Разбить исходный массив на два массива по типу");
            System.out.println("0. Выход из программы");
            System.out.print("Выберете пункт меню: ");
            switch (scan.nextLine()) {
                case "1":
                    System.out.println("====ИНФОРМАЦИЯ О МАССИВЕ====");
                    PrintOutArray(array);
                    break;
                case "2":
                    try {
                        Int[][] res = FindCommonRes();
                        for (Int[] array : res) {
                            System.out.println("Бизнес-метод: " + array[0].calcPages());
                            PrintOutArray(array);
                        }
                    }
                    catch (PagesLessZeroException e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println("В серии " + e.getMessage() + "-ый элемент меньше нуля" + "\n");
                        String name = e.getMessage().split(" ")[0];
                        int index = Integer.parseInt(e.getMessage().split(" ")[1]);
                        replaceElement(name, index);
                    }
                    catch (RuntimeException  e) {
                        System.out.println("====ОШИБКА====");
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case "3":
                    System.out.println("\n====РАЗБИЕНИЕ ПО ТИПУ====");
                    Int[][] splitedByType = SplitByType();
                    System.out.println("Количество серий типа \"Сочинение\": " + splitedByType[0].length);
                    System.out.println("Количество серий типа \"Статья\": " + splitedByType[1].length);
                    System.out.println("\n====ВЫВОД МАССИВА====");
                    System.out.println("1. Массив серий \"Сочинение\"");
                    System.out.println("2. Массив серий \"Статья\"");
                    System.out.println("3. Вывести оба массива");
                    System.out.println("0. Не выводить ничего");
                    System.out.print("Вывести массив: ");
                    switch (scan.nextLine()) {
                        case "1":
                            System.out.println("\n====МАССИВ СЕРИИ \"СОЧИНЕНИЕ\"====");
                            PrintOutArray(splitedByType[0]);
                            break;
                        case "2":
                            System.out.println("\n====МАССИВ СЕРИИ \"СТАТЬЯ\"====");
                            PrintOutArray(splitedByType[1]);
                            break;
                        case "3":
                            System.out.println("\n====МАССИВ СЕРИИ \"СОЧИНЕНИЕ\"====");
                            PrintOutArray(splitedByType[0]);
                            System.out.println("====МАССИВ СЕРИИ \"СТАТЬЯ\"====");
                            PrintOutArray(splitedByType[1]);
                            break;
                        case "0":
                            break;
                        default:
                            System.out.println("====ОШИБКА====");
                            System.out.println("Введено не правильное значение!\n");
                    }
                    break;
                case "0":
                    System.out.println("====ЗАВЕРШЕНИЕ РАБОТЫ====");
                    end = true;
                    break;
                default:
                    System.out.println("====ОШИБКА====");
                    System.out.println("Введено не правильное значение!\n");
                    break;
            }
        }



    }

    private static void replaceElement(String name, int index) {
        for (Int el: array) {
            if (el.getName().equals(name)) {
                System.out.print("Введите, сколько страниц будет в " + index + "-ой книге: ");
                Scanner scan = new Scanner(System.in);
                int value = Integer.parseInt(scan.nextLine());
                el.setElement(index - 1, value);
                System.out.println("====УСПЕШНО====\n");
            }
        }
    }


    private static Int[][] FindCommonRes() throws PagesLessZeroException {
        Int[][] res = new Int[0][];
        ArrayList<Integer> uniqueNum =  new ArrayList<>() ;
        ArrayList<Int> uniqueInts;
        int c = 0;
        for (int i = 0; i < array.length; i++) {
            uniqueInts = new ArrayList<>();
            int num;
            try {
                num = array[i].calcPages();
                if (!uniqueNum.contains(num)) {
                    uniqueNum.add(num);
                    for (int j = i + 1; j < array.length; j++) {
                        if (num == array[j].calcPages()) {
                            uniqueInts.add(array[j]);
                        }
                    }
                    if (!uniqueInts.contains(array[i])) {
                        uniqueInts.add(array[i]);
                    }
                    res = Arrays.copyOf(res, res.length + 1);
                    res[c] = uniqueInts.toArray(new Int[0]);
                    c++;
                }
            } catch (PagesLessZeroException e) {
                throw new PagesLessZeroException(e.getMessage());
            }
        }
        return res;
    }

    private static Int[][] SplitByType() {

        int essays = 0;
        int articles = 0;
        for (Int anInt : array) {
            if (anInt.getClass().equals(Essays.class)) { essays++; }
            else if (anInt.getClass().equals(Articles.class)) {  articles++; }
        }

        Int[][] result = new Int[2][];
        result[0] = new Int[essays];
        result[1] = new Int[articles];
        essays = 0;
        articles = 0;
        for (Int anInt : array) {
            if (anInt.getClass().equals(Essays.class)) {
                result[0][essays] = anInt;
                essays++;
            } else if (anInt.getClass().equals(Articles.class)) {
                result[1][articles] = anInt;
                articles++;
            }
        }
        return result;
    }


    private static void PrintOutArray(Int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("====ЭЛЕМЕНТ #" + (i + 1) + "====");
            System.out.println(array[i].toString());
        }
    }
}
