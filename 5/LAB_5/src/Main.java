import java.util.Scanner;

public class Main {



    public static void main(String[] s) {
        Scanner scan = new Scanner(System.in);
        System.out.println("====ЛАБОРАТОРНАЯ РАБОТА №5====");
        boolean end = false;
        while (!end) {
            System.out.println("=========================МЕНЮ=========================");
            System.out.println("1. Параллельные запись/чтение массива (Задание 1)");
            System.out.println("2. Последовательные запись/чтение массива (Задание 2)");
            System.out.println("3. Последовательные запись/чтение массива (Задание 3)");
            System.out.println("0. Выход из программы");
            System.out.print("Выберете пункт меню: ");
            switch (scan.nextLine()) {
                case "1":
                    System.out.println("====СОЗДАНИЕ ОБЪЕКТА====");
                    System.out.print("Введите длину массива: ");
                    int length = scan.nextInt();
                    Int obj = new Essays(length);
                    System.out.println("====УСПЕШНО====\n");
                    Thread readThread = new ReadThread(obj);
                    Thread writeThread = new WriteThread(obj);

                    writeThread.start();
                    readThread.start();
                    try {
                        readThread.join();
                    } catch (InterruptedException ignored) { }
                    try {
                        writeThread.join();
                    } catch (InterruptedException ignored) { }
                    break;
                case "2":
                    System.out.println("====СОЗДАНИЕ ОБЪЕКТА====");
                    System.out.print("Введите длину массива: ");
                    length = scan.nextInt();
                    obj = new Essays(length);
                    IntSynchronizer intSynchronizer = new IntSynchronizer(obj);
                    Thread read = new Thread(new ReadSyncThread(intSynchronizer));
                    Thread write =  new Thread(new WriteSyncThread(intSynchronizer));
                    read.start();
                    write.start();
                    System.out.println("====УСПЕШНО====\n");
                    break;
                case "3":
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


/*
    private static Int[][] FindCommonRes() throws PagesLessZeroException {
        Int[][] res = new Int[0][];
        ArrayList<Integer> uniqueNum =  new ArrayList<>() ;
        ArrayList<Int> uniqueInts;
        int c = 0;
        for (int i = 0; i < array.length; i++) {
            uniqueInts = new ArrayList<>();
            int num = 0;
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

*/
/*
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
*/


    private static void PrintOutArray(Int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("====ЭЛЕМЕНТ #" + (i + 1) + "====");
            System.out.println(array[i].toString());
        }
    }
}
