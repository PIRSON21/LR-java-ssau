import java.util.Scanner;

public class Program {

    public static void main(String[] s) {


        System.out.println("=====СОЗДАНИЕ ВЕКТОРА=====");

        try {
            System.out.print("Введите размерность вектора: ");
            Scanner scan = new Scanner(System.in);
            int n = Integer.parseInt(scan.nextLine());
            Vector vec = new Vector(n);
            for (int i = 0; i < vec.getLen(); i++) {
                System.out.print("Введите значение [" + i + "]: ");
                double k = Double.parseDouble(scan.nextLine());
                vec.setCord(i, k);
            }

            System.out.println("=====МАКСИМАЛЬНОЕ И МИНИМАЛЬНОЕ ЗНАЧЕНИЯ=====");

            System.out.println("Максимальное значение: " + vec.maxCord());
            System.out.println("Минимальное значение: " + vec.minCord());

            System.out.println("=====СОРТИРОВКА МАССИВА=====");
            System.out.println("Массив до сортировки");
            vec.printVector();

            Vector sorted = new Vector(vec.getLen());
            for (int i = 0; i < vec.getLen(); i++) {
                sorted.setCord(i, vec.getCord(i));
            }
            sorted.sortVector();
            System.out.println("Массив после сортировки");
            sorted.printVector();

            sorted = null;

            System.out.println("=====УМНОЖЕНИЕ НА ЧИСЛО=====");
            System.out.print("Введите число: ");
            double k = Double.parseDouble(scan.nextLine());
            System.out.println("Вектор до умножения:");
            vec.printVector();
            System.out.println("Вектор после умножения:");
            (vec.mulNumber(k)).printVector();

            System.out.println("=====ЕВКЛИДОВО ЧИСЛО=====");

            System.out.print("Введите размерность вектора 2: ");
            n = Integer.parseInt(scan.nextLine());
            Vector vec2 = new Vector(n);
            for (int i = 0; i < vec.getLen(); i++) {
                System.out.print("Введите значение [" + i + "]: ");
                k = Double.parseDouble(scan.nextLine());
                vec2.setCord(i, k);
            }
            if (vec.getLen() == vec2.getLen()) {
                System.out.println("Евклидово число: " + vec.evklid(vec2));

                System.out.println("=====СУММА ВЕКТОРОВ=====");
                System.out.println("Вектор до сложение:");
                vec.printVector();
                System.out.println("Вектор после сложения:");
                (Vector.sumVector(vec, vec2)).printVector();

                System.out.println("=====СКАЛЯРНОЕ ПРОИЗВЕДЕНИЕ=====");
                System.out.println("Скалярное произведение: " + Vector.scalar(vec, vec2));

            } else {
                System.out.println("Ошибка! Размерности векторов не совпадают!");
            }
        } catch (RuntimeException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
